package bo.app;

import org.json.JSONObject;

public final class dw
{
  public final String a;
  
  public dw(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      a = paramJSONObject.optString("piqid", null);
      return;
    }
    a = null;
  }
}

/* Location:
 * Qualified Name:     bo.app.dw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */