package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<WalletFragmentStyle>
{
  static void zza(WalletFragmentStyle paramWalletFragmentStyle, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, aHU, false);
    zzb.zzc(paramParcel, 3, aIu);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public WalletFragmentStyle[] zzaat(int paramInt)
  {
    return new WalletFragmentStyle[paramInt];
  }
  
  public WalletFragmentStyle zzsr(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    Bundle localBundle = null;
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
        localBundle = zza.zzs(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new WalletFragmentStyle(i, localBundle, j);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.fragment.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */