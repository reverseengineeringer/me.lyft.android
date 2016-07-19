package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbe
  implements Parcelable.Creator<PackageStorageInfo>
{
  static void zza(PackageStorageInfo paramPackageStorageInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, packageName, false);
    zzb.zza(paramParcel, 3, label, false);
    zzb.zza(paramParcel, 4, aLc);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public PackageStorageInfo[] zzaco(int paramInt)
  {
    return new PackageStorageInfo[paramInt];
  }
  
  public PackageStorageInfo zzuh(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    long l = 0L;
    String str2 = null;
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
        str2 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new PackageStorageInfo(i, str2, str1, l);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */