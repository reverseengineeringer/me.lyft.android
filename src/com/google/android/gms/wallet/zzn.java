package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn
  implements Parcelable.Creator<NotifyTransactionStatusRequest>
{
  static void zza(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, aGj, false);
    zzb.zzc(paramParcel, 3, status);
    zzb.zza(paramParcel, 4, aHu, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public NotifyTransactionStatusRequest[] zzaad(int paramInt)
  {
    return new NotifyTransactionStatusRequest[paramInt];
  }
  
  public NotifyTransactionStatusRequest zzsc(Parcel paramParcel)
  {
    String str2 = null;
    int j = 0;
    int k = zza.zzcl(paramParcel);
    String str1 = null;
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
        str1 = zza.zzq(paramParcel, m);
        break;
      case 3: 
        j = zza.zzg(paramParcel, m);
        break;
      case 4: 
        str2 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new NotifyTransactionStatusRequest(i, str1, j, str2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */