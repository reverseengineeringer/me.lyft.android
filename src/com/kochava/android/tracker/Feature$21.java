package com.kochava.android.tracker;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import com.kochava.android.util.Logging;
import org.json.JSONException;
import org.json.JSONObject;

final class Feature$21
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    if (Feature.access$2300()) {
      Logging.LogError("The library was not initialized properly or we cannot connect to our servers. Cannot send location udpate");
    }
    do
    {
      for (;;)
      {
        return;
        Logging.Log("Location Handler got message, queueing location update.");
        try
        {
          paramMessage = new JSONObject();
          JSONObject localJSONObject1 = new JSONObject();
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("lat", Feature.access$400().getString("kochava_lat", ""));
          localJSONObject2.put("lon", Feature.access$400().getString("kochava_lon", ""));
          localJSONObject2.put("acc", Feature.access$400().getString("kochava_accuracy", ""));
          localJSONObject1.put("location", localJSONObject2);
          paramMessage.put("action", "update");
          paramMessage.put("kochava_device_id", Feature.access$2800());
          paramMessage.put("kochava_app_id", Feature.access$800());
          paramMessage.put("sdk_version", "Android20160222" + Feature.versionExtension);
          paramMessage.put("sdk_protocol", "4");
          paramMessage.put("data", localJSONObject1);
          Logging.Log("Location update: " + paramMessage);
          int i = Feature.access$3800().addEvent(paramMessage, false, true);
          Feature.access$4902(System.currentTimeMillis());
          long l = Feature.access$400().getLong("kochava_loc_timestamp", 0L);
          Feature.access$400().edit().putLong("kochava_old_loc_timestamp", l).apply();
          if (i >= 50)
          {
            Feature.flush();
            return;
          }
        }
        catch (JSONException paramMessage) {}
      }
    } while (!Global.DEBUGERROR);
    paramMessage.printStackTrace();
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */