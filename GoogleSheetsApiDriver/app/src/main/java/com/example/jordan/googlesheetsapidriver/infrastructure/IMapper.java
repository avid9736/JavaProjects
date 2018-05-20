package com.example.jordan.googlesheetsapidriver.infrastructure;

public interface IMapper<TSource, TDestination>
{
    TDestination Map(TSource source);
}
