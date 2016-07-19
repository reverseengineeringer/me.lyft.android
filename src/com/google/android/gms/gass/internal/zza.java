package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.internal.zzae.zza;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class zza
{
  public static zzae.zza zzf(Context paramContext, String paramString1, String paramString2)
  {
    return new zza(paramContext, paramString1, paramString2).zzcm();
  }
  
  private static class zza
    implements zzd.zzb, zzd.zzc
  {
    protected final zzb aar;
    private final String aas;
    private final LinkedBlockingQueue<zzae.zza> aat;
    private final HandlerThread aau;
    private final String packageName;
    
    public zza(Context paramContext, String paramString1, String paramString2)
    {
      packageName = paramString1;
      aas = paramString2;
      aau = new HandlerThread("GassClient");
      aau.start();
      aar = new zzb(paramContext, aau.getLooper(), this, this);
      aat = new LinkedBlockingQueue();
      connect();
    }
    
    protected void connect()
    {
      aar.zzart();
    }
    
    public void onConnected(Bundle paramBundle)
    {
      paramBundle = zzbly();
      if (paramBundle != null) {}
      try
      {
        paramBundle = paramBundle.zza(new GassRequestParcel(packageName, aas)).zzbma();
        aat.put(paramBundle);
        zzqx();
        aau.quit();
        return;
      }
      catch (Throwable paramBundle)
      {
        paramBundle = paramBundle;
        zzqx();
        aau.quit();
        return;
      }
      finally
      {
        paramBundle = finally;
        zzqx();
        aau.quit();
        throw paramBundle;
      }
    }
    
    public void onConnectionFailed(ConnectionResult paramConnectionResult) {}
    
    public void onConnectionSuspended(int paramInt) {}
    
    protected zze zzbly()
    {
      try
      {
        zze localzze = (zze)aar.zzarw();
        return localzze;
      }
      catch (DeadObjectException localDeadObjectException) {}
      return null;
    }
    
    public zzae.zza zzcm()
    {
      return zzse(2000);
    }
    
    public void zzqx()
    {
      if (aar != null) {
        aar.disconnect();
      }
    }
    
    public zzae.zza zzse(int paramInt)
    {
      try
      {
        zzae.zza localzza1 = (zzae.zza)aat.poll(paramInt, TimeUnit.MILLISECONDS);
        zzae.zza localzza2 = localzza1;
        if (localzza1 == null) {
          localzza2 = new zzae.zza();
        }
        return localzza2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.gass.internal.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */