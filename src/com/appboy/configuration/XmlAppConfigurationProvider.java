package com.appboy.configuration;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import bo.app.dc;
import bo.app.m;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.PackageUtils;
import com.appboy.support.StringUtils;
import java.util.Locale;
import java.util.Map;

public class XmlAppConfigurationProvider
  extends CachedConfigurationProvider
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, XmlAppConfigurationProvider.class.getName() });
  private final Context b;
  
  public XmlAppConfigurationProvider(Context paramContext)
  {
    super(paramContext);
    b = paramContext;
  }
  
  private int a(m paramm)
  {
    if (paramm.equals(m.b)) {}
    for (paramm = "com_appboy_push_large_notification_icon"; mConfigurationCache.containsKey(paramm); paramm = "com_appboy_push_small_notification_icon") {
      return ((Integer)mConfigurationCache.get(paramm)).intValue();
    }
    int i = b.getResources().getIdentifier(paramm, "drawable", PackageUtils.getResourcePackageName(b));
    mConfigurationCache.put(paramm, Integer.valueOf(i));
    return i;
  }
  
  public dc getAppboyApiKey()
  {
    dc localdc2 = (dc)mConfigurationCache.get("com_appboy_api_key");
    dc localdc1 = localdc2;
    String str;
    if (localdc2 == null)
    {
      str = b.getSharedPreferences("com_appboy_override_configuration_cache", 0).getString("com_appboy_api_key", null);
      if (str == null) {
        break label176;
      }
      AppboyLogger.i(a, "Found an override api key.  Using it to configure Appboy.");
    }
    for (;;)
    {
      localdc1 = localdc2;
      if (str != null)
      {
        localdc1 = new dc(str);
        mConfigurationCache.put("com_appboy_api_key", localdc1);
      }
      if (localdc1 != null) {
        break;
      }
      AppboyLogger.e(a, "****************************************************");
      AppboyLogger.e(a, "**                                                **");
      AppboyLogger.e(a, "**                 !! WARNING !!                  **");
      AppboyLogger.e(a, "**                                                **");
      AppboyLogger.e(a, "**     No API key set in res/values/appboy.xml    **");
      AppboyLogger.e(a, "** No cached API Key found from Appboy.configure  **");
      AppboyLogger.e(a, "**         Appboy functionality disabled          **");
      AppboyLogger.e(a, "**                                                **");
      AppboyLogger.e(a, "****************************************************");
      throw new RuntimeException("Unable to read the Appboy API key from the res/values/appboy.xml file. See log for more details.");
      label176:
      str = getAppboyApiKeyStringFromLocaleMapping(Locale.getDefault());
      if (str != null) {
        AppboyLogger.i(a, "Found a locale that matches the current locale in appboy.xml.  Using the associated api key");
      } else {
        str = readStringResourceValue("com_appboy_api_key", null);
      }
    }
    return localdc1;
  }
  
  public String getAppboyApiKeyStringFromLocaleMapping(Locale paramLocale)
  {
    if (paramLocale == null) {
      paramLocale = a;
    }
    for (;;)
    {
      return null;
      String[] arrayOfString = readStringArrayResourceValue("com_appboy_locale_api_key_map", null);
      if (arrayOfString == null)
      {
        paramLocale = a;
        return null;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfString[i];
        if (StringUtils.countOccurrences((String)localObject, ",") == 1)
        {
          localObject = ((String)localObject).split(",");
          if (localObject.length == 2)
          {
            String str = localObject[0].trim().toLowerCase();
            boolean bool = str.equals(paramLocale.toString().toLowerCase());
            if ((str.equals(paramLocale.getCountry().toLowerCase())) || (bool)) {
              return localObject[1].trim();
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public int getApplicationIconResourceId()
  {
    i = 0;
    if (mConfigurationCache.containsKey("application_icon")) {
      return ((Integer)mConfigurationCache.get("application_icon")).intValue();
    }
    str = b.getPackageName();
    try
    {
      j = b.getPackageManager().getApplicationInfo(str, 0).icon;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      for (;;)
      {
        int j;
        AppboyLogger.e(a, String.format("Cannot find package named %s", new Object[] { str }));
        try
        {
          j = b.getPackageManager().getApplicationInfo(b.getPackageName(), 0).icon;
          i = j;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          AppboyLogger.e(a, String.format("Cannot find package named %s", new Object[] { str }));
        }
      }
    }
    mConfigurationCache.put("application_icon", Integer.valueOf(i));
    return i;
  }
  
  public String getBaseUrlForRequests()
  {
    if ("STAGING".equals(getStringValue("com_appboy_server_target", "PROD").toUpperCase(Locale.US))) {
      return "https://sondheim.appboy.com/api/v2/";
    }
    return "https://dev.appboy.com/api/v2/";
  }
  
  public int getDefaultNotificationAccentColor()
  {
    return getIntValue("com_appboy_default_notification_accent_color", 0);
  }
  
  public String getGcmSenderId()
  {
    return getStringValue("com_appboy_push_gcm_sender_id", null);
  }
  
  public boolean getIsUilImageCacheDisabled()
  {
    return getBooleanValue("com_appboy_disable_uil_image_cache", false);
  }
  
  public int getLargeNotificationIconResourceId()
  {
    return a(m.b);
  }
  
  public float getLocationUpdateDistanceInMeters()
  {
    return getIntValue("com_appboy_location_update_distance", -1);
  }
  
  public long getLocationUpdateTimeIntervalInMillis()
  {
    return 1000L * getIntValue("com_appboy_location_update_time_interval", -1);
  }
  
  public int getSessionTimeoutSeconds()
  {
    return getIntValue("com_appboy_session_timeout", 10);
  }
  
  public int getSmallNotificationIconResourceId()
  {
    return a(m.a);
  }
  
  public long getTriggerActionMinimumTimeIntervalInSeconds()
  {
    return getIntValue("com_appboy_trigger_action_minimum_time_interval_seconds", 30);
  }
  
  public int getVersionCode()
  {
    if (mConfigurationCache.containsKey("version_code")) {
      return ((Integer)mConfigurationCache.get("version_code")).intValue();
    }
    try
    {
      String str = PackageUtils.getResourcePackageName(b);
      i = b.getPackageManager().getPackageInfo(str, 0).versionCode;
      mConfigurationCache.put("version_code", Integer.valueOf(i));
      return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        AppboyLogger.e(a, "Unable to read the version code.");
        int i = -1;
      }
    }
  }
  
  public boolean isAdmMessagingRegistrationEnabled()
  {
    return getBooleanValue("com_appboy_push_adm_messaging_registration_enabled", false);
  }
  
  public boolean isBackgroundLocationCollectionEnabled()
  {
    return getBooleanValue("com_appboy_enable_background_location_collection", false);
  }
  
  public boolean isGcmMessagingRegistrationEnabled()
  {
    return getBooleanValue("com_appboy_push_gcm_messaging_registration_enabled", false);
  }
  
  public boolean isLocationCollectionEnabled()
  {
    boolean bool = false;
    if (!getBooleanValue("com_appboy_disable_location_collection", false)) {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.appboy.configuration.XmlAppConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */