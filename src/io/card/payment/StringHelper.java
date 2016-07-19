package io.card.payment;

class StringHelper
{
  public static String getDigitsOnlyString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      char c = paramString[i];
      if (Character.isDigit(c)) {
        localStringBuilder.append(c);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     io.card.payment.StringHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */