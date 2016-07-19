package me.lyft.android.common;

public class Objects
{
  public static <T> boolean equals(T paramT1, T paramT2)
  {
    if (paramT1 == null) {
      return paramT1 == paramT2;
    }
    return paramT1.equals(paramT2);
  }
  
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
  
  public static <T> T firstNonNull(T... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramVarArgs[i];
      if (? != null) {
        return ?;
      }
      i += 1;
    }
    throw new NullPointerException("All items are null");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.Objects
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */