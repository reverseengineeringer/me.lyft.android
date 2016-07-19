package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<InterstitialAdParameterParcel>
{
  static void zza(InterstitialAdParameterParcel paramInterstitialAdParameterParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzamc);
    zzb.zza(paramParcel, 3, zzamd);
    zzb.zza(paramParcel, 4, zzame, false);
    zzb.zza(paramParcel, 5, zzamf);
    zzb.zza(paramParcel, 6, zzamg);
    zzb.zzc(paramParcel, 7, zzamh);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public InterstitialAdParameterParcel zzb(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzcl(paramParcel);
    String str = null;
    float f = 0.0F;
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        bool3 = zza.zzc(paramParcel, m);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, m);
        break;
      case 4: 
        str = zza.zzq(paramParcel, m);
        break;
      case 5: 
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 6: 
        f = zza.zzl(paramParcel, m);
        break;
      case 7: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new InterstitialAdParameterParcel(j, bool3, bool2, str, bool1, f, i);
  }
  
  public InterstitialAdParameterParcel[] zzi(int paramInt)
  {
    return new InterstitialAdParameterParcel[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */