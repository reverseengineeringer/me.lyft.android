package bo.app;

import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class da
{
  public long a;
  public Set<String> b;
  public Set<String> c;
  public Set<String> d;
  public boolean e = false;
  public boolean f = false;
  public long g = -1L;
  public float h = -1.0F;
  public boolean i = false;
  
  public da() {}
  
  public da(JSONObject paramJSONObject)
  {
    b = a(paramJSONObject, "events_blacklist");
    c = a(paramJSONObject, "attributes_blacklist");
    d = a(paramJSONObject, "purchases_blacklist");
    a = paramJSONObject.optLong("time", 0L);
    paramJSONObject = paramJSONObject.optJSONObject("location");
    if (paramJSONObject != null) {}
    try
    {
      f = paramJSONObject.getBoolean("enabled");
      e = true;
      long l = paramJSONObject.optLong("time", -1L);
      if (l >= 0L) {
        g = (l * 1000L);
      }
      h = ((float)paramJSONObject.optDouble("distance", -1.0D));
      i = paramJSONObject.optBoolean("piq_enabled", false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        e = false;
      }
    }
  }
  
  private static Set<String> a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject.optJSONArray(paramString) != null)
    {
      HashSet localHashSet = new HashSet();
      paramJSONObject = paramJSONObject.optJSONArray(paramString);
      int j = 0;
      while (j < paramJSONObject.length())
      {
        localHashSet.add(paramJSONObject.getString(j));
        j += 1;
      }
      return localHashSet;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bo.app.da
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */