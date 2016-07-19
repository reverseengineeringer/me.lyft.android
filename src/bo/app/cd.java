package bo.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.Constants;
import com.appboy.services.AppboyWearableListenerService;
import com.appboy.support.AppboyLogger;
import com.appboy.support.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class cd
  implements ci<dm>
{
  private static final String a = String.format("%s.%s", new Object[] { Constants.APPBOY_LOG_TAG_PREFIX, cd.class.getName() });
  private final Context b;
  private final boolean c;
  private final SharedPreferences d;
  
  public cd(Context paramContext)
  {
    b = paramContext.getApplicationContext();
    c = c();
    d = paramContext.getSharedPreferences("com.appboy.managers.connected_device_storage", 0);
  }
  
  private void a(dm paramdm)
  {
    try
    {
      SharedPreferences.Editor localEditor = d.edit();
      localEditor.putString(a.a, paramdm.a().toString());
      localEditor.apply();
      return;
    }
    finally
    {
      paramdm = finally;
      throw paramdm;
    }
  }
  
  private boolean c()
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("com.appboy.services.AppboyWearableListenerService", false, cd.class.getClassLoader());
        if (localClass == null) {
          break label79;
        }
        i = 1;
        if (i == 0)
        {
          AppboyLogger.i(a, "AppboyWearableListenerService not found on path. Service not available.");
          return false;
        }
      }
      catch (Exception localException)
      {
        AppboyLogger.i(a, "AppboyWearableListenerService not found on path. Service not available.");
        return false;
      }
      catch (NoClassDefFoundError localNoClassDefFoundError)
      {
        AppboyLogger.i(a, "AppboyWearableListenerService not found on path. Service not available.");
        return false;
      }
      catch (Throwable localThrowable)
      {
        AppboyLogger.i(a, "AppboyWearableListenerService not found on path. Service not available.");
        return false;
      }
      return fn.a(b, AppboyWearableListenerService.class);
      label79:
      int i = 0;
    }
  }
  
  public final List<dm> a()
  {
    ArrayList localArrayList;
    try
    {
      SharedPreferences.Editor localEditor = d.edit();
      localArrayList = new ArrayList();
      Iterator localIterator = d.getAll().keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = d.getString(str1, null);
        boolean bool = StringUtils.isNullOrBlank(str2);
        if (!bool) {
          try
          {
            localArrayList.add(dm.a(new JSONObject(str2)));
          }
          catch (JSONException localJSONException)
          {
            AppboyLogger.e(a, "JSON error while pulling connected device from storage: " + str2, localJSONException);
            localEditor.remove(str1);
          }
        }
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
    finally {}
    return localArrayList;
  }
  
  public final void b()
  {
    if (!c)
    {
      AppboyLogger.i(a, "Appboy Wearable service is not available. Declare <service android:name=\"com.appboy.services.AppboyWearableListenerService\"/> in your appboy.xml to enable Appboy wearable service. See the Droidboy manifest for an example");
      return;
    }
    AppboyLogger.i(a, "Starting AppboyWearableListenerService.");
    Intent localIntent = new Intent().setClass(b, AppboyWearableListenerService.class);
    b.startService(localIntent);
  }
}

/* Location:
 * Qualified Name:     bo.app.cd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */