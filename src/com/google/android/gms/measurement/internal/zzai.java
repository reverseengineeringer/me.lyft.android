package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

public class zzai
  extends zzaa
{
  private boolean zzczn;
  private final AlarmManager zzczo = (AlarmManager)getContext().getSystemService("alarm");
  
  protected zzai(zzx paramzzx)
  {
    super(paramzzx);
  }
  
  private PendingIntent zzacn()
  {
    Intent localIntent = new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementReceiver");
    localIntent.setAction("com.google.android.gms.measurement.UPLOAD");
    return PendingIntent.getBroadcast(getContext(), 0, localIntent, 0);
  }
  
  public void cancel()
  {
    zzzg();
    zzczn = false;
    zzczo.cancel(zzacn());
  }
  
  public void zzv(long paramLong)
  {
    zzzg();
    if (paramLong > 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zzbn(bool);
      zzab.zza(zzu.zzav(getContext()), "Receiver not registered/enabled");
      zzab.zza(zzae.zzaw(getContext()), "Service not registered/enabled");
      cancel();
      long l = zzyw().elapsedRealtime();
      zzczn = true;
      zzczo.setInexactRepeating(2, l + paramLong, Math.max(zzbtb().zzbsk(), paramLong), zzacn());
      return;
    }
  }
  
  protected void zzwv()
  {
    zzczo.cancel(zzacn());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */