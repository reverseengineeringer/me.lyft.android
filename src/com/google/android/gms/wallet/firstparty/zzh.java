package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<InitializeBuyFlowRequest>
{
  static void zza(InitializeBuyFlowRequest paramInitializeBuyFlowRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramInitializeBuyFlowRequest.getVersionCode());
    zzb.zza(paramParcel, 2, aHS, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public InitializeBuyFlowRequest[] zzaao(int paramInt)
  {
    return new InitializeBuyFlowRequest[paramInt];
  }
  
  public InitializeBuyFlowRequest zzsn(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    byte[][] arrayOfByte = null;
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
        arrayOfByte = zza.zzu(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new InitializeBuyFlowRequest(i, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */