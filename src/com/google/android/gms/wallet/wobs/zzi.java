package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi
  implements Parcelable.Creator<WalletObjectMessage>
{
  static void zza(WalletObjectMessage paramWalletObjectMessage, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramWalletObjectMessage.getVersionCode());
    zzb.zza(paramParcel, 2, aIN, false);
    zzb.zza(paramParcel, 3, body, false);
    zzb.zza(paramParcel, 4, aIR, paramInt, false);
    zzb.zza(paramParcel, 5, aIS, paramInt, false);
    zzb.zza(paramParcel, 6, aIT, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public WalletObjectMessage[] zzabe(int paramInt)
  {
    return new WalletObjectMessage[paramInt];
  }
  
  public WalletObjectMessage zzta(Parcel paramParcel)
  {
    UriData localUriData1 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    UriData localUriData2 = null;
    TimeInterval localTimeInterval = null;
    String str1 = null;
    String str2 = null;
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
        str2 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        localTimeInterval = (TimeInterval)zza.zza(paramParcel, k, TimeInterval.CREATOR);
        break;
      case 5: 
        localUriData2 = (UriData)zza.zza(paramParcel, k, UriData.CREATOR);
        break;
      case 6: 
        localUriData1 = (UriData)zza.zza(paramParcel, k, UriData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new WalletObjectMessage(i, str2, str1, localTimeInterval, localUriData2, localUriData1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */