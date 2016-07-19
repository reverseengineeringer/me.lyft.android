package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbl
  implements Parcelable.Creator<StorageInfoResponse>
{
  static void zza(StorageInfoResponse paramStorageInfoResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, aLc);
    zzb.zzc(paramParcel, 4, aLe, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public StorageInfoResponse[] zzact(int paramInt)
  {
    return new StorageInfoResponse[paramInt];
  }
  
  public StorageInfoResponse zzum(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzcl(paramParcel);
    long l = 0L;
    ArrayList localArrayList = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, m, PackageStorageInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new StorageInfoResponse(j, i, l, localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */