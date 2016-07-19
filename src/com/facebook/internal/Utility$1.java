package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

final class Utility$1
  implements Runnable
{
  Utility$1(Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = val$context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
    Object localObject2 = localSharedPreferences.getString(val$settingsKey, null);
    if (!Utility.isNullOrEmpty((String)localObject2)) {
      localObject1 = null;
    }
    try
    {
      localObject2 = new JSONObject((String)localObject2);
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Utility.logd("FacebookSDK", localJSONException);
      }
    }
    if (localObject1 != null) {
      Utility.access$000(val$applicationId, (JSONObject)localObject1);
    }
    Object localObject1 = Utility.access$100(val$applicationId);
    if (localObject1 != null)
    {
      Utility.access$000(val$applicationId, (JSONObject)localObject1);
      localSharedPreferences.edit().putString(val$settingsKey, ((JSONObject)localObject1).toString()).apply();
    }
    Utility.access$200().set(false);
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.Utility.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */