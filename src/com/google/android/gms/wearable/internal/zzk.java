package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<CapabilityInfoParcelable>
{
  static void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramCapabilityInfoParcelable.getName(), false);
    zzb.zzc(paramParcel, 3, paramCapabilityInfoParcelable.zzcix(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public CapabilityInfoParcelable[] zzabm(int paramInt)
  {
    return new CapabilityInfoParcelable[paramInt];
  }
  
  public CapabilityInfoParcelable zzti(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str = null;
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
        str = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new CapabilityInfoParcelable(i, str, localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */