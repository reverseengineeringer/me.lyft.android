package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<AncsNotificationParcelable>
{
  static void zza(AncsNotificationParcelable paramAncsNotificationParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, mVersionCode);
    zzb.zzc(paramParcel, 2, paramAncsNotificationParcelable.getId());
    zzb.zza(paramParcel, 3, paramAncsNotificationParcelable.zzsi(), false);
    zzb.zza(paramParcel, 4, paramAncsNotificationParcelable.zzciq(), false);
    zzb.zza(paramParcel, 5, paramAncsNotificationParcelable.zzcir(), false);
    zzb.zza(paramParcel, 6, paramAncsNotificationParcelable.getTitle(), false);
    zzb.zza(paramParcel, 7, paramAncsNotificationParcelable.zzbhi(), false);
    zzb.zza(paramParcel, 8, paramAncsNotificationParcelable.getDisplayName(), false);
    zzb.zza(paramParcel, 9, paramAncsNotificationParcelable.zzcis());
    zzb.zza(paramParcel, 10, paramAncsNotificationParcelable.zzcit());
    zzb.zza(paramParcel, 11, paramAncsNotificationParcelable.zzciu());
    zzb.zza(paramParcel, 12, paramAncsNotificationParcelable.zzciv());
    zzb.zza(paramParcel, 13, paramAncsNotificationParcelable.getPackageName(), false);
    zzb.zzaj(paramParcel, paramInt);
  }
  
  public AncsNotificationParcelable[] zzabl(int paramInt)
  {
    return new AncsNotificationParcelable[paramInt];
  }
  
  public AncsNotificationParcelable zzth(Parcel paramParcel)
  {
    int k = zza.zzcl(paramParcel);
    int j = 0;
    int i = 0;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    String str2 = null;
    byte b4 = 0;
    byte b3 = 0;
    byte b2 = 0;
    byte b1 = 0;
    String str1 = null;
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
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        str7 = zza.zzq(paramParcel, m);
        break;
      case 4: 
        str6 = zza.zzq(paramParcel, m);
        break;
      case 5: 
        str5 = zza.zzq(paramParcel, m);
        break;
      case 6: 
        str4 = zza.zzq(paramParcel, m);
        break;
      case 7: 
        str3 = zza.zzq(paramParcel, m);
        break;
      case 8: 
        str2 = zza.zzq(paramParcel, m);
        break;
      case 9: 
        b4 = zza.zze(paramParcel, m);
        break;
      case 10: 
        b3 = zza.zze(paramParcel, m);
        break;
      case 11: 
        b2 = zza.zze(paramParcel, m);
        break;
      case 12: 
        b1 = zza.zze(paramParcel, m);
        break;
      case 13: 
        str1 = zza.zzq(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza(37 + "Overread allowed size end=" + k, paramParcel);
    }
    return new AncsNotificationParcelable(j, i, str7, str6, str5, str4, str3, str2, b4, b3, b2, b1, str1);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.zzh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */