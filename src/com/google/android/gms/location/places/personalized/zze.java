package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.location.places.PlacesStatusCodes;

@Deprecated
public final class zze
  extends zzd<PlaceUserData>
  implements Result
{
  private final Status cc;
  
  public zze(DataHolder paramDataHolder)
  {
    this(paramDataHolder, PlacesStatusCodes.zzgz(paramDataHolder.getStatusCode()));
  }
  
  private zze(DataHolder paramDataHolder, Status paramStatus)
  {
    super(paramDataHolder, PlaceUserData.CREATOR);
    if ((paramDataHolder == null) || (paramDataHolder.getStatusCode() == paramStatus.getStatusCode())) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbn(bool);
      cc = paramStatus;
      return;
    }
  }
  
  public Status getStatus()
  {
    return cc;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */