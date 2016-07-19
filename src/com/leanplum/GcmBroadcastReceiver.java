package com.leanplum;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

public class GcmBroadcastReceiver
  extends WakefulBroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    if ("com.google.android.c2dm.intent.REGISTRATION".equals(paramIntent.getAction()))
    {
      if (paramIntent.getStringExtra("error") != null) {
        Log.e("Leanplum", "Error when registering for push notifications: " + paramIntent.getStringExtra("error"));
      }
      do
      {
        return;
        paramIntent = paramIntent.getStringExtra("registration_id");
      } while (paramIntent == null);
      LeanplumPushService.a(paramContext, paramIntent);
      return;
    }
    if (paramIntent.hasCategory("lpAction"))
    {
      Bundle localBundle = paramIntent.getExtras();
      Log.i("Leanplum", "Opening notification");
      paramIntent = LeanplumPushService.a();
      if ((LeanplumActivityHelper.b != null) && (!LeanplumActivityHelper.a)) {
        if (paramIntent == null) {
          if (i != 0)
          {
            paramIntent = LeanplumPushService.a();
            if (paramIntent == null) {
              break label185;
            }
          }
        }
      }
      label185:
      for (paramIntent = new Intent(paramContext, paramIntent);; paramIntent = paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName()))
      {
        paramIntent.putExtras(localBundle);
        paramIntent.addFlags(335544320);
        paramContext.startActivity(paramIntent);
        LeanplumActivityHelper.queueActionUponActive(new m(this, localBundle));
        return;
        if ((paramIntent != null) && (paramIntent.isInstance(LeanplumActivityHelper.b))) {
          break;
        }
        i = 1;
        break;
      }
    }
    startWakefulService(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), LeanplumPushService.class.getName())));
    setResultCode(-1);
  }
}

/* Location:
 * Qualified Name:     com.leanplum.GcmBroadcastReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */