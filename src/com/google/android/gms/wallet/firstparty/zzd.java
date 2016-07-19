package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<GetClientTokenRequest>
{
  static void zza(GetClientTokenRequest paramGetClientTokenRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetClientTokenRequest.getVersionCode());
    zzb.zza(paramParcel, 2, aHN, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public GetClientTokenRequest[] zzaak(int paramInt)
  {
    return new GetClientTokenRequest[paramInt];
  }
  
  public GetClientTokenRequest zzsj(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    WalletCustomTheme localWalletCustomTheme = null;
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
        localWalletCustomTheme = (WalletCustomTheme)zza.zza(paramParcel, k, WalletCustomTheme.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GetClientTokenRequest(i, localWalletCustomTheme);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */