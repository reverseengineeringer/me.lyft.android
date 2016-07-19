package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.support.AppboyFileUtils;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

public class gr
  implements gn
{
  static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, gr.class.getName() });
  private final Context b;
  private final ThreadPoolExecutor c;
  private final SharedPreferences d;
  private Map<String, String> e;
  private Map<String, String> f = new HashMap();
  
  public gr(Context paramContext, ThreadPoolExecutor paramThreadPoolExecutor, String paramString)
  {
    b = paramContext;
    c = paramThreadPoolExecutor;
    d = paramContext.getSharedPreferences("com.appboy.storage.triggers.local_assets." + paramString, 0);
    e = c();
  }
  
  private Map<String, String> c()
  {
    localConcurrentHashMap = new ConcurrentHashMap();
    Object localObject = d.getAll();
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
        String str2 = d.getString(str1, null);
        if (!StringUtils.isNullOrBlank(str2))
        {
          String str3 = a;
          String.format("Retrieving trigger local asset path %s from local storage for remote path %s.", new Object[] { str2, str1 });
          localConcurrentHashMap.put(str1, str2);
        }
      }
      return localConcurrentHashMap;
    }
    catch (Exception localException)
    {
      AppboyLogger.e(a, "Encountered unexpected exception while parsing stored triggered action local assets.", localException);
    }
  }
  
  final File a()
  {
    return new File(AppboyFileUtils.getApplicationCacheDir(b).getPath() + "/ab_triggers");
  }
  
  public final String a(fs paramfs)
  {
    if (!paramfs.a())
    {
      paramfs = a;
      return null;
    }
    paramfs = paramfs.d();
    if (StringUtils.isNullOrBlank(paramfs))
    {
      AppboyLogger.i(a, "Remote asset path was null or blank.  Not retrieving local asset path.");
      return null;
    }
    if (e.containsKey(paramfs))
    {
      String str = (String)e.get(paramfs);
      if (!new File(str).exists())
      {
        AppboyLogger.w(a, "Local asset for remote asset path did not exist: " + paramfs);
        return null;
      }
      AppboyLogger.i(a, "Retrieving local asset path for remote asset path: " + paramfs);
      f.put(paramfs, str);
      return str;
    }
    AppboyLogger.w(a, "No local asset path found for remote asset path: " + paramfs);
    return null;
  }
  
  public final void a(List<fs> paramList)
  {
    if (!AppboyFileUtils.canStoreAssetsLocally(b))
    {
      AppboyLogger.i(a, "Can not store assets locally. Write external permission must be grantedon devices running lower than Kit-Kat (API 19).");
      return;
    }
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    String str2;
    String str3;
    while (paramList.hasNext())
    {
      localObject = (fs)paramList.next();
      str2 = ((fs)localObject).d();
      if (!StringUtils.isNullOrBlank(str2)) {
        if (((fs)localObject).a())
        {
          str3 = a;
          String.format("Received new remote path for triggered action %s at %s.", new Object[] { ((fs)localObject).b(), str2 });
          localHashSet.add(str2);
        }
        else
        {
          str3 = a;
          String.format("Pre-fetch off for triggered action %s. Not pre-fetching assets at remote path %s.", new Object[] { ((fs)localObject).b(), str2 });
        }
      }
    }
    paramList = d.edit();
    Object localObject = new HashSet(e.keySet()).iterator();
    String str4;
    while (((Iterator)localObject).hasNext())
    {
      str2 = (String)((Iterator)localObject).next();
      if (f.containsKey(str2))
      {
        str3 = a;
        String.format("Not removing local path for remote path %s from cache because it is being preserved until the end of the app run.", new Object[] { str2 });
      }
      else if (!localHashSet.contains(str2))
      {
        str3 = (String)e.get(str2);
        str4 = a;
        String.format("Removing obsolete local path %s for obsolete remote path %s from cache.", new Object[] { str3, str2 });
        e.remove(str2);
        paramList.remove(str2);
        AppboyFileUtils.deleteFileOrDirectory(new File(str3));
      }
    }
    paramList.apply();
    try
    {
      localObject = a().listFiles();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          str2 = localObject[i];
          str3 = str2.getPath();
          if ((!e.containsValue(str3)) && (!f.containsValue(str3)))
          {
            str4 = a;
            String.format("Deleting obsolete asset %s from filesystem.", new Object[] { str3 });
            AppboyFileUtils.deleteFileOrDirectory(str2);
          }
          i += 1;
        }
      }
      String str1;
      return;
    }
    catch (Exception localException)
    {
      str1 = a;
      String.format("Exception while deleting obsolete assets from filesystem.", new Object[0]);
      paramList = new gs(this, localHashSet, paramList);
      c.execute(paramList);
    }
  }
}

/* Location:
 * Qualified Name:     bo.app.gr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */