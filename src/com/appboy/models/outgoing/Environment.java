package com.appboy.models.outgoing;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bo.app.dh;
import bo.app.fb;
import bo.app.fg;
import com.appboy.Constants;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class Environment
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, Environment.class.getName() });
  private final String b;
  private final int c;
  private final String d;
  private final String e;
  private fb f;
  private final Object g = new Object();
  
  public Environment(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    b = paramString1;
    c = paramInt;
    d = paramString2;
    e = paramString3;
  }
  
  public Environment(String paramString1, int paramInt, String paramString2, String paramString3, fb paramfb)
  {
    this(paramString1, paramInt, paramString2, paramString3);
    f = paramfb;
  }
  
  public dh dispatch()
  {
    Object localObject3 = g;
    String str = null;
    Object localObject1 = str;
    try
    {
      if (f != null)
      {
        localObject1 = str;
        if (f.e.get())
        {
          localObject1 = String.valueOf(f.f());
          if (!"1.13.4".equals(f.g))
          {
            str = "0";
            fb localfb = f;
            localObject1 = str;
            if (!"1.13.4".equals(g))
            {
              g = "1.13.4";
              localObject1 = c.edit();
              ((SharedPreferences.Editor)localObject1).putString("last_configured_appboy_sdk_version", "1.13.4");
              ((SharedPreferences.Editor)localObject1).apply();
              localObject1 = str;
            }
          }
          f.a(false);
        }
      }
      localObject1 = new dh(b, c, d, e, (String)localObject1);
      return (dh)localObject1;
    }
    finally {}
  }
  
  public JSONObject forStatelessJsonPut()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sdk_version", b);
      localJSONObject.put("now", fg.b());
      localJSONObject.put("version_code", c);
      localJSONObject.put("version_name", d);
      localJSONObject.put("package_name", e);
      localJSONObject.put("no_acks", true);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      String str = a;
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     com.appboy.models.outgoing.Environment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */