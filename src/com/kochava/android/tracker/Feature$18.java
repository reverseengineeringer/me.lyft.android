package com.kochava.android.tracker;

import com.kochava.android.util.Logging;
import java.util.TimerTask;

class Feature$18
  extends TimerTask
{
  Feature$18(Feature paramFeature) {}
  
  public void run()
  {
    if ((Feature.access$1400()) && (System.currentTimeMillis() - Feature.access$4900() < Feature.access$1300()))
    {
      Logging.Log("Too soon since last event, flush timer waiting for next flush attempt.");
      return;
    }
    Feature.flush();
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.18
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */