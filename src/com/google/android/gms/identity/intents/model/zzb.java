package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<UserAddress>
{
  static void zza(UserAddress paramUserAddress, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramUserAddress.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, name, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, abC, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, abD, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, abE, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, abF, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, abG, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, abH, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, abI, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, zzcgl, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 11, abJ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 12, abK, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 13, phoneNumber, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 14, abL);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 15, abM, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 16, abN, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, paramInt);
  }
  
  public UserAddress zzmm(Parcel paramParcel)
  {
    int j = zza.zzcl(paramParcel);
    int i = 0;
    String str14 = null;
    String str13 = null;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    boolean bool = false;
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
        str14 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str13 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        str12 = zza.zzq(paramParcel, k);
        break;
      case 5: 
        str11 = zza.zzq(paramParcel, k);
        break;
      case 6: 
        str10 = zza.zzq(paramParcel, k);
        break;
      case 7: 
        str9 = zza.zzq(paramParcel, k);
        break;
      case 8: 
        str8 = zza.zzq(paramParcel, k);
        break;
      case 9: 
        str7 = zza.zzq(paramParcel, k);
        break;
      case 10: 
        str6 = zza.zzq(paramParcel, k);
        break;
      case 11: 
        str5 = zza.zzq(paramParcel, k);
        break;
      case 12: 
        str4 = zza.zzq(paramParcel, k);
        break;
      case 13: 
        str3 = zza.zzq(paramParcel, k);
        break;
      case 14: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 15: 
        str2 = zza.zzq(paramParcel, k);
        break;
      case 16: 
        str1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new UserAddress(i, str14, str13, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, bool, str2, str1);
  }
  
  public UserAddress[] zzsp(int paramInt)
  {
    return new UserAddress[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.identity.intents.model.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */