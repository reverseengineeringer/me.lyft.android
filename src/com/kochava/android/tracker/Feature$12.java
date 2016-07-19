package com.kochava.android.tracker;

import com.kochava.android.util.Logging;
import java.util.HashMap;

class Feature$12
  extends Thread
{
  Feature$12(Feature paramFeature, String paramString1, String paramString2) {}
  
  public void run()
  {
    Logging.Log("Got event " + val$eventName);
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_name", val$eventName);
    localHashMap.put("event_data", val$eventData);
    Feature.access$3700(this$0, "event", localHashMap);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */