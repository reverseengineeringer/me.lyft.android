package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzar
  implements Parcelable.Creator<GetDataItemResponse>
{
  static void zza(GetDataItemResponse paramGetDataItemResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, aKM, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public GetDataItemResponse[] zzaci(int paramInt)
  {
    return new GetDataItemResponse[paramInt];
  }
  
  public GetDataItemResponse zzub(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    DataItemParcelable localDataItemParcelable = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localDataItemParcelable = (DataItemParcelable)zza.zza(paramParcel, m, DataItemParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GetDataItemResponse(i, j, localDataItemParcelable);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */