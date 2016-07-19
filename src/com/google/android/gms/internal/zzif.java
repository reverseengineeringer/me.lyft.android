package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;

@zzir
public abstract class zzif
  extends zzkg
{
  protected final Context mContext;
  protected final Object zzail = new Object();
  protected final zzig.zza zzbxu;
  protected final zzjy.zza zzbxv;
  protected AdResponseParcel zzbxw;
  protected final Object zzbxy = new Object();
  
  protected zzif(Context paramContext, zzjy.zza paramzza, zzig.zza paramzza1)
  {
    super(true);
    mContext = paramContext;
    zzbxv = paramzza;
    zzbxw = zzciu;
    zzbxu = paramzza1;
  }
  
  public void onStop() {}
  
  protected abstract zzjy zzak(int paramInt);
  
  public void zzew()
  {
    for (;;)
    {
      int i;
      synchronized (zzail)
      {
        zzkh.zzcw("AdRendererBackgroundTask started.");
        i = zzbxv.errorCode;
        try
        {
          zzh(SystemClock.elapsedRealtime());
          final zzjy localzzjy = zzak(i);
          zzkl.zzclg.post(new Runnable()
          {
            public void run()
            {
              synchronized (zzail)
              {
                zzm(localzzjy);
                return;
              }
            }
          });
          return;
        }
        catch (zza localzza)
        {
          i = localzza.getErrorCode();
          if (i == 3) {
            continue;
          }
        }
        if (i == -1)
        {
          zzkh.zzcx(localzza.getMessage());
          if (zzbxw == null)
          {
            zzbxw = new AdResponseParcel(i);
            zzkl.zzclg.post(new Runnable()
            {
              public void run()
              {
                onStop();
              }
            });
          }
        }
        else
        {
          zzkh.zzcy(localzza.getMessage());
        }
      }
      zzbxw = new AdResponseParcel(i, zzbxw.zzbnw);
    }
  }
  
  protected abstract void zzh(long paramLong)
    throws zzif.zza;
  
  protected void zzm(zzjy paramzzjy)
  {
    zzbxu.zzb(paramzzjy);
  }
  
  protected static final class zza
    extends Exception
  {
    private final int zzbym;
    
    public zza(String paramString, int paramInt)
    {
      super();
      zzbym = paramInt;
    }
    
    public int getErrorCode()
    {
      return zzbym;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */