package com.kochava.android.tracker;

import com.kochava.android.util.Logging;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

final class Feature$15
  extends Thread
{
  Feature$15(String paramString) {}
  
  public void run()
  {
    Logging.Log("Got event " + val$state);
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("state", val$state);
    Logging.Log("FIRE EVENT*** action:" + "session");
    Logging.Log("FIRE EVENT*** properties:" + localObject1);
    JSONObject localJSONObject1 = new JSONObject();
    label308:
    do
    {
      JSONObject localJSONObject2;
      Object localObject2;
      try
      {
        localJSONObject1.put("kochava_app_id", Feature.access$800());
        localJSONObject1.put("kochava_device_id", Feature.access$2800());
        localJSONObject1.put("action", "session");
        localJSONObject1.put("dev_id_strategy", Feature.access$3900());
        localJSONObject2 = Feature.access$4000(new JSONObject());
        if (Feature.access$4100() != null)
        {
          localObject2 = Feature.access$4100().entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            localJSONObject2.put((String)localEntry.getKey(), localEntry.getValue());
          }
        }
        if (localObject1 == null) {
          break label308;
        }
      }
      catch (JSONException localJSONException)
      {
        if (Global.DEBUGERROR) {
          localJSONException.printStackTrace();
        }
        Logging.LogError("event " + localJSONException);
        return;
      }
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localJSONObject2.put((String)((Map.Entry)localObject2).getKey(), ((Map.Entry)localObject2).getValue());
      }
      localJSONException.put("data", localJSONObject2);
      Logging.Log("fireEvent with properties: " + localJSONException);
    } while (Feature.access$3800().addEvent(localJSONException, false, false) < 50);
    Feature.flush();
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */