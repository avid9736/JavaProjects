package com.example.jordan.googlesheetsapidriver.domainmodel.exceptions;

public class ValidationException extends Exception
{
    public ValidationException(String message) { super(message); }
    public ValidationException(String message, Exception e) { super(message, e);}
}
