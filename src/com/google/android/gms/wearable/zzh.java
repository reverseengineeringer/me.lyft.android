package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<PutDataRequest>
{
  static void zza(PutDataRequest paramPutDataRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramPutDataRequest.getUri(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPutDataRequest.zzcik(), false);
    zzb.zza(paramParcel, 5, paramPutDataRequest.getData(), false);
    zzb.zza(paramParcel, 6, paramPutDataRequest.zzcil());
    zzb.zzaj(paramParcel, i);
  }
  
  public PutDataRequest[] zzabh(int paramInt)
  {
    return new PutDataRequest[paramInt];
  }
  
  public PutDataRequest zztd(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    long l = 0L;
    Bundle localBundle = null;
    Uri localUri = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      case 3: 
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 4: 
        localBundle = zza.zzs(paramParcel, k);
        break;
      case 5: 
        arrayOfByte = zza.zzt(paramParcel, k);
        break;
      case 6: 
        l = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new PutDataRequest(i, localUri, localBundle, arrayOfByte, l);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */