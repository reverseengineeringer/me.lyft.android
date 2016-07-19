package com.kochava.android.tracker;

import android.content.Context;
import android.provider.Settings.Secure;

class Feature$5
  extends Thread
{
  Feature$5(Feature paramFeature) {}
  
  public void run()
  {
    try
    {
      Feature.access$302(this$0, Settings.Secure.getString(Feature.appContext.getContentResolver(), "android_id"));
      return;
    }
    catch (Exception localException)
    {
      while (!Global.DEBUGERROR) {}
      localException.printStackTrace();
    }
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */