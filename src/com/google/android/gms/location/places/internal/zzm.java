package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PlaceLikelihoodEntity>
{
  static void zza(PlaceLikelihoodEntity paramPlaceLikelihoodEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, afS, paramInt, false);
    zzb.zza(paramParcel, 2, afT);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzaj(paramParcel, i);
  }
  
  public PlaceLikelihoodEntity zznm(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    PlaceEntity localPlaceEntity = null;
    float f = 0.0F;
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
        localPlaceEntity = (PlaceEntity)zza.zza(paramParcel, k, PlaceEntity.CREATOR);
        continue;
        f = zza.zzl(paramParcel, k);
        continue;
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceLikelihoodEntity(i, localPlaceEntity, f);
  }
  
  public PlaceLikelihoodEntity[] zzuc(int paramInt)
  {
    return new PlaceLikelihoodEntity[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */