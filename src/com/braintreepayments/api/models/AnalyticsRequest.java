package com.braintreepayments.api.models;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.braintreepayments.api.Utils;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.UUID;

public class AnalyticsRequest
{
  public Meta _meta;
  public Analytics[] analytics;
  
  public AnalyticsRequest(Context paramContext, String paramString1, String paramString2)
  {
    analytics = new Analytics[] { new Analytics(paramString1) };
    _meta = new Meta(paramContext, paramString2);
  }
  
  public String toJson()
  {
    return Utils.getGson().toJson(this);
  }
  
  private class Analytics
  {
    private String kind;
    
    public Analytics(String paramString)
    {
      kind = paramString;
    }
  }
  
  private class Meta
  {
    private String androidId;
    private String deviceAppGeneratedPersistentUuid;
    private String deviceManufacturer;
    private String deviceModel;
    private String deviceNetworkType;
    private String deviceRooted;
    private String deviceScreenOrientation;
    private String integrationType;
    private String isSimulator;
    private String merchantAppId;
    private String merchantAppName;
    private String merchantAppVersion;
    private String platform;
    private String platformVersion;
    private String sdkVersion;
    private String userInterfaceOrientation;
    
    Meta(Context paramContext, String paramString)
    {
      String str = paramContext.getPackageName();
      PackageManager localPackageManager = paramContext.getPackageManager();
      try
      {
        this$1 = localPackageManager.getApplicationInfo(str, 0);
        platform = "Android";
        platformVersion = Integer.toString(Build.VERSION.SDK_INT);
        sdkVersion = "1.4.0";
        merchantAppId = str;
        merchantAppName = getAppName(AnalyticsRequest.this, localPackageManager);
        merchantAppVersion = getAppVersion(localPackageManager, str);
        deviceRooted = isDeviceRooted();
        deviceManufacturer = Build.MANUFACTURER;
        deviceModel = Build.MODEL;
        deviceNetworkType = getNetworkType(paramContext);
        androidId = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
        deviceAppGeneratedPersistentUuid = getUUID(paramContext);
        isSimulator = detectEmulator();
        integrationType = paramString;
        userInterfaceOrientation = getUserOrientation(paramContext);
        return;
      }
      catch (PackageManager.NameNotFoundException this$1)
      {
        for (;;)
        {
          this$1 = null;
        }
      }
    }
    
    private String detectEmulator()
    {
      if (("google_sdk".equalsIgnoreCase(Build.PRODUCT)) || ("sdk".equalsIgnoreCase(Build.PRODUCT)) || ("Genymotion".equalsIgnoreCase(Build.MANUFACTURER))) {
        return "true";
      }
      return "false";
    }
    
    private String getAppName(ApplicationInfo paramApplicationInfo, PackageManager paramPackageManager)
    {
      if (paramApplicationInfo != null) {
        return (String)paramPackageManager.getApplicationLabel(paramApplicationInfo);
      }
      return "ApplicationNameUnknown";
    }
    
    private String getAppVersion(PackageManager paramPackageManager, String paramString)
    {
      try
      {
        paramPackageManager = getPackageInfo0versionName;
        return paramPackageManager;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager) {}
      return "VersionUnknown";
    }
    
    private String getNetworkType(Context paramContext)
    {
      return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getTypeName();
    }
    
    private String getUUID(Context paramContext)
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("BraintreeApi", 0);
      String str = localSharedPreferences.getString("braintreeUUID", null);
      paramContext = str;
      if (str == null)
      {
        paramContext = UUID.randomUUID().toString().replace("-", "");
        localSharedPreferences.edit().putString("braintreeUUID", paramContext).apply();
      }
      return paramContext;
    }
    
    private String getUserOrientation(Context paramContext)
    {
      switch (getResourcesgetConfigurationorientation)
      {
      default: 
        return "Unknown";
      case 1: 
        return "Portrait";
      }
      return "Landscape";
    }
    
    private String isDeviceRooted()
    {
      boolean bool2 = false;
      String str = Build.TAGS;
      int j;
      if ((str != null) && (str.contains("test-keys"))) {
        j = 1;
      }
      try
      {
        for (;;)
        {
          bool1 = new File("/system/app/Superuser.apk").exists();
          try
          {
            str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" }).getInputStream())).readLine();
            if (str == null) {
              break;
            }
            i = 1;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              int i = 0;
            }
          }
          if ((j == 0) && (!bool1))
          {
            bool1 = bool2;
            if (i == 0) {}
          }
          else
          {
            bool1 = true;
          }
          return Boolean.toString(bool1);
          j = 0;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          boolean bool1 = false;
          continue;
          i = 0;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.braintreepayments.api.models.AnalyticsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */