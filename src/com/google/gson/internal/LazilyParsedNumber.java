package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber
  extends Number
{
  private final String value;
  
  public LazilyParsedNumber(String paramString)
  {
    value = paramString;
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new BigDecimal(value);
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof LazilyParsedNumber));
      paramObject = (LazilyParsedNumber)paramObject;
      if (value == value) {
        break;
      }
      bool1 = bool2;
    } while (!value.equals(value));
    return true;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(value);
  }
  
  public int hashCode()
  {
    return value.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(value);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2) {}
    }
    return new BigDecimal(value).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException) {}
    return new BigDecimal(value).longValue();
  }
  
  public String toString()
  {
    return value;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.LazilyParsedNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */