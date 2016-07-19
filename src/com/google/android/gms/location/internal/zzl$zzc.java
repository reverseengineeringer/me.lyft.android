package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzpr.zzb;
import com.google.android.gms.location.LocationSettingsResult;

final class zzl$zzc
  extends zzj.zza
{
  private zzpr.zzb<LocationSettingsResult> adS;
  
  public zzl$zzc(zzpr.zzb<LocationSettingsResult> paramzzb)
  {
    if (paramzzb != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzb(bool, "listener can't be null.");
      adS = paramzzb;
      return;
    }
  }
  
  public void zza(LocationSettingsResult paramLocationSettingsResult)
    throws RemoteException
  {
    adS.setResult(paramLocationSettingsResult);
    adS = null;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzl.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */