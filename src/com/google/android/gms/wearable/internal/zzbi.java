package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi
  implements Parcelable.Creator<SendMessageResponse>
{
  static void zza(SendMessageResponse paramSendMessageResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zzc(paramParcel, 3, aci);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public SendMessageResponse[] zzacs(int paramInt)
  {
    return new SendMessageResponse[paramInt];
  }
  
  public SendMessageResponse zzul(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzcl(paramParcel);
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new SendMessageResponse(i, j, k);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzbi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */