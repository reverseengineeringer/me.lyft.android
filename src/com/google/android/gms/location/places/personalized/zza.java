package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<AliasedPlace>
{
  static void zza(AliasedPlace paramAliasedPlace, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramAliasedPlace.getPlaceId(), false);
    zzb.zzb(paramParcel, 2, paramAliasedPlace.zzbpa(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public AliasedPlace zznq(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcl(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzck(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 2: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.zza.zzae(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new AliasedPlace(i, str, localArrayList);
  }
  
  public AliasedPlace[] zzug(int paramInt)
  {
    return new AliasedPlace[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.personalized.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */