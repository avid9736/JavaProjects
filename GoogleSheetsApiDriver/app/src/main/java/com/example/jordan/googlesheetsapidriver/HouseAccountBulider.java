package com.example.jordan.googlesheetsapidriver;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.CreateTransactionCommand;
import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.domainmodel.handlers.CreateTransactionCommandHandler;
import com.example.jordan.googlesheetsapidriver.domainmodel.handlers.ICommandHandler;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.CompositeValidator;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.IValidate;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction.PaidByUsageValidator;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction.PositiveAmountValidator;
import com.example.jordan.googlesheetsapidriver.domainmodel.validators.Transaction.TransferToUsageValidator;
import com.example.jordan.googlesheetsapidriver.persistence.Ledger;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;

import java.util.Arrays;

public class HouseAccountBulider
{
    private static ICommandHandler<CreateTransactionCommand> _commandHandler;
    private static HouseAccount _houseAccount;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static HouseAccount Build() throws ValidationException
    {
        if (_houseAccount == null)
            _houseAccount = BuildHouseAccount();

        return _houseAccount;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static HouseAccount BuildHouseAccount() throws ValidationException
    {
        if (_commandHandler == null)
            _commandHandler = BuildCommandHandler();

        return new HouseAccount(_commandHandler);
    }

    private static ICommandHandler<CreateTransactionCommand> BuildCommandHandler() throws ValidationException
    {
        Ledger ledger = new Ledger();
        IValidate<Transaction> validator = BuildValidator();

        return new CreateTransactionCommandHandler(ledger, validator);
    }

    private static IValidate<Transaction> BuildValidator()
    {
        return CreateCompositeValidator(
                new PaidByUsageValidator(),
                new PositiveAmountValidator(),
                new TransferToUsageValidator()
        );
    }

    private static IValidate<Transaction> CreateCompositeValidator(IValidate<Transaction>... validators)
    {
        return new CompositeValidator<>(Arrays.asList(validators));
    }
}
