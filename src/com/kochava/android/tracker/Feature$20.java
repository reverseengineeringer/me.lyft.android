package com.kochava.android.tracker;

import android.content.SharedPreferences;
import com.kochava.android.util.Logging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

final class Feature$20
  extends Thread
{
  Feature$20(Exception paramException) {}
  
  public void run()
  {
    try
    {
      Feature.access$2302(true);
      Object localObject2 = val$e.getMessage();
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("message", localObject2);
      ((JSONObject)localObject1).put("os_version", Feature.access$3400());
      ((JSONObject)localObject1).put("device", Feature.access$5300() + "-" + Feature.access$5400());
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("kochava_device_id", Feature.access$2800());
      ((JSONObject)localObject2).put("action", "error");
      ((JSONObject)localObject2).put("data", localObject1);
      ((JSONObject)localObject2).put("kochava_app_id", Feature.access$800());
      ((JSONObject)localObject2).put("sdk_version", "Android20160222" + Feature.versionExtension);
      ((JSONObject)localObject2).put("sdk_protocol", "4");
      Logging.Log("https log - posting to " + "http://" + Feature.access$600() + "/track/kvTracker.php");
      Object localObject3 = new URL("http://" + Feature.access$600() + "/track/kvTracker.php");
      localObject1 = ((JSONObject)localObject2).toString();
      Logging.Log("https failure data:" + (String)localObject1);
      localObject2 = (HttpURLConnection)((URL)localObject3).openConnection();
      ((HttpURLConnection)localObject2).setRequestProperty("User-Agent", Feature.access$400().getString("useragent", ""));
      ((HttpURLConnection)localObject2).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      ((HttpURLConnection)localObject2).setRequestMethod("POST");
      ((HttpURLConnection)localObject2).setConnectTimeout(30000);
      ((HttpURLConnection)localObject2).setReadTimeout(30000);
      ((HttpURLConnection)localObject2).setDoInput(true);
      ((HttpURLConnection)localObject2).setDoOutput(true);
      ((HttpURLConnection)localObject2).connect();
      localObject3 = new OutputStreamWriter(((HttpURLConnection)localObject2).getOutputStream());
      ((OutputStreamWriter)localObject3).write((String)localObject1);
      ((OutputStreamWriter)localObject3).close();
      Logging.Log("Grabbing Result...");
      localObject1 = new StringBuffer("");
      localObject2 = new BufferedReader(new InputStreamReader(((HttpURLConnection)localObject2).getInputStream()));
      for (;;)
      {
        localObject3 = ((BufferedReader)localObject2).readLine();
        if (localObject3 == null) {
          break;
        }
        ((StringBuffer)localObject1).append((String)localObject3);
      }
      str = localException.toString();
    }
    catch (Exception localException)
    {
      Logging.LogError("httpsFail " + localException);
      return;
    }
    String str;
    Logging.Log("Result: " + str);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */