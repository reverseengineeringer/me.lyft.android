package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@zzir
@TargetApi(14)
public class zzcn
  implements Application.ActivityLifecycleCallbacks
{
  private Activity mActivity;
  private Context mContext;
  private final Object zzail = new Object();
  
  public zzcn(Application paramApplication, Context paramContext)
  {
    paramApplication.registerActivityLifecycleCallbacks(this);
    if ((paramContext instanceof Activity)) {
      setActivity((Activity)paramContext);
    }
    mContext = paramContext;
  }
  
  private void setActivity(Activity paramActivity)
  {
    synchronized (zzail)
    {
      if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads")) {
        mActivity = paramActivity;
      }
      return;
    }
  }
  
  public Activity getActivity()
  {
    return mActivity;
  }
  
  public Context getContext()
  {
    return mContext;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (zzail)
    {
      if (mActivity == null) {
        return;
      }
      if (mActivity.equals(paramActivity)) {
        mActivity = null;
      }
      return;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzcn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */