package me.lyft.android.common;

public class AddressUtils
{
  public static String getShortAddress(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf(", ");
    if (i > -1)
    {
      int j = paramString.indexOf(", ", i + 1);
      if (j > -1) {
        return paramString.substring(0, j);
      }
      return paramString.substring(0, i);
    }
    return paramString;
  }
  
  public static String getStateOrCountry(String paramString)
  {
    String str = getShortAddress(paramString);
    if (Strings.isNullOrEmpty(str)) {
      return "";
    }
    int i = str.indexOf(", ");
    int j = paramString.lastIndexOf(", ");
    if (i > -1) {
      return str.substring(i + 1).replaceAll("\\d", "").trim();
    }
    return paramString.substring(j + 1).replaceAll("\\d", "").trim();
  }
  
  public static String getStreetAddress(String paramString)
  {
    String str;
    if (Strings.isNullOrEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf(", ");
      str = paramString;
    } while (i <= -1);
    return paramString.substring(0, i);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.AddressUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */