package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<TimeInterval>
{
  static void zza(TimeInterval paramTimeInterval, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramTimeInterval.getVersionCode());
    zzb.zza(paramParcel, 2, aIO);
    zzb.zza(paramParcel, 3, aIP);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public TimeInterval[] zzabc(int paramInt)
  {
    return new TimeInterval[paramInt];
  }
  
  public TimeInterval zzsy(Parcel paramParcel)
  {
    long l1 = 0L;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    long l2 = 0L;
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
        l2 = zza.zzi(paramParcel, k);
        break;
      case 3: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new TimeInterval(i, l2, l1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */