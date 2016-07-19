package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$3
{
  FieldNamingPolicy$3()
  {
    super(paramString, paramInt, null);
  }
  
  public String translateName(Field paramField)
  {
    return upperCaseFirstLetter(separateCamelCase(paramField.getName(), " "));
  }
}

/* Location:
 * Qualified Name:     com.google.gson.FieldNamingPolicy.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */