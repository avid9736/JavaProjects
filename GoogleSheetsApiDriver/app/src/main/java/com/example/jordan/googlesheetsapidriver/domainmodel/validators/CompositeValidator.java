package com.example.jordan.googlesheetsapidriver.domainmodel.validators;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;

import java.util.List;

public class CompositeValidator<T> implements IValidate<T>
{
    final List<IValidate<T>> _innerValidators;

    public CompositeValidator(List<IValidate<T>> innerValidators) throws ValidationException
    {
        if (innerValidators == null) throw new ValidationException("innerValidators cannot be null");
        _innerValidators = innerValidators;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Validate(final T value) throws ValidationException
    {
        for (IValidate<T> innerValidator : _innerValidators)
        {
            // Validate [value] against all inner validators
            innerValidator.Validate(value);
        }
    }
}
