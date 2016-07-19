package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<ChannelImpl>
{
  static void zza(ChannelImpl paramChannelImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramChannelImpl.getToken(), false);
    zzb.zza(paramParcel, 3, paramChannelImpl.getNodeId(), false);
    zzb.zza(paramParcel, 4, paramChannelImpl.getPath(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public ChannelImpl[] zzabq(int paramInt)
  {
    return new ChannelImpl[paramInt];
  }
  
  public ChannelImpl zztk(Parcel paramParcel)
  {
    String str3 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str2 = null;
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
        break;
      case 4: 
        str3 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new ChannelImpl(i, str1, str2, str3);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */