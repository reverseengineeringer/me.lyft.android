package io.card.payment;

import java.text.CharacterIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Calendar;
import java.util.Date;

class CreditCardNumber
{
  private static String formatFifteenString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 15)
    {
      if ((i == 4) || (i == 10)) {
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(paramString.charAt(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static String formatSixteenString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 16)
    {
      if ((i != 0) && (i % 4 == 0)) {
        localStringBuilder.append(' ');
      }
      localStringBuilder.append(paramString.charAt(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String formatString(String paramString)
  {
    return formatString(paramString, true, null);
  }
  
  public static String formatString(String paramString, boolean paramBoolean, CardType paramCardType)
  {
    String str;
    int i;
    if (paramBoolean)
    {
      str = StringHelper.getDigitsOnlyString(paramString);
      CardType localCardType = paramCardType;
      if (paramCardType == null) {
        localCardType = CardType.fromCardNumber(str);
      }
      i = localCardType.numberLength();
      paramCardType = paramString;
      if (str.length() == i)
      {
        if (i != 16) {
          break label61;
        }
        paramCardType = formatSixteenString(str);
      }
    }
    label61:
    do
    {
      return paramCardType;
      str = paramString;
      break;
      paramCardType = paramString;
    } while (i != 15);
    return formatFifteenString(str);
  }
  
  public static Date getDateForString(String paramString)
  {
    Object localObject = null;
    String str = StringHelper.getDigitsOnlyString(paramString);
    SimpleDateFormat localSimpleDateFormat = getDateFormatForLength(str.length());
    paramString = (String)localObject;
    if (localSimpleDateFormat != null) {}
    try
    {
      localSimpleDateFormat.setLenient(false);
      paramString = localSimpleDateFormat.parse(str);
      return paramString;
    }
    catch (ParseException paramString) {}
    return null;
  }
  
  public static SimpleDateFormat getDateFormatForLength(int paramInt)
  {
    if (paramInt == 4) {
      return new SimpleDateFormat("MMyy");
    }
    if (paramInt == 6) {
      return new SimpleDateFormat("MMyyyy");
    }
    return null;
  }
  
  public static boolean isDateValid(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (12 < paramInt1)) {}
    int i;
    int j;
    do
    {
      return false;
      Calendar localCalendar = Calendar.getInstance();
      i = localCalendar.get(1);
      j = localCalendar.get(2);
    } while ((paramInt2 < i) || ((paramInt2 == i) && (paramInt1 < j + 1)) || (paramInt2 > i + 15));
    return true;
  }
  
  public static boolean passesLuhnChecksum(String paramString)
  {
    boolean bool = true;
    int m = 0;
    int[] arrayOfInt1 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] arrayOfInt2 = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };
    paramString = new StringCharacterIterator(paramString);
    int i = paramString.last();
    int k = 0;
    while (i != 65535)
    {
      if (!Character.isDigit(i)) {
        return false;
      }
      m += new int[][] { arrayOfInt1, arrayOfInt2 }[(k & 0x1)][(i - 48)];
      int j = paramString.previous();
      k += 1;
    }
    if (m % 10 == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     io.card.payment.CreditCardNumber
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */