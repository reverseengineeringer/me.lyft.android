package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<GetInstrumentsRequest>
{
  static void zza(GetInstrumentsRequest paramGetInstrumentsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetInstrumentsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, aHP, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetInstrumentsRequest[] zzaam(int paramInt)
  {
    return new GetInstrumentsRequest[paramInt];
  }
  
  public GetInstrumentsRequest zzsl(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    int[] arrayOfInt = null;
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
        arrayOfInt = zza.zzw(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GetInstrumentsRequest(i, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */