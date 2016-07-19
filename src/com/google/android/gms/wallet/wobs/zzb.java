package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<LabelValue>
{
  static void zza(LabelValue paramLabelValue, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramLabelValue.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, label, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, value, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, paramInt);
  }
  
  public LabelValue[] zzaax(int paramInt)
  {
    return new LabelValue[paramInt];
  }
  
  public LabelValue zzst(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LabelValue(i, str1, str2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */