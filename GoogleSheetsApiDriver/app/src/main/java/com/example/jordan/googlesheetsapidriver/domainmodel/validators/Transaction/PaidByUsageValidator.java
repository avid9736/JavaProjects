package com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.example.jordan.googlesheetsapidriver.transport.TransactionType;

import java.util.Arrays;
import java.util.List;

public class PaidByUsageValidator implements IValidate<Transaction>
{
    private final List<TransactionType> _typesThatRequirePaidBy = Arrays.asList(
            TransactionType.Groceries,
            TransactionType.Deposit,
            TransactionType.Transfer,
            TransactionType.Withdrawl
    );
    private final List<TransactionType> _typesThatPreventPaidBy = Arrays.asList(
            TransactionType.Rent
    );

    public void Validate(Transaction value) throws ValidationException
    {
        if (_typesThatRequirePaidBy.contains(value.TransactionType))
            AssertPaidBy(value);

        if (_typesThatPreventPaidBy.contains(value.TransactionType))
            AssertNoPaidBy(value);
    }

    void AssertPaidBy(Transaction value) throws ValidationException
    {
        if (value.PaidBy.isEmpty())
            throw new ValidationException(String.format("PaidBy must be provided when doing %s", value.TransactionType.toString()));
    }

    void AssertNoPaidBy(Transaction value) throws ValidationException
    {
        if (!value.PaidBy.isEmpty())
            throw new ValidationException(String.format("PaidBy must be empty when doing %s", value.TransactionType.toString()));}
}
