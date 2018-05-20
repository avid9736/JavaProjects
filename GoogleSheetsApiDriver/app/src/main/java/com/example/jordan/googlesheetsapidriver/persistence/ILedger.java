package com.example.jordan.googlesheetsapidriver.persistence;

import com.example.jordan.googlesheetsapidriver.transport.Transaction;

import java.io.IOException;

public interface ILedger
{
     void SaveTransaction(Transaction transaction) throws IOException;
}
