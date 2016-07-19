package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public class zza
  implements Parcelable.Creator<WalletFragmentInitParams>
{
  static void zza(WalletFragmentInitParams paramWalletFragmentInitParams, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramWalletFragmentInitParams.getAccountName(), false);
    zzb.zza(paramParcel, 3, paramWalletFragmentInitParams.getMaskedWalletRequest(), paramInt, false);
    zzb.zzc(paramParcel, 4, paramWalletFragmentInitParams.getMaskedWalletRequestCode());
    zzb.zza(paramParcel, 5, paramWalletFragmentInitParams.getMaskedWallet(), paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public WalletFragmentInitParams[] zzaaq(int paramInt)
  {
    return new WalletFragmentInitParams[paramInt];
  }
  
  public WalletFragmentInitParams zzsp(Parcel paramParcel)
  {
    MaskedWallet localMaskedWallet = null;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcl(paramParcel);
    int j = 0;
    int i = -1;
    MaskedWalletRequest localMaskedWalletRequest = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzck(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 3: 
        localMaskedWalletRequest = (MaskedWalletRequest)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, MaskedWalletRequest.CREATOR);
        break;
      case 4: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 5: 
        localMaskedWallet = (MaskedWallet)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, MaskedWallet.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new WalletFragmentInitParams(j, str, localMaskedWalletRequest, i, localMaskedWallet);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */