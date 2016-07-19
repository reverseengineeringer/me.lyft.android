package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<AddPlaceRequest>
{
  static void zza(AddPlaceRequest paramAddPlaceRequest, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramAddPlaceRequest.getName(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramAddPlaceRequest.getLatLng(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramAddPlaceRequest.getAddress(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramAddPlaceRequest.getPlaceTypes(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramAddPlaceRequest.getPhoneNumber(), false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramAddPlaceRequest.getWebsiteUri(), paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }
  
  public AddPlaceRequest zzna(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str1 = null;
    ArrayList localArrayList = null;
    String str2 = null;
    LatLng localLatLng = null;
    String str3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzck(paramParcel);
      switch (zza.zzgi(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str3 = zza.zzq(paramParcel, k);
        break;
      case 2: 
        localLatLng = (LatLng)zza.zza(paramParcel, k, LatLng.CREATOR);
        break;
      case 3: 
        str2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzad(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzq(paramParcel, k);
        break;
      case 6: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new AddPlaceRequest(i, str3, localLatLng, str2, localArrayList, str1, localUri);
  }
  
  public AddPlaceRequest[] zzto(int paramInt)
  {
    return new AddPlaceRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */