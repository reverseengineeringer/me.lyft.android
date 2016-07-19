package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<PaymentMethodTokenizationParameters>
{
  static void zza(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramPaymentMethodTokenizationParameters.getVersionCode());
    zzb.zzc(paramParcel, 2, aHx);
    zzb.zza(paramParcel, 3, aHy, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public PaymentMethodTokenizationParameters[] zzaag(int paramInt)
  {
    return new PaymentMethodTokenizationParameters[paramInt];
  }
  
  public PaymentMethodTokenizationParameters zzsf(Parcel paramParcel)
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
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localBundle = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new PaymentMethodTokenizationParameters(i, j, localBundle);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */