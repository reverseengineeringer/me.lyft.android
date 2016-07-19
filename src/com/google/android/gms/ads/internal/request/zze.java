package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.internal.zzir;

@zzir
public class zze
  extends zzd<zzk>
{
  final int zzcat;
  
  public zze(Context paramContext, Looper paramLooper, zzd.zzb paramzzb, zzd.zzc paramzzc, int paramInt)
  {
    super(paramContext, paramLooper, 8, paramzzb, paramzzc, null);
    zzcat = paramInt;
  }
  
  protected zzk zzba(IBinder paramIBinder)
  {
    return zzk.zza.zzbc(paramIBinder);
  }
  
  protected String zzra()
  {
    return "com.google.android.gms.ads.service.START";
  }
  
  protected String zzrb()
  {
    return "com.google.android.gms.ads.internal.request.IAdRequestService";
  }
  
  public zzk zzrc()
    throws DeadObjectException
  {
    return (zzk)super.zzarw();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.request.zze
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */