package com.kochava.android.util;

public class Base64Coder
{
  private static char[] map1 = new char[64];
  private static byte[] map2;
  
  static
  {
    int i = 65;
    int j = 0;
    while (i <= 90)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 97;
    while (i <= 122)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    i = 48;
    while (i <= 57)
    {
      map1[j] = i;
      i = (char)(i + 1);
      j += 1;
    }
    char[] arrayOfChar = map1;
    int k = j + 1;
    arrayOfChar[j] = '+';
    map1[k] = '/';
    map2 = new byte[''];
    j = 0;
    while (j < map2.length)
    {
      map2[j] = -1;
      j += 1;
    }
    j = 0;
    while (j < 64)
    {
      map2[map1[j]] = ((byte)j);
      j += 1;
    }
  }
  
  public static String encodeString(String paramString)
  {
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.util.Base64Coder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */