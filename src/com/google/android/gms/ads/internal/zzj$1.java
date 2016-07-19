package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.client.AdRequestParcel;
import java.lang.ref.WeakReference;

class zzj$1
  implements Runnable
{
  zzj$1(zzj paramzzj, AdRequestParcel paramAdRequestParcel) {}
  
  public void run()
  {
    synchronized (zzj.zza(zzalp))
    {
      zzq localzzq = zzalp.zzer();
      zzj.zza(zzalp, new WeakReference(localzzq));
      localzzq.zzb(zzj.zzb(zzalp));
      localzzq.zzb(zzj.zzc(zzalp));
      localzzq.zza(zzj.zzd(zzalp));
      localzzq.zza(zzj.zze(zzalp));
      localzzq.zzb(zzj.zzf(zzalp));
      localzzq.zzb(zzj.zzg(zzalp));
      localzzq.zzb(zzj.zzh(zzalp));
      localzzq.zza(zzj.zzi(zzalp));
      localzzq.zzb(zzalo);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzj.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */