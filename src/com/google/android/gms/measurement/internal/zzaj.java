package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaj
  implements Parcelable.Creator<UserAttributeParcel>
{
  static void zza(UserAttributeParcel paramUserAttributeParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, name, false);
    zzb.zza(paramParcel, 3, anQ);
    zzb.zza(paramParcel, 4, anR, false);
    zzb.zza(paramParcel, 5, anS, false);
    zzb.zza(paramParcel, 6, zr, false);
    zzb.zza(paramParcel, 7, akg, false);
    zzb.zza(paramParcel, 8, anT, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public UserAttributeParcel zzop(Parcel paramParcel)
  {
    Double localDouble = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    long l = 0L;
    String str1 = null;
    String str2 = null;
    Float localFloat = null;
    Long localLong = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str3 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        l = zza.zzi(paramParcel, k);
        break;
      case 4: 
        localLong = zza.zzj(paramParcel, k);
        break;
      case 5: 
        localFloat = zza.zzm(paramParcel, k);
        break;
      case 6: 
        str2 = zza.zzq(paramParcel, k);
        break;
      case 7: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 8: 
        localDouble = zza.zzo(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new UserAttributeParcel(i, str3, l, localLong, localFloat, str2, str1, localDouble);
  }
  
  public UserAttributeParcel[] zzvh(int paramInt)
  {
    return new UserAttributeParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzaj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */