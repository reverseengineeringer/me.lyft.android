package me.lyft.android.infrastructure.activity;

import android.app.Activity;
import android.os.Bundle;
import com.jakewharton.rxrelay.BehaviorRelay;
import me.lyft.android.logging.L;
import me.lyft.android.utils.ActivityResult;
import rx.Observable;
import rx.functions.Func1;

public class ActivityLifecycleService
  implements IActivityLifecycleService
{
  private final BehaviorRelay<ActivityResult> activityResultRelay = BehaviorRelay.create();
  private Activity currentActivity;
  
  public ActivityLifecycleService(Activity paramActivity)
  {
    currentActivity = paramActivity;
  }
  
  public void clearResult()
  {
    activityResultRelay.call(null);
  }
  
  public final Activity getCurrentActivity()
  {
    return currentActivity;
  }
  
  public Observable<ActivityResult> observeResult()
  {
    activityResultRelay.filter(new Func1()
    {
      public Boolean call(ActivityResult paramAnonymousActivityResult)
      {
        if (paramAnonymousActivityResult != null) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    L.d("onActivityCreated", new Object[0]);
  }
  
  public void onActivityDestroyed()
  {
    L.d("onActivityDestroyed", new Object[0]);
  }
  
  public void onActivityResult(ActivityResult paramActivityResult)
  {
    activityResultRelay.call(paramActivityResult);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.activity.ActivityLifecycleService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */