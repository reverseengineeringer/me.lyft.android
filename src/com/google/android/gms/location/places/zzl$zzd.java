package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zzd<A extends Api.zze>
  extends zzl.zzb<PlaceLikelihoodBuffer, A>
{
  public zzl$zzd(Api paramApi, GoogleApiClient paramGoogleApiClient)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected PlaceLikelihoodBuffer zzdp(Status paramStatus)
  {
    return new PlaceLikelihoodBuffer(DataHolder.zzfp(paramStatus.getStatusCode()), 100, null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */