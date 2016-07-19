package bo.app;

import com.appboy.Constants;
import com.appboy.models.IInAppMessage;
import com.appboy.support.AppboyLogger;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cy
{
  private static final String e = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cy.class.getName() });
  public final JSONArray a;
  public final IInAppMessage b;
  public final List<fs> c;
  public final da d;
  
  public cy(JSONObject paramJSONObject, ch paramch)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("feed");
    if (localJSONArray != null)
    {
      a = localJSONArray;
      b = fj.a(paramJSONObject.optJSONObject("inapp"), paramch);
      c = gv.a(paramJSONObject.optJSONArray("triggers"), paramch);
      paramch = paramJSONObject.optJSONObject("config");
      if (paramch == null) {
        break label143;
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = new da(paramch);
        d = paramJSONObject;
        return;
        a = null;
      }
      catch (JSONException paramJSONObject)
      {
        AppboyLogger.w(e, "Encountered JSONException processing server config: " + paramch.toString(), paramJSONObject);
        paramJSONObject = null;
        continue;
      }
      catch (Exception paramJSONObject)
      {
        AppboyLogger.w(e, "Encountered Exception processing server config: " + paramch.toString(), paramJSONObject);
      }
      label143:
      paramJSONObject = null;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.cy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */