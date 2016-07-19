package com.kochava.android.tracker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.kochava.android.util.Logging;
import java.util.Timer;
import java.util.TimerTask;

class Feature$17
  extends Handler
{
  Feature$17(Feature paramFeature) {}
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = paramMessage.getData().getBoolean("sendonstart");
    Feature.access$4500(this$0);
    if (!bool)
    {
      Feature.access$4700(this$0).schedule(new TimerTask()
      {
        public void run()
        {
          Logging.Log("Reached 10 min mark w/o sending initial, sending now.");
          Feature.access$4600(this$0, false);
        }
      }, 600000L);
      return;
    }
    Feature.access$4700(this$0).schedule(new TimerTask()
    {
      public void run()
      {
        Logging.Log("Scheduling timer to que initial event if needed.");
        Feature.access$4600(this$0, false);
      }
    }, 2000L);
    Feature.access$4802(this$0, new Timer());
    Feature.access$4800(this$0).schedule(new TimerTask()
    {
      public void run() {}
    }, 4000L);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */