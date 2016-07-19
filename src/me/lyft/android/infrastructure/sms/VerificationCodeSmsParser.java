package me.lyft.android.infrastructure.sms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.lyft.android.common.Strings;

public class VerificationCodeSmsParser
{
  private static final String DEFAULT_SMS_FORMAT = "^Your Lyft code is [0-9]{4}$";
  private static final String NO_DIGITS_REG_EX = "[^0-9]";
  
  public String extractCode(String paramString)
  {
    if (Strings.isNullOrEmpty(paramString)) {}
    while (!Pattern.compile("^Your Lyft code is [0-9]{4}$").matcher(paramString).find()) {
      return null;
    }
    return paramString.replaceAll("[^0-9]", "");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.sms.VerificationCodeSmsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */