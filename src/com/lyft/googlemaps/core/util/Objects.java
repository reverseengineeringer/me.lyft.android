package com.lyft.googlemaps.core.util;

public class Objects
{
  public static <T> T firstNonNull(T paramT1, T paramT2)
  {
    if (paramT1 != null) {
      return paramT1;
    }
    if (paramT2 == null) {
      throw new NullPointerException("All items are null");
    }
    return paramT2;
  }
}

/* Location:
 * Qualified Name:     com.lyft.googlemaps.core.util.Objects
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */