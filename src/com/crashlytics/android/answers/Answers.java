package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.Crash.FatalException;
import io.fabric.sdk.android.services.common.Crash.LoggedException;
import io.fabric.sdk.android.services.settings.FeaturesSettingsData;
import io.fabric.sdk.android.services.settings.Settings;
import io.fabric.sdk.android.services.settings.SettingsData;
import java.io.File;

public class Answers
  extends Kit<Boolean>
{
  SessionAnalyticsManager analyticsManager;
  
  protected Boolean doInBackground()
  {
    try
    {
      SettingsData localSettingsData = Settings.getInstance().awaitSettingsData();
      if (localSettingsData == null)
      {
        Fabric.getLogger().e("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
      }
      if (featuresData.collectAnalytics)
      {
        Fabric.getLogger().d("Answers", "Analytics collection enabled");
        analyticsManager.setAnalyticsSettingsData(analyticsSettingsData, getOverridenSpiEndpoint());
        return Boolean.valueOf(true);
      }
      Fabric.getLogger().d("Answers", "Analytics collection disabled");
      analyticsManager.disable();
      return Boolean.valueOf(false);
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Error dealing with settings", localException);
    }
    return Boolean.valueOf(false);
  }
  
  public String getIdentifier()
  {
    return "com.crashlytics.sdk.android:answers";
  }
  
  String getOverridenSpiEndpoint()
  {
    return CommonUtils.getStringsFileValue(getContext(), "com.crashlytics.ApiEndpoint");
  }
  
  public String getVersion()
  {
    return "1.3.6.97";
  }
  
  public void onException(Crash.FatalException paramFatalException)
  {
    if (analyticsManager != null) {
      analyticsManager.onCrash(paramFatalException.getSessionId());
    }
  }
  
  public void onException(Crash.LoggedException paramLoggedException)
  {
    if (analyticsManager != null) {
      analyticsManager.onError(paramLoggedException.getSessionId());
    }
  }
  
  @SuppressLint({"NewApi"})
  protected boolean onPreExecute()
  {
    try
    {
      Context localContext = getContext();
      PackageManager localPackageManager = localContext.getPackageManager();
      String str2 = localContext.getPackageName();
      PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str2, 0);
      String str3 = Integer.toString(versionCode);
      String str1;
      if (versionName == null)
      {
        str1 = "0.0";
        if (Build.VERSION.SDK_INT < 9) {
          break label101;
        }
      }
      label101:
      for (long l = firstInstallTime;; l = new File(getApplicationInfo0sourceDir).lastModified())
      {
        analyticsManager = SessionAnalyticsManager.build(this, localContext, getIdManager(), str3, str1, l);
        analyticsManager.enable();
        return true;
        str1 = versionName;
        break;
      }
      return false;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Error retrieving app properties", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.Answers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */