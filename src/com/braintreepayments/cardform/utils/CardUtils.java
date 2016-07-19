package com.braintreepayments.cardform.utils;

public class CardUtils
{
  public static boolean isLuhnValid(String paramString)
  {
    paramString = new StringBuffer(paramString).reverse().toString();
    int m = paramString.length();
    int j = 0;
    int k = 0;
    int i = 0;
    if (i < m)
    {
      char c = paramString.charAt(i);
      if (!Character.isDigit(c)) {
        throw new IllegalArgumentException(String.format("Not a digit: '%s'", new Object[] { Character.valueOf(c) }));
      }
      int n = Character.digit(c, 10);
      if (i % 2 == 0) {
        j += n;
      }
      for (;;)
      {
        i += 1;
        break;
        k += n / 5 + n * 2 % 10;
      }
    }
    return (j + k) % 10 == 0;
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.cardform.utils.CardUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */