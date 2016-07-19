package com.kochava.android.tracker;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.kochava.android.util.Logging;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

class Feature$8
  implements Runnable
{
  Feature$8(Feature paramFeature, String paramString) {}
  
  @SuppressLint({"NewApi"})
  public void run()
  {
    Logging.Log("Checking watchlist from " + val$source + "...");
    Object localObject2 = new HashMap();
    if (!Feature.access$400().contains("app_short_string"))
    {
      Logging.Log("No previous app_short_string in watchlist, adding " + Feature.access$3100(this$0));
      Feature.access$400().edit().putString("app_short_string", Feature.access$3100(this$0)).apply();
      if (Feature.access$400().contains("app_limit_tracking")) {
        break label723;
      }
      Logging.Log("No previous app_limit_tracking in watchlist, adding " + Feature.access$3200(this$0));
      Feature.access$400().edit().putBoolean("app_limit_tracking", Feature.access$3200(this$0)).apply();
      label174:
      if (Feature.access$400().contains("app_version")) {
        break label834;
      }
      Logging.Log("No previous app_version in watchlist, adding " + Feature.access$500(this$0));
      Feature.access$400().edit().putString("app_version", Feature.access$500(this$0)).apply();
      label242:
      if (Feature.access$400().contains("device_limit_tracking")) {
        break label949;
      }
      Logging.Log("No previous device_limit_tracking in watchlist, adding " + Feature.access$3300());
      Feature.access$400().edit().putBoolean("device_limit_tracking", Feature.access$3300()).apply();
      label302:
      if (Feature.access$2200())
      {
        if (Feature.access$400().contains("adid")) {
          break label1044;
        }
        Logging.Log("No previous adid in watchlist, adding " + Feature.access$100());
        Feature.access$400().edit().putString("adid", Feature.access$100()).apply();
        ((HashMap)localObject2).put("adid", Feature.access$100());
      }
      label378:
      if (Feature.access$400().contains("os_version")) {
        break label1125;
      }
      Logging.Log("No previous os_version in watchlist, adding " + Feature.access$3400());
      Feature.access$400().edit().putString("os_version", Feature.access$3400()).apply();
    }
    for (;;)
    {
      if (!((HashMap)localObject2).keySet().isEmpty()) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("action", "update");
          localJSONObject.put("kochava_device_id", Feature.access$2800());
          localJSONObject.put("kochava_app_id", Feature.access$800());
          localJSONObject.put("sdk_version", "Android20160222" + Feature.versionExtension);
          localJSONObject.put("sdk_protocol", "4");
          localObject3 = new JSONObject();
          Iterator localIterator = ((HashMap)localObject2).keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            ((JSONObject)localObject3).put(str, ((HashMap)localObject2).get(str));
          }
          return;
        }
        catch (Exception localException)
        {
          Logging.LogError("Update error: " + localException.toString());
        }
      }
      if (Feature.access$400().getString("app_short_string", "").equals(Feature.access$3100(this$0))) {
        break;
      }
      Logging.Log("app_short_string changed! Is now " + Feature.access$3100(this$0));
      ((HashMap)localObject2).put("app_short_string", Feature.access$3100(this$0) + "");
      Feature.access$400().edit().putString("app_short_string", Feature.access$3100(this$0)).apply();
      break;
      label723:
      if (Feature.access$400().getBoolean("app_limit_tracking", false) == Feature.access$3200(this$0)) {
        break label174;
      }
      Logging.Log("app_limit_tracking changed! Is now " + Feature.access$3200(this$0));
      ((HashMap)localObject2).put("app_limit_tracking", Feature.access$3200(this$0) + "");
      Feature.access$400().edit().putBoolean("app_limit_tracking", Feature.access$3200(this$0)).apply();
      break label174;
      label834:
      if (Feature.access$400().getString("app_version", "").equals(Feature.access$500(this$0))) {
        break label242;
      }
      Logging.Log("app_version changed! Is now " + Feature.access$500(this$0));
      ((HashMap)localObject2).put("app_version", Feature.access$500(this$0) + "");
      Feature.access$400().edit().putString("app_version", Feature.access$500(this$0)).apply();
      break label242;
      label949:
      if (Feature.access$400().getBoolean("device_limit_tracking", false) == Feature.access$3300()) {
        break label302;
      }
      Logging.Log("device_limit_tracking changed! Is now " + Feature.access$3300());
      ((HashMap)localObject2).put("device_limit_tracking", Feature.access$3300() + "");
      Feature.access$400().edit().putBoolean("device_limit_tracking", Feature.access$3300()).apply();
      break label302;
      label1044:
      if (Feature.access$400().getString("adid", "").equals(Feature.access$100())) {
        break label378;
      }
      Logging.Log("adid changed! Is now " + Feature.access$100());
      ((HashMap)localObject2).put("adid", Feature.access$100());
      Feature.access$400().edit().putString("adid", Feature.access$100()).apply();
      break label378;
      label1125:
      if (!Feature.access$400().getString("os_version", "").equals(Feature.access$3400()))
      {
        Logging.Log("os_version changed! Is now " + Feature.access$3400());
        ((HashMap)localObject2).put("os_version", Feature.access$3400());
        Feature.access$400().edit().putString("os_version", Feature.access$3400()).apply();
        Feature.access$400().edit().putString("useragent", Feature.access$3500(this$0)).apply();
      }
    }
    localException.put("data", localObject3);
    if ((Feature.access$600() == null) || (Feature.access$600().trim().isEmpty())) {
      Feature.access$602("control.kochava.com");
    }
    Logging.Log("posting update to " + "https://" + Feature.access$600() + "/track/kvTracker.php");
    localObject2 = (HttpsURLConnection)new URL("https://" + Feature.access$600() + "/track/kvTracker.php").openConnection();
    ((HttpsURLConnection)localObject2).setRequestProperty("User-Agent", Feature.access$400().getString("useragent", ""));
    ((HttpsURLConnection)localObject2).setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    ((HttpsURLConnection)localObject2).setRequestMethod("POST");
    ((HttpsURLConnection)localObject2).setConnectTimeout(30000);
    ((HttpsURLConnection)localObject2).setReadTimeout(30000);
    ((HttpsURLConnection)localObject2).setDoInput(true);
    ((HttpsURLConnection)localObject2).setDoOutput(true);
    ((HttpsURLConnection)localObject2).connect();
    Object localObject3 = localException.toString();
    Logging.Log("Trying to post an update: " + localException.toString());
    Object localObject1 = new OutputStreamWriter(((HttpsURLConnection)localObject2).getOutputStream());
    ((OutputStreamWriter)localObject1).write((String)localObject3);
    ((OutputStreamWriter)localObject1).close();
    Logging.Log("(Update) Grabbing Result...");
    localObject1 = new StringBuffer("");
    localObject2 = new BufferedReader(new InputStreamReader(((HttpsURLConnection)localObject2).getInputStream()));
    for (;;)
    {
      localObject3 = ((BufferedReader)localObject2).readLine();
      if (localObject3 == null) {
        break;
      }
      ((StringBuffer)localObject1).append((String)localObject3);
    }
    localObject1 = ((StringBuffer)localObject1).toString();
    Logging.Log("Update Result: " + (String)localObject1);
  }
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.Feature.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */