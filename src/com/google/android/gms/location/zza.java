package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<ActivityRecognitionRequest>
{
  static void zza(ActivityRecognitionRequest paramActivityRecognitionRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zza(paramParcel, 1, paramActivityRecognitionRequest.getIntervalMillis());
    zzb.zza(paramParcel, 2, paramActivityRecognitionRequest.zzbnb());
    zzb.zza(paramParcel, 3, paramActivityRecognitionRequest.zzbnc(), paramInt, false);
    zzb.zza(paramParcel, 4, paramActivityRecognitionRequest.getTag(), false);
    zzb.zza(paramParcel, 5, paramActivityRecognitionRequest.zzbnd(), false);
    zzb.zza(paramParcel, 6, paramActivityRecognitionRequest.zzbne());
    zzb.zza(paramParcel, 7, paramActivityRecognitionRequest.getAccountName(), false);
    zzb.zzc(paramParcel, 1000, paramActivityRecognitionRequest.getVersionCode());
    zzb.zzaj(paramParcel, i);
  }
  
  public ActivityRecognitionRequest zzmo(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzcl(paramParcel);
    long l = 0L;
    int[] arrayOfInt = null;
    String str2 = null;
    WorkSource localWorkSource = null;
    boolean bool2 = false;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzck(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzgi(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
        break;
      case 2: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 3: 
        localWorkSource = (WorkSource)com.google.android.gms.common.internal.safeparcel.zza.zza(paramParcel, k, WorkSource.CREATOR);
        break;
      case 4: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 5: 
        arrayOfInt = com.google.android.gms.common.internal.safeparcel.zza.zzw(paramParcel, k);
        break;
      case 6: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 7: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new ActivityRecognitionRequest(i, l, bool2, localWorkSource, str2, arrayOfInt, bool1, str1);
  }
  
  public ActivityRecognitionRequest[] zzss(int paramInt)
  {
    return new ActivityRecognitionRequest[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */