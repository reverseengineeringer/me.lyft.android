package bo.app;

import com.appboy.Constants;
import com.appboy.models.ResponseError;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public final class cz
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cz.class.getName() });
  public final ResponseError a;
  
  public cz(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("error");
    if (localJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = new ResponseError(localJSONObject);
        a = paramJSONObject;
        return;
      }
      catch (JSONException paramJSONObject)
      {
        AppboyLogger.w(b, "Encountered exception processing ResponseError: " + localJSONObject.toString(), paramJSONObject);
      }
      paramJSONObject = null;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */