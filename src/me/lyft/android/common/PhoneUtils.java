package me.lyft.android.common;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberFormat;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import me.lyft.android.logging.L;

public class PhoneUtils
{
  public static String DEFAULT_REGION = "US";
  private static PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
  
  public static String formatPhoneNumberToE164(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = phoneNumberUtil.format(phoneNumberUtil.parse(paramString1, paramString2), PhoneNumberUtil.PhoneNumberFormat.E164);
      return paramString2;
    }
    catch (NumberParseException paramString2) {}
    return paramString1;
  }
  
  public static String formatPhoneNumberToNational(String paramString1, String paramString2)
  {
    try
    {
      if (!Strings.isNullOrEmpty(paramString1))
      {
        if (paramString1.startsWith("+"))
        {
          localObject = phoneNumberUtil.parse(paramString1, paramString2);
          return phoneNumberUtil.format((Phonenumber.PhoneNumber)localObject, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        }
        Object localObject = new StringBuffer("+");
        ((StringBuffer)localObject).append(phoneNumberUtil.getCountryCodeForRegion(paramString2));
        ((StringBuffer)localObject).append(paramString1);
        try
        {
          localObject = phoneNumberUtil.parse(((StringBuffer)localObject).toString(), paramString2);
          localObject = phoneNumberUtil.format((Phonenumber.PhoneNumber)localObject, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
          return (String)localObject;
        }
        catch (NumberFormatException paramString2)
        {
          return paramString1;
        }
      }
      return paramString1;
    }
    catch (NumberParseException localNumberParseException)
    {
      L.w(localNumberParseException, "formatPhoneNumberToNational failed for %s and country code %s", new Object[] { paramString1, paramString2 });
    }
  }
  
  public static String getCountryCodeForPhone(String paramString)
  {
    try
    {
      Object localObject = phoneNumberUtil.parse(paramString, DEFAULT_REGION);
      localObject = (String)Objects.firstNonNull(phoneNumberUtil.getRegionCodeForCountryCode(((Phonenumber.PhoneNumber)localObject).getCountryCode()), DEFAULT_REGION);
      return (String)localObject;
    }
    catch (NumberParseException localNumberParseException)
    {
      L.w(localNumberParseException, "getCountryCodeForPhone failed for %s", new Object[] { paramString });
    }
    return DEFAULT_REGION;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.PhoneUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */