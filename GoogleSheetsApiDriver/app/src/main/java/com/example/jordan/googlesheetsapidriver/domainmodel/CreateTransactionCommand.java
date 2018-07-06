package com.example.jordan.googlesheetsapidriver.domainmodel;

import com.example.jordan.googlesheetsapidriver.transport.Transaction;

public class CreateTransactionCommand
{
    public CreateTransactionCommand(Transaction transaction)
    {
        Transaction = transaction;
    }

    public final Transaction Transaction;
}
