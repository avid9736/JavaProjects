package com.example.jordan.googlesheetsapidriver.domainmodel.handlers;

import com.example.jordan.googlesheetsapidriver.domainmodel.CreateTransactionCommand;
import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.persistence.ILedger;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;

import java.io.IOException;

public class CreateTransactionCommandHandler implements ICommandHandler<CreateTransactionCommand>
{
    private final ILedger _ledger;
    private final IValidate<Transaction> _validator;

    public CreateTransactionCommandHandler(ILedger Ledger, IValidate<Transaction> Validator) throws ValidationException
    {
        if (Ledger == null) throw new ValidationException("Ledger cannot be null");
        if (Validator == null) throw new ValidationException("Validator cannot be null");

        _validator = Validator;
        _ledger = Ledger;
    }

    public void Handle(CreateTransactionCommand createTransactionCommand) throws Exception
    {
        if (createTransactionCommand == null) throw new ValidationException("Command cannot be null");
        Transaction transaction = createTransactionCommand.Transaction;

        _validator.Validate(transaction);

        _ledger.SaveTransaction(transaction);
    }
}
