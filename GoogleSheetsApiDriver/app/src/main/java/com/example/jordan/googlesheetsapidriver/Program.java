package com.example.jordan.googlesheetsapidriver;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Program {
    public static void main(String[] args)
    {
        SheetsQuickstart quickstart = new SheetsQuickstart();

        try
        {
            quickstart.DoThings();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (GeneralSecurityException e)
        {
            e.printStackTrace();
        }
    }
}
