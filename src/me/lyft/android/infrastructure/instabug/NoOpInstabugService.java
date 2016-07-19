package me.lyft.android.infrastructure.instabug;

import android.app.Activity;
import android.os.Bundle;
import me.lyft.android.maps.LyftMapView;
import me.lyft.android.utils.ActivityResult;
import me.lyft.android.utils.IActivityService;

public class NoOpInstabugService
  implements IInstabugService, IActivityService
{
  public void addMapView(LyftMapView paramLyftMapView) {}
  
  public void dismissIfShowing() {}
  
  public boolean isNull()
  {
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResult(Activity paramActivity, ActivityResult paramActivityResult) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity) {}
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.instabug.NoOpInstabugService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */