package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;

public class zzb
  extends zzd<zze>
{
  public zzb(Context paramContext, Looper paramLooper, zzd.zzb paramzzb, zzd.zzc paramzzc)
  {
    super(paramContext, paramLooper, 116, paramzzb, paramzzc, null);
  }
  
  protected zze zzgk(IBinder paramIBinder)
  {
    return zze.zza.zzgl(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.gass.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.gass.internal.IGassService";
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gass.internal.zzb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */