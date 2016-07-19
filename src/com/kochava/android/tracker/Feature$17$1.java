package com.kochava.android.tracker;

import com.kochava.android.util.Logging;
import java.util.TimerTask;

class Feature$17$1
  extends TimerTask
{
  Feature$17$1(Feature.17 param17) {}
  
  public void run()
  {
    Logging.Log("Reached 10 min mark w/o sending initial, sending now.");
    Feature.access$4600(this$1.this$0, false);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.17.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */