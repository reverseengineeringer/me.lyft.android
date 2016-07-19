package bo.app;

import com.appboy.Constants;
import com.appboy.models.IPutIntoJson;
import com.appboy.support.AppboyLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class dk
  implements ct, IPutIntoJson<JSONObject>
{
  private static final String d = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dk.class.getName() });
  public final List<cr> a;
  public final de b;
  public final dl c;
  
  public dk(List<cr> paramList, de paramde, dl paramdl)
  {
    a = paramList;
    b = paramde;
    c = paramdl;
  }
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((a != null) && (!a.isEmpty())) {
        localJSONObject.put("sessions", fl.a(a));
      }
      if (b != null) {
        localJSONObject.put("device", b.a());
      }
      if (c != null) {
        localJSONObject.put("user", c.a);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(d, "Caught exception creating outbound extras Json.", localJSONException);
    }
    return localJSONObject;
  }
  
  public final boolean c()
  {
    Object localObject = new ArrayList();
    if (a != null) {
      ((List)localObject).addAll(a);
    }
    ((List)localObject).add(b);
    ((List)localObject).add(c);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ct localct = (ct)((Iterator)localObject).next();
      if ((localct != null) && (!localct.c())) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     bo.app.dk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */