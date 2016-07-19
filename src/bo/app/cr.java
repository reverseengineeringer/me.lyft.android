package bo.app;

import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class cr
  implements ct, IPutIntoJson<JSONObject>
{
  private static final String d = String.format("%s.%s", new Object[] { "Appboy", cr.class.getName() });
  public final cx a;
  public volatile Double b;
  public final boolean c;
  private final Set<cs> e;
  private final db f;
  private final double g;
  
  public cr(cx paramcx, Double paramDouble1, Double paramDouble2, Set<cs> paramSet, db paramdb, boolean paramBoolean)
  {
    a = paramcx;
    g = paramDouble1.doubleValue();
    b = paramDouble2;
    e = paramSet;
    f = paramdb;
    c = paramBoolean;
  }
  
  public final cp a()
  {
    return new cp(e);
  }
  
  public final JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("guid", f.a.toString());
      localJSONObject.put("start_time", g);
      if (!e.isEmpty()) {
        localJSONObject.put("events", fl.a(e));
      }
      if (c) {
        localJSONObject.put("new", true);
      }
      if (b != null) {
        localJSONObject.put("end_time", b);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(d, "Caught exception creating dispatch session Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public final boolean c()
  {
    Set localSet = aa;
    return (!c) && (b == null) && ((localSet == null) || (localSet.isEmpty()));
  }
}

/* Location:
 * Qualified Name:     bo.app.cr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */