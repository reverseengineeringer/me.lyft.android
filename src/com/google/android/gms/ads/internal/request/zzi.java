package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi
  implements Parcelable.Creator<AutoClickProtectionConfigurationParcel>
{
  static void zza(AutoClickProtectionConfigurationParcel paramAutoClickProtectionConfigurationParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzccy);
    zzb.zzb(paramParcel, 3, zzccz, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public AutoClickProtectionConfigurationParcel[] zzaq(int paramInt)
  {
    return new AutoClickProtectionConfigurationParcel[paramInt];
  }
  
  public AutoClickProtectionConfigurationParcel zzm(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzcl(paramParcel);
    ArrayList localArrayList = null;
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzae(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new AutoClickProtectionConfigurationParcel(i, bool, localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */