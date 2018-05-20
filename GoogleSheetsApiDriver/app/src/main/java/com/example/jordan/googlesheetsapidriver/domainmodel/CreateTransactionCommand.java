package com.example.jordan.googlesheetsapidriver.domainmodel;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;

public class CreateTransactionCommand
{
    public CreateTransactionCommand(Transaction transaction) throws ValidationException
    {
        if (transaction == null)
            throw new ValidationException("Transaction cannot be null");

        Transaction = transaction;
    }

    public final Transaction Transaction;
}
