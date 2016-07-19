package bo.app;

import android.net.Uri;
import com.appboy.Appboy;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class dy
  extends ek
  implements ee
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, dy.class.getName() });
  private dk c;
  private dh d;
  
  protected dy(Uri paramUri)
  {
    super(paramUri, null);
  }
  
  public final void a(dh paramdh)
  {
    d = paramdh;
  }
  
  public final void a(dk paramdk)
  {
    c = paramdk;
  }
  
  public final Uri b()
  {
    return Appboy.getAppboyApiEndpoint(a);
  }
  
  public final void b(bd parambd)
  {
    dl localdl = c.c;
    de localde = c.b;
    if (localdl != null) {
      parambd.a(new bh(localdl), bh.class);
    }
    if (localde != null) {
      parambd.a(new bg(localde), bg.class);
    }
  }
  
  public final dk c()
  {
    return c;
  }
  
  public final dh d()
  {
    return d;
  }
  
  public JSONObject e()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (c != null) {
        localJSONObject.put("extras", c.a());
      }
      if (d != null) {
        localJSONObject.put("environment", d.a());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.w(b, "Experienced JSONException while retrieving parameters. Returning null.", localJSONException);
    }
    return null;
  }
  
  public boolean f()
  {
    return (c == null) || (c.c());
  }
}

/* Location:
 * Qualified Name:     bo.app.dy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */