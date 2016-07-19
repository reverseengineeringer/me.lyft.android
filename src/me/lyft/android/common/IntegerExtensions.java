package me.lyft.android.common;

public class IntegerExtensions
{
  public static Integer tryParse(String paramString)
  {
    try
    {
      paramString = Integer.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static Integer tryParse(String paramString, int paramInt)
  {
    try
    {
      paramString = Integer.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return Integer.valueOf(paramInt);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.IntegerExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */