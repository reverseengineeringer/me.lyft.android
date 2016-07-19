package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzah
  implements Parcelable.Creator<GetAllCapabilitiesResponse>
{
  static void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zzc(paramParcel, 3, aKD, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetAllCapabilitiesResponse[] zzaby(int paramInt)
  {
    return new GetAllCapabilitiesResponse[paramInt];
  }
  
  public GetAllCapabilitiesResponse zztr(Parcel paramParcel)
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
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, m, CapabilityInfoParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GetAllCapabilitiesResponse(i, j, localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */