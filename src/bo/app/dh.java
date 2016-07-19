package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public class dh
  implements IPutIntoJson<JSONObject>
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dh.class.getName() });
  public final String a;
  private final String c;
  private final int d;
  private final String e;
  private final String f;
  
  public dh(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    c = paramString1;
    d = paramInt;
    e = paramString2;
    f = paramString3;
    a = paramString4;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("sdk_version", c);
      localJSONObject.put("now", fg.b());
      localJSONObject.put("version_code", d);
      localJSONObject.put("version_name", e);
      localJSONObject.put("package_name", f);
      if (a != null) {
        localJSONObject.put("config_time", a);
      }
      localJSONObject.put("no_acks", true);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(b, "Caught exception creating dispatch environment Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.dh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */