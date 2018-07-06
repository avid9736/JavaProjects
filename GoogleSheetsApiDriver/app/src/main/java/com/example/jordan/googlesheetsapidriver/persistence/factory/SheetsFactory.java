package com.example.jordan.googlesheetsapidriver.persistence.factory;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.infrastructure.Lazy;
import com.example.jordan.googlesheetsapidriver.persistence.configuration.GoogleApiClientConfiguration;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class SheetsFactory implements ISheetsFactory
{
    final String _applicationName = "GoogleSheetApiDriver";
    final NetHttpTransport HTTP_TRANSPORT = BuildNetHttpTransport();
    final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    Lazy<Credential> _credential = new Lazy<>(() -> BuildCredential());

    public SheetsFactory() throws ValidationException {}

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Sheets BulidSheets()
    {
        Sheets sheets= new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, _credential.getValue())
                .setApplicationName(_applicationName)
                .build();

        return sheets;
    }

    NetHttpTransport BuildNetHttpTransport() throws ValidationException
    {
        try
        {
            return GoogleNetHttpTransport.newTrustedTransport();
        }
        catch (GeneralSecurityException e)
        {
            throw new ValidationException("Some kind of security exception!", e);
        }
        catch (IOException e)
        {
            throw new ValidationException("Some kind of IO exception!", e);
        }
    }

    Credential BuildCredential()
    {
        try
        {
            GoogleAuthorizationCodeFlow flow = BuildFlow();
            AuthorizationCodeInstalledApp app = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver());

            return app.authorize("jordan.selinger@gmail.com");
        }
        catch (IOException e)
        {
            // This is not good
            e.printStackTrace();
        }

        return null;
    }

    GoogleAuthorizationCodeFlow BuildFlow() throws IOException
    {
        GoogleClientSecrets clientSecrets = BuildSecrets();
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File("credentials")))
                .setAccessType("offline")
                .build();

        return flow;
    }

    GoogleClientSecrets BuildSecrets()
    {
        GoogleClientSecrets.Details details = BuildDetails();
        GoogleClientSecrets clientSecrets = new GoogleClientSecrets();
        clientSecrets.setInstalled(details);

        return clientSecrets;
    }

    GoogleClientSecrets.Details BuildDetails()
    {
        GoogleApiClientConfiguration config = new GoogleApiClientConfiguration();
        GoogleClientSecrets.Details details = new GoogleClientSecrets.Details();
        details.setTokenUri(config.TokenUri);
        details.setRedirectUris(config.RedirectUris);
        details.setClientId(config.ClientId);
        details.setClientSecret(config.ClientSecret);
        details.setAuthUri(config.AuthUri);

        return details;
    }
}
