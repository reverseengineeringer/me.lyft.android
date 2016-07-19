package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<NearbyAlertRequest>
{
  static void zza(NearbyAlertRequest paramNearbyAlertRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramNearbyAlertRequest.zzbns());
    zzb.zzc(paramParcel, 2, paramNearbyAlertRequest.zzbnw());
    zzb.zza(paramParcel, 3, paramNearbyAlertRequest.zzbnx(), paramInt, false);
    zzb.zza(paramParcel, 4, paramNearbyAlertRequest.zzbny(), paramInt, false);
    zzb.zza(paramParcel, 5, paramNearbyAlertRequest.zzbnz());
    zzb.zzc(paramParcel, 6, paramNearbyAlertRequest.zzboa());
    zzb.zzc(paramParcel, 7, paramNearbyAlertRequest.getPriority());
    zzb.zzc(paramParcel, 1000, paramNearbyAlertRequest.getVersionCode());
    zzb.zzaj(paramParcel, i);
  }
  
  public NearbyAlertRequest zznd(Parcel paramParcel)
  {
    NearbyAlertFilter localNearbyAlertFilter = null;
    int j = 0;
    int i1 = zza.zzcl(paramParcel);
    int k = -1;
    int i = 110;
    boolean bool = false;
    PlaceFilter localPlaceFilter = null;
    int m = 0;
    int n = 0;
    while (paramParcel.dataPosition() < i1)
    {
      int i2 = zza.zzck(paramParcel);
      switch (zza.zzgi(i2))
      {
      default: 
        zza.zzb(paramParcel, i2);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i2);
        break;
      case 2: 
        k = zza.zzg(paramParcel, i2);
        break;
      case 3: 
        localPlaceFilter = (PlaceFilter)zza.zza(paramParcel, i2, PlaceFilter.CREATOR);
        break;
      case 4: 
        localNearbyAlertFilter = (NearbyAlertFilter)zza.zza(paramParcel, i2, NearbyAlertFilter.CREATOR);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, i2);
        break;
      case 6: 
        j = zza.zzg(paramParcel, i2);
        break;
      case 7: 
        i = zza.zzg(paramParcel, i2);
        break;
      case 1000: 
        n = zza.zzg(paramParcel, i2);
      }
    }
    if (paramParcel.dataPosition() != i1) {
      throw new zza.zza(37 + "Overread allowed size end=" + i1, paramParcel);
    }
    return new NearbyAlertRequest(n, m, k, localPlaceFilter, localNearbyAlertFilter, bool, j, i);
  }
  
  public NearbyAlertRequest[] zztr(int paramInt)
  {
    return new NearbyAlertRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */