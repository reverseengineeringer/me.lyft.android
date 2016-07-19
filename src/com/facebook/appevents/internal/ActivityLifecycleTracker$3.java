package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.Context;
import com.facebook.internal.Utility;

final class ActivityLifecycleTracker$3
  implements Runnable
{
  ActivityLifecycleTracker$3(Activity paramActivity, long paramLong) {}
  
  public void run()
  {
    Context localContext = val$activity.getApplicationContext();
    String str = Utility.getActivityName(val$activity);
    if (ActivityLifecycleTracker.access$200() == null)
    {
      ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
      SessionLogger.logActivateApp(localContext, str, null, ActivityLifecycleTracker.access$300());
    }
    for (;;)
    {
      ActivityLifecycleTracker.access$200().setSessionLastEventTime(Long.valueOf(val$currentTime));
      ActivityLifecycleTracker.access$200().writeSessionToDisk();
      return;
      if (ActivityLifecycleTracker.access$200().getSessionLastEventTime() != null)
      {
        long l = val$currentTime - ActivityLifecycleTracker.access$200().getSessionLastEventTime().longValue();
        if (l > ActivityLifecycleTracker.access$400() * 1000)
        {
          SessionLogger.logDeactivateApp(localContext, str, ActivityLifecycleTracker.access$200(), ActivityLifecycleTracker.access$300());
          SessionLogger.logActivateApp(localContext, str, null, ActivityLifecycleTracker.access$300());
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
        }
        else if (l > 1000L)
        {
          ActivityLifecycleTracker.access$200().incrementInterruptionCount();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */