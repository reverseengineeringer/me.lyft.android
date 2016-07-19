package com.leanplum;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.leanplum.callbacks.ActionCallback;

final class e
  extends ActionCallback
{
  e(c paramc) {}
  
  public final boolean onResponse(ActionContext paramActionContext)
  {
    paramActionContext = paramActionContext.c();
    Context localContext = Leanplum.a();
    Object localObject2 = localContext.getSharedPreferences("__leanplum_messaging__", 0);
    Object localObject1 = String.format("__leanplum_local_message_%s", new Object[] { paramActionContext });
    long l = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
    localObject2 = ((SharedPreferences)localObject2).edit();
    ((SharedPreferences.Editor)localObject2).remove((String)localObject1);
    try
    {
      ((SharedPreferences.Editor)localObject2).apply();
      localObject1 = new Intent(localContext, LeanplumPushService.class);
      ((AlarmManager)localContext.getSystemService("alarm")).cancel(PendingIntent.getService(localContext, paramActionContext.hashCode(), (Intent)localObject1, 134217728));
      if (l > System.currentTimeMillis())
      {
        bool = true;
        if (bool) {
          Log.i("Leanplum", "Cancelled notification");
        }
        return bool;
      }
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      for (;;)
      {
        ((SharedPreferences.Editor)localObject2).commit();
        continue;
        boolean bool = false;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.leanplum.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */