package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzv
  implements Parcelable.Creator<CloseChannelResponse>
{
  static void zza(CloseChannelResponse paramCloseChannelResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public CloseChannelResponse[] zzabu(int paramInt)
  {
    return new CloseChannelResponse[paramInt];
  }
  
  public CloseChannelResponse zztn(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new CloseChannelResponse(i, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */