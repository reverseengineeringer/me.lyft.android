package bo.app;

import org.json.JSONException;
import org.json.JSONObject;

public final class gf
  implements gd
{
  private final long a;
  private final long b;
  private final int c;
  private final int d;
  private final gc e;
  
  public gf(JSONObject paramJSONObject)
  {
    a = paramJSONObject.optLong("start_time", -1L);
    b = paramJSONObject.optLong("end_time", -1L);
    c = paramJSONObject.optInt("priority", 0);
    d = paramJSONObject.optInt("delay", 0);
    e = new ge(paramJSONObject);
  }
  
  private JSONObject f()
  {
    try
    {
      JSONObject localJSONObject = (JSONObject)e.forJsonPut();
      localJSONObject.put("start_time", a);
      localJSONObject.put("end_time", b);
      localJSONObject.put("priority", c);
      localJSONObject.put("delay", d);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final long a()
  {
    return a;
  }
  
  public final long b()
  {
    return b;
  }
  
  public final int c()
  {
    return c;
  }
  
  public final int d()
  {
    return d;
  }
  
  public final gc e()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     bo.app.gf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */