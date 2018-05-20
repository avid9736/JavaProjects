package com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;

public class PositiveAmountValidator implements IValidate<Transaction>
{
    public void Validate(Transaction value) throws ValidationException
    {
        if (value.Amount <= 0)
            throw new ValidationException("Amount must be positive.");
    }
}
