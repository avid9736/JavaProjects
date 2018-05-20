package com.example.jordan.googlesheetsapidriver.infrastructure;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;

import java.util.function.Supplier;

public class Lazy<T>
{
    Supplier<T> _getInstance;
    T _instance;

    public Lazy(Supplier<T> getInstance) throws Exception
    {
        if (getInstance == null) throw new ValidationException("getInstance cannot be null");
        _getInstance = getInstance;
        _instance = null;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public T getValue()
    {
        if (_instance == null)
            _instance = _getInstance.get();

        return _instance;
    }
}
