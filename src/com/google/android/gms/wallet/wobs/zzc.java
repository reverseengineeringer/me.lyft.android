package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<LabelValueRow>
{
  static void zza(LabelValueRow paramLabelValueRow, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzcm(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramLabelValueRow.getVersionCode());
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, aIE, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, aIF, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 4, aIG, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzaj(paramParcel, paramInt);
  }
  
  public LabelValueRow[] zzaay(int paramInt)
  {
    return new LabelValueRow[paramInt];
  }
  
  public LabelValueRow zzsu(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    ArrayList localArrayList = com.google.android.gms.common.util.zzb.zzavf();
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
        str1 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, k, LabelValue.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LabelValueRow(i, str1, str2, localArrayList);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wallet.wobs.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */