package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.facebook.appevents.AppEventsLogger;

final class ActivityLifecycleTracker$1
  implements Application.ActivityLifecycleCallbacks
{
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    ActivityLifecycleTracker.access$000();
    ActivityLifecycleTracker.onActivityCreated(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    ActivityLifecycleTracker.access$000();
    ActivityLifecycleTracker.access$100(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    ActivityLifecycleTracker.access$000();
    ActivityLifecycleTracker.onActivityResumed(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */