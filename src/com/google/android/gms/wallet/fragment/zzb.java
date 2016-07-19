package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<WalletFragmentOptions>
{
  static void zza(WalletFragmentOptions paramWalletFragmentOptions, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramWalletFragmentOptions.getEnvironment());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 3, paramWalletFragmentOptions.getTheme());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramWalletFragmentOptions.getFragmentStyle(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 5, paramWalletFragmentOptions.getMode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }
  
  public WalletFragmentOptions[] zzaar(int paramInt)
  {
    return new WalletFragmentOptions[paramInt];
  }
  
  public WalletFragmentOptions zzsq(Parcel paramParcel)
  {
    int i = 1;
    int j = 0;
    int n = zza.zzcl(paramParcel);
    WalletFragmentStyle localWalletFragmentStyle = null;
    int k = 1;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzck(paramParcel);
      switch (zza.zzgi(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 3: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        localWalletFragmentStyle = (WalletFragmentStyle)zza.zza(paramParcel, i1, WalletFragmentStyle.CREATOR);
        break;
      case 5: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza(37 + "Overread allowed size end=" + n, paramParcel);
    }
    return new WalletFragmentOptions(m, k, j, localWalletFragmentStyle, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */