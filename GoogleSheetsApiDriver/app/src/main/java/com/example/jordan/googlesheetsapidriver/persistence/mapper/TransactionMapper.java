package com.example.jordan.googlesheetsapidriver.persistence.mapper;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.infrastructure.IMapper;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransactionMapper implements IMapper<Transaction, ValueRange>
{
    final IMapper<Transaction, List<Object>> _amountMapper = new AmountMapper();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public ValueRange Map(Transaction transaction)
    {
        List<Object> values = Arrays.asList(
                transaction.TransactionType.toString(),
                transaction.PaidBy,
                transaction.TransferTo,
                transaction.Notes,
                transaction.Date.toString());

        List<Object> amounts = _amountMapper.Map(transaction);

        List<Object> allValues = Stream.of(values, amounts)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return ToValueRange(allValues);
    }

    ValueRange ToValueRange(List<Object> values)
    {
        ValueRange valueRange = new ValueRange();
        valueRange.setValues(Arrays.asList(values));

        return valueRange;
    }
}
