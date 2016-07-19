package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<PlacePhotoMetadataResult>
{
  static void zza(PlacePhotoMetadataResult paramPlacePhotoMetadataResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramPlacePhotoMetadataResult.getStatus(), paramInt, false);
    zzb.zza(paramParcel, 2, aeI, paramInt, false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzaj(paramParcel, i);
  }
  
  public PlacePhotoMetadataResult zznf(Parcel paramParcel)
  {
    DataHolder localDataHolder = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new PlacePhotoMetadataResult(i, localStatus, localDataHolder);
  }
  
  public PlacePhotoMetadataResult[] zztu(int paramInt)
  {
    return new PlacePhotoMetadataResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */