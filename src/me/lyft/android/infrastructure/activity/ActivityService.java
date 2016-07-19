package me.lyft.android.infrastructure.activity;

import android.app.Activity;
import android.os.Bundle;
import me.lyft.android.logging.L;
import me.lyft.android.utils.ActivityResult;
import me.lyft.android.utils.IActivityService;

public abstract class ActivityService
  implements IActivityService
{
  private Activity currentActivity;
  
  protected final Activity getCurrentActivity()
  {
    return currentActivity;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    currentActivity = paramActivity;
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity.equals(currentActivity))
    {
      currentActivity = null;
      return;
    }
    L.e(new IllegalStateException(), "Destroyed and current activity did not match", new Object[0]);
  }
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.activity.ActivityService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */