package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<RemoteMessage>
{
  static void zza(RemoteMessage paramRemoteMessage, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, bM, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public RemoteMessage[] zzadu(int paramInt)
  {
    return new RemoteMessage[paramInt];
  }
  
  public RemoteMessage zzvd(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    Bundle localBundle = null;
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
        localBundle = zza.zzs(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new RemoteMessage(i, localBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.firebase.messaging.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */