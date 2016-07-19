package com.kochava.android.tracker;

import android.content.SharedPreferences;
import com.kochava.android.util.Logging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

final class Feature$22
  extends Thread
{
  Feature$22(JSONArray paramJSONArray) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("action", "update");
      ((JSONObject)localObject2).put("kochava_device_id", Feature.access$2800());
      ((JSONObject)localObject2).put("kochava_app_id", Feature.access$800());
      ((JSONObject)localObject2).put("sdk_version", "Android20160222" + Feature.versionExtension);
      ((JSONObject)localObject2).put("sdk_protocol", "4");
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("outside_services", val$services_found);
      ((JSONObject)localObject2).put("data", localObject1);
      if ((Feature.access$600() == null) || (Feature.access$600().trim().isEmpty())) {
        Feature.access$602("control.kochava.com");
      }
      Logging.Log("posting update to " + "https://" + Feature.access$600() + "/track/kvTracker.php");
      localObject1 = (HttpsURLConnection)new URL("https://" + Feature.access$600() + "/track/kvTracker.php").openConnection();
      ((HttpsURLConnection)localObject1).setRequestProperty("User-Agent", Feature.access$400().getString("useragent", ""));
      ((HttpsURLConnection)localObject1).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      ((HttpsURLConnection)localObject1).setRequestMethod("POST");
      ((HttpsURLConnection)localObject1).setConnectTimeout(30000);
      ((HttpsURLConnection)localObject1).setReadTimeout(30000);
      ((HttpsURLConnection)localObject1).setDoInput(true);
      ((HttpsURLConnection)localObject1).setDoOutput(true);
      ((HttpsURLConnection)localObject1).connect();
      String str2 = ((JSONObject)localObject2).toString();
      Logging.Log("Trying to post an update: " + ((JSONObject)localObject2).toString());
      localObject2 = new OutputStreamWriter(((HttpsURLConnection)localObject1).getOutputStream());
      ((OutputStreamWriter)localObject2).write(str2);
      ((OutputStreamWriter)localObject2).close();
      Logging.Log("(Update) Grabbing Result...");
      localObject2 = new StringBuffer("");
      localObject1 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject1).getInputStream()));
      for (;;)
      {
        str2 = ((BufferedReader)localObject1).readLine();
        if (str2 == null) {
          break;
        }
        ((StringBuffer)localObject2).append(str2);
      }
      str1 = ((StringBuffer)localObject2).toString();
    }
    catch (Exception localException)
    {
      Logging.LogError("Update error: " + localException.toString());
      return;
    }
    String str1;
    Logging.Log("Update Result: " + str1);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */