package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;

public class zzo
  extends zzd<zzm>
{
  public zzo(Context paramContext, Looper paramLooper, zzd.zzb paramzzb, zzd.zzc paramzzc)
  {
    super(paramContext, paramLooper, 93, paramzzb, paramzzc, null);
  }
  
  public zzm zzjc(IBinder paramIBinder)
  {
    return zzm.zza.zzjb(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.measurement.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.measurement.internal.IMeasurementService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */