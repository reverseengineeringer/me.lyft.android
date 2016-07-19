package com.google.android.gms.location.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpr.zzb;

class zzd$zzb
  extends zzg.zza
{
  private final zzpr.zzb<Status> zj;
  
  public zzd$zzb(zzpr.zzb<Status> paramzzb)
  {
    zj = paramzzb;
  }
  
  public void zza(FusedLocationProviderResult paramFusedLocationProviderResult)
  {
    zj.setResult(paramFusedLocationProviderResult.getStatus());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */