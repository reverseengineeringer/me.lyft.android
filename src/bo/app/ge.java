package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class ge
  implements gc
{
  private final int a;
  
  public ge(JSONObject paramJSONObject)
  {
    a = paramJSONObject.optInt("re_eligibility", -1);
  }
  
  private JSONObject d()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("re_eligibility", a);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final boolean a()
  {
    return a == 0;
  }
  
  public final boolean b()
  {
    return a == -1;
  }
  
  public final Integer c()
  {
    if (a > 0) {
      return Integer.valueOf(a);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.ge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */