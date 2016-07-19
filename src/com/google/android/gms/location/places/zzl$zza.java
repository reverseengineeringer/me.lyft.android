package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zza<A extends Api.zze>
  extends zzl.zzb<AutocompletePredictionBuffer, A>
{
  public zzl$zza(Api paramApi, GoogleApiClient paramGoogleApiClient)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected AutocompletePredictionBuffer zzdn(Status paramStatus)
  {
    return new AutocompletePredictionBuffer(DataHolder.zzfp(paramStatus.getStatusCode()));
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */