package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void zza(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, id, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, aGK, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, aGL, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, aGM, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, DP, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, aGN, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 8, aGO, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 9, aGP, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 10, aGQ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 11, aGR, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 12, state);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 13, aGS, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 14, aGT, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 15, aGU, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 16, aGV, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 17, aGW, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 18, aGX, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 19, aGY);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 20, aGZ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 21, aHa, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 22, aHb, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 23, aHc, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, i);
  }
  
  public LoyaltyWalletObject[] zzaaa(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
  
  public LoyaltyWalletObject zzrz(Parcel paramParcel)
  {
    int k = zza.zzcl(paramParcel);
    int j = 0;
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
    LoyaltyPoints localLoyaltyPoints = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzck(paramParcel);
      switch (zza.zzgi(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str12 = zza.zzq(paramParcel, m);
        break;
      case 3: 
        str11 = zza.zzq(paramParcel, m);
        break;
      case 4: 
        str10 = zza.zzq(paramParcel, m);
        break;
      case 5: 
        str9 = zza.zzq(paramParcel, m);
        break;
      case 6: 
        str8 = zza.zzq(paramParcel, m);
        break;
      case 7: 
        str7 = zza.zzq(paramParcel, m);
        break;
      case 8: 
        str6 = zza.zzq(paramParcel, m);
        break;
      case 9: 
        str5 = zza.zzq(paramParcel, m);
        break;
      case 10: 
        str4 = zza.zzq(paramParcel, m);
        break;
      case 11: 
        str3 = zza.zzq(paramParcel, m);
        break;
      case 12: 
        i = zza.zzg(paramParcel, m);
        break;
      case 13: 
        localArrayList6 = zza.zzc(paramParcel, m, WalletObjectMessage.CREATOR);
        break;
      case 14: 
        localTimeInterval = (TimeInterval)zza.zza(paramParcel, m, TimeInterval.CREATOR);
        break;
      case 15: 
        localArrayList5 = zza.zzc(paramParcel, m, LatLng.CREATOR);
        break;
      case 16: 
        str2 = zza.zzq(paramParcel, m);
        break;
      case 17: 
        str1 = zza.zzq(paramParcel, m);
        break;
      case 18: 
        localArrayList4 = zza.zzc(paramParcel, m, LabelValueRow.CREATOR);
        break;
      case 19: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 20: 
        localArrayList3 = zza.zzc(paramParcel, m, UriData.CREATOR);
        break;
      case 21: 
        localArrayList2 = zza.zzc(paramParcel, m, TextModuleData.CREATOR);
        break;
      case 22: 
        localArrayList1 = zza.zzc(paramParcel, m, UriData.CREATOR);
        break;
      case 23: 
        localLoyaltyPoints = (LoyaltyPoints)zza.zza(paramParcel, m, LoyaltyPoints.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localTimeInterval, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localLoyaltyPoints);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */