package com.example.jordan.googlesheetsapidriver;

import com.example.jordan.googlesheetsapidriver.persistence.Ledger;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

import java.io.IOException;

public class Program {
    public static void main(String[] args) throws Exception
    {
        Ledger ledger = new Ledger();

        SaveTransaction(ledger, TransactionType.Deposit, "Jordan", "", "Hello world!", 45.78f);
        SaveTransaction(ledger, TransactionType.Deposit, "Dylan", "", "", 345.85f);
        SaveTransaction(ledger, TransactionType.Deposit, "Donald", "", "", 445.78f);
        SaveTransaction(ledger, TransactionType.Deposit, "Emilio", "", "", 852.687f);
        SaveTransaction(ledger, TransactionType.Deposit, "Sean", "", "", 45.78f);
        SaveTransaction(ledger, TransactionType.Transfer, "Jordan", "Donald", "Hello world!", 20.00f);
        SaveTransaction(ledger, TransactionType.Rent, "", "", "Hello world!", 45.78f);
        SaveTransaction(ledger, TransactionType.Groceries, "Jordan", "", "Hello world!", 45.78f);
        SaveTransaction(ledger, TransactionType.Deposit, "Jordan", "", "Hello world!", 45.78f);
        SaveTransaction(ledger, TransactionType.Deposit, "Jordan", "", "Hello world!", 45.78f);
        SaveTransaction(ledger, TransactionType.Deposit, "Jordan", "", "Hello world!", 45.78f);
    }

    static void SaveTransaction(Ledger ledger, TransactionType type, String paidBy, String transferTo, String notes, float amount) throws IOException
    {
        Transaction transaction = new Transaction(type, paidBy, transferTo, notes, amount);

        ledger.SaveTransaction(transaction);
    }
}
