package com.kochava.android.tracker;

import com.kochava.android.util.Logging;

final class Feature$AppLifeCycleStatusManager$1
  extends Thread
{
  Feature$AppLifeCycleStatusManager$1(String paramString) {}
  
  public void run()
  {
    if (!Feature.AppLifeCycleStatusManager.active) {
      Logging.Log("AppLifeCycleStatusManager - not active");
    }
    do
    {
      return;
      if (val$status.equals("is_focused"))
      {
        if (!Feature.AppLifeCycleStatusManager.resumed)
        {
          Logging.Log("AppLifeCycleStatusManager - not already resumed, starting session...");
          Feature.access$5100();
          Feature.AppLifeCycleStatusManager.resumed = true;
          return;
        }
        Logging.Log("AppLifeCycleStatusManager - IS_FOCUSED received, App is already in focused state.");
        return;
      }
    } while (!val$status.equals("is_in_background"));
    if (Feature.AppLifeCycleStatusManager.resumed)
    {
      Logging.Log("AppLifeCycleStatusManager - going to background from app, ending session");
      Feature.access$5200();
      Feature.AppLifeCycleStatusManager.resumed = false;
      return;
    }
    Logging.Log("AppLifeCycleStatusManager - IS_IN_BACKGROUND received, App is already in background state.");
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.AppLifeCycleStatusManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */