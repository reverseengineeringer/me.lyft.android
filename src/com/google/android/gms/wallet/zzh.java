package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<InstrumentInfo>
{
  static void zza(InstrumentInfo paramInstrumentInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramInstrumentInfo.getVersionCode());
    zzb.zza(paramParcel, 2, paramInstrumentInfo.getInstrumentType(), false);
    zzb.zza(paramParcel, 3, paramInstrumentInfo.getInstrumentDetails(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public InstrumentInfo zzrw(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str1 = null;
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
        str1 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new InstrumentInfo(i, str1, str2);
  }
  
  public InstrumentInfo[] zzzx(int paramInt)
  {
    return new InstrumentInfo[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */