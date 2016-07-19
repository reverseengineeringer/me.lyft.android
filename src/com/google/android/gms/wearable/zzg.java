package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<ConnectionConfiguration>
{
  static void zza(ConnectionConfiguration paramConnectionConfiguration, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramConnectionConfiguration.getName(), false);
    zzb.zza(paramParcel, 3, paramConnectionConfiguration.getAddress(), false);
    zzb.zzc(paramParcel, 4, paramConnectionConfiguration.getType());
    zzb.zzc(paramParcel, 5, paramConnectionConfiguration.getRole());
    zzb.zza(paramParcel, 6, paramConnectionConfiguration.isEnabled());
    zzb.zza(paramParcel, 7, paramConnectionConfiguration.isConnected());
    zzb.zza(paramParcel, 8, paramConnectionConfiguration.zzcii(), false);
    zzb.zza(paramParcel, 9, paramConnectionConfiguration.zzcij());
    zzb.zza(paramParcel, 10, paramConnectionConfiguration.getNodeId(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public ConnectionConfiguration[] zzabg(int paramInt)
  {
    return new ConnectionConfiguration[paramInt];
  }
  
  public ConnectionConfiguration zztc(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool1 = false;
    int m = zza.zzcl(paramParcel);
    String str2 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    int j = 0;
    String str3 = null;
    String str4 = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str4 = zza.zzq(paramParcel, n);
        break;
      case 3: 
        str3 = zza.zzq(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
        break;
      case 6: 
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 7: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 8: 
        str2 = zza.zzq(paramParcel, n);
        break;
      case 9: 
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 10: 
        str1 = zza.zzq(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new ConnectionConfiguration(k, str4, str3, j, i, bool3, bool2, str2, bool1, str1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.zzg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */