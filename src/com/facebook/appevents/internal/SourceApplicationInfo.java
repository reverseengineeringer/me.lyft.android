package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import bolts.AppLinks;
import com.facebook.FacebookSdk;

class SourceApplicationInfo
{
  private static final String CALL_APPLICATION_PACKAGE_KEY = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
  private static final String OPENED_BY_APP_LINK_KEY = "com.facebook.appevents.SourceApplicationInfo.openedByApplink";
  private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
  private String callingApplicationPackage;
  private boolean openedByApplink;
  
  private SourceApplicationInfo(String paramString, boolean paramBoolean)
  {
    callingApplicationPackage = paramString;
    openedByApplink = paramBoolean;
  }
  
  public static void clearSavedSourceApplicationInfoFromDisk()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
    localEditor.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
    localEditor.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
    localEditor.apply();
  }
  
  public static SourceApplicationInfo getStoredSourceApplicatioInfo()
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
    if (!localSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
      return null;
    }
    return new SourceApplicationInfo(localSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), localSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
  }
  
  public String getCallingApplicationPackage()
  {
    return callingApplicationPackage;
  }
  
  public boolean isOpenedByApplink()
  {
    return openedByApplink;
  }
  
  public String toString()
  {
    String str1 = "Unclassified";
    if (openedByApplink) {
      str1 = "Applink";
    }
    String str2 = str1;
    if (callingApplicationPackage != null) {
      str2 = str1 + "(" + callingApplicationPackage + ")";
    }
    return str2;
  }
  
  public void writeSourceApplicationInfoToDisk()
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
    localEditor.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", callingApplicationPackage);
    localEditor.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", openedByApplink);
    localEditor.apply();
  }
  
  public static class Factory
  {
    public static SourceApplicationInfo create(Activity paramActivity)
    {
      boolean bool2 = false;
      Object localObject = paramActivity.getCallingActivity();
      if (localObject == null) {}
      do
      {
        return null;
        localObject = ((ComponentName)localObject).getPackageName();
      } while (((String)localObject).equals(paramActivity.getPackageName()));
      Intent localIntent = paramActivity.getIntent();
      paramActivity = (Activity)localObject;
      boolean bool1 = bool2;
      if (localIntent != null)
      {
        paramActivity = (Activity)localObject;
        bool1 = bool2;
        if (!localIntent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false))
        {
          localIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
          Bundle localBundle = AppLinks.getAppLinkData(localIntent);
          paramActivity = (Activity)localObject;
          bool1 = bool2;
          if (localBundle != null)
          {
            bool2 = true;
            localBundle = localBundle.getBundle("referer_app_link");
            paramActivity = (Activity)localObject;
            bool1 = bool2;
            if (localBundle != null)
            {
              paramActivity = localBundle.getString("package");
              bool1 = bool2;
            }
          }
        }
      }
      localIntent.putExtra("_fbSourceApplicationHasBeenSet", true);
      return new SourceApplicationInfo(paramActivity, bool1, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.SourceApplicationInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */