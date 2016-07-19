package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class zzkl$zza
  extends BroadcastReceiver
{
  private zzkl$zza(zzkl paramzzkl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {
      zzkl.zza(zzcll, true);
    }
    while (!"android.intent.action.SCREEN_OFF".equals(paramIntent.getAction())) {
      return;
    }
    zzkl.zza(zzcll, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */