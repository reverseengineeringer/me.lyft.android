package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<GetInstrumentsResponse>
{
  static void zza(GetInstrumentsResponse paramGetInstrumentsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetInstrumentsResponse.getVersionCode());
    zzb.zza(paramParcel, 2, aHQ, false);
    zzb.zza(paramParcel, 3, aHR, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetInstrumentsResponse[] zzaan(int paramInt)
  {
    return new GetInstrumentsResponse[paramInt];
  }
  
  public GetInstrumentsResponse zzsm(Parcel paramParcel)
  {
    byte[][] arrayOfByte = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String[] arrayOfString = null;
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
        arrayOfString = zza.zzac(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = zza.zzu(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GetInstrumentsResponse(i, arrayOfString, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */