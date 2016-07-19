package com.appboy.support;

import com.appboy.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class ValidationUtils
{
  public static final int APPBOY_STRING_MAX_LENGTH = 255;
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ValidationUtils.class.getName() });
  private static final Set<String> b = new HashSet(Arrays.asList(new String[] { "appboy" }));
  private static final Set<String> c = new HashSet(Arrays.asList(new String[] { "first_name", "last_name", "email", "gender", "dob", "country", "home_city", "email_subscribe", "push_subscribe", "phone", "facebook", "twitter", "image_url" }));
  
  public static boolean customAttributeKeyHasReservedPrefix(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.toLowerCase().startsWith(str))
      {
        AppboyLogger.w(a, String.format("'%s' contains a reserved prefix. Cannot use the given key.", new Object[] { paramString }));
        return true;
      }
    }
    return false;
  }
  
  public static boolean customAttributeKeyIsReservedKey(String paramString)
  {
    paramString = paramString.trim();
    if (c.contains(paramString))
    {
      AppboyLogger.w(a, String.format("'%s' is a reserved attribute key. Cannot use the given key.", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  public static String ensureAppboyFieldLength(String paramString)
  {
    String str = paramString.trim();
    paramString = str;
    if (str.length() > 255)
    {
      AppboyLogger.w(a, String.format("Provided string field is too long [%d]. The max length is %d, truncating provided field.", new Object[] { Integer.valueOf(str.length()), Integer.valueOf(255) }));
      paramString = str.substring(0, 255);
    }
    return paramString;
  }
  
  public static String[] ensureCustomAttributeArrayValues(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        paramArrayOfString[i] = ensureAppboyFieldLength(paramArrayOfString[i]);
        i += 1;
      }
    }
    return paramArrayOfString;
  }
  
  public static boolean isBlacklistedCustomAttributeKey(String paramString, Set<String> paramSet)
  {
    if (paramSet.contains(paramString))
    {
      AppboyLogger.w(a, String.format("Custom attribute key cannot be blacklisted attribute: %s.", new Object[] { paramString }));
      return true;
    }
    return false;
  }
  
  public static boolean isValidCustomAttributeKey(String paramString)
  {
    if (paramString == null) {
      AppboyLogger.w(a, "Custom attribute key cannot be null.");
    }
    while ((customAttributeKeyHasReservedPrefix(paramString)) || (customAttributeKeyIsReservedKey(paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean isValidCustomAttributeValue(String paramString)
  {
    if (paramString == null)
    {
      AppboyLogger.w(a, "Custom attribute value cannot be null.");
      return false;
    }
    return true;
  }
  
  public static boolean isValidEmailAddress(String paramString)
  {
    return (paramString != null) && (paramString.toLowerCase().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"));
  }
  
  public static boolean isValidPhoneNumber(String paramString)
  {
    return (paramString != null) && (paramString.matches("^[0-9 .\\(\\)\\+\\-]+$"));
  }
}

/* Location:
 * Qualified Name:     com.appboy.support.ValidationUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */