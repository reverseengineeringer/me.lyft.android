package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<StringParcel>
{
  static void zza(StringParcel paramStringParcel, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, zzbek, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public StringParcel[] zzat(int paramInt)
  {
    return new StringParcel[paramInt];
  }
  
  public StringParcel zzp(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str = null;
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
        str = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new StringParcel(i, str);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */