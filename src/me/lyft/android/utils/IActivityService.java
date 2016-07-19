package me.lyft.android.utils;

import android.app.Activity;
import android.os.Bundle;

public abstract interface IActivityService
{
  public abstract void onActivityCreated(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityDestroyed(Activity paramActivity);
  
  public abstract void onActivityPaused(Activity paramActivity);
  
  public abstract void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult);
  
  public abstract void onActivityResumed(Activity paramActivity);
  
  public abstract void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle);
  
  public abstract void onActivityStarted(Activity paramActivity);
  
  public abstract void onActivityStopped(Activity paramActivity);
}

/* Location:
 * Qualified Name:     me.lyft.android.utils.IActivityService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */