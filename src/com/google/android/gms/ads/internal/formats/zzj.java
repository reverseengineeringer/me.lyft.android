package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<NativeAdOptionsParcel>
{
  static void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbgt);
    zzb.zzc(paramParcel, 3, zzbgu);
    zzb.zza(paramParcel, 4, zzbgv);
    zzb.zzc(paramParcel, 5, zzbgw);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public NativeAdOptionsParcel zzg(Parcel paramParcel)
  {
    int i = 0;
    int m = zza.zzcl(paramParcel);
    boolean bool1 = false;
    int j = 0;
    boolean bool2 = false;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new NativeAdOptionsParcel(k, bool2, j, bool1, i);
  }
  
  public NativeAdOptionsParcel[] zzw(int paramInt)
  {
    return new NativeAdOptionsParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.formats.zzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */