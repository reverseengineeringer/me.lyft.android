package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.google.android.gms.common.api.zzd;
import java.lang.ref.WeakReference;

class zzrd$zza
  implements IBinder.DeathRecipient, zzrd.zzb
{
  private final WeakReference<zzpr.zza<?, ?>> vx;
  private final WeakReference<zzd> vy;
  private final WeakReference<IBinder> vz;
  
  private zzrd$zza(zzpr.zza<?, ?> paramzza, zzd paramzzd, IBinder paramIBinder)
  {
    vy = new WeakReference(paramzzd);
    vx = new WeakReference(paramzza);
    vz = new WeakReference(paramIBinder);
  }
  
  private void zzaqd()
  {
    Object localObject = (zzpr.zza)vx.get();
    zzd localzzd = (zzd)vy.get();
    if ((localzzd != null) && (localObject != null)) {
      localzzd.remove(((zzpr.zza)localObject).zzaog().intValue());
    }
    localObject = (IBinder)vz.get();
    if (vz != null) {
      ((IBinder)localObject).unlinkToDeath(this, 0);
    }
  }
  
  public void binderDied()
  {
    zzaqd();
  }
  
  public void zzh(zzpr.zza<?, ?> paramzza)
  {
    zzaqd();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrd.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */