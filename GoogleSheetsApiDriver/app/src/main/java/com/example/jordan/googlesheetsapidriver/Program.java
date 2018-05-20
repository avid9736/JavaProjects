package com.example.jordan.googlesheetsapidriver;

import com.example.jordan.googlesheetsapidriver.persistence.Ledger;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

public class Program {
    public static void main(String[] args) throws Exception
    {
        Ledger ledger = new Ledger();

        Transaction first = new Transaction(TransactionType.Deposit, "Jordan", "", "Hello world!", 45.78f);

        ledger.SaveTransaction(first);
    }
}
