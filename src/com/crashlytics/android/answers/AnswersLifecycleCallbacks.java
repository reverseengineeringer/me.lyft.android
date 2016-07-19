package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;

class AnswersLifecycleCallbacks
  extends ActivityLifecycleManager.Callbacks
{
  private final SessionAnalyticsManager analyticsManager;
  private final BackgroundManager backgroundManager;
  
  public AnswersLifecycleCallbacks(SessionAnalyticsManager paramSessionAnalyticsManager, BackgroundManager paramBackgroundManager)
  {
    analyticsManager = paramSessionAnalyticsManager;
    backgroundManager = paramBackgroundManager;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.PAUSE);
    backgroundManager.onActivityPaused();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.RESUME);
    backgroundManager.onActivityResumed();
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.START);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    analyticsManager.onLifecycle(paramActivity, SessionEvent.Type.STOP);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersLifecycleCallbacks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */