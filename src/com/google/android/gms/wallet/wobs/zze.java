package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<LoyaltyPoints>
{
  static void zza(LoyaltyPoints paramLoyaltyPoints, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramLoyaltyPoints.getVersionCode());
    zzb.zza(paramParcel, 2, label, false);
    zzb.zza(paramParcel, 3, aIH, paramInt, false);
    zzb.zza(paramParcel, 4, type, false);
    zzb.zza(paramParcel, 5, aGT, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public LoyaltyPoints[] zzaba(int paramInt)
  {
    return new LoyaltyPoints[paramInt];
  }
  
  public LoyaltyPoints zzsw(Parcel paramParcel)
  {
    TimeInterval localTimeInterval = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str1 = null;
    LoyaltyPointsBalance localLoyaltyPointsBalance = null;
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
        localLoyaltyPointsBalance = (LoyaltyPointsBalance)zza.zza(paramParcel, k, LoyaltyPointsBalance.CREATOR);
        break;
      case 4: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 5: 
        localTimeInterval = (TimeInterval)zza.zza(paramParcel, k, TimeInterval.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LoyaltyPoints(i, str2, localLoyaltyPointsBalance, str1, localTimeInterval);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */