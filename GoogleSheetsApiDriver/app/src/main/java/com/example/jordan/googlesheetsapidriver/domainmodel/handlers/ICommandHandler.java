package com.example.jordan.googlesheetsapidriver.domainmodel.handlers;

import com.example.jordan.googlesheetsapidriver.domainmodel.exceptions.ValidationException;

public interface ICommandHandler<TCommand>
{
    void Handle(TCommand command) throws ValidationException;
}
