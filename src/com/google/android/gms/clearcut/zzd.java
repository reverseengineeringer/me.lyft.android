package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd
  implements Parcelable.Creator<LogEventParcelable>
{
  static void zza(LogEventParcelable paramLogEventParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzcm(paramParcel);
    zzb.zzc(paramParcel, 1, versionCode);
    zzb.zza(paramParcel, 2, qk, paramInt, false);
    zzb.zza(paramParcel, 3, ql, false);
    zzb.zza(paramParcel, 4, qm, false);
    zzb.zza(paramParcel, 5, qn, false);
    zzb.zza(paramParcel, 6, qo, false);
    zzb.zza(paramParcel, 7, qp, false);
    zzb.zza(paramParcel, 8, qq);
    zzb.zzaj(paramParcel, i);
  }
  
  public LogEventParcelable zzbw(Parcel paramParcel)
  {
    byte[][] arrayOfByte = null;
    int j = zza.zzcl(paramParcel);
    int i = 0;
    boolean bool = true;
    int[] arrayOfInt1 = null;
    String[] arrayOfString = null;
    int[] arrayOfInt2 = null;
    byte[] arrayOfByte1 = null;
    PlayLoggerContext localPlayLoggerContext = null;
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
        localPlayLoggerContext = (PlayLoggerContext)zza.zza(paramParcel, k, PlayLoggerContext.CREATOR);
        break;
      case 3: 
        arrayOfByte1 = zza.zzt(paramParcel, k);
        break;
      case 4: 
        arrayOfInt2 = zza.zzw(paramParcel, k);
        break;
      case 5: 
        arrayOfString = zza.zzac(paramParcel, k);
        break;
      case 6: 
        arrayOfInt1 = zza.zzw(paramParcel, k);
        break;
      case 7: 
        arrayOfByte = zza.zzu(paramParcel, k);
        break;
      case 8: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza(37 + "Overread allowed size end=" + j, paramParcel);
    }
    return new LogEventParcelable(i, localPlayLoggerContext, arrayOfByte1, arrayOfInt2, arrayOfString, arrayOfInt1, arrayOfByte, bool);
  }
  
  public LogEventParcelable[] zzey(int paramInt)
  {
    return new LogEventParcelable[paramInt];
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.clearcut.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */