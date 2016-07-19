package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvz;

public final class zzae
{
  private static Boolean zzcsb;
  private final zza anz;
  private final Context mContext;
  private final Handler mHandler;
  
  public zzae(zza paramzza)
  {
    mContext = paramzza.getContext();
    zzab.zzaa(mContext);
    anz = paramzza;
    mHandler = new Handler();
  }
  
  public static boolean zzaw(Context paramContext)
  {
    zzab.zzaa(paramContext);
    if (zzcsb != null) {
      return zzcsb.booleanValue();
    }
    boolean bool = zzal.zzk(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
    zzcsb = Boolean.valueOf(bool);
    return bool;
  }
  
  private zzp zzbsz()
  {
    return zzx.zzdo(mContext).zzbsz();
  }
  
  private void zzvw()
  {
    try
    {
      synchronized (zzu.zzamp)
      {
        zzvz localzzvz = zzu.zzcrz;
        if ((localzzvz != null) && (localzzvz.isHeld())) {
          localzzvz.release();
        }
        return;
      }
      return;
    }
    catch (SecurityException localSecurityException) {}
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzbsz().zzbtr().log("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzy(zzx.zzdo(mContext));
    }
    zzbsz().zzbtt().zzj("onBind received unknown action", paramIntent);
    return null;
  }
  
  public void onCreate()
  {
    zzx localzzx = zzx.zzdo(mContext);
    zzp localzzp = localzzx.zzbsz();
    if (localzzx.zzbtb().zzabc())
    {
      localzzp.zzbty().log("Device AppMeasurementService is starting up");
      return;
    }
    localzzp.zzbty().log("Local AppMeasurementService is starting up");
  }
  
  public void onDestroy()
  {
    zzx localzzx = zzx.zzdo(mContext);
    zzp localzzp = localzzx.zzbsz();
    if (localzzx.zzbtb().zzabc())
    {
      localzzp.zzbty().log("Device AppMeasurementService is shutting down");
      return;
    }
    localzzp.zzbty().log("Local AppMeasurementService is shutting down");
  }
  
  public void onRebind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzbsz().zzbtr().log("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzbsz().zzbty().zzj("onRebind called. action", paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, final int paramInt2)
  {
    zzvw();
    final zzx localzzx = zzx.zzdo(mContext);
    final zzp localzzp = localzzx.zzbsz();
    if (paramIntent == null) {
      localzzp.zzbtt().log("AppMeasurementService started with null intent");
    }
    for (;;)
    {
      return 2;
      paramIntent = paramIntent.getAction();
      if (localzzx.zzbtb().zzabc()) {
        localzzp.zzbty().zze("Device AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
      }
      while ("com.google.android.gms.measurement.UPLOAD".equals(paramIntent))
      {
        localzzx.zzbsy().zzl(new Runnable()
        {
          public void run()
          {
            localzzx.zzbvd();
            localzzx.zzbuy();
            zzae.zzb(zzae.this).post(new Runnable()
            {
              public void run()
              {
                if (zzae.zza(zzae.this).callServiceStopSelfResult(zzcsd))
                {
                  if (anA.zzbtb().zzabc()) {
                    anB.zzbty().log("Device AppMeasurementService processed last upload request");
                  }
                }
                else {
                  return;
                }
                anB.zzbty().log("Local AppMeasurementService processed last upload request");
              }
            });
          }
        });
        return 2;
        localzzp.zzbty().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), paramIntent);
      }
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzbsz().zzbtr().log("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzbsz().zzbty().zzj("onUnbind called for intent. action", paramIntent);
    return true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean callServiceStopSelfResult(int paramInt);
    
    public abstract Context getContext();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */