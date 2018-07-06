package com.example.jordan.googlesheetsapidriver.persistence;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;
import com.example.jordan.googlesheetsapidriver.infrastructure.IMapper;
import com.example.jordan.googlesheetsapidriver.persistence.configuration.SpreadsheetConfiguration;
import com.example.jordan.googlesheetsapidriver.persistence.factory.ISheetsFactory;
import com.example.jordan.googlesheetsapidriver.persistence.factory.SheetsFactory;
import com.example.jordan.googlesheetsapidriver.persistence.mapper.TransactionMapper;
import com.example.jordan.googlesheetsapidriver.transport.Transaction;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;

public class Ledger implements ILedger
{
    final SpreadsheetConfiguration _config = new SpreadsheetConfiguration();
    final ISheetsFactory factory = new SheetsFactory();
    final IMapper<Transaction, ValueRange> _mapper = new TransactionMapper();

    public Ledger() throws ValidationException {}

    public void SaveTransaction(Transaction transaction) throws ValidationException
    {
        Sheets sheets = factory.BulidSheets();
        ValueRange data = _mapper.Map(transaction);

        Sheets.Spreadsheets.Values.Append append;

        try
        {
            append = sheets.spreadsheets().values()
                    .append(_config.SpreadsheetId, _config.SpreadsheetRange, data);

            append.setValueInputOption("USER_ENTERED");

            append.execute();
        }
        catch (IOException e)
        {
            throw new ValidationException("Some kind of IO exception!", e);
        }
    }
}
