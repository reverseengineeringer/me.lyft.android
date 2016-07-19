package com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ISO8601Utils
{
  private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
  
  private static boolean checkOffset(String paramString, int paramInt, char paramChar)
  {
    return (paramInt < paramString.length()) && (paramString.charAt(paramInt) == paramChar);
  }
  
  private static int indexOfNonDigit(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i < 48) || (i > 57)) {
        return paramInt;
      }
      paramInt += 1;
    }
    return paramString.length();
  }
  
  public static Date parse(String paramString, ParsePosition paramParsePosition)
    throws ParseException
  {
    try
    {
      i = paramParsePosition.getIndex();
      j = i + 4;
      i6 = parseInt(paramString, i, j);
      i = j;
      if (checkOffset(paramString, j, '-')) {
        i = j + 1;
      }
      j = i + 2;
      i7 = parseInt(paramString, i, j);
      if (!checkOffset(paramString, j, '-')) {
        break label945;
      }
      i = j + 1;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      int i6;
      int i7;
      int i8;
      boolean bool;
      GregorianCalendar localGregorianCalendar;
      int i5;
      if (paramString != null) {
        break label892;
      }
      paramString = null;
      String str1 = localIndexOutOfBoundsException.getMessage();
      if (str1 == null) {
        break label446;
      }
      Object localObject2 = str1;
      if (!str1.isEmpty()) {
        break label479;
      }
      localObject2 = "(" + localIndexOutOfBoundsException.getClass().getName() + ")";
      paramString = new ParseException("Failed to parse date [" + paramString + "]: " + (String)localObject2, paramParsePosition.getIndex());
      paramString.initCause(localIndexOutOfBoundsException);
      throw paramString;
      i *= 10;
      break label951;
      i *= 100;
      break label951;
      c = paramString.charAt(i);
      if (c != 'Z') {
        break label972;
      }
      Object localObject1 = TIMEZONE_UTC;
      i += 1;
      String str2;
      do
      {
        do
        {
          localObject1 = new GregorianCalendar((TimeZone)localObject1);
          ((Calendar)localObject1).setLenient(false);
          ((Calendar)localObject1).set(1, i6);
          ((Calendar)localObject1).set(2, i7 - 1);
          ((Calendar)localObject1).set(5, i8);
          ((Calendar)localObject1).set(11, k);
          ((Calendar)localObject1).set(12, n);
          ((Calendar)localObject1).set(13, i1);
          ((Calendar)localObject1).set(14, m);
          paramParsePosition.setIndex(i);
          return ((Calendar)localObject1).getTime();
          localObject1 = paramString.substring(i);
          if (((String)localObject1).length() >= 5) {}
          for (;;)
          {
            j = i + ((String)localObject1).length();
            if ((!"+0000".equals(localObject1)) && (!"+00:00".equals(localObject1))) {
              break label737;
            }
            localObject1 = TIMEZONE_UTC;
            i = j;
            break;
            localObject1 = (String)localObject1 + "00";
          }
          str1 = "GMT" + (String)localObject1;
          localObject2 = TimeZone.getTimeZone(str1);
          str2 = ((TimeZone)localObject2).getID();
          i = j;
          localObject1 = localObject2;
        } while (str2.equals(str1));
        i = j;
        localObject1 = localObject2;
      } while (str2.replace(":", "").equals(str1));
      throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + str1 + " given, resolves to " + ((TimeZone)localObject2).getID());
      throw new IndexOutOfBoundsException("Invalid time zone indicator '" + c + "'");
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        int j;
        int i2;
        int i4;
        int i3;
        char c;
        continue;
        paramString = '"' + paramString + "'";
        continue;
        int k = i2;
        int m = i4;
        int n = i3;
        int i1 = j;
        continue;
        int i = k;
        continue;
        i = j;
        continue;
        k = i2;
        m = i;
        n = i3;
        i = i1;
        i1 = j;
        continue;
        if (c != '+') {
          if (c != '-') {}
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label446:
      label479:
      label737:
      label892:
      label920:
      label939:
      label945:
      label951:
      label972:
      for (;;) {}
    }
    i2 = i + 2;
    i8 = parseInt(paramString, i, i2);
    k = 0;
    n = 0;
    j = 0;
    i4 = 0;
    bool = checkOffset(paramString, i2, 'T');
    if ((!bool) && (paramString.length() <= i2))
    {
      localGregorianCalendar = new GregorianCalendar(i6, i7 - 1, i8);
      paramParsePosition.setIndex(i2);
      return localGregorianCalendar.getTime();
    }
    m = i4;
    i = i2;
    i1 = j;
    if (bool)
    {
      i = i2 + 1;
      k = i + 2;
      i2 = parseInt(paramString, i, k);
      i = k;
      if (checkOffset(paramString, k, ':')) {
        i = k + 1;
      }
      k = i + 2;
      i3 = parseInt(paramString, i, k);
      if (!checkOffset(paramString, k, ':')) {
        break label939;
      }
      i = k + 1;
      if (paramString.length() <= i) {
        break label920;
      }
      k = paramString.charAt(i);
      if ((k == 90) || (k == 43) || (k == 45)) {
        break label920;
      }
      i5 = i + 2;
      i = parseInt(paramString, i, i5);
      j = i;
      if (i > 59)
      {
        j = i;
        if (i < 63) {
          j = 59;
        }
      }
      k = i2;
      m = i4;
      n = i3;
      i = i5;
      i1 = j;
      if (checkOffset(paramString, i5, '.'))
      {
        k = i5 + 1;
        i1 = indexOfNonDigit(paramString, k + 1);
        m = Math.min(i1, k + 3);
        i = parseInt(paramString, k, m);
      }
    }
    switch (m - k)
    {
    case 2: 
      if (paramString.length() <= i) {
        throw new IllegalArgumentException("No time zone indicator");
      }
      break;
    }
  }
  
  private static int parseInt(String paramString, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    if ((paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt1 > paramInt2)) {
      throw new NumberFormatException(paramString);
    }
    int j = 0;
    int i;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1 + 1;
      j = Character.digit(paramString.charAt(paramInt1), 10);
      if (j < 0) {
        throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
      }
      j = -j;
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        int k = Character.digit(paramString.charAt(i), 10);
        if (k < 0) {
          throw new NumberFormatException("Invalid number: " + paramString.substring(paramInt1, paramInt2));
        }
        j = j * 10 - k;
        i += 1;
      }
      else
      {
        return -j;
        i = paramInt1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.util.ISO8601Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */