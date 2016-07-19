package bo.app;

import com.appboy.support.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class ga
  implements fx
{
  private String a;
  
  public ga() {}
  
  public ga(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONObject("data");
    if ((paramJSONObject != null) && (!paramJSONObject.isNull("campaign_id"))) {
      a = paramJSONObject.optString("campaign_id", null);
    }
  }
  
  private JSONObject a()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("type", "push_click");
      if (a != null)
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.putOpt("campaign_id", a);
        localJSONObject1.putOpt("data", localJSONObject2);
      }
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final boolean a(gh paramgh)
  {
    if ((paramgh instanceof gk))
    {
      if (StringUtils.isNullOrBlank(a)) {}
      do
      {
        return true;
        paramgh = (gk)paramgh;
      } while ((!StringUtils.isNullOrBlank(a)) && (a.equals(a)));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.ga
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */