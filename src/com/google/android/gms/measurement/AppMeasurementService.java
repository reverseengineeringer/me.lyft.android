package com.google.android.gms.measurement;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzae.zza;

public final class AppMeasurementService
  extends Service
  implements zzae.zza
{
  private zzae ajf;
  
  private zzae zzbqm()
  {
    if (ajf == null) {
      ajf = new zzae(this);
    }
    return ajf;
  }
  
  public boolean callServiceStopSelfResult(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
  
  public Context getContext()
  {
    return this;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return zzbqm().onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    zzbqm().onCreate();
  }
  
  public void onDestroy()
  {
    zzbqm().onDestroy();
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    zzbqm().onRebind(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zzbqm().onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    return zzbqm().onUnbind(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.AppMeasurementService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */