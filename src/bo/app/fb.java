package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class fb
{
  public static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, fb.class.getName() });
  public final bd b;
  public final SharedPreferences c;
  public final Object d = new Object();
  public AtomicBoolean e = new AtomicBoolean(false);
  public da f;
  public String g;
  
  public fb(Context paramContext, String paramString, bd parambd)
  {
    if (paramString == null) {
      AppboyLogger.e(a, "ServerConfigStorageProvider received null api key.");
    }
    for (paramString = "";; paramString = "." + paramString)
    {
      c = paramContext.getSharedPreferences("com.appboy.storage.serverconfigstorageprovider" + paramString, 0);
      g = c.getString("last_configured_appboy_sdk_version", null);
      b = parambd;
      new fc(this, (byte)0).execute(new Void[0]);
      return;
    }
  }
  
  private Set<String> a(String paramString)
  {
    try
    {
      paramString = c.getString(paramString, "");
      if (StringUtils.isNullOrBlank(paramString)) {
        return null;
      }
      paramString = new JSONArray(paramString);
      HashSet localHashSet = new HashSet();
      int i = 0;
      while (i < paramString.length())
      {
        localHashSet.add(paramString.getString(i));
        i += 1;
      }
      return localHashSet;
    }
    catch (Exception paramString)
    {
      AppboyLogger.w(a, "Experienced exception retrieving blacklisted strings from local storage. Returning null.", paramString);
    }
    return null;
  }
  
  public final void a(boolean paramBoolean)
  {
    e.set(paramBoolean);
  }
  
  public final boolean a()
  {
    synchronized (d)
    {
      if (f != null)
      {
        bool = f.i;
        return bool;
      }
      boolean bool = c.getBoolean("piq_enabled", false);
      return bool;
    }
  }
  
  public final boolean b()
  {
    synchronized (d)
    {
      if (f != null)
      {
        bool = f.f;
        return bool;
      }
      boolean bool = c.getBoolean("location_enabled_set", false);
      return bool;
    }
  }
  
  public final boolean c()
  {
    synchronized (d)
    {
      if (f != null)
      {
        bool = f.f;
        return bool;
      }
      boolean bool = c.getBoolean("location_enabled", false);
      return bool;
    }
  }
  
  public final long d()
  {
    synchronized (d)
    {
      if (f != null)
      {
        l = f.g;
        return l;
      }
      long l = c.getLong("location_time", -1L);
      return l;
    }
  }
  
  public final float e()
  {
    synchronized (d)
    {
      if (f != null)
      {
        f1 = f.h;
        return f1;
      }
      float f1 = c.getFloat("location_distance", -1.0F);
      return f1;
    }
  }
  
  public final long f()
  {
    synchronized (d)
    {
      if (f != null)
      {
        l = f.a;
        return l;
      }
      long l = c.getLong("config_time", 0L);
      return l;
    }
  }
  
  public final Set<String> g()
  {
    synchronized (d)
    {
      if (f != null) {}
      for (Object localObject1 = f.b; localObject1 != null; localObject1 = a("blacklisted_events")) {
        return (Set<String>)localObject1;
      }
      localObject1 = new HashSet();
      return (Set<String>)localObject1;
    }
  }
  
  public final Set<String> h()
  {
    synchronized (d)
    {
      if (f != null) {}
      for (Object localObject1 = f.c; localObject1 != null; localObject1 = a("blacklisted_attributes")) {
        return (Set<String>)localObject1;
      }
      localObject1 = new HashSet();
      return (Set<String>)localObject1;
    }
  }
  
  public final Set<String> i()
  {
    synchronized (d)
    {
      if (f != null) {}
      for (Object localObject1 = f.d; localObject1 != null; localObject1 = a("blacklisted_purchases")) {
        return (Set<String>)localObject1;
      }
      localObject1 = new HashSet();
      return (Set<String>)localObject1;
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.fb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */