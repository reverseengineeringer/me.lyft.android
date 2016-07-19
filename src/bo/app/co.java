package bo.app;

import org.json.JSONObject;

public final class co
{
  public final cy a;
  public final cz b;
  
  public co(JSONObject paramJSONObject, ch paramch)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("extras");
    if (localJSONObject != null) {}
    for (a = new cy(localJSONObject, paramch);; a = null)
    {
      paramJSONObject = paramJSONObject.optJSONObject("result");
      if (paramJSONObject == null) {
        break;
      }
      b = new cz(paramJSONObject);
      return;
    }
    b = null;
  }
}

/* Location:
 * Qualified Name:     bo.app.co
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */