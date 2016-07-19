package bo.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class fv
  implements fs
{
  public final String a;
  final gd b;
  private final List<fx> c = new ArrayList();
  private boolean d;
  
  protected fv(JSONObject paramJSONObject)
  {
    a = paramJSONObject.optString("id", null);
    b = new gf(paramJSONObject);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("trigger_condition");
    if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
      c.addAll(gv.a(localJSONArray));
    }
    d = paramJSONObject.optBoolean("prefetch", true);
  }
  
  public final boolean a()
  {
    return d;
  }
  
  public final boolean a(gh paramgh)
  {
    if ((b.a() == -1L) || (fg.a() > b.a()))
    {
      i = 1;
      if (i == 0) {
        break label94;
      }
      if ((b.b() != -1L) && (fg.a() >= b.b())) {
        break label89;
      }
      i = 1;
      label72:
      if (i == 0) {
        break label94;
      }
    }
    label89:
    label94:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label99;
      }
      return false;
      i = 0;
      break;
      i = 0;
      break label72;
    }
    label99:
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      if (((fx)localIterator.next()).a(paramgh)) {
        return true;
      }
    }
    return false;
  }
  
  public final String b()
  {
    return a;
  }
  
  public final gd c()
  {
    return b;
  }
  
  public JSONObject e()
  {
    try
    {
      JSONObject localJSONObject2 = (JSONObject)b.forJsonPut();
      localJSONObject2.put("id", a);
      Object localObject = localJSONObject2;
      if (c != null)
      {
        localObject = new JSONArray();
        Iterator localIterator = c.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject).put(((fx)localIterator.next()).forJsonPut());
        }
        localJSONObject2.put("trigger_condition", localObject);
        localJSONObject2.put("prefetch", d);
        return localJSONObject2;
      }
    }
    catch (JSONException localJSONException)
    {
      JSONObject localJSONObject1 = null;
      return localJSONObject1;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.fv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */