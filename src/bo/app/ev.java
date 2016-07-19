package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ev
  extends en<de>
{
  private static final String c = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, ev.class.getName() });
  final SharedPreferences a;
  public de b = null;
  
  public ev(Context paramContext)
  {
    this(paramContext, null, null);
  }
  
  public ev(Context paramContext, String paramString1, String paramString2)
  {
    a = paramContext.getSharedPreferences("com.appboy.storage.device_cache" + StringUtils.getCacheFileSuffix(paramString1, paramString2), 0);
  }
  
  private de d()
  {
    JSONObject localJSONObject2 = b.a();
    Object localObject1 = new JSONObject();
    try
    {
      localJSONObject1 = new JSONObject(a.getString("cached_device", "{}"));
      localObject1 = localJSONObject1;
    }
    catch (JSONException localJSONException4)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        Iterator localIterator;
        String str3;
        Object localObject2;
        Object localObject3;
        AppboyLogger.e(c, "Caught exception confirming and unlocking Json objects.", localJSONException4);
        continue;
        int i = 0;
        if (!localObject2.equals(localObject3))
        {
          try
          {
            localJSONException4.put(str3, localObject2);
          }
          catch (JSONException localJSONException2)
          {
            AppboyLogger.e(c, "Caught json exception creating dirty outbound device. Returning the whole device.", localJSONException2);
            return b;
          }
          try
          {
            de localde = de.a(localJSONException4);
            return localde;
          }
          catch (JSONException localJSONException3)
          {
            String str2 = c;
            return b;
          }
          if (i == 0) {}
        }
      }
    }
    localJSONObject1 = new JSONObject();
    localIterator = localJSONObject2.keys();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label221;
      }
      str3 = (String)localIterator.next();
      localObject2 = localJSONObject2.opt(str3);
      localObject3 = ((JSONObject)localObject1).opt(str3);
      if ((!(localObject2 instanceof JSONObject)) && (!(localObject2 instanceof JSONArray))) {
        break label183;
      }
      if (localObject3 != null) {}
      try
      {
        if (avalueOfvalueOfca) {
          break;
        }
        i = 1;
      }
      catch (JSONException localJSONException1)
      {
        String str1 = c;
        return b;
      }
      localJSONObject1.put(str3, localObject2);
    }
  }
  
  public final void c()
  {
    try
    {
      SharedPreferences.Editor localEditor = a.edit();
      localEditor.remove("cached_device");
      localEditor.apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.ev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */