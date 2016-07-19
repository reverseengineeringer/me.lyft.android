package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzs
  implements Parcelable.Creator<PlacesParams>
{
  static void zza(PlacesParams paramPlacesParams, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, agd, false);
    zzb.zza(paramParcel, 2, age, false);
    zzb.zza(paramParcel, 3, DP, false);
    zzb.zza(paramParcel, 4, afc, false);
    zzb.zzc(paramParcel, 6, agf);
    zzb.zzc(paramParcel, 7, agg);
    zzb.zzc(paramParcel, 1000, versionCode);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public PlacesParams zzno(Parcel paramParcel)
  {
    int i = 0;
    String str1 = null;
    int m = zza.zzcl(paramParcel);
    int j = 0;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        str4 = zza.zzq(paramParcel, n);
        break;
      case 2: 
        str3 = zza.zzq(paramParcel, n);
        break;
      case 3: 
        str2 = zza.zzq(paramParcel, n);
        break;
      case 4: 
        str1 = zza.zzq(paramParcel, n);
        break;
      case 6: 
        j = zza.zzg(paramParcel, n);
        break;
      case 7: 
        i = zza.zzg(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new PlacesParams(k, str4, str3, str2, str1, j, i);
  }
  
  public PlacesParams[] zzue(int paramInt)
  {
    return new PlacesParams[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */