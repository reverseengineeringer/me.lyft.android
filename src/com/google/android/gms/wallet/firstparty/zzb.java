package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<GetBuyFlowInitializationTokenRequest>
{
  static void zza(GetBuyFlowInitializationTokenRequest paramGetBuyFlowInitializationTokenRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramGetBuyFlowInitializationTokenRequest.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, aHK, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, aHL, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetBuyFlowInitializationTokenRequest[] zzaai(int paramInt)
  {
    return new GetBuyFlowInitializationTokenRequest[paramInt];
  }
  
  public GetBuyFlowInitializationTokenRequest zzsh(Parcel paramParcel)
  {
    byte[] arrayOfByte2 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    byte[] arrayOfByte1 = null;
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
        arrayOfByte1 = zza.zzt(paramParcel, k);
        break;
      case 3: 
        arrayOfByte2 = zza.zzt(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GetBuyFlowInitializationTokenRequest(i, arrayOfByte1, arrayOfByte2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */