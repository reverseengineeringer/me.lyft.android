package com.google.android.gms.location.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;

class zzd$1
  extends zzd.zza
{
  zzd$1(zzd paramzzd, GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener)
  {
    super(paramGoogleApiClient);
  }
  
  protected void zza(zzl paramzzl)
    throws RemoteException
  {
    zzd.zzb localzzb = new zzd.zzb(this);
    paramzzl.zza(adA, adB, null, localzzb);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzd.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */