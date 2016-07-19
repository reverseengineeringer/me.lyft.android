package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

@TargetApi(14)
class zzac$zza
  implements Application.ActivityLifecycleCallbacks
{
  private zzac$zza(zzac paramzzac) {}
  
  private boolean zzmi(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      ana.zzd("auto", "_ldl", paramString);
      return true;
    }
    return false;
  }
  
  private boolean zzs(Uri paramUri)
  {
    String str1 = paramUri.getQueryParameter("utm_campaign");
    String str2 = paramUri.getQueryParameter("utm_source");
    String str3 = paramUri.getQueryParameter("utm_medium");
    String str4 = paramUri.getQueryParameter("gclid");
    if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str4)))
    {
      Bundle localBundle = new Bundle();
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("campaign", str1);
      }
      if (!TextUtils.isEmpty(str2)) {
        localBundle.putString("source", str2);
      }
      if (!TextUtils.isEmpty(str3)) {
        localBundle.putString("medium", str3);
      }
      if (!TextUtils.isEmpty(str4)) {
        localBundle.putString("gclid", str4);
      }
      str1 = paramUri.getQueryParameter("utm_term");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("term", str1);
      }
      str1 = paramUri.getQueryParameter("utm_content");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("content", str1);
      }
      str1 = paramUri.getQueryParameter("aclid");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("aclid", str1);
      }
      str1 = paramUri.getQueryParameter("cp1");
      if (!TextUtils.isEmpty(str1)) {
        localBundle.putString("cp1", str1);
      }
      paramUri = paramUri.getQueryParameter("anid");
      if (!TextUtils.isEmpty(paramUri)) {
        localBundle.putString("anid", paramUri);
      }
      ana.zze("auto", "_cmp", localBundle);
      return true;
    }
    return false;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    try
    {
      ana.zzbsz().zzbty().log("onActivityCreated");
      paramActivity = paramActivity.getIntent();
      if (paramActivity == null) {
        return;
      }
      paramActivity = paramActivity.getData();
      if ((paramActivity == null) || (!paramActivity.isHierarchical())) {
        return;
      }
      if (paramBundle == null) {
        zzs(paramActivity);
      }
      paramActivity = paramActivity.getQueryParameter("referrer");
      if (TextUtils.isEmpty(paramActivity)) {
        return;
      }
      if (!paramActivity.contains("gclid"))
      {
        ana.zzbsz().zzbtx().log("Activity created with data 'referrer' param without gclid");
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      ana.zzbsz().zzbtr().zzj("Throwable caught in onActivityCreated", paramActivity);
      return;
    }
    ana.zzbsz().zzbtx().zzj("Activity created with referrer", paramActivity);
    zzmi(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    ana.zzbsx().zzbvv();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    ana.zzbsx().zzbvt();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzac.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */