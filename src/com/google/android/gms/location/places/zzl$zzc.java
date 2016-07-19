package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzl$zzc<A extends Api.zze>
  extends zzl.zzb<PlaceBuffer, A>
{
  public zzl$zzc(Api paramApi, GoogleApiClient paramGoogleApiClient)
  {
    super(paramApi, paramGoogleApiClient);
  }
  
  protected PlaceBuffer zzdo(Status paramStatus)
  {
    return new PlaceBuffer(DataHolder.zzfp(paramStatus.getStatusCode()), null);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzl.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */