package me.lyft.android.infrastructure.activity;

import android.app.Activity;
import android.os.Bundle;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;

public abstract interface IActivityLifecycleService
{
  public abstract void clearResult();
  
  public abstract Activity getCurrentActivity();
  
  public abstract Observable<ActivityResult> observeResult();
  
  public abstract void onActivityCreated(Bundle paramBundle);
  
  public abstract void onActivityDestroyed();
  
  public abstract void onActivityResult(ActivityResult paramActivityResult);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.activity.IActivityLifecycleService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */