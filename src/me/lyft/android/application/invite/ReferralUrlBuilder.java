package me.lyft.android.application.invite;

import me.lyft.android.common.Strings;

public class ReferralUrlBuilder
{
  public static final String DRIVER_URL = "https://lyft.com/drivers";
  public static final String FALLBACK_URL = "https://lyft.com/i";
  
  public static String buildDriverUrl(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://lyft.com/drivers");
    if (!Strings.isNullOrBlank(paramString)) {
      localStringBuilder.append("/").append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static String buildUrl(String paramString1, String paramString2)
  {
    if (Strings.isNullOrBlank(paramString2)) {
      return "https://lyft.com/i";
    }
    return Strings.firstNonEmpty(new String[] { paramString1, "https://lyft.com/i" }) + "/" + paramString2;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.invite.ReferralUrlBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */