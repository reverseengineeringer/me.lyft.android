package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class PlacePhotoMetadataResult
  extends AbstractSafeParcelable
  implements Result
{
  public static final Parcelable.Creator<PlacePhotoMetadataResult> CREATOR = new zzh();
  final DataHolder aeI;
  private final PlacePhotoMetadataBuffer aeJ;
  private final Status cc;
  final int mVersionCode;
  
  PlacePhotoMetadataResult(int paramInt, Status paramStatus, DataHolder paramDataHolder)
  {
    mVersionCode = paramInt;
    cc = paramStatus;
    aeI = paramDataHolder;
    if (paramDataHolder == null)
    {
      aeJ = null;
      return;
    }
    aeJ = new PlacePhotoMetadataBuffer(aeI);
  }
  
  public Status getStatus()
  {
    return cc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.PlacePhotoMetadataResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */