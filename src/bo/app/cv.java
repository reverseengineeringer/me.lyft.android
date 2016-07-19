package bo.app;

import com.appboy.models.InAppMessageBase;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class cv
  extends InAppMessageBase
{
  private boolean g = false;
  
  public cv(JSONObject paramJSONObject, ch paramch)
  {
    super(paramJSONObject, paramch);
  }
  
  public final boolean a()
  {
    if (StringUtils.isNullOrEmpty(d))
    {
      AppboyLogger.w(a, "Trigger Id not found. Not logging in-app message control impression.");
      return false;
    }
    if (g)
    {
      AppboyLogger.i(a, "Control impression already logged for this in-app message. Ignoring.");
      return false;
    }
    if (f == null)
    {
      AppboyLogger.e(a, "Cannot log an in-app message control impression because the AppboyManager is null.");
      return false;
    }
    try
    {
      dd localdd = dd.a(b, c, d);
      f.a(localdd);
      g = true;
      return true;
    }
    catch (JSONException localJSONException)
    {
      f.a(localJSONException);
    }
    return false;
  }
  
  public final JSONObject forJsonPut()
  {
    try
    {
      JSONObject localJSONObject = super.forJsonPut();
      localJSONObject.put("is_control", true);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.cv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */