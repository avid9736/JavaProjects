package com.example.jordan.googlesheetsapidriver;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.CreateTransactionCommand;
import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.handlers.ICommandHandler;
import com.example.jordan.googlesheetsapidriver.infrastructure.Lazy;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

public class HouseAccount
{
    final static Lazy<ICommandHandler<CreateTransactionCommand>> _commandHandler new Lazy<ICommandHandler<CreateTransactionCommand>>(() => );

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Deposit(String paidBy, String notes, float amount) throws Exception
    {
        Handle(TransactionType.Transfer, paidBy, "", notes, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Withdrawl(String paidBy, String notes, float amount) throws Exception
    {
        Handle(TransactionType.Transfer, paidBy, "", notes, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Transfer(String paidBy, String transferTo, String notes, float amount) throws Exception
    {
        Handle(TransactionType.Transfer, paidBy, transferTo, notes, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Groceries(String paidBy, String notes, float amount) throws Exception
    {
        Handle(TransactionType.Groceries, paidBy, "", notes, amount);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Rent(String notes) throws Exception
    {
        Handle(TransactionType.Rent, "", "", notes, 0.00f);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    void Handle(TransactionType type, String paidBy, String transferTo, String notes, float amount) throws Exception
    {
        CreateTransactionCommand command = CreateCommand(type, paidBy, transferTo, notes, amount);

        _commandHandler.getValue().Handle(command);
    }

    CreateTransactionCommand CreateCommand(TransactionType type, String paidBy, String transferTo, String notes, float amount) throws ValidationException
    {
        Transaction transaction = new Transaction(type, paidBy, transferTo, notes, amount);

        return new CreateTransactionCommand(transaction);
    }
}
