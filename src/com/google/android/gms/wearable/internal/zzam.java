package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzam
  implements Parcelable.Creator<GetCloudSyncOptInStatusResponse>
{
  static void zza(GetCloudSyncOptInStatusResponse paramGetCloudSyncOptInStatusResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zzc(paramParcel, 2, statusCode);
    zzb.zza(paramParcel, 3, aKH);
    zzb.zza(paramParcel, 4, aKI);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public GetCloudSyncOptInStatusResponse[] zzacd(int paramInt)
  {
    return new GetCloudSyncOptInStatusResponse[paramInt];
  }
  
  public GetCloudSyncOptInStatusResponse zztw(Parcel paramParcel)
  {
    boolean bool2 = false;
    int k = zza.zzcl(paramParcel);
    boolean bool1 = false;
    int j = 0;
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
        bool1 = zza.zzc(paramParcel, m);
        break;
      case 4: 
        bool2 = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new GetCloudSyncOptInStatusResponse(i, j, bool1, bool2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */