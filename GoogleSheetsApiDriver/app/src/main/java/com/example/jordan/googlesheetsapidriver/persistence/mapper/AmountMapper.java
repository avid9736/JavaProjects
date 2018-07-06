package com.example.jordan.googlesheetsapidriver.persistence.mapper;

import com.example.jordan.googlesheetsapidriver.infrastructure.IMapper;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

import java.util.Arrays;
import java.util.List;

public class AmountMapper implements IMapper<Transaction, List<Object>>
{
    @Override
    public List<Object> Map(Transaction transaction)
    {
        if (transaction.TransactionType == TransactionType.Deposit)
            return OnlyDeposit(transaction);

        if (transaction.TransactionType == TransactionType.Withdrawl)
            return OnlyWithdrawl(transaction);

        return Both(transaction);
    }

    List<Object> OnlyDeposit(Transaction transaction)
    {
        return Arrays.asList(transaction.Amount.toString(), "");
    }

    List<Object> OnlyWithdrawl(Transaction transaction)
    {
        return Arrays.asList("", transaction.Amount.toString());
    }

    List<Object> Both(Transaction transaction)
    {
        return Arrays.asList(transaction.Amount.toString(), transaction.Amount.toString());
    }
}
