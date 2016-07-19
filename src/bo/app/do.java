package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class do
  implements IPutIntoJson<JSONObject>
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, do.class.getName() });
  public final String a;
  
  private do(String paramString)
  {
    a = paramString;
  }
  
  public static do a(JSONObject paramJSONObject)
  {
    return new do(StringUtils.emptyToNull(paramJSONObject.optString("android_id")));
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("android_id", a);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(b, "Caught exception creating wear device identifier Json.", localJSONException);
    }
    return localJSONObject;
  }
}

/* Location:
 * Qualified Name:     bo.app.do
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */