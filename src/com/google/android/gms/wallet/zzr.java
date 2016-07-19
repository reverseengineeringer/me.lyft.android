package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ProxyCard>
{
  static void zza(ProxyCard paramProxyCard, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramProxyCard.getVersionCode());
    zzb.zza(paramParcel, 2, aHA, false);
    zzb.zza(paramParcel, 3, aHB, false);
    zzb.zzc(paramParcel, 4, aHC);
    zzb.zzc(paramParcel, 5, aHD);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public ProxyCard[] zzaah(int paramInt)
  {
    return new ProxyCard[paramInt];
  }
  
  public ProxyCard zzsg(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zza.zzcl(paramParcel);
    int j = 0;
    String str2 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str2 = zza.zzq(paramParcel, n);
        break;
      case 3: 
        str1 = zza.zzq(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ProxyCard(k, str2, str1, j, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */