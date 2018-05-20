package com.example.jordan.googlesheetsapidriver.persistence.mapper;

import com.example.jordan.googlesheetsapidriver.infrastructure.IMapper;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.Arrays;
import java.util.List;

public class TransactionMapper implements IMapper<Transaction, ValueRange>
{
    @Override
    public ValueRange Map(Transaction transaction)
    {
        List<Object> values = Arrays.asList(
                transaction.TransactionType.toString(),
                transaction.PaidBy,
                transaction.TransferTo,
                transaction.Notes,
                transaction.Date.toString(),
                transaction.Amount.toString(),
                transaction.Amount.toString(),
                transaction.Amount.toString()
        );

        ValueRange valueRange = new ValueRange();
        valueRange.setValues(Arrays.asList(values));

        return valueRange;
    }
}
