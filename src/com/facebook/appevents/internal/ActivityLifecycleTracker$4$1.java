package com.facebook.appevents.internal;

import java.util.concurrent.atomic.AtomicInteger;

class ActivityLifecycleTracker$4$1
  implements Runnable
{
  ActivityLifecycleTracker$4$1(ActivityLifecycleTracker.4 param4) {}
  
  public void run()
  {
    if (ActivityLifecycleTracker.access$500().get() <= 0)
    {
      SessionLogger.logDeactivateApp(this$0.val$applicationContext, this$0.val$activityName, ActivityLifecycleTracker.access$200(), ActivityLifecycleTracker.access$300());
      SessionInfo.clearSavedSessionFromDisk();
      ActivityLifecycleTracker.access$202(null);
    }
    ActivityLifecycleTracker.access$602(null);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.4.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */