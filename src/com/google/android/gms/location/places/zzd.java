package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<NearbyAlertFilter>
{
  static void zza(NearbyAlertFilter paramNearbyAlertFilter, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzb(paramParcel, 1, aen, false);
    zzb.zza(paramParcel, 2, aeo, false);
    zzb.zzc(paramParcel, 3, aep, false);
    zzb.zza(paramParcel, 4, aeq, false);
    zzb.zza(paramParcel, 5, aer);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public NearbyAlertFilter zznc(Parcel paramParcel)
  {
    boolean bool = false;
    String str = null;
    int j = zza.zzcl(paramParcel);
    ArrayList localArrayList1 = null;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList3 = null;
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
        localArrayList3 = zza.zzae(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = zza.zzad(paramParcel, k);
        break;
      case 3: 
        localArrayList1 = zza.zzc(paramParcel, k, UserDataType.CREATOR);
        break;
      case 4: 
        str = zza.zzq(paramParcel, k);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new NearbyAlertFilter(i, localArrayList3, localArrayList2, localArrayList1, str, bool);
  }
  
  public NearbyAlertFilter[] zztq(int paramInt)
  {
    return new NearbyAlertFilter[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */