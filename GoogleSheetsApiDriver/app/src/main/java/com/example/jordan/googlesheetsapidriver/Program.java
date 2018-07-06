package com.example.jordan.googlesheetsapidriver;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;

public class Program
{
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main(String[] args)
    {
        try
        {
            HouseAccount houseAccount = HouseAccountBulider.Build();

            houseAccount.Deposit("Jordan", 5000.00f);
            houseAccount.Groceries("Sean", 375.12f);
            houseAccount.Rent("May Rent");
            houseAccount.Transfer("Jordan", "Sean", 375.12f);
            houseAccount.Withdrawl("Jordan",150.00f);
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
    }
}
