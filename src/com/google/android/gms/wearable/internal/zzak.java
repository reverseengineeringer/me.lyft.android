package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzak
  implements Parcelable.Creator<GetChannelOutputStreamResponse>
{
  static void zza(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, aKF, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public GetChannelOutputStreamResponse[] zzacb(int paramInt)
  {
    return new GetChannelOutputStreamResponse[paramInt];
  }
  
  public GetChannelOutputStreamResponse zztu(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, m, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GetChannelOutputStreamResponse(i, j, localParcelFileDescriptor);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzak
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */