package com.leanplum;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.leanplum.callbacks.ActionCallback;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class d
  extends ActionCallback
{
  d(c paramc) {}
  
  public final boolean onResponse(ActionContext paramActionContext)
  {
    String str1 = paramActionContext.c();
    if (paramActionContext.d()) {}
    for (Object localObject = Double.valueOf(5.0D); !(localObject instanceof Number); localObject = ((Map)localObject).get("countdown"))
    {
      Log.e("Leanplum", "Invalid notification countdown: " + localObject);
      return false;
      localObject = (Map)aU.b().get(str1);
      if (localObject == null)
      {
        Log.e("Leanplum", "Could not find message options for ID " + str1);
        return false;
      }
    }
    long l1 = System.currentTimeMillis() + ((Number)localObject).longValue() * 1000L;
    Context localContext = Leanplum.a();
    Intent localIntent = new Intent(localContext, LeanplumPushService.class);
    AlarmManager localAlarmManager = (AlarmManager)localContext.getSystemService("alarm");
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("__leanplum_messaging__", 0);
    long l2 = localSharedPreferences.getLong(String.format("__leanplum_local_message_%s", new Object[] { str1 }), 0L);
    if ((l2 > 0L) && (l2 > System.currentTimeMillis()))
    {
      if (l2 < l1) {
        return false;
      }
      if (l2 >= l1) {
        localAlarmManager.cancel(PendingIntent.getService(localContext, str1.hashCode(), localIntent, 134217728));
      }
    }
    localObject = (Map)paramActionContext.objectNamed("Advanced options.Data");
    Iterator localIterator;
    if (localObject != null) {
      localIterator = ((Map)localObject).keySet().iterator();
    }
    for (;;)
    {
      boolean bool;
      if (!localIterator.hasNext())
      {
        localObject = paramActionContext.stringNamed("Open action");
        bool = Boolean.TRUE.equals(paramActionContext.objectNamed("Advanced options.Mute inside app"));
        if (localObject == null) {
          break label523;
        }
        if (!bool) {
          break label510;
        }
        localIntent.putExtra("_lpu", str1);
        label327:
        localObject = paramActionContext.stringNamed("Message");
        if (localObject == null) {
          break label554;
        }
        localIntent.putExtra("lp_message", (String)localObject);
        localObject = paramActionContext.stringNamed("Android options.Collapse key");
        if (localObject != null) {
          localIntent.putExtra("collapseKey", (String)localObject);
        }
        bool = Boolean.TRUE.equals(paramActionContext.objectNamed("Android options.Delay while idle"));
        if (bool) {
          localIntent.putExtra("delayWhileIdle", bool);
        }
        localAlarmManager.set(0, l1, PendingIntent.getService(localContext, str1.hashCode(), localIntent, 134217728));
        paramActionContext = localSharedPreferences.edit();
        paramActionContext.putLong(String.format("__leanplum_local_message_%s", new Object[] { str1 }), l1);
      }
      try
      {
        paramActionContext.apply();
        if (g.k) {
          Log.i("Leanplum", "Scheduled notification");
        }
        return true;
        String str2 = (String)localIterator.next();
        localIntent.putExtra(str2, (Serializable)((Map)localObject).get(str2));
        continue;
        label510:
        localIntent.putExtra("_lpm", str1);
        break label327;
        label523:
        if (bool)
        {
          localIntent.putExtra("_lpv", str1);
          break label327;
        }
        localIntent.putExtra("_lpn", str1);
        break label327;
        label554:
        localObject = "Push message goes here.";
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        for (;;)
        {
          paramActionContext.commit();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */