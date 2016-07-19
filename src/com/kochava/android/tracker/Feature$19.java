package com.kochava.android.tracker;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.kochava.android.util.Logging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

final class Feature$19
  extends Thread
{
  Feature$19(JSONObject paramJSONObject) {}
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    try
    {
      Object localObject1 = new JSONObject();
      Object localObject3 = new JSONObject();
      Feature.access$4000((JSONObject)localObject3);
      if (val$pushCommand.has("register"))
      {
        ((JSONObject)localObject3).put("token", val$pushCommand.get("register").toString());
        ((JSONObject)localObject1).put("push_action", "register_token");
      }
      if (val$pushCommand.has("remove")) {
        ((JSONObject)localObject1).put("push_action", "remove_token");
      }
      ((JSONObject)localObject1).put("action", "push");
      ((JSONObject)localObject1).put("data", localObject3);
      ((JSONObject)localObject1).put("kochava_app_id", Feature.access$800());
      ((JSONObject)localObject1).put("kochava_device_id", Feature.access$2800());
      ((JSONObject)localObject1).put("sdk_version", "Android20160222" + Feature.versionExtension);
      ((JSONObject)localObject1).put("sdk_protocol", "4");
      if ((Feature.access$600() == null) || (Feature.access$600().trim().isEmpty()))
      {
        Logging.Log("Push token - hostControl was empty, using default");
        Feature.access$602("control.kochava.com");
      }
      Logging.Log("kvPush - posting to " + "https://" + Feature.access$600() + "/track/kvTracker.php");
      localObject3 = new URL("https://" + Feature.access$600() + "/track/kvTracker.php");
      localObject1 = ((JSONObject)localObject1).toString();
      Logging.Log("kvPush data:" + (String)localObject1);
      localObject3 = (HttpsURLConnection)((URL)localObject3).openConnection();
      ((HttpsURLConnection)localObject3).setRequestProperty("User-Agent", Feature.access$400().getString("useragent", ""));
      ((HttpsURLConnection)localObject3).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
      ((HttpsURLConnection)localObject3).setRequestMethod("POST");
      ((HttpsURLConnection)localObject3).setConnectTimeout(30000);
      ((HttpsURLConnection)localObject3).setReadTimeout(30000);
      ((HttpsURLConnection)localObject3).setDoInput(true);
      ((HttpsURLConnection)localObject3).setDoOutput(true);
      ((HttpsURLConnection)localObject3).connect();
      Object localObject4 = new OutputStreamWriter(((HttpsURLConnection)localObject3).getOutputStream());
      ((OutputStreamWriter)localObject4).write((String)localObject1);
      ((OutputStreamWriter)localObject4).close();
      Logging.Log("Grabbing Result...");
      localObject1 = new StringBuffer("");
      localObject3 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject3).getInputStream()));
      for (;;)
      {
        localObject4 = ((BufferedReader)localObject3).readLine();
        if (localObject4 == null) {
          break;
        }
        ((StringBuffer)localObject1).append((String)localObject4);
      }
      localObject2 = localException.toString();
    }
    catch (Exception localException)
    {
      Logging.LogError("Problem sending register/remove token, saving push command: " + val$pushCommand.toString());
      Feature.access$400().edit().putString("register_remove_token", val$pushCommand.toString()).apply();
      if (Global.DEBUGERROR) {
        localException.printStackTrace();
      }
      return;
    }
    Logging.Log("Result: " + (String)localObject2);
    Object localObject2 = new JSONObject((String)localObject2);
    if ((localObject2 != null) && (((JSONObject)localObject2).get("success").toString().equals("1")))
    {
      Feature.access$400().edit().remove("register_remove_token").apply();
      return;
    }
    Logging.LogError("Did not get a good response, saving push command: " + val$pushCommand.toString());
    Feature.access$400().edit().putString("register_remove_token", val$pushCommand.toString()).apply();
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */