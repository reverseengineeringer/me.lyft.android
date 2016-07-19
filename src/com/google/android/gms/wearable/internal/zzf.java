package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<AmsEntityUpdateParcelable>
{
  static void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramAmsEntityUpdateParcelable.zzcio());
    zzb.zza(paramParcel, 3, paramAmsEntityUpdateParcelable.zzcip());
    zzb.zza(paramParcel, 4, paramAmsEntityUpdateParcelable.getValue(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public AmsEntityUpdateParcelable[] zzabk(int paramInt)
  {
    return new AmsEntityUpdateParcelable[paramInt];
  }
  
  public AmsEntityUpdateParcelable zztg(Parcel paramParcel)
  {
    byte b2 = 0;
    int j = zza.zzcl(paramParcel);
    String str = null;
    byte b1 = 0;
    int i = 0;
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
        b1 = zza.zze(paramParcel, k);
        break;
      case 3: 
        b2 = zza.zze(paramParcel, k);
        break;
      case 4: 
        str = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new AmsEntityUpdateParcelable(i, b1, b2, str);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */