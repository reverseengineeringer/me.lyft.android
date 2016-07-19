package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import java.lang.reflect.Field;

public final class FieldAttributes
{
  private final Field field;
  
  public FieldAttributes(Field paramField)
  {
    .Gson.Preconditions.checkNotNull(paramField);
    field = paramField;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.FieldAttributes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */