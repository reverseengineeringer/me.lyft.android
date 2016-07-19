package com.kochava.android.tracker;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.kochava.android.util.Logging;

@TargetApi(14)
public class Feature$MemoryBoss
  implements ComponentCallbacks2
{
  protected Feature$MemoryBoss(Feature paramFeature) {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void onLowMemory() {}
  
  public void onTrimMemory(int paramInt)
  {
    if (paramInt == 20)
    {
      Logging.Log("MemoryBoss - Tracking Activity lost focus");
      Feature.AppLifeCycleStatusManager.changeStatus("is_in_background");
      Feature.access$4202(true);
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.MemoryBoss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */