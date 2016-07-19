package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<GeofencingRequest>
{
  static void zza(GeofencingRequest paramGeofencingRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramGeofencingRequest.zzbnf(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 2, paramGeofencingRequest.getInitialTrigger());
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramGeofencingRequest.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, paramInt);
  }
  
  public GeofencingRequest zzmp(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzcl(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, m, ParcelableGeofence.CREATOR);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GeofencingRequest(i, localArrayList, j);
  }
  
  public GeofencingRequest[] zzsw(int paramInt)
  {
    return new GeofencingRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */