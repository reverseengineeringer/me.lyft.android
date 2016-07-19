package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zza;
import com.google.android.gms.maps.model.LatLngBounds;

class zzd$3
  extends zzl.zza<zze>
{
  zzd$3(zzd paramzzd, Api paramApi, GoogleApiClient paramGoogleApiClient, String paramString, LatLngBounds paramLatLngBounds, AutocompleteFilter paramAutocompleteFilter)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected void zza(zze paramzze)
    throws RemoteException
  {
    paramzze.zza(new zzl(this), afu, afv, afw);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzd.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */