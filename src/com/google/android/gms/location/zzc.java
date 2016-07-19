package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<GestureRequest>
{
  static void zza(GestureRequest paramGestureRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramGestureRequest.zzbng(), false);
    zzb.zzc(paramParcel, 1000, paramGestureRequest.getVersionCode());
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GestureRequest zzmq(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzad(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GestureRequest(i, localArrayList);
  }
  
  public GestureRequest[] zzsx(int paramInt)
  {
    return new GestureRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */