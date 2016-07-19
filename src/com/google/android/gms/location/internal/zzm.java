package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzm
  implements Parcelable.Creator<LocationRequestInternal>
{
  static void zza(LocationRequestInternal paramLocationRequestInternal, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, PM, paramInt, false);
    zzb.zza(paramParcel, 4, acu);
    zzb.zzc(paramParcel, 5, adU, false);
    zzb.zza(paramParcel, 6, mTag, false);
    zzb.zza(paramParcel, 7, adV);
    zzb.zzc(paramParcel, 1000, paramLocationRequestInternal.getVersionCode());
    zzb.zza(paramParcel, 8, adW);
    zzb.zzaj(paramParcel, i);
  }
  
  public LocationRequestInternal zzmx(Parcel paramParcel)
  {
    String str = null;
    boolean bool1 = false;
    int j = zza.zzcl(paramParcel);
    boolean bool3 = true;
    Object localObject = LocationRequestInternal.adT;
    boolean bool2 = false;
    LocationRequest localLocationRequest = null;
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
        localLocationRequest = (LocationRequest)zza.zza(paramParcel, k, LocationRequest.CREATOR);
        break;
      case 4: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 5: 
        localObject = zza.zzc(paramParcel, k, ClientIdentity.CREATOR);
        break;
      case 6: 
        str = zza.zzq(paramParcel, k);
        break;
      case 7: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 8: 
        bool1 = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LocationRequestInternal(i, localLocationRequest, bool3, (List)localObject, str, bool2, bool1);
  }
  
  public LocationRequestInternal[] zztj(int paramInt)
  {
    return new LocationRequestInternal[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.internal.zzm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */