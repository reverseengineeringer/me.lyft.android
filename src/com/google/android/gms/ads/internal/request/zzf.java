package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<AdRequestInfoParcel>
{
  static void zza(AdRequestInfoParcel paramAdRequestInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, zzcau, false);
    zzb.zza(paramParcel, 3, zzcav, paramInt, false);
    zzb.zza(paramParcel, 4, zzaoy, paramInt, false);
    zzb.zza(paramParcel, 5, zzaos, false);
    zzb.zza(paramParcel, 6, applicationInfo, paramInt, false);
    zzb.zza(paramParcel, 7, zzcaw, paramInt, false);
    zzb.zza(paramParcel, 8, zzcax, false);
    zzb.zza(paramParcel, 9, zzcay, false);
    zzb.zza(paramParcel, 10, zzcaz, false);
    zzb.zza(paramParcel, 11, zzaou, paramInt, false);
    zzb.zza(paramParcel, 12, zzcba, false);
    zzb.zzc(paramParcel, 13, zzcbb);
    zzb.zzb(paramParcel, 14, zzapq, false);
    zzb.zza(paramParcel, 15, zzcbc, false);
    zzb.zza(paramParcel, 16, zzcbd);
    zzb.zza(paramParcel, 17, zzcbe, paramInt, false);
    zzb.zzc(paramParcel, 18, zzcbf);
    zzb.zzc(paramParcel, 19, zzcbg);
    zzb.zza(paramParcel, 20, zzcbh);
    zzb.zza(paramParcel, 21, zzcbi, false);
    zzb.zza(paramParcel, 25, zzcbj);
    zzb.zza(paramParcel, 26, zzcbk, false);
    zzb.zzb(paramParcel, 27, zzcbl, false);
    zzb.zza(paramParcel, 28, zzaor, false);
    zzb.zza(paramParcel, 29, zzapm, paramInt, false);
    zzb.zzb(paramParcel, 30, zzcbm, false);
    zzb.zza(paramParcel, 31, zzcbn);
    zzb.zza(paramParcel, 32, zzcbo, paramInt, false);
    zzb.zza(paramParcel, 33, zzcbp, false);
    zzb.zza(paramParcel, 34, zzcbq);
    zzb.zzc(paramParcel, 35, zzcbr);
    zzb.zzc(paramParcel, 36, zzcbs);
    zzb.zza(paramParcel, 37, zzcbt);
    zzb.zza(paramParcel, 38, zzcbu);
    zzb.zza(paramParcel, 39, zzcbv, false);
    zzb.zza(paramParcel, 40, zzcbw);
    zzb.zza(paramParcel, 41, zzcbx, false);
    zzb.zza(paramParcel, 42, zzbnu);
    zzb.zzc(paramParcel, 43, zzcby);
    zzb.zza(paramParcel, 44, zzcbz, false);
    zzb.zzaj(paramParcel, i);
  }
  
  public AdRequestInfoParcel[] zzao(int paramInt)
  {
    return new AdRequestInfoParcel[paramInt];
  }
  
  public AdRequestInfoParcel zzk(Parcel paramParcel)
  {
    int i3 = zza.zzcl(paramParcel);
    int i2 = 0;
    Bundle localBundle4 = null;
    AdRequestParcel localAdRequestParcel = null;
    AdSizeParcel localAdSizeParcel = null;
    String str10 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    Bundle localBundle3 = null;
    int i1 = 0;
    ArrayList localArrayList3 = null;
    Bundle localBundle2 = null;
    boolean bool5 = false;
    Messenger localMessenger = null;
    int n = 0;
    int m = 0;
    float f2 = 0.0F;
    String str6 = null;
    long l2 = 0L;
    String str5 = null;
    ArrayList localArrayList2 = null;
    String str4 = null;
    NativeAdOptionsParcel localNativeAdOptionsParcel = null;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    CapabilityParcel localCapabilityParcel = null;
    String str3 = null;
    float f1 = 0.0F;
    boolean bool4 = false;
    int k = 0;
    int j = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    int i = 0;
    Bundle localBundle1 = null;
    while (paramParcel.dataPosition() < i3)
    {
      int i4 = zza.zzck(paramParcel);
      switch (zza.zzgi(i4))
      {
      case 22: 
      case 23: 
      case 24: 
      default: 
        zza.zzb(paramParcel, i4);
        break;
      case 1: 
        i2 = zza.zzg(paramParcel, i4);
        break;
      case 2: 
        localBundle4 = zza.zzs(paramParcel, i4);
        break;
      case 3: 
        localAdRequestParcel = (AdRequestParcel)zza.zza(paramParcel, i4, AdRequestParcel.CREATOR);
        break;
      case 4: 
        localAdSizeParcel = (AdSizeParcel)zza.zza(paramParcel, i4, AdSizeParcel.CREATOR);
        break;
      case 5: 
        str10 = zza.zzq(paramParcel, i4);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)zza.zza(paramParcel, i4, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)zza.zza(paramParcel, i4, PackageInfo.CREATOR);
        break;
      case 8: 
        str9 = zza.zzq(paramParcel, i4);
        break;
      case 9: 
        str8 = zza.zzq(paramParcel, i4);
        break;
      case 10: 
        str7 = zza.zzq(paramParcel, i4);
        break;
      case 11: 
        localVersionInfoParcel = (VersionInfoParcel)zza.zza(paramParcel, i4, VersionInfoParcel.CREATOR);
        break;
      case 12: 
        localBundle3 = zza.zzs(paramParcel, i4);
        break;
      case 13: 
        i1 = zza.zzg(paramParcel, i4);
        break;
      case 14: 
        localArrayList3 = zza.zzae(paramParcel, i4);
        break;
      case 15: 
        localBundle2 = zza.zzs(paramParcel, i4);
        break;
      case 16: 
        bool5 = zza.zzc(paramParcel, i4);
        break;
      case 17: 
        localMessenger = (Messenger)zza.zza(paramParcel, i4, Messenger.CREATOR);
        break;
      case 18: 
        n = zza.zzg(paramParcel, i4);
        break;
      case 19: 
        m = zza.zzg(paramParcel, i4);
        break;
      case 20: 
        f2 = zza.zzl(paramParcel, i4);
        break;
      case 21: 
        str6 = zza.zzq(paramParcel, i4);
        break;
      case 25: 
        l2 = zza.zzi(paramParcel, i4);
        break;
      case 26: 
        str5 = zza.zzq(paramParcel, i4);
        break;
      case 27: 
        localArrayList2 = zza.zzae(paramParcel, i4);
        break;
      case 28: 
        str4 = zza.zzq(paramParcel, i4);
        break;
      case 29: 
        localNativeAdOptionsParcel = (NativeAdOptionsParcel)zza.zza(paramParcel, i4, NativeAdOptionsParcel.CREATOR);
        break;
      case 30: 
        localArrayList1 = zza.zzae(paramParcel, i4);
        break;
      case 31: 
        l1 = zza.zzi(paramParcel, i4);
        break;
      case 32: 
        localCapabilityParcel = (CapabilityParcel)zza.zza(paramParcel, i4, CapabilityParcel.CREATOR);
        break;
      case 33: 
        str3 = zza.zzq(paramParcel, i4);
        break;
      case 34: 
        f1 = zza.zzl(paramParcel, i4);
        break;
      case 35: 
        k = zza.zzg(paramParcel, i4);
        break;
      case 36: 
        j = zza.zzg(paramParcel, i4);
        break;
      case 37: 
        bool3 = zza.zzc(paramParcel, i4);
        break;
      case 38: 
        bool2 = zza.zzc(paramParcel, i4);
        break;
      case 39: 
        str2 = zza.zzq(paramParcel, i4);
        break;
      case 40: 
        bool4 = zza.zzc(paramParcel, i4);
        break;
      case 41: 
        str1 = zza.zzq(paramParcel, i4);
        break;
      case 42: 
        bool1 = zza.zzc(paramParcel, i4);
        break;
      case 43: 
        i = zza.zzg(paramParcel, i4);
        break;
      case 44: 
        localBundle1 = zza.zzs(paramParcel, i4);
      }
    }
    if (paramParcel.dataPosition() != i3) {
      throw new zza.zza(37 + "Overread allowed size end=" + i3, paramParcel);
    }
    return new AdRequestInfoParcel(i2, localBundle4, localAdRequestParcel, localAdSizeParcel, str10, localApplicationInfo, localPackageInfo, str9, str8, str7, localVersionInfoParcel, localBundle3, i1, localArrayList3, localBundle2, bool5, localMessenger, n, m, f2, str6, l2, str5, localArrayList2, str4, localNativeAdOptionsParcel, localArrayList1, l1, localCapabilityParcel, str3, f1, bool4, k, j, bool3, bool2, str2, str1, bool1, i, localBundle1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zzf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */