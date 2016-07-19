package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvz;

public final class zzu
{
  static final Object zzamp = new Object();
  static zzvz zzcrz;
  static Boolean zzcsa;
  
  public static boolean zzav(Context paramContext)
  {
    zzab.zzaa(paramContext);
    if (zzcsa != null) {
      return zzcsa.booleanValue();
    }
    boolean bool = zzal.zzb(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
    zzcsa = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzx.zzdo(paramContext);
    localzzp = ((zzx)localObject).zzbsz();
    if (??? == null) {
      localzzp.zzbtt().log("AppMeasurementReceiver called with null intent");
    }
    for (;;)
    {
      return;
      ??? = ???.getAction();
      if (((zzx)localObject).zzbtb().zzabc()) {
        localzzp.zzbty().zzj("Device AppMeasurementReceiver got", ???);
      }
      while ("com.google.android.gms.measurement.UPLOAD".equals(???))
      {
        boolean bool = zzae.zzaw(paramContext);
        localObject = new Intent().setClassName(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
        ((Intent)localObject).setAction("com.google.android.gms.measurement.UPLOAD");
        synchronized (zzamp)
        {
          paramContext.startService((Intent)localObject);
          if (bool) {
            break label131;
          }
          return;
        }
        localzzp.zzbty().zzj("Local AppMeasurementReceiver got", ???);
      }
    }
    try
    {
      label131:
      if (zzcrz == null)
      {
        zzcrz = new zzvz(paramContext, 1, "AppMeasurement WakeLock");
        zzcrz.setReferenceCounted(false);
      }
      zzcrz.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzzp.zzbtt().log("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */