package com.kochava.android.tracker;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.kochava.android.util.Logging;

@TargetApi(14)
public class Feature$LifeCycleTracker
  implements Application.ActivityLifecycleCallbacks
{
  protected Feature$LifeCycleTracker(Feature paramFeature) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity)
  {
    Logging.Log("LifeCycleTracker - Tracking Activity lost focus");
    Feature.AppLifeCycleStatusManager.changeStatus("is_in_background");
    Feature.access$4202(true);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Logging.Log("LifeCycleTracker - Tracking Activity Resumed");
    Feature.AppLifeCycleStatusManager.changeStatus("is_focused");
    Feature.access$4202(false);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.LifeCycleTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */