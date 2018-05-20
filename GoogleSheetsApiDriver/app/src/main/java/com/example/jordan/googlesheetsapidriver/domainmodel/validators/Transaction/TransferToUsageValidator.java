package com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

import java.util.Arrays;
import java.util.List;

public class TransferToUsageValidator implements IValidate<Transaction>
{
    private final List<TransactionType> _typesAllowedToTransferTo = Arrays.asList(TransactionType.Transfer);

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Validate(Transaction value) throws ValidationException
    {
        if (_typesAllowedToTransferTo.contains(value.TransactionType))
            return;

        if (!value.TransferTo.isEmpty())
            throw new ValidationException(String.format("TransferTo must be empty when doing %s", value.TransactionType.toString()));
    }
}
