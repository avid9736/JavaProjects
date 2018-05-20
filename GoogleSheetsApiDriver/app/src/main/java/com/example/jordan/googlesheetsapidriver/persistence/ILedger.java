package com.example.jordan.googlesheetsapidriver.persistence;

import com.example.jordan.googlesheetsapidriver.transport.Transaction;

public interface ILedger
{
     void SaveTransaction(Transaction transaction);
}
