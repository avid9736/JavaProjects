package com.example.jordan.googlesheetsapidriver.domainmodel.handlers;

import com.example.jordan.googlesheetsapidriver.domainmodel.CreateTransactionCommand;
import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.persistence.ILedger;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;

public class CreateTransactionCommandHandler implements ICommandHandler<CreateTransactionCommand>
{
    private final ILedger _ledger;
    private final IValidate<Transaction> _validator;

    public CreateTransactionCommandHandler(ILedger Ledger, IValidate<Transaction> Validator)
    {
        _validator = Validator;
        _ledger = Ledger;
    }

    public void Handle(CreateTransactionCommand createTransactionCommand) throws ValidationException
    {
        Transaction transaction = createTransactionCommand.Transaction;

        _validator.Validate(transaction);

        _ledger.SaveTransaction(transaction);
    }
}
