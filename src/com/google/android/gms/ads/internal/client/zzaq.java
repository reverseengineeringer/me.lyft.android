package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaq
  implements Parcelable.Creator<VideoOptionsParcel>
{
  static void zza(VideoOptionsParcel paramVideoOptionsParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzaxk);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public VideoOptionsParcel zzf(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcl(paramParcel);
    int i = 0;
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
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new VideoOptionsParcel(i, bool);
  }
  
  public VideoOptionsParcel[] zzv(int paramInt)
  {
    return new VideoOptionsParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.client.zzaq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */