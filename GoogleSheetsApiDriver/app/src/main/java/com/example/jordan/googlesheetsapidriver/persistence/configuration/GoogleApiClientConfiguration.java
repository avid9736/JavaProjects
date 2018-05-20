package com.example.jordan.googlesheetsapidriver.persistence.configuration;

import java.util.Arrays;
import java.util.List;

public class GoogleApiClientConfiguration
{
    public final String AuthUri = "https://accounts.google.com/o/oauth2/auth";
    public final String ClientId = "858751214390-m2ggis35kfutsmg3ev4fhaeb5cb50c0v.apps.googleusercontent.com";
    public final String ClientSecret = "rjiAfrPns79vWQKdEozI_Grj";
    public final List<String> RedirectUris = Arrays.asList("urn:ietf:wg:oauth:2.0:oob","http://localhost");
    public final String TokenUri = "https://accounts.google.com/o/oauth2/token";
}
