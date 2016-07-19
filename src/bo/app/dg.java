package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class dg
  implements IPutIntoJson<JSONObject>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dg.class.getName() });
  private final String b;
  private final String c;
  
  public dg(String paramString1, String paramString2)
  {
    b = paramString1;
    c = paramString2;
  }
  
  public static dg a(JSONObject paramJSONObject)
  {
    String str = StringUtils.emptyToNull(paramJSONObject.optString("android_id"));
    return new dg(StringUtils.emptyToNull(paramJSONObject.optString("serial")), str);
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("serial", b);
      localJSONObject.put("android_id", c);
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
 * Qualified Name:     bo.app.dg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */