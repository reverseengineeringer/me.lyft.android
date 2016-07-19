package com.google.android.gms.wallet.firstparty;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<WalletCustomTheme>
{
  static void zza(WalletCustomTheme paramWalletCustomTheme, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, aHT);
    zzb.zza(paramParcel, 3, aHU, false);
    zzb.zza(paramParcel, 4, aHV, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public WalletCustomTheme[] zzaap(int paramInt)
  {
    return new WalletCustomTheme[paramInt];
  }
  
  public WalletCustomTheme zzso(Parcel paramParcel)
  {
    String str = null;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localBundle = zza.zzs(paramParcel, m);
        break;
      case 4: 
        str = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new WalletCustomTheme(i, j, localBundle, str);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */