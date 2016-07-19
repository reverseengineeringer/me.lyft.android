package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<TextModuleData>
{
  static void zza(TextModuleData paramTextModuleData, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramTextModuleData.getVersionCode());
    zzb.zza(paramParcel, 2, aIN, false);
    zzb.zza(paramParcel, 3, body, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public TextModuleData[] zzabb(int paramInt)
  {
    return new TextModuleData[paramInt];
  }
  
  public TextModuleData zzsx(Parcel paramParcel)
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
    return new TextModuleData(i, str1, str2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */