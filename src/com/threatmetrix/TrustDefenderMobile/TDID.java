package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Locale;
import java.util.UUID;

class TDID
{
  private static final String TAG = StringUtils.getLogTag(TDID.class);
  
  static String checkLength(String paramString)
    throws InterruptedException
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    String str;
    do
    {
      return null;
      if (paramString.length() == 32) {
        return paramString;
      }
      if (paramString.length() >= 32) {
        break;
      }
      str = StringUtils.MD5(paramString);
    } while (str == null);
    int j = 32 - paramString.length();
    int i = j;
    if (j > str.length()) {
      i = str.length();
    }
    for (paramString = paramString + str.substring(0, i);; paramString = StringUtils.MD5(paramString)) {
      return paramString;
    }
  }
  
  static String getAndroidID(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    if ((str != null) && (!str.equals("9774d56d682e549c")))
    {
      paramContext = str;
      if (str.length() >= 15) {}
    }
    else
    {
      Log.d(TAG, "ANDROID_ID contains nothing useful");
      paramContext = null;
    }
    return paramContext;
  }
  
  static String getCookie(String paramString, boolean paramBoolean)
    throws InterruptedException
  {
    String str1 = paramString;
    String str2 = str1;
    if (str1 != null)
    {
      if (paramBoolean) {
        str1 = StringUtils.MD5(paramString);
      }
      Log.d(TAG, "using ANDROID_ID for TPC:" + str1);
      str2 = str1;
    }
    return checkLength(str2);
  }
  
  static String getFlashCookie(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws InterruptedException
  {
    paramString1 = getSerial(paramString1, paramString2, paramString3);
    paramContext = paramString1;
    if (paramBoolean) {
      paramContext = StringUtils.MD5(paramString1);
    }
    return checkLength(StringUtils.MD5(paramContext));
  }
  
  static String getHTML5Cookie(String paramString, boolean paramBoolean)
    throws InterruptedException
  {
    String str = paramString;
    if (paramBoolean) {
      str = StringUtils.MD5(paramString);
    }
    Log.d(TAG, "using generated ID for LSC:" + str);
    return checkLength(str);
  }
  
  static String getIMEI(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      Log.d(TAG, "imei: " + paramContext);
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      Log.d(TAG, "imei failed", paramContext);
    }
    return "";
  }
  
  static String getPref(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("ThreatMetrixMobileSDK", 0);
    Object localObject = localSharedPreferences.getString("ThreatMetrixMobileSDK", null);
    paramContext = (Context)localObject;
    if (localObject == null)
    {
      Log.d(TAG, "Found nothing in shared prefs, generating GUID");
      paramContext = UUID.randomUUID().toString().replace("-", "").toLowerCase(Locale.US);
      localObject = localSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putString("ThreatMetrixMobileSDK", paramContext);
      ((SharedPreferences.Editor)localObject).commit();
    }
    return paramContext;
  }
  
  private static String getSerial(String paramString1, String paramString2, String paramString3)
  {
    if (Build.SERIAL == null) {}
    for (String str = ""; (paramString3 != null) && (!paramString3.isEmpty()) && (!paramString3.equals("000000000000000")); str = Build.SERIAL) {
      return str + paramString3;
    }
    if (paramString1 != null) {
      return str + paramString1;
    }
    return str + paramString2;
  }
  
  static boolean isDodgySerial()
  {
    boolean bool2 = false;
    String str = Build.SERIAL;
    boolean bool1 = bool2;
    if (str != null) {
      if (!str.equals("unknown"))
      {
        bool1 = bool2;
        if (!str.equals("1234567890ABCDEF")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.TDID
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */