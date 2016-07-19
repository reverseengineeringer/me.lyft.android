package bo.app;

import com.appboy.models.IPutIntoJson;
import org.json.JSONObject;

public final class dl
  implements ct, IPutIntoJson<JSONObject>
{
  public final JSONObject a;
  
  public dl(JSONObject paramJSONObject)
  {
    a = paramJSONObject;
  }
  
  public final boolean c()
  {
    return (a == null) || (a.length() == 0);
  }
}

/* Location:
 * Qualified Name:     bo.app.dl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */