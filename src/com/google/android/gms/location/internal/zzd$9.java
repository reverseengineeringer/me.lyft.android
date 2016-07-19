package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;

class zzd$9
  extends zzd.zza
{
  zzd$9(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    zzd.zzb localzzb = new zzd.zzb(this);
    paramzzl.zza(adB, localzzb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */