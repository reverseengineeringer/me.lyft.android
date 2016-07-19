package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.configuration.XmlAppConfigurationProvider;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONException;
import org.json.JSONObject;

public class gt
  implements go
{
  private static final String b = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, gt.class.getName() });
  public final Object a = new Object();
  private final Context c;
  private final ch d;
  private final bd e;
  private final long f;
  private final SharedPreferences g;
  private final gn h;
  private final gq i;
  private Map<String, fs> j;
  private volatile long k = 0L;
  
  public gt(Context paramContext, ch paramch, ThreadPoolExecutor paramThreadPoolExecutor, bd parambd, XmlAppConfigurationProvider paramXmlAppConfigurationProvider, String paramString1, String paramString2)
  {
    c = paramContext.getApplicationContext();
    d = paramch;
    e = parambd;
    f = paramXmlAppConfigurationProvider.getTriggerActionMinimumTimeIntervalInSeconds();
    g = paramContext.getSharedPreferences("com.appboy.storage.triggers.actions" + StringUtils.getCacheFileSuffix(paramString1, paramString2), 0);
    h = new gr(paramContext, paramThreadPoolExecutor, paramString2);
    i = new gu(paramContext, paramString1, paramString2);
    j = a();
  }
  
  private Map<String, fs> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = g.getAll();
    if ((localObject1 == null) || (((Map)localObject1).size() == 0)) {
      return localHashMap;
    }
    localObject1 = ((Map)localObject1).keySet();
    if ((localObject1 == null) || (((Set)localObject1).size() == 0)) {
      return localHashMap;
    }
    try
    {
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = g.getString((String)localObject2, null);
        if (!StringUtils.isNullOrBlank((String)localObject3)) {
          break label138;
        }
        AppboyLogger.w(b, String.format("Received null or blank serialized triggered action string for action id %s from shared preferences. Not parsing.", new Object[] { localObject2 }));
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        AppboyLogger.e(b, "Encountered Json exception while parsing stored triggered actions.", localJSONException);
        return localHashMap;
        localObject3 = new JSONObject((String)localObject3);
        str = ((JSONObject)localObject3).getString("type");
        if (!StringUtils.isNullOrBlank(str)) {
          break;
        }
        AppboyLogger.w(b, String.format("Received null or blank serialized triggered action type for action id %s from shared preferences. Not parsing.", new Object[] { localObject2 }));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        label138:
        String str;
        AppboyLogger.e(b, "Encountered unexpected exception while parsing stored triggered actions.", localException);
        continue;
        if (str.equals("inapp"))
        {
          localObject2 = new ft((JSONObject)localObject3, d);
          localHashMap.put(a, localObject2);
          localObject3 = b;
          String.format("Retrieving triggered action id %s from local storage.", new Object[] { a });
        }
      }
    }
  }
  
  private fs b(gh paramgh)
  {
    Object localObject1 = null;
    label289:
    label292:
    for (;;)
    {
      synchronized (a)
      {
        if (!(paramgh instanceof gl))
        {
          long l = fg.a() - k;
          if (l < f)
          {
            AppboyLogger.i(b, String.format("Not checking for matches for this trigger event since only %d seconds have passed since the last trigger action (minimum interval: %d).", new Object[] { Long.valueOf(l), Long.valueOf(f) }));
            return null;
          }
        }
        else
        {
          localObject2 = b;
        }
        int m = Integer.MIN_VALUE;
        Iterator localIterator = j.values().iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (fs)localIterator.next();
          if ((!((fs)localObject2).a(paramgh)) || (!i.a((fs)localObject2))) {
            break label289;
          }
          Object localObject4 = b;
          String.format("Found potential triggered action for incoming trigger event. Action id %s.", new Object[] { ((fs)localObject2).b() });
          localObject4 = ((fs)localObject2).c();
          if (((gd)localObject4).c() <= m) {
            break label289;
          }
          m = ((gd)localObject4).c();
          localObject1 = localObject2;
          break label292;
        }
        if (localObject1 != null)
        {
          localObject2 = b;
          String.format("Found best triggered action for incoming trigger event. Action id %s.", new Object[] { ((fs)localObject1).b() });
          k = paramgh.a();
          return (fs)localObject1;
        }
      }
      Object localObject2 = b;
      String.format("Failed to match triggered action for incoming %s.", new Object[] { paramgh.getClass().getName() });
    }
  }
  
  public final void a(gh paramgh)
  {
    Object localObject = b;
    String.format("New incoming %s. Searching for matching triggers.", new Object[] { paramgh.getClass().getName() });
    localObject = b(paramgh);
    if (localObject != null)
    {
      ((fs)localObject).a(h.a((fs)localObject));
      ((fs)localObject).a(c, e);
      i.a((fs)localObject, paramgh.a());
    }
  }
  
  public final void a(List<fs> paramList)
  {
    int m = 0;
    gl localgl = new gl();
    if (paramList == null)
    {
      AppboyLogger.w(b, "Received a null list of triggers in registerTriggeredActions(). Doing nothing.");
      return;
    }
    for (;;)
    {
      synchronized (a)
      {
        j.clear();
        SharedPreferences.Editor localEditor = g.edit();
        localEditor.clear();
        Object localObject2 = b;
        String.format("Registering %d new triggered actions.", new Object[] { Integer.valueOf(paramList.size()) });
        localObject2 = paramList.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          fs localfs = (fs)((Iterator)localObject2).next();
          String str = b;
          String.format("Registering triggered action id %s.", new Object[] { localfs.b() });
          j.put(localfs.b(), localfs);
          localEditor.putString(localfs.b(), ((JSONObject)localfs.forJsonPut()).toString());
          if (localfs.a(localgl)) {
            m = 1;
          }
        }
        else
        {
          localEditor.apply();
          i.a(paramList);
          h.a(paramList);
          if (m == 0) {
            break;
          }
          AppboyLogger.i(b, "Test triggered actions found, triggering test event.");
          a(localgl);
          return;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.gt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */