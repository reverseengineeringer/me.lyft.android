package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<GetClientTokenResponse>
{
  static void zza(GetClientTokenResponse paramGetClientTokenResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetClientTokenResponse.getVersionCode());
    zzb.zza(paramParcel, 2, aHO, false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetClientTokenResponse[] zzaal(int paramInt)
  {
    return new GetClientTokenResponse[paramInt];
  }
  
  public GetClientTokenResponse zzsk(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    byte[] arrayOfByte = null;
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
        arrayOfByte = zza.zzt(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new GetClientTokenResponse(i, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.firstparty.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */