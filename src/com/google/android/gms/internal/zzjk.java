package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;

@zzir
public class zzjk
  extends zzkg
  implements zzjl, zzjo
{
  private final Context mContext;
  private final Object zzail;
  private final String zzbog;
  private final zzjy.zza zzbxv;
  private int zzbym = 3;
  private final zzjq zzchq;
  private final zzjo zzchr;
  private final String zzchs;
  private final String zzcht;
  private int zzchu = 0;
  
  public zzjk(Context paramContext, String paramString1, String paramString2, String paramString3, zzjy.zza paramzza, zzjq paramzzjq, zzjo paramzzjo)
  {
    mContext = paramContext;
    zzbog = paramString1;
    zzchs = paramString2;
    zzcht = paramString3;
    zzbxv = paramzza;
    zzchq = paramzzjq;
    zzail = new Object();
    zzchr = paramzzjo;
  }
  
  private void zza(AdRequestParcel paramAdRequestParcel, zzgo paramzzgo)
  {
    try
    {
      if ("com.google.ads.mediation.admob.AdMobAdapter".equals(zzbog))
      {
        paramzzgo.zza(paramAdRequestParcel, zzchs, zzcht);
        return;
      }
      paramzzgo.zzc(paramAdRequestParcel, zzchs);
      return;
    }
    catch (RemoteException paramAdRequestParcel)
    {
      zzkh.zzd("Fail to load ad from adapter.", paramAdRequestParcel);
      zza(zzbog, 0);
    }
  }
  
  private void zzk(long paramLong)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzchu != 0) {
          return;
        }
        if (!zzf(paramLong)) {
          return;
        }
      }
    }
  }
  
  public void onStop() {}
  
  public void zza(String arg1, int paramInt)
  {
    synchronized (zzail)
    {
      zzchu = 2;
      zzbym = paramInt;
      zzail.notify();
      return;
    }
  }
  
  public void zzaw(int paramInt)
  {
    zza(zzbog, 0);
  }
  
  public void zzch(String arg1)
  {
    synchronized (zzail)
    {
      zzchu = 1;
      zzail.notify();
      return;
    }
  }
  
  public void zzew()
  {
    if ((zzchq == null) || (zzchq.zzrw() == null) || (zzchq.zzrv() == null)) {
      return;
    }
    final zzjn localzzjn = zzchq.zzrw();
    localzzjn.zza(this);
    localzzjn.zza(this);
    final AdRequestParcel localAdRequestParcel = zzbxv.zzcit.zzcav;
    final zzgo localzzgo = zzchq.zzrv();
    try
    {
      if (localzzgo.isInitialized()) {
        zza.zzcnf.post(new Runnable()
        {
          public void run()
          {
            zzjk.zza(zzjk.this, localAdRequestParcel, localzzgo);
          }
        });
      }
      for (;;)
      {
        zzk(zzu.zzfu().elapsedRealtime());
        localzzjn.zza(null);
        localzzjn.zza(null);
        if (zzchu != 1) {
          break;
        }
        zzchr.zzch(zzbog);
        return;
        zza.zzcnf.post(new Runnable()
        {
          public void run()
          {
            try
            {
              localzzgo.zza(com.google.android.gms.dynamic.zze.zzae(zzjk.zza(zzjk.this)), localAdRequestParcel, null, localzzjn, zzjk.zzb(zzjk.this));
              return;
            }
            catch (RemoteException localRemoteException)
            {
              str = String.valueOf(zzjk.zzc(zzjk.this));
              if (str.length() == 0) {}
            }
            for (String str = "Fail to initialize adapter ".concat(str);; str = new String("Fail to initialize adapter "))
            {
              zzkh.zzd(str, localRemoteException);
              zza(zzjk.zzc(zzjk.this), 0);
              return;
            }
          }
        });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        zzkh.zzd("Fail to check if adapter is initialized.", localRemoteException);
        zza(zzbog, 0);
      }
      zzchr.zza(zzbog, zzbym);
    }
  }
  
  protected boolean zzf(long paramLong)
  {
    paramLong = 20000L - (zzu.zzfu().elapsedRealtime() - paramLong);
    if (paramLong <= 0L) {
      return false;
    }
    try
    {
      zzail.wait(paramLong);
      return true;
    }
    catch (InterruptedException localInterruptedException) {}
    return false;
  }
  
  public void zzrt()
  {
    zza(zzbxv.zzcit.zzcav, zzchq.zzrv());
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */