package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;

public final class zzd$zzh
  implements ServiceConnection
{
  private final int xy;
  
  public zzd$zzh(zzd paramzzd, int paramInt)
  {
    xy = paramInt;
  }
  
  public void onServiceConnected(ComponentName arg1, IBinder paramIBinder)
  {
    zzab.zzb(paramIBinder, "Expecting a valid IBinder");
    synchronized (zzd.zza(xv))
    {
      zzd.zza(xv, zzu.zza.zzdt(paramIBinder));
      xv.zza(0, null, xy);
      return;
    }
  }
  
  public void onServiceDisconnected(ComponentName arg1)
  {
    synchronized (zzd.zza(xv))
    {
      zzd.zza(xv, null);
      xv.mHandler.sendMessage(xv.mHandler.obtainMessage(4, xy, 1));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */