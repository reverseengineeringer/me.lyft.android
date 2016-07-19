package bo.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class by
  implements ch
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, by.class.getName() });
  public final cb b;
  public final y c;
  public final cj d;
  public final XmlAppConfigurationProvider e;
  public final eg f;
  public Class<? extends Activity> g = null;
  private AtomicInteger h = new AtomicInteger(0);
  private AtomicInteger i = new AtomicInteger(0);
  private volatile String j = "";
  private final bd k;
  private final SharedPreferences l;
  
  public by(cb paramcb, y paramy, bd parambd, cj paramcj, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, Context paramContext, eg parameg)
  {
    b = paramcb;
    c = paramy;
    k = parambd;
    d = paramcj;
    e = paramXmlAppConfigurationProvider;
    f = parameg;
    l = paramContext.getSharedPreferences("com.appboy.stored.push.clicks", 0);
  }
  
  private boolean b(Throwable paramThrowable)
  {
    h.getAndIncrement();
    if ((j.equals(paramThrowable.getMessage())) && (i.get() > 3) && (h.get() < 100)) {
      return true;
    }
    if (j.equals(paramThrowable.getMessage())) {
      i.getAndIncrement();
    }
    for (;;)
    {
      if (h.get() >= 100) {
        h.set(0);
      }
      j = paramThrowable.getMessage();
      return false;
      i.set(0);
    }
  }
  
  public final cx a()
  {
    cx localcx = b.a();
    c.a(localcx);
    AppboyLogger.i(a, "Completed the openSession call. Starting or continuing session " + d);
    return localcx;
  }
  
  public final void a(int paramInt)
  {
    c.a(new eb(e.getBaseUrlForRequests(), paramInt));
  }
  
  public final void a(bp parambp)
  {
    try
    {
      if (b(parambp))
      {
        AppboyLogger.w(a, "Not logging duplicate database exception.");
        return;
      }
      a(dd.a(parambp, b.c()));
      return;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, String.format("Failed to create database exception event from %s.", new Object[] { parambp }), localJSONException);
      return;
    }
    catch (Exception parambp)
    {
      AppboyLogger.e(a, "Failed to log error.", parambp);
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    try
    {
      if (b(paramThrowable))
      {
        AppboyLogger.w(a, "Not logging duplicate error.");
        return;
      }
      a(dd.a(paramThrowable, b.c()));
      return;
    }
    catch (JSONException localJSONException)
    {
      AppboyLogger.e(a, String.format("Failed to create error event from %s.", new Object[] { paramThrowable }), localJSONException);
      return;
    }
    catch (Exception paramThrowable)
    {
      AppboyLogger.e(a, "Failed to log error.", paramThrowable);
    }
  }
  
  public final boolean a(cs paramcs)
  {
    int n = 0;
    int m;
    if ((paramcs.b().equals(ad.d)) || (paramcs.b().equals(ad.e)))
    {
      m = 1;
      if (m == 0) {
        break label199;
      }
      if ((b.c() != null) && (!b.d())) {
        break label150;
      }
      if (!paramcs.b().equals(ad.d))
      {
        m = n;
        if (!paramcs.b().equals(ad.e)) {}
      }
      else
      {
        m = 1;
      }
      if (m != 0) {
        break label107;
      }
      paramcs = a;
    }
    label107:
    label150:
    label199:
    do
    {
      return true;
      m = 0;
      break;
      Object localObject = l.edit();
      ((SharedPreferences.Editor)localObject).putString(Double.toString(paramcs.a()), paramcs.d());
      ((SharedPreferences.Editor)localObject).apply();
      return true;
      localObject = paramcs.c();
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).optString("cid", null);
        k.a(new bi((String)localObject, paramcs.b()), bi.class);
      }
      while (paramcs == null)
      {
        throw new NullPointerException();
        AppboyLogger.w(a, "Event json was null. Not logging internal push logged event.");
      }
      paramcs = b.a(paramcs);
      if (paramcs == null) {
        break label263;
      }
      c.a(paramcs);
    } while (!paramcs.c());
    a(ab.e);
    return true;
    label263:
    return false;
  }
  
  public final void b()
  {
    if ((b.c() == null) || (b.d())) {
      return;
    }
    Object localObject = l.getAll().keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      str = l.getString(str, null);
      if (!StringUtils.isNullOrEmpty(str)) {
        try
        {
          a(dd.a(new JSONObject(str)));
        }
        catch (JSONException localJSONException)
        {
          AppboyLogger.w(a, "Could not log pending AppboyEvent from shared preferences storage. Serialized string is: " + str, localJSONException);
        }
      }
    }
    localObject = l.edit();
    ((SharedPreferences.Editor)localObject).clear();
    ((SharedPreferences.Editor)localObject).apply();
  }
}

/* Location:
 * Qualified Name:     bo.app.by
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */