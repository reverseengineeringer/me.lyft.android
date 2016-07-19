package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<CountrySpecification>
{
  static void zza(CountrySpecification paramCountrySpecification, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramCountrySpecification.getVersionCode());
    zzb.zza(paramParcel, 2, zzcgl, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public CountrySpecification zzml(Parcel paramParcel)
  {
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcl(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzck(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new CountrySpecification(i, str);
  }
  
  public CountrySpecification[] zzso(int paramInt)
  {
    return new CountrySpecification[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */