package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class zza
  implements Parcelable.Creator<CommonWalletObject>
{
  static void zza(CommonWalletObject paramCommonWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramCommonWalletObject.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, id, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, aGR, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, name, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, aGL, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, aGN, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, aGO, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, aGP, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, aGQ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 10, state);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 11, aGS, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 12, aGT, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 13, aGU, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 14, aGV, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 15, aGW, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 16, aGX, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 17, aGY);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 18, aGZ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 19, aHa, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 20, aHb, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }
  
  public CommonWalletObject[] zzaaw(int paramInt)
  {
    return new CommonWalletObject[paramInt];
  }
  
  public CommonWalletObject zzss(Parcel paramParcel)
  {
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzcl(paramParcel);
    int j = 0;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    int i = 0;
    ArrayList localArrayList6 = com.google.android.gms.common.util.zzb.zzavf();
    TimeInterval localTimeInterval = null;
    ArrayList localArrayList5 = com.google.android.gms.common.util.zzb.zzavf();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = com.google.android.gms.common.util.zzb.zzavf();
    boolean bool = false;
    ArrayList localArrayList3 = com.google.android.gms.common.util.zzb.zzavf();
    ArrayList localArrayList2 = com.google.android.gms.common.util.zzb.zzavf();
    ArrayList localArrayList1 = com.google.android.gms.common.util.zzb.zzavf();
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzck(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        str10 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 3: 
        str9 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 4: 
        str8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 5: 
        str7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 6: 
        str6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 7: 
        str5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 8: 
        str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 9: 
        str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 10: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 11: 
        localArrayList6 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, WalletObjectMessage.CREATOR);
        break;
      case 12: 
        localTimeInterval = (TimeInterval)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, m, TimeInterval.CREATOR);
        break;
      case 13: 
        localArrayList5 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, LatLng.CREATOR);
        break;
      case 14: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 15: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, m);
        break;
      case 16: 
        localArrayList4 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, LabelValueRow.CREATOR);
        break;
      case 17: 
        bool = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m);
        break;
      case 18: 
        localArrayList3 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, UriData.CREATOR);
        break;
      case 19: 
        localArrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, TextModuleData.CREATOR);
        break;
      case 20: 
        localArrayList1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, m, UriData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new CommonWalletObject(j, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localTimeInterval, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */