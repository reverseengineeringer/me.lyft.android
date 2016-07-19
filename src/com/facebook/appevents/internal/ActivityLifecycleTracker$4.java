package com.facebook.appevents.internal;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class ActivityLifecycleTracker$4
  implements Runnable
{
  ActivityLifecycleTracker$4(long paramLong, Context paramContext, String paramString) {}
  
  public void run()
  {
    if (ActivityLifecycleTracker.access$200() == null) {
      ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
    }
    ActivityLifecycleTracker.access$200().setSessionLastEventTime(Long.valueOf(val$currentTime));
    if (ActivityLifecycleTracker.access$500().get() <= 0)
    {
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          if (ActivityLifecycleTracker.access$500().get() <= 0)
          {
            SessionLogger.logDeactivateApp(val$applicationContext, val$activityName, ActivityLifecycleTracker.access$200(), ActivityLifecycleTracker.access$300());
            SessionInfo.clearSavedSessionFromDisk();
            ActivityLifecycleTracker.access$202(null);
          }
          ActivityLifecycleTracker.access$602(null);
        }
      };
      ActivityLifecycleTracker.access$602(ActivityLifecycleTracker.access$700().schedule(local1, ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS));
    }
    ActivityLifecycleTracker.access$200().writeSessionToDisk();
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */