package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzao
  implements Parcelable.Creator<GetConfigResponse>
{
  static void zza(GetConfigResponse paramGetConfigResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, aKJ, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public GetConfigResponse[] zzacf(int paramInt)
  {
    return new GetConfigResponse[paramInt];
  }
  
  public GetConfigResponse zzty(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    ConnectionConfiguration localConnectionConfiguration = null;
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
        localConnectionConfiguration = (ConnectionConfiguration)zza.zza(paramParcel, m, ConnectionConfiguration.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GetConfigResponse(i, j, localConnectionConfiguration);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */