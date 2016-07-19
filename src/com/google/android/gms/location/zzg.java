package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<LocationSettingsRequest>
{
  static void zza(LocationSettingsRequest paramLocationSettingsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramLocationSettingsRequest.zzbew(), false);
    zzb.zza(paramParcel, 2, paramLocationSettingsRequest.zzbnh());
    zzb.zza(paramParcel, 3, paramLocationSettingsRequest.zzbni());
    zzb.zzc(paramParcel, 1000, paramLocationSettingsRequest.getVersionCode());
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public LocationSettingsRequest zzms(Parcel paramParcel)
  {
    boolean bool2 = false;
    int j = zza.zzcl(paramParcel);
    ArrayList localArrayList = null;
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
        localArrayList = zza.zzc(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 2: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsRequest(i, localArrayList, bool1, bool2);
  }
  
  public LocationSettingsRequest[] zztb(int paramInt)
  {
    return new LocationSettingsRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */