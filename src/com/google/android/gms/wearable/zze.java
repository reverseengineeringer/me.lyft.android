package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<Asset>
{
  static void zza(Asset paramAsset, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zza(paramParcel, 2, paramAsset.getData(), false);
    zzb.zza(paramParcel, 3, paramAsset.getDigest(), false);
    zzb.zza(paramParcel, 4, aIV, paramInt, false);
    zzb.zza(paramParcel, 5, uri, paramInt, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public Asset[] zzabf(int paramInt)
  {
    return new Asset[paramInt];
  }
  
  public Asset zztb(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    String str = null;
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
        break;
      case 3: 
        str = zza.zzq(paramParcel, k);
        break;
      case 4: 
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new Asset(i, arrayOfByte, str, localParcelFileDescriptor, localUri);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */