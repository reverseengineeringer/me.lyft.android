package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public class zzd$zzi
  implements zzd.zzf
{
  public zzd$zzi(zzd paramzzd) {}
  
  public void zzh(ConnectionResult paramConnectionResult)
  {
    if (paramConnectionResult.isSuccess()) {
      xv.zza(null, xv.zzary());
    }
    while (zzd.zze(xv) == null) {
      return;
    }
    zzd.zze(xv).onConnectionFailed(paramConnectionResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzd.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */