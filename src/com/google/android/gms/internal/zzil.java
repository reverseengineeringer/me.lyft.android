package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzir
public class zzil
{
  private static final Object zzamp = new Object();
  private static final long zzbyx = TimeUnit.SECONDS.toMillis(60L);
  private static boolean zzbyy = false;
  private static zzfw zzbyz = null;
  private final Context mContext;
  private final zzq zzbgb;
  private final zzas zzbgh;
  private final zzjy.zza zzbxv;
  private zzfu zzbza;
  private zzfw.zze zzbzb;
  private zzft zzbzc;
  private boolean zzbzd = false;
  
  public zzil(Context paramContext, zzjy.zza paramzza, zzq paramzzq, zzas paramzzas)
  {
    mContext = paramContext;
    zzbxv = paramzza;
    zzbgb = paramzzq;
    zzbgh = paramzzas;
    zzbzd = ((Boolean)zzdc.zzbcd.get()).booleanValue();
  }
  
  private String zzd(zzjy.zza paramzza)
  {
    String str = (String)zzdc.zzbaa.get();
    if (zzciu.zzbts.indexOf("https") == 0) {}
    for (paramzza = "https:";; paramzza = "http:")
    {
      paramzza = String.valueOf(paramzza);
      str = String.valueOf(str);
      if (str.length() == 0) {
        break;
      }
      return paramzza.concat(str);
    }
    return new String(paramzza);
  }
  
  private void zzqj()
  {
    synchronized (zzamp)
    {
      if (!zzbyy)
      {
        if (mContext.getApplicationContext() != null)
        {
          localContext = mContext.getApplicationContext();
          zzbyz = new zzfw(localContext, zzbxv.zzcit.zzaou, zzd(zzbxv), new zzkp()new zzfw.zzb
          {
            public void zza(zzft paramAnonymouszzft)
            {
              paramAnonymouszzft.zza(zzil.zza(zzil.this), zzil.zza(zzil.this), zzil.zza(zzil.this), zzil.zza(zzil.this), false, null, null, null, null);
            }
          }, new zzfw.zzb());
          zzbyy = true;
        }
      }
      else {
        return;
      }
      Context localContext = mContext;
    }
  }
  
  private void zzqk()
  {
    zzbzb = new zzfw.zze(zzqp().zzc(zzbgh));
  }
  
  private void zzql()
  {
    zzbza = new zzfu();
  }
  
  private void zzqm()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    zzbzc = ((zzft)zzqn().zza(mContext, zzbxv.zzcit.zzaou, zzd(zzbxv), zzbgh).get(zzbyx, TimeUnit.MILLISECONDS));
    zzbzc.zza(zzbgb, zzbgb, zzbgb, zzbgb, false, null, null, null, null);
  }
  
  public void zza(final zza paramzza)
  {
    if (zzbzd)
    {
      localObject = zzqq();
      if (localObject == null)
      {
        zzkh.zzcy("SharedJavascriptEngine not initialized");
        return;
      }
      ((zzfw.zze)localObject).zza(new zzle.zzc()new zzle.zza
      {
        public void zzb(zzfx paramAnonymouszzfx)
        {
          paramzza.zze(paramAnonymouszzfx);
        }
      }, new zzle.zza()
      {
        public void run()
        {
          paramzza.zzqr();
        }
      });
      return;
    }
    Object localObject = zzqo();
    if (localObject == null)
    {
      zzkh.zzcy("JavascriptEngine not initialized");
      return;
    }
    paramzza.zze((zzfx)localObject);
  }
  
  public void zzqh()
  {
    if (zzbzd)
    {
      zzqj();
      return;
    }
    zzql();
  }
  
  public void zzqi()
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    if (zzbzd)
    {
      zzqk();
      return;
    }
    zzqm();
  }
  
  protected zzfu zzqn()
  {
    return zzbza;
  }
  
  protected zzft zzqo()
  {
    return zzbzc;
  }
  
  protected zzfw zzqp()
  {
    return zzbyz;
  }
  
  protected zzfw.zze zzqq()
  {
    return zzbzb;
  }
  
  public static abstract class zza
  {
    public abstract void zze(zzfx paramzzfx);
    
    public void zzqr() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */