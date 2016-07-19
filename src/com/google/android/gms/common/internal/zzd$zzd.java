package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;

final class zzd$zzd
  extends Handler
{
  public zzd$zzd(zzd paramzzd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void zza(Message paramMessage)
  {
    paramMessage = (zzd.zze)obj;
    paramMessage.zzasa();
    paramMessage.unregister();
  }
  
  private boolean zzb(Message paramMessage)
  {
    return (what == 2) || (what == 1) || (what == 5);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PendingIntent localPendingIntent = null;
    if (xv.xs.get() != arg1)
    {
      if (zzb(paramMessage)) {
        zza(paramMessage);
      }
      return;
    }
    if (((what == 1) || (what == 5)) && (!xv.isConnecting()))
    {
      zza(paramMessage);
      return;
    }
    if (what == 3)
    {
      if ((obj instanceof PendingIntent)) {
        localPendingIntent = (PendingIntent)obj;
      }
      paramMessage = new ConnectionResult(arg2, localPendingIntent);
      zzd.zzb(xv).zzh(paramMessage);
      xv.onConnectionFailed(paramMessage);
      return;
    }
    if (what == 4)
    {
      zzd.zza(xv, 4, null);
      if (zzd.zzc(xv) != null) {
        zzd.zzc(xv).onConnectionSuspended(arg2);
      }
      xv.onConnectionSuspended(arg2);
      zzd.zza(xv, 4, 1, null);
      return;
    }
    if ((what == 2) && (!xv.isConnected()))
    {
      zza(paramMessage);
      return;
    }
    if (zzb(paramMessage))
    {
      ((zzd.zze)obj).zzasb();
      return;
    }
    int i = what;
    Log.wtf("GmsClient", 45 + "Don't know how to handle message: " + i, new Exception());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */