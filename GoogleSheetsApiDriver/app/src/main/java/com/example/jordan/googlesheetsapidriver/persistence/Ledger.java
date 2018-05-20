package com.example.jordan.googlesheetsapidriver.persistence;

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

    public Ledger() throws Exception
    {}

    public void SaveTransaction(Transaction transaction) throws IOException
    {
        Sheets sheets = factory.BulidSheets();
        ValueRange data = _mapper.Map(transaction);

        Sheets.Spreadsheets.Values.Append append = sheets.spreadsheets().values()
                .append(_config.SpreadsheetId, _config.SpreadsheetRange, data);
        append.setValueInputOption("USER_ENTERED");

        append.execute();
    }
}
