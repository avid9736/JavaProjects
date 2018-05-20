package com.example.jordan.googlesheetsapidriver.domainmodel.handlers;

public interface ICommandHandler<TCommand>
{
    void Handle(TCommand command) throws Exception;
}
