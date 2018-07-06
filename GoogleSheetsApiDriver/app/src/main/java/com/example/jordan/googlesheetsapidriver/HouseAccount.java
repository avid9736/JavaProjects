package com.example.jordan.googlesheetsapidriver;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.CreateTransactionCommand;
import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.handlers.ICommandHandler;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

@RequiresApi(api = Build.VERSION_CODES.N)
public class HouseAccount
{
    private ICommandHandler<CreateTransactionCommand> _commandHandler;

    public HouseAccount(ICommandHandler<CreateTransactionCommand> commandHandler)
    {
        _commandHandler = commandHandler;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Deposit(String paidBy, float amount, String notes)
    {
        Handle(TransactionType.Transfer, paidBy, "", notes, amount);
    }

    public void Deposit(String paidBy, float amount)
    {
        Deposit(paidBy, amount, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Withdrawl(String paidBy, float amount, String notes)
    {
        Handle(TransactionType.Transfer, paidBy, "", notes, amount);
    }

    public void Withdrawl(String paidBy, float amount)
    {
        Withdrawl(paidBy, amount, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Transfer(String paidBy, String transferTo, float amount, String notes)
    {
        Handle(TransactionType.Transfer, paidBy, transferTo, notes, amount);
    }

    public void Transfer(String paidBy, String transferTo, float amount)
    {
        Transfer(paidBy, transferTo, amount, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Groceries(String paidBy, float amount, String notes)
    {
        Handle(TransactionType.Groceries, paidBy, "", notes, amount);
    }

    public void Groceries(String paidBy, float amount)
    {
        Groceries(paidBy, amount, "");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Rent(String notes)
    {
        Handle(TransactionType.Rent, "", "", notes, 2000.00f);
    }

    public void Rent()
    {
        Rent("");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void Handle(TransactionType type, String paidBy, String transferTo, String notes, float amount)
    {
        try {
            CreateTransactionCommand command = CreateCommand(type, paidBy, transferTo, notes, amount);

            _commandHandler.Handle(command);
        }
        catch (ValidationException e)
        {
            //TODO handle this nicely
            e.printStackTrace();
        }
    }

    private CreateTransactionCommand CreateCommand(TransactionType type, String paidBy, String transferTo, String notes, float amount)
    {
        Transaction transaction = new Transaction(type, paidBy, transferTo, notes, amount);

        return new CreateTransactionCommand(transaction);
    }
}
