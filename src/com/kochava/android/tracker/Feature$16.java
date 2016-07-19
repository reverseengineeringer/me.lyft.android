package com.kochava.android.tracker;

import java.util.TimerTask;

class Feature$16
  extends TimerTask
{
  Feature$16(Feature paramFeature) {}
  
  public void run()
  {
    if (Feature.access$4200()) {
      Feature.flush();
    }
    Feature.access$4302(false);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */