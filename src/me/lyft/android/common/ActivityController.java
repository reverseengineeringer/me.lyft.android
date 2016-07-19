package me.lyft.android.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.Window;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class ActivityController
{
  private final BehaviorSubject<Configuration> configurationSubject = BehaviorSubject.create();
  private Activity currentActivity;
  private boolean keepScreenOnEnabled = false;
  
  public void disableKeepScreenOn()
  {
    if (currentActivity == null) {
      return;
    }
    currentActivity.getWindow().clearFlags(6291584);
    keepScreenOnEnabled = false;
  }
  
  public void enableKeepScreenOn()
  {
    if (currentActivity == null) {
      return;
    }
    currentActivity.getWindow().addFlags(6291584);
    keepScreenOnEnabled = true;
  }
  
  public void finish()
  {
    currentActivity.finish();
  }
  
  public Activity getActivity()
  {
    return currentActivity;
  }
  
  public Observable<Configuration> observeConfigurationChange()
  {
    return configurationSubject.asObservable();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    configurationSubject.onNext(paramConfiguration);
  }
  
  public void onCreate(Activity paramActivity)
  {
    currentActivity = paramActivity;
  }
  
  public void onDestroy(Activity paramActivity)
  {
    if (paramActivity.equals(currentActivity))
    {
      if (keepScreenOnEnabled) {
        disableKeepScreenOn();
      }
      currentActivity = null;
    }
  }
  
  public void restoreDefaultOrientation()
  {
    currentActivity.setRequestedOrientation(1);
  }
  
  public void setLandscapeOrientation()
  {
    currentActivity.setRequestedOrientation(0);
  }
  
  public void setRotationOrientation()
  {
    currentActivity.setRequestedOrientation(4);
  }
  
  public void startActivity(Intent paramIntent)
  {
    currentActivity.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    currentActivity.startActivityForResult(paramIntent, paramInt);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.ActivityController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */