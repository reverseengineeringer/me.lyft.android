package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class fy
  implements fx
{
  private static JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", "open");
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final boolean a(gh paramgh)
  {
    return paramgh instanceof gi;
  }
}

/* Location:
 * Qualified Name:     bo.app.fy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */