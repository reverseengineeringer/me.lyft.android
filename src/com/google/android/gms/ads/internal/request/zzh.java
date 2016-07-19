package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<AdResponseParcel>
{
  static void zza(AdResponseParcel paramAdResponseParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzbts, false);
    zzb.zza(paramParcel, 3, body, false);
    zzb.zzb(paramParcel, 4, zzbnq, false);
    zzb.zzc(paramParcel, 5, errorCode);
    zzb.zzb(paramParcel, 6, zzbnr, false);
    zzb.zza(paramParcel, 7, zzccb);
    zzb.zza(paramParcel, 8, zzccc);
    zzb.zza(paramParcel, 9, zzccd);
    zzb.zzb(paramParcel, 10, zzcce, false);
    zzb.zza(paramParcel, 11, zzbnw);
    zzb.zzc(paramParcel, 12, orientation);
    zzb.zza(paramParcel, 13, zzccf, false);
    zzb.zza(paramParcel, 14, zzccg);
    zzb.zza(paramParcel, 15, zzcch, false);
    zzb.zza(paramParcel, 18, zzcci);
    zzb.zza(paramParcel, 19, zzccj, false);
    zzb.zza(paramParcel, 21, zzcck, false);
    zzb.zza(paramParcel, 22, zzccl);
    zzb.zza(paramParcel, 23, zzaus);
    zzb.zza(paramParcel, 24, zzcbd);
    zzb.zza(paramParcel, 25, zzccm);
    zzb.zza(paramParcel, 26, zzccn);
    zzb.zza(paramParcel, 28, zzcco, paramInt, false);
    zzb.zza(paramParcel, 29, zzccp, false);
    zzb.zza(paramParcel, 30, zzccq, false);
    zzb.zza(paramParcel, 31, zzaut);
    zzb.zza(paramParcel, 32, zzauu);
    zzb.zza(paramParcel, 33, zzccr, paramInt, false);
    zzb.zzb(paramParcel, 34, zzccs, false);
    zzb.zzb(paramParcel, 35, zzcct, false);
    zzb.zza(paramParcel, 36, zzccu);
    zzb.zza(paramParcel, 37, zzccv, paramInt, false);
    zzb.zza(paramParcel, 38, zzcbu);
    zzb.zza(paramParcel, 39, zzcbv, false);
    zzb.zzb(paramParcel, 40, zzbnt, false);
    zzb.zza(paramParcel, 41, zzccw, false);
    zzb.zza(paramParcel, 42, zzbnu);
    zzb.zza(paramParcel, 43, zzccx, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public AdResponseParcel[] zzap(int paramInt)
  {
    return new AdResponseParcel[paramInt];
  }
  
  public AdResponseParcel zzl(Parcel paramParcel)
  {
    int m = zza.zzcl(paramParcel);
    int k = 0;
    String str11 = null;
    String str10 = null;
    ArrayList localArrayList6 = null;
    int j = 0;
    ArrayList localArrayList5 = null;
    long l4 = 0L;
    boolean bool12 = false;
    long l3 = 0L;
    ArrayList localArrayList4 = null;
    long l2 = 0L;
    int i = 0;
    String str9 = null;
    long l1 = 0L;
    String str8 = null;
    boolean bool11 = false;
    String str7 = null;
    String str6 = null;
    boolean bool10 = false;
    boolean bool9 = false;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool6 = false;
    LargeParcelTeleporter localLargeParcelTeleporter = null;
    String str5 = null;
    String str4 = null;
    boolean bool5 = false;
    boolean bool4 = false;
    RewardItemParcel localRewardItemParcel = null;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    boolean bool3 = false;
    AutoClickProtectionConfigurationParcel localAutoClickProtectionConfigurationParcel = null;
    boolean bool2 = false;
    String str3 = null;
    ArrayList localArrayList1 = null;
    String str2 = null;
    boolean bool1 = false;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzck(paramParcel);
      switch (zza.zzgi(n))
      {
      case 16: 
      case 17: 
      case 20: 
      case 27: 
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str11 = zza.zzq(paramParcel, n);
        break;
      case 3: 
        str10 = zza.zzq(paramParcel, n);
        break;
      case 4: 
        localArrayList6 = zza.zzae(paramParcel, n);
        break;
      case 5: 
        j = zza.zzg(paramParcel, n);
        break;
      case 6: 
        localArrayList5 = zza.zzae(paramParcel, n);
        break;
      case 7: 
        l4 = zza.zzi(paramParcel, n);
        break;
      case 8: 
        bool12 = zza.zzc(paramParcel, n);
        break;
      case 9: 
        l3 = zza.zzi(paramParcel, n);
        break;
      case 10: 
        localArrayList4 = zza.zzae(paramParcel, n);
        break;
      case 11: 
        l2 = zza.zzi(paramParcel, n);
        break;
      case 12: 
        i = zza.zzg(paramParcel, n);
        break;
      case 13: 
        str9 = zza.zzq(paramParcel, n);
        break;
      case 14: 
        l1 = zza.zzi(paramParcel, n);
        break;
      case 15: 
        str8 = zza.zzq(paramParcel, n);
        break;
      case 18: 
        bool11 = zza.zzc(paramParcel, n);
        break;
      case 19: 
        str7 = zza.zzq(paramParcel, n);
        break;
      case 21: 
        str6 = zza.zzq(paramParcel, n);
        break;
      case 22: 
        bool10 = zza.zzc(paramParcel, n);
        break;
      case 23: 
        bool9 = zza.zzc(paramParcel, n);
        break;
      case 24: 
        bool8 = zza.zzc(paramParcel, n);
        break;
      case 25: 
        bool7 = zza.zzc(paramParcel, n);
        break;
      case 26: 
        bool6 = zza.zzc(paramParcel, n);
        break;
      case 28: 
        localLargeParcelTeleporter = (LargeParcelTeleporter)zza.zza(paramParcel, n, LargeParcelTeleporter.CREATOR);
        break;
      case 29: 
        str5 = zza.zzq(paramParcel, n);
        break;
      case 30: 
        str4 = zza.zzq(paramParcel, n);
        break;
      case 31: 
        bool5 = zza.zzc(paramParcel, n);
        break;
      case 32: 
        bool4 = zza.zzc(paramParcel, n);
        break;
      case 33: 
        localRewardItemParcel = (RewardItemParcel)zza.zza(paramParcel, n, RewardItemParcel.CREATOR);
        break;
      case 34: 
        localArrayList3 = zza.zzae(paramParcel, n);
        break;
      case 35: 
        localArrayList2 = zza.zzae(paramParcel, n);
        break;
      case 36: 
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 37: 
        localAutoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel)zza.zza(paramParcel, n, AutoClickProtectionConfigurationParcel.CREATOR);
        break;
      case 38: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 39: 
        str3 = zza.zzq(paramParcel, n);
        break;
      case 40: 
        localArrayList1 = zza.zzae(paramParcel, n);
        break;
      case 41: 
        str2 = zza.zzq(paramParcel, n);
        break;
      case 42: 
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 43: 
        str1 = zza.zzq(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza(37 + "Overread allowed size end=" + m, paramParcel);
    }
    return new AdResponseParcel(k, str11, str10, localArrayList6, j, localArrayList5, l4, bool12, l3, localArrayList4, l2, i, str9, l1, str8, bool11, str7, str6, bool10, bool9, bool8, bool7, bool6, localLargeParcelTeleporter, str5, str4, bool5, bool4, localRewardItemParcel, localArrayList3, localArrayList2, bool3, localAutoClickProtectionConfigurationParcel, bool2, str3, localArrayList1, str2, bool1, str1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */