package bo.app;

import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class fw
  implements fx
{
  private String a;
  
  public fw(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if (paramJSONObject != null) {
      a = paramJSONObject.optString("event_name", null);
    }
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "custom_event");
      if (a != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("event_name", a);
        localJSONObject1.putOpt("data", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final boolean a(gh paramgh)
  {
    if ((paramgh instanceof gg))
    {
      paramgh = (gg)paramgh;
      if ((!StringUtils.isNullOrBlank(a)) && (a.equals(a))) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.fw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */