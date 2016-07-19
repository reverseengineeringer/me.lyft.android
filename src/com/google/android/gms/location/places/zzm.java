package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<UserDataType>
{
  static void zza(UserDataType paramUserDataType, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, zzcgd, false);
    zzb.zzc(paramParcel, 2, afi);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public UserDataType zznj(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    String str = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzq(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new UserDataType(i, str, j);
  }
  
  public UserDataType[] zzty(int paramInt)
  {
    return new UserDataType[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */