package com.google.android.gms.internal;

import java.lang.ref.WeakReference;

class zzqd$zzb
  extends zzqj.zza
{
  private WeakReference<zzqd> uk;
  
  zzqd$zzb(zzqd paramzzqd)
  {
    uk = new WeakReference(paramzzqd);
  }
  
  public void zzaor()
  {
    zzqd localzzqd = (zzqd)uk.get();
    if (localzzqd == null) {
      return;
    }
    zzqd.zza(localzzqd);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */