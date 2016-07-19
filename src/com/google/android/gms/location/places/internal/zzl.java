package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

public class zzl
  implements Parcelable.Creator<PlaceEntity>
{
  static void zza(PlaceEntity paramPlaceEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceEntity.getId(), false);
    zzb.zza(paramParcel, 2, paramPlaceEntity.zzbos(), false);
    zzb.zza(paramParcel, 3, paramPlaceEntity.zzbou(), paramInt, false);
    zzb.zza(paramParcel, 4, paramPlaceEntity.getLatLng(), paramInt, false);
    zzb.zza(paramParcel, 5, paramPlaceEntity.zzbon());
    zzb.zza(paramParcel, 6, paramPlaceEntity.getViewport(), paramInt, false);
    zzb.zza(paramParcel, 7, paramPlaceEntity.zzbot(), false);
    zzb.zzc(paramParcel, 1000, mVersionCode);
    zzb.zza(paramParcel, 8, paramPlaceEntity.getWebsiteUri(), paramInt, false);
    zzb.zza(paramParcel, 9, paramPlaceEntity.zzboq());
    zzb.zza(paramParcel, 10, paramPlaceEntity.getRating());
    zzb.zzc(paramParcel, 11, paramPlaceEntity.getPriceLevel());
    zzb.zza(paramParcel, 12, paramPlaceEntity.zzbor());
    zzb.zza(paramParcel, 13, paramPlaceEntity.zzbom(), false);
    zzb.zza(paramParcel, 14, (String)paramPlaceEntity.getAddress(), false);
    zzb.zza(paramParcel, 15, (String)paramPlaceEntity.getPhoneNumber(), false);
    zzb.zza(paramParcel, 16, paramPlaceEntity.zzboo(), false);
    zzb.zzb(paramParcel, 17, paramPlaceEntity.zzbop(), false);
    zzb.zza(paramParcel, 19, (String)paramPlaceEntity.getName(), false);
    zzb.zza(paramParcel, 20, paramPlaceEntity.getPlaceTypes(), false);
    zzb.zzaj(paramParcel, i);
  }
  
  public PlaceEntity zznl(Parcel paramParcel)
  {
    int k = zza.zzcl(paramParcel);
    int j = 0;
    String str6 = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    Bundle localBundle = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    ArrayList localArrayList1 = null;
    LatLng localLatLng = null;
    float f2 = 0.0F;
    LatLngBounds localLatLngBounds = null;
    String str1 = null;
    Uri localUri = null;
    boolean bool = false;
    float f1 = 0.0F;
    int i = 0;
    long l = 0L;
    PlaceLocalization localPlaceLocalization = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str6 = zza.zzq(paramParcel, m);
        break;
      case 2: 
        localBundle = zza.zzs(paramParcel, m);
        break;
      case 3: 
        localPlaceLocalization = (PlaceLocalization)zza.zza(paramParcel, m, PlaceLocalization.CREATOR);
        break;
      case 4: 
        localLatLng = (LatLng)zza.zza(paramParcel, m, LatLng.CREATOR);
        break;
      case 5: 
        f2 = zza.zzl(paramParcel, m);
        break;
      case 6: 
        localLatLngBounds = (LatLngBounds)zza.zza(paramParcel, m, LatLngBounds.CREATOR);
        break;
      case 7: 
        str1 = zza.zzq(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 8: 
        localUri = (Uri)zza.zza(paramParcel, m, Uri.CREATOR);
        break;
      case 9: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 10: 
        f1 = zza.zzl(paramParcel, m);
        break;
      case 11: 
        i = zza.zzg(paramParcel, m);
        break;
      case 12: 
        l = zza.zzi(paramParcel, m);
        break;
      case 13: 
        localArrayList2 = zza.zzad(paramParcel, m);
        break;
      case 14: 
        str4 = zza.zzq(paramParcel, m);
        break;
      case 15: 
        str3 = zza.zzq(paramParcel, m);
        break;
      case 16: 
        str2 = zza.zzq(paramParcel, m);
        break;
      case 17: 
        localArrayList1 = zza.zzae(paramParcel, m);
        break;
      case 19: 
        str5 = zza.zzq(paramParcel, m);
        break;
      case 20: 
        localArrayList3 = zza.zzad(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new PlaceEntity(j, str6, localArrayList3, localArrayList2, localBundle, str5, str4, str3, str2, localArrayList1, localLatLng, f2, localLatLngBounds, str1, localUri, bool, f1, i, l, localPlaceLocalization);
  }
  
  public PlaceEntity[] zzub(int paramInt)
  {
    return new PlaceEntity[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */