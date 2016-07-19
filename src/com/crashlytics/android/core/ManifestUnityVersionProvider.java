package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

class ManifestUnityVersionProvider
  implements UnityVersionProvider
{
  private final Context context;
  private final String packageName;
  
  public ManifestUnityVersionProvider(Context paramContext, String paramString)
  {
    context = paramContext;
    packageName = paramString;
  }
  
  public String getUnityVersion()
  {
    String str = null;
    Object localObject = context.getPackageManager();
    try
    {
      localObject = getApplicationInfopackageName, 128).metaData;
      if (localObject != null) {
        str = ((Bundle)localObject).getString("io.fabric.unity.crashlytics.version");
      }
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.ManifestUnityVersionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */