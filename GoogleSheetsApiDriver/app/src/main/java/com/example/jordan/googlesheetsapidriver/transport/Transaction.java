package com.example.jordan.googlesheetsapidriver.transport;

import java.util.Date;

public class Transaction
{
    public Transaction(TransactionType transactionType, String paidBy, String transferTo, String notes, Float amount)
    {
        TransactionType = transactionType;
        PaidBy = paidBy;
        TransferTo = transferTo;
        Notes = notes;
        Amount = amount;
        Date = new Date();
    }

    public final TransactionType TransactionType;
    public final String PaidBy;
    public final String TransferTo;
    public final String Notes;
    public final Float Amount;
    public final Date Date;
}
