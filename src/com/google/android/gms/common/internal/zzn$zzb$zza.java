package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Iterator;
import java.util.Set;

public class zzn$zzb$zza
  implements ServiceConnection
{
  public zzn$zzb$zza(zzn.zzb paramzzb) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zzn.zza(yL.yK))
    {
      zzn.zzb.zza(yL, paramIBinder);
      zzn.zzb.zza(yL, paramComponentName);
      Iterator localIterator = zzn.zzb.zzb(yL).iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
      }
    }
    zzn.zzb.zza(yL, 1);
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zzn.zza(yL.yK))
    {
      zzn.zzb.zza(yL, null);
      zzn.zzb.zza(yL, paramComponentName);
      Iterator localIterator = zzn.zzb.zzb(yL).iterator();
      if (localIterator.hasNext()) {
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
      }
    }
    zzn.zzb.zza(yL, 2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzn.zzb.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */