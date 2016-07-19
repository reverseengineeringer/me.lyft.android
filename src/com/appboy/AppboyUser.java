package com.appboy;

import bo.app.by;
import bo.app.cl;
import bo.app.dd;
import bo.app.dj;
import bo.app.fb;
import bo.app.fd;
import bo.app.fg;
import com.appboy.enums.Gender;
import com.appboy.enums.Month;
import com.appboy.enums.NotificationSubscriptionType;
import com.appboy.models.outgoing.AttributionData;
import com.appboy.models.outgoing.FacebookUser;
import com.appboy.models.outgoing.TwitterUser;
import com.appboy.support.AppboyLogger;
import com.appboy.support.ValidationUtils;

public class AppboyUser
{
  private static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, AppboyUser.class.getName() });
  final Object a = new Object();
  volatile String b;
  private final fd d;
  private final by e;
  private final fb f;
  private final cl g;
  
  AppboyUser(fd paramfd, by paramby, String paramString, cl paramcl, fb paramfb)
  {
    b = paramString;
    d = paramfd;
    e = paramby;
    g = paramcl;
    f = paramfb;
  }
  
  public boolean addToCustomAttributeArray(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (!ValidationUtils.isValidCustomAttributeKey(paramString1)) {
        return false;
      }
      str = paramString1;
      if (!ValidationUtils.isBlacklistedCustomAttributeKey(paramString1, f.h()))
      {
        str = paramString1;
        if (ValidationUtils.isValidCustomAttributeValue(paramString2))
        {
          str = paramString1;
          paramString1 = ValidationUtils.ensureAppboyFieldLength(paramString1);
          str = paramString1;
          paramString2 = dd.c(paramString1, ValidationUtils.ensureAppboyFieldLength(paramString2));
          str = paramString1;
          e.a(paramString2);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppboyLogger.w(c, "Failed to add custom attribute with key '" + str + "'.", paramString1);
    }
    return false;
  }
  
  public String getUserId()
  {
    synchronized (a)
    {
      String str = b;
      return str;
    }
  }
  
  public boolean incrementCustomUserAttribute(String paramString)
  {
    return incrementCustomUserAttribute(paramString, 1);
  }
  
  public boolean incrementCustomUserAttribute(String paramString, int paramInt)
  {
    try
    {
      if (ValidationUtils.isBlacklistedCustomAttributeKey(paramString, f.h())) {
        return false;
      }
      dd localdd = dd.a(paramString, paramInt);
      e.a(localdd);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to increment custom attribute " + paramString + " by " + paramInt + ".", localException);
    }
    return false;
  }
  
  public boolean removeFromCustomAttributeArray(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (!ValidationUtils.isValidCustomAttributeKey(paramString1)) {
        return false;
      }
      str = paramString1;
      if (!ValidationUtils.isBlacklistedCustomAttributeKey(paramString1, f.h()))
      {
        str = paramString1;
        if (ValidationUtils.isValidCustomAttributeValue(paramString2))
        {
          str = paramString1;
          paramString1 = ValidationUtils.ensureAppboyFieldLength(paramString1);
          str = paramString1;
          paramString2 = dd.d(paramString1, ValidationUtils.ensureAppboyFieldLength(paramString2));
          str = paramString1;
          e.a(paramString2);
          return true;
        }
      }
    }
    catch (Exception paramString1)
    {
      AppboyLogger.w(c, "Failed to remove custom attribute with key '" + str + "'.", paramString1);
    }
    return false;
  }
  
  public boolean setAttributionData(AttributionData paramAttributionData)
  {
    try
    {
      d.a(paramAttributionData);
      return true;
    }
    catch (Exception paramAttributionData)
    {
      AppboyLogger.w(c, "Failed to set attribution data.", paramAttributionData);
    }
    return false;
  }
  
  public boolean setAvatarImageUrl(String paramString)
  {
    try
    {
      d.g(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(c, "Failed to set the avatar image URL.", paramString);
    }
    return false;
  }
  
  public boolean setBio(String paramString)
  {
    return false;
  }
  
  public boolean setCountry(String paramString)
  {
    try
    {
      d.d(paramString);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set country to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setCustomAttributeArray(String paramString, String[] paramArrayOfString)
  {
    Object localObject = paramString;
    try
    {
      if (!ValidationUtils.isValidCustomAttributeKey(paramString)) {
        return false;
      }
      localObject = paramString;
      if (!ValidationUtils.isBlacklistedCustomAttributeKey(paramString, f.h()))
      {
        localObject = paramString;
        String str = ValidationUtils.ensureAppboyFieldLength(paramString);
        paramString = paramArrayOfString;
        if (paramArrayOfString != null)
        {
          localObject = str;
          paramString = ValidationUtils.ensureCustomAttributeArrayValues(paramArrayOfString);
        }
        localObject = str;
        paramString = dd.a(str, paramString);
        localObject = str;
        e.a(paramString);
        return true;
      }
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(c, "Failed to set custom attribute array with key: '" + (String)localObject + "'.");
    }
    return false;
  }
  
  public boolean setCustomUserAttribute(String paramString, float paramFloat)
  {
    try
    {
      boolean bool = d.a(paramString, Float.valueOf(paramFloat));
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom float attribute " + paramString + ".", localException);
    }
    return false;
  }
  
  public boolean setCustomUserAttribute(String paramString, int paramInt)
  {
    try
    {
      boolean bool = d.a(paramString, Integer.valueOf(paramInt));
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom integer attribute " + paramString + ".", localException);
    }
    return false;
  }
  
  public boolean setCustomUserAttribute(String paramString, long paramLong)
  {
    try
    {
      boolean bool = d.a(paramString, Long.valueOf(paramLong));
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom long attribute " + paramString + ".", localException);
    }
    return false;
  }
  
  public boolean setCustomUserAttribute(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = d.a(paramString1, paramString2);
      return bool;
    }
    catch (Exception paramString2)
    {
      AppboyLogger.w(c, "Failed to set custom string attribute " + paramString1 + ".", paramString2);
    }
    return false;
  }
  
  public boolean setCustomUserAttribute(String paramString, boolean paramBoolean)
  {
    try
    {
      paramBoolean = d.a(paramString, Boolean.valueOf(paramBoolean));
      return paramBoolean;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom boolean attribute " + paramString + ".", localException);
    }
    return false;
  }
  
  public boolean setCustomUserAttributeToNow(String paramString)
  {
    try
    {
      boolean bool = d.a(paramString, fg.a());
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom attribute " + paramString + " to now.", localException);
    }
    return false;
  }
  
  public boolean setCustomUserAttributeToSecondsFromEpoch(String paramString, long paramLong)
  {
    try
    {
      boolean bool = d.a(paramString, paramLong);
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set custom attribute " + paramString + " to " + paramLong + " seconds from epoch.", localException);
    }
    return false;
  }
  
  public boolean setDateOfBirth(int paramInt1, Month paramMonth, int paramInt2)
  {
    try
    {
      boolean bool = d.a(paramInt1, paramMonth, paramInt2);
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, String.format("Failed to set date of birth to: %d-%d-%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramMonth.getValue()), Integer.valueOf(paramInt2) }), localException);
    }
    return false;
  }
  
  public boolean setEmail(String paramString)
  {
    try
    {
      boolean bool = d.c(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set email to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    try
    {
      d.a(paramNotificationSubscriptionType);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set email notification subscription to: " + paramNotificationSubscriptionType, localException);
    }
    return false;
  }
  
  public boolean setFacebookData(FacebookUser paramFacebookUser)
  {
    try
    {
      d.a(paramFacebookUser);
      return true;
    }
    catch (Exception paramFacebookUser)
    {
      AppboyLogger.w(c, "Failed to set Facebook user data.", paramFacebookUser);
    }
    return false;
  }
  
  public boolean setFirstName(String paramString)
  {
    try
    {
      d.a(paramString);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set first name to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setGender(Gender paramGender)
  {
    try
    {
      d.a(paramGender);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set gender to: " + paramGender, localException);
    }
    return false;
  }
  
  public boolean setHomeCity(String paramString)
  {
    try
    {
      d.e(paramString);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set home city to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setIsSubscribedToEmails(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (NotificationSubscriptionType localNotificationSubscriptionType = NotificationSubscriptionType.SUBSCRIBED;; localNotificationSubscriptionType = NotificationSubscriptionType.UNSUBSCRIBED) {
      return setEmailNotificationSubscriptionType(localNotificationSubscriptionType);
    }
  }
  
  public void setLastKnownLocation(double paramDouble1, double paramDouble2, Double paramDouble3, Double paramDouble4)
  {
    try
    {
      paramDouble3 = new dj(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      g.a(paramDouble3);
      return;
    }
    catch (Exception paramDouble3)
    {
      AppboyLogger.w(c, "Failed to manually set location.", paramDouble3);
    }
  }
  
  public boolean setLastName(String paramString)
  {
    try
    {
      d.b(paramString);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set last name to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setPhoneNumber(String paramString)
  {
    try
    {
      boolean bool = d.f(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set phone number to: " + paramString, localException);
    }
    return false;
  }
  
  public boolean setPushNotificationSubscriptionType(NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    try
    {
      d.b(paramNotificationSubscriptionType);
      return true;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to set push notification subscription to: " + paramNotificationSubscriptionType, localException);
    }
    return false;
  }
  
  public boolean setTwitterData(TwitterUser paramTwitterUser)
  {
    try
    {
      d.a(paramTwitterUser);
      return true;
    }
    catch (Exception paramTwitterUser)
    {
      AppboyLogger.w(c, "Failed to set Twitter user data.", paramTwitterUser);
    }
    return false;
  }
  
  public boolean unsetCustomUserAttribute(String paramString)
  {
    try
    {
      if (ValidationUtils.isBlacklistedCustomAttributeKey(paramString, f.h())) {
        return false;
      }
      boolean bool = d.i(paramString);
      return bool;
    }
    catch (Exception localException)
    {
      AppboyLogger.w(c, "Failed to unset custom attribute " + paramString + ".", localException);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.appboy.AppboyUser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */