package com.example.jordan.googlesheetsapidriver.domainmodel.validators;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;

public interface IValidate<T>
{
    void Validate(T value) throws ValidationException;
}
