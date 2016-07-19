package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

class zzpv$zzb
  implements zzqm.zza
{
  private zzpv$zzb(zzpv paramzzpv) {}
  
  public void zzc(int paramInt, boolean paramBoolean)
  {
    zzpv.zza(tj).lock();
    try
    {
      if (zzpv.zzc(tj))
      {
        zzpv.zza(tj, false);
        zzpv.zza(tj, paramInt, paramBoolean);
        return;
      }
      zzpv.zza(tj, true);
      zzpv.zzf(tj).onConnectionSuspended(paramInt);
      return;
    }
    finally
    {
      zzpv.zza(tj).unlock();
    }
  }
  
  public void zzd(ConnectionResult paramConnectionResult)
  {
    zzpv.zza(tj).lock();
    try
    {
      zzpv.zzb(tj, paramConnectionResult);
      zzpv.zzb(tj);
      return;
    }
    finally
    {
      zzpv.zza(tj).unlock();
    }
  }
  
  public void zzm(Bundle paramBundle)
  {
    zzpv.zza(tj).lock();
    try
    {
      zzpv.zzb(tj, ConnectionResult.qR);
      zzpv.zzb(tj);
      return;
    }
    finally
    {
      zzpv.zza(tj).unlock();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpv.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */