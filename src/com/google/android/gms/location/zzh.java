package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<LocationSettingsResult>
{
  static void zza(LocationSettingsResult paramLocationSettingsResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramLocationSettingsResult.getStatus(), paramInt, false);
    zzb.zza(paramParcel, 2, paramLocationSettingsResult.getLocationSettingsStates(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramLocationSettingsResult.getVersionCode());
    zzb.zzaj(paramParcel, i);
  }
  
  public LocationSettingsResult zzmt(Parcel paramParcel)
  {
    LocationSettingsStates localLocationSettingsStates = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localLocationSettingsStates = (LocationSettingsStates)zza.zza(paramParcel, k, LocationSettingsStates.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LocationSettingsResult(i, localStatus, localLocationSettingsStates);
  }
  
  public LocationSettingsResult[] zztc(int paramInt)
  {
    return new LocationSettingsResult[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */