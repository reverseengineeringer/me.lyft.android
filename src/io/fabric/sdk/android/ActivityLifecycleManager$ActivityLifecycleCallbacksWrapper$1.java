package io.fabric.sdk.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class ActivityLifecycleManager$ActivityLifecycleCallbacksWrapper$1
  implements Application.ActivityLifecycleCallbacks
{
  ActivityLifecycleManager$ActivityLifecycleCallbacksWrapper$1(ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper paramActivityLifecycleCallbacksWrapper, ActivityLifecycleManager.Callbacks paramCallbacks) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    val$callbacks.onActivityCreated(paramActivity, paramBundle);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    val$callbacks.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    val$callbacks.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    val$callbacks.onActivityResumed(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    val$callbacks.onActivitySaveInstanceState(paramActivity, paramBundle);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    val$callbacks.onActivityStarted(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    val$callbacks.onActivityStopped(paramActivity);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */