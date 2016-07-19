package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class gu
  implements gq
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, gu.class.getName() });
  private final SharedPreferences b;
  private Map<String, Long> c;
  
  public gu(Context paramContext, String paramString1, String paramString2)
  {
    b = paramContext.getSharedPreferences("com.appboy.storage.triggers.re_eligibility" + StringUtils.getCacheFileSuffix(paramString1, paramString2), 0);
    c = a();
  }
  
  private Map<String, Long> a()
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = b.getAll();
    if ((localObject == null) || (((Map)localObject).size() == 0)) {
      return localConcurrentHashMap;
    }
    localObject = ((Map)localObject).keySet();
    if ((localObject == null) || (((Set)localObject).size() == 0)) {
      return localConcurrentHashMap;
    }
    try
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        long l = b.getLong(str1, 0L);
        String str2 = a;
        String.format("Retrieving triggered action id %s eligibility information from local storage.", new Object[] { str1 });
        localConcurrentHashMap.put(str1, Long.valueOf(l));
      }
      return localConcurrentHashMap;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(a, "Encountered unexpected exception while parsing stored re-eligibility information.", localException);
    }
  }
  
  public final void a(fs paramfs, long paramLong)
  {
    Object localObject = a;
    String.format("Updating re-eligibility for action Id %s to time %d.", new Object[] { paramfs.b(), Long.valueOf(paramLong) });
    c.put(paramfs.b(), Long.valueOf(paramLong));
    localObject = b.edit();
    ((SharedPreferences.Editor)localObject).putLong(paramfs.b(), paramLong);
    ((SharedPreferences.Editor)localObject).apply();
  }
  
  public final void a(List<fs> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(((fs)paramList.next()).b());
    }
    Object localObject = new HashSet(c.keySet());
    paramList = b.edit();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2;
      if (!localHashSet.contains(str1))
      {
        str2 = a;
        String.format("Deleting outdated triggered action id %s from re-eligibility list.", new Object[] { str1 });
        c.remove(str1);
        paramList.remove(str1);
      }
      else
      {
        str2 = a;
        String.format("Retaining triggered action %s in re-eligibility list.", new Object[] { str1 });
      }
    }
    paramList.apply();
  }
  
  public final boolean a(fs paramfs)
  {
    Object localObject = paramfs.c().e();
    if (((gc)localObject).a())
    {
      localObject = a;
      String.format("Triggered action id %s always eligible via configuration. Returning true for eligibility status", new Object[] { paramfs.b() });
      return true;
    }
    if (!c.containsKey(paramfs.b()))
    {
      localObject = a;
      String.format("Triggered action id %s always eligible via never having been triggered. Returning true for eligibility status", new Object[] { paramfs.b() });
      return true;
    }
    if (((gc)localObject).b())
    {
      localObject = a;
      String.format("Triggered action id %s no longer eligible due to having been triggered in the past", new Object[] { paramfs.b() });
      return false;
    }
    long l = ((Long)c.get(paramfs.b())).longValue();
    l = fg.a() - l;
    if (l > ((gc)localObject).c().intValue())
    {
      paramfs = a;
      String.format("Trigger action is re-eligible for display since %d seconds have passed since the last time it was triggered (minimum interval: %d).", new Object[] { Long.valueOf(l), ((gc)localObject).c() });
      return true;
    }
    paramfs = a;
    String.format("Trigger action is not re-eligible for display since only %d seconds have passed since the last time it was triggered (minimum interval: %d).", new Object[] { Long.valueOf(l), ((gc)localObject).c() });
    return false;
  }
}

/* Location:
 * Qualified Name:     bo.app.gu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */