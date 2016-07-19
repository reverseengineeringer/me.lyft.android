package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<CapabilityParcel>
{
  static void zza(CapabilityParcel paramCapabilityParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzcda);
    zzb.zza(paramParcel, 3, zzcdb);
    zzb.zza(paramParcel, 4, zzcdc);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public CapabilityParcel[] zzar(int paramInt)
  {
    return new CapabilityParcel[paramInt];
  }
  
  public CapabilityParcel zzn(Parcel paramParcel)
  {
    boolean bool3 = false;
    int j = zza.zzcl(paramParcel);
    boolean bool2 = false;
    boolean bool1 = false;
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
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        bool3 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new CapabilityParcel(i, bool1, bool2, bool3);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */