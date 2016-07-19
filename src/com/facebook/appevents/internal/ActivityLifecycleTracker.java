package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.FetchedAppSettings;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ActivityLifecycleTracker
{
  private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
  private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000L;
  private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
  private static String appId;
  private static volatile ScheduledFuture currentFuture;
  private static volatile SessionInfo currentSession;
  private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
  private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
  private static AtomicBoolean tracking = new AtomicBoolean(false);
  
  private static void assertIsMainThread() {}
  
  private static void cancelCurrentTask()
  {
    if (currentFuture != null) {
      currentFuture.cancel(false);
    }
    currentFuture = null;
  }
  
  public static UUID getCurrentSessionGuid()
  {
    if (currentSession != null) {
      return currentSession.getSessionId();
    }
    return null;
  }
  
  private static int getSessionTimeoutInSeconds()
  {
    Utility.FetchedAppSettings localFetchedAppSettings = Utility.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
    if (localFetchedAppSettings == null) {
      return Constants.getDefaultAppEventsSessionTimeoutInSeconds();
    }
    return localFetchedAppSettings.getSessionTimeoutInSeconds();
  }
  
  public static boolean isTracking()
  {
    return tracking.get();
  }
  
  public static void onActivityCreated(Activity paramActivity)
  {
    paramActivity = new Runnable()
    {
      public void run()
      {
        if (ActivityLifecycleTracker.currentSession == null)
        {
          Context localContext = val$activity.getApplicationContext();
          String str = Utility.getActivityName(val$activity);
          Object localObject = SessionInfo.getStoredSessionInfo();
          if (localObject != null) {
            SessionLogger.logDeactivateApp(localContext, str, (SessionInfo)localObject, ActivityLifecycleTracker.appId);
          }
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
          localObject = SourceApplicationInfo.Factory.create(val$activity);
          ActivityLifecycleTracker.currentSession.setSourceApplicationInfo((SourceApplicationInfo)localObject);
          SessionLogger.logActivateApp(localContext, str, (SourceApplicationInfo)localObject, ActivityLifecycleTracker.appId);
        }
      }
    };
    singleThreadExecutor.execute(paramActivity);
  }
  
  private static void onActivityPaused(Activity paramActivity)
  {
    if (foregroundActivityCount.decrementAndGet() < 0)
    {
      foregroundActivityCount.set(0);
      Log.w(TAG, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
    }
    cancelCurrentTask();
    paramActivity = new Runnable()
    {
      public void run()
      {
        if (ActivityLifecycleTracker.currentSession == null) {
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
        }
        ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(val$currentTime));
        if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0)
        {
          Runnable local1 = new Runnable()
          {
            public void run()
            {
              if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0)
              {
                SessionLogger.logDeactivateApp(val$applicationContext, val$activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                SessionInfo.clearSavedSessionFromDisk();
                ActivityLifecycleTracker.access$202(null);
              }
              ActivityLifecycleTracker.access$602(null);
            }
          };
          ActivityLifecycleTracker.access$602(ActivityLifecycleTracker.singleThreadExecutor.schedule(local1, ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS));
        }
        ActivityLifecycleTracker.currentSession.writeSessionToDisk();
      }
    };
    singleThreadExecutor.execute(paramActivity);
  }
  
  public static void onActivityResumed(Activity paramActivity)
  {
    foregroundActivityCount.incrementAndGet();
    cancelCurrentTask();
    paramActivity = new Runnable()
    {
      public void run()
      {
        Context localContext = val$activity.getApplicationContext();
        String str = Utility.getActivityName(val$activity);
        if (ActivityLifecycleTracker.currentSession == null)
        {
          ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
          SessionLogger.logActivateApp(localContext, str, null, ActivityLifecycleTracker.appId);
        }
        for (;;)
        {
          ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(val$currentTime));
          ActivityLifecycleTracker.currentSession.writeSessionToDisk();
          return;
          if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null)
          {
            long l = val$currentTime - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
            if (l > ActivityLifecycleTracker.access$400() * 1000)
            {
              SessionLogger.logDeactivateApp(localContext, str, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
              SessionLogger.logActivateApp(localContext, str, null, ActivityLifecycleTracker.appId);
              ActivityLifecycleTracker.access$202(new SessionInfo(Long.valueOf(val$currentTime), null));
            }
            else if (l > 1000L)
            {
              ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
            }
          }
        }
      }
    };
    singleThreadExecutor.execute(paramActivity);
  }
  
  public static void startTracking(Application paramApplication, String paramString)
  {
    if (!tracking.compareAndSet(false, true)) {
      return;
    }
    appId = paramString;
    paramApplication.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        ActivityLifecycleTracker.access$000();
        ActivityLifecycleTracker.onActivityCreated(paramAnonymousActivity);
      }
      
      public void onActivityDestroyed(Activity paramAnonymousActivity) {}
      
      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        ActivityLifecycleTracker.access$000();
        ActivityLifecycleTracker.onActivityPaused(paramAnonymousActivity);
      }
      
      public void onActivityResumed(Activity paramAnonymousActivity)
      {
        ActivityLifecycleTracker.access$000();
        ActivityLifecycleTracker.onActivityResumed(paramAnonymousActivity);
      }
      
      public void onActivitySaveInstanceState(Activity paramAnonymousActivity, Bundle paramAnonymousBundle) {}
      
      public void onActivityStarted(Activity paramAnonymousActivity) {}
      
      public void onActivityStopped(Activity paramAnonymousActivity) {}
    });
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.internal.ActivityLifecycleTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */