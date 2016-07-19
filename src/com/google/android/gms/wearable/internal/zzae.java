package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae
  implements Parcelable.Creator<DataItemParcelable>
{
  static void zza(DataItemParcelable paramDataItemParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramDataItemParcelable.getUri(), paramInt, false);
    zzb.zza(paramParcel, 4, paramDataItemParcelable.zzcik(), false);
    zzb.zza(paramParcel, 5, paramDataItemParcelable.getData(), false);
    zzb.zzaj(paramParcel, i);
  }
  
  public DataItemParcelable[] zzabw(int paramInt)
  {
    return new DataItemParcelable[paramInt];
  }
  
  public DataItemParcelable zztp(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      Object localObject3;
      switch (zza.zzgi(k))
      {
      case 3: 
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzs(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        arrayOfByte = zza.zzt(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new DataItemParcelable(i, (Uri)localObject1, (Bundle)localObject2, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */