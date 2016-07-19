package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.Context;
import com.facebook.internal.Utility;

final class ActivityLifecycleTracker$2
  implements Runnable
{
  ActivityLifecycleTracker$2(Activity paramActivity, long paramLong) {}
  
  public void run()
  {
    if (ActivityLifecycleTracker.access$200() == null)
    {
      Context localContext = val$activity.getApplicationContext();
      String str = Utility.getActivityName(val$activity);
      Object localObject = SessionInfo.getStoredSessionInfo();
      if (localObject != null) {
        SessionLogger.logDeactivateApp(localContext, str, (SessionInfo)localObject, ActivityLifecycleTracker.access$300());
      }
      ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
      localObject = SourceApplicationInfo.Factory.create(val$activity);
      ActivityLifecycleTracker.access$200().setSourceApplicationInfo((SourceApplicationInfo)localObject);
      SessionLogger.logActivateApp(localContext, str, (SourceApplicationInfo)localObject, ActivityLifecycleTracker.access$300());
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */