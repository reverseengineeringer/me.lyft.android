package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;
import java.util.Map;

@zzir
public class zzfw
{
  private final Context mContext;
  private final Object zzail = new Object();
  private final VersionInfoParcel zzalm;
  private final String zzblv;
  private zzkp<zzft> zzblw;
  private zzkp<zzft> zzblx;
  private zzd zzbly;
  private int zzblz = 1;
  
  public zzfw(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString)
  {
    zzblv = paramString;
    mContext = paramContext.getApplicationContext();
    zzalm = paramVersionInfoParcel;
    zzblw = new zzb();
    zzblx = new zzb();
  }
  
  public zzfw(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzkp<zzft> paramzzkp1, zzkp<zzft> paramzzkp2)
  {
    this(paramContext, paramVersionInfoParcel, paramString);
    zzblw = paramzzkp1;
    zzblx = paramzzkp2;
  }
  
  private zzd zza(final zzas paramzzas)
  {
    final zzd localzzd = new zzd(zzblx);
    zzu.zzfq().runOnUiThread(new Runnable()
    {
      public void run()
      {
        final zzft localzzft = zza(zzfw.zza(zzfw.this), zzfw.zzb(zzfw.this), paramzzas);
        localzzft.zza(new zzft.zza()
        {
          public void zzmb()
          {
            zzkl.zzclg.postDelayed(new Runnable()
            {
              public void run()
              {
                synchronized (zzfw.zzc(zzfw.this))
                {
                  if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
                    return;
                  }
                  zzbmb.reject();
                  zzu.zzfq().runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzbmd.destroy();
                    }
                  });
                  zzkh.v("Could not receive loaded message in a timely manner. Rejecting.");
                  return;
                }
              }
            }, zzfw.zza.zzbml);
          }
        });
        localzzft.zza("/jsLoaded", new zzet()
        {
          public void zza(zzll arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzfw.zzc(zzfw.this))
            {
              if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
                return;
              }
              zzfw.zza(zzfw.this, 0);
              zzfw.zzd(zzfw.this).zzd(localzzft);
              zzbmb.zzg(localzzft);
              zzfw.zza(zzfw.this, zzbmb);
              zzkh.v("Successfully loaded JS Engine.");
              return;
            }
          }
        });
        final zzkw localzzkw = new zzkw();
        zzet local3 = new zzet()
        {
          public void zza(zzll arg1, Map<String, String> paramAnonymous2Map)
          {
            synchronized (zzfw.zzc(zzfw.this))
            {
              zzkh.zzcx("JS Engine is requesting an update");
              if (zzfw.zze(zzfw.this) == 0)
              {
                zzkh.zzcx("Starting reload.");
                zzfw.zza(zzfw.this, 2);
                zzb(zzbma);
              }
              localzzft.zzb("/requestReload", (zzet)localzzkw.get());
              return;
            }
          }
        };
        localzzkw.set(local3);
        localzzft.zza("/requestReload", local3);
        if (zzfw.zzf(zzfw.this).endsWith(".js")) {
          localzzft.zzbh(zzfw.zzf(zzfw.this));
        }
        for (;;)
        {
          zzkl.zzclg.postDelayed(new Runnable()
          {
            public void run()
            {
              synchronized (zzfw.zzc(zzfw.this))
              {
                if ((zzbmb.getStatus() == -1) || (zzbmb.getStatus() == 1)) {
                  return;
                }
                zzbmb.reject();
                zzu.zzfq().runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    zzbmd.destroy();
                  }
                });
                zzkh.v("Could not receive loaded message in a timely manner. Rejecting.");
                return;
              }
            }
          }, zzfw.zza.zzbmk);
          return;
          if (zzfw.zzf(zzfw.this).startsWith("<html>")) {
            localzzft.zzbj(zzfw.zzf(zzfw.this));
          } else {
            localzzft.zzbi(zzfw.zzf(zzfw.this));
          }
        }
      }
    });
    return localzzd;
  }
  
  protected zzft zza(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzas paramzzas)
  {
    return new zzfv(paramContext, paramVersionInfoParcel, paramzzas);
  }
  
  protected zzd zzb(final zzas paramzzas)
  {
    paramzzas = zza(paramzzas);
    paramzzas.zza(new zzle.zzc()new zzle.zza
    {
      public void zza(zzft arg1)
      {
        synchronized (zzfw.zzc(zzfw.this))
        {
          zzfw.zza(zzfw.this, 0);
          if ((zzfw.zzg(zzfw.this) != null) && (paramzzas != zzfw.zzg(zzfw.this)))
          {
            zzkh.v("New JS engine is loaded, marking previous one as destroyable.");
            zzfw.zzg(zzfw.this).zzmf();
          }
          zzfw.zza(zzfw.this, paramzzas);
          return;
        }
      }
    }, new zzle.zza()
    {
      public void run()
      {
        synchronized (zzfw.zzc(zzfw.this))
        {
          zzfw.zza(zzfw.this, 1);
          zzkh.v("Failed loading new engine. Marking new engine destroyable.");
          paramzzas.zzmf();
          return;
        }
      }
    });
    return paramzzas;
  }
  
  public zzc zzc(zzas paramzzas)
  {
    synchronized (zzail)
    {
      if ((zzbly == null) || (zzbly.getStatus() == -1))
      {
        zzblz = 2;
        zzbly = zzb(paramzzas);
        paramzzas = zzbly.zzmd();
        return paramzzas;
      }
      if (zzblz == 0)
      {
        paramzzas = zzbly.zzmd();
        return paramzzas;
      }
    }
    if (zzblz == 1)
    {
      zzblz = 2;
      zzb(paramzzas);
      paramzzas = zzbly.zzmd();
      return paramzzas;
    }
    if (zzblz == 2)
    {
      paramzzas = zzbly.zzmd();
      return paramzzas;
    }
    paramzzas = zzbly.zzmd();
    return paramzzas;
  }
  
  public zzc zzmc()
  {
    return zzc(null);
  }
  
  static class zza
  {
    static int zzbmk = 60000;
    static int zzbml = 10000;
  }
  
  public static class zzb<T>
    implements zzkp<T>
  {
    public void zzd(T paramT) {}
  }
  
  public static class zzc
    extends zzlf<zzfx>
  {
    private final Object zzail = new Object();
    private final zzfw.zzd zzbmm;
    private boolean zzbmn;
    
    public zzc(zzfw.zzd paramzzd)
    {
      zzbmm = paramzzd;
    }
    
    public void release()
    {
      synchronized (zzail)
      {
        if (zzbmn) {
          return;
        }
        zzbmn = true;
        zza(new zzle.zzc()new zzle.zzb
        {
          public void zzb(zzfx paramAnonymouszzfx)
          {
            zzkh.v("Ending javascript session.");
            ((zzfy)paramAnonymouszzfx).zzmh();
          }
        }, new zzle.zzb());
        zza(new zzle.zzc()new zzle.zza
        {
          public void zzb(zzfx paramAnonymouszzfx)
          {
            zzkh.v("Releasing engine reference.");
            zzfw.zzc.zza(zzfw.zzc.this).zzme();
          }
        }, new zzle.zza()
        {
          public void run()
          {
            zzfw.zzc.zza(zzfw.zzc.this).zzme();
          }
        });
        return;
      }
    }
  }
  
  public static class zzd
    extends zzlf<zzft>
  {
    private final Object zzail = new Object();
    private zzkp<zzft> zzblx;
    private boolean zzbmp;
    private int zzbmq;
    
    public zzd(zzkp<zzft> paramzzkp)
    {
      zzblx = paramzzkp;
      zzbmp = false;
      zzbmq = 0;
    }
    
    public zzfw.zzc zzmd()
    {
      final zzfw.zzc localzzc = new zzfw.zzc(this);
      for (;;)
      {
        synchronized (zzail)
        {
          zza(new zzle.zzc()new zzle.zza
          {
            public void zza(zzft paramAnonymouszzft)
            {
              zzkh.v("Getting a new session for JS Engine.");
              localzzc.zzg(paramAnonymouszzft.zzma());
            }
          }, new zzle.zza()
          {
            public void run()
            {
              zzkh.v("Rejecting reference for JS Engine.");
              localzzc.reject();
            }
          });
          if (zzbmq >= 0)
          {
            bool = true;
            zzab.zzbm(bool);
            zzbmq += 1;
            return localzzc;
          }
        }
        boolean bool = false;
      }
    }
    
    protected void zzme()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (zzail)
        {
          if (zzbmq >= 1)
          {
            zzab.zzbm(bool);
            zzkh.v("Releasing 1 reference for JS Engine");
            zzbmq -= 1;
            zzmg();
            return;
          }
        }
      }
    }
    
    public void zzmf()
    {
      for (boolean bool = true;; bool = false) {
        synchronized (zzail)
        {
          if (zzbmq >= 0)
          {
            zzab.zzbm(bool);
            zzkh.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            zzbmp = true;
            zzmg();
            return;
          }
        }
      }
    }
    
    protected void zzmg()
    {
      for (;;)
      {
        synchronized (zzail)
        {
          if (zzbmq >= 0)
          {
            bool = true;
            zzab.zzbm(bool);
            if ((zzbmp) && (zzbmq == 0))
            {
              zzkh.v("No reference is left (including root). Cleaning up engine.");
              zza(new zzle.zzc()new zzle.zzb
              {
                public void zza(final zzft paramAnonymouszzft)
                {
                  zzu.zzfq().runOnUiThread(new Runnable()
                  {
                    public void run()
                    {
                      zzfw.zzd.zza(zzfw.zzd.this).zzd(paramAnonymouszzft);
                      paramAnonymouszzft.destroy();
                    }
                  });
                }
              }, new zzle.zzb());
              return;
            }
            zzkh.v("There are still references to the engine. Not destroying.");
          }
        }
        boolean bool = false;
      }
    }
  }
  
  public static class zze
    extends zzlf<zzfx>
  {
    private zzfw.zzc zzbmv;
    
    public zze(zzfw.zzc paramzzc)
    {
      zzbmv = paramzzc;
    }
    
    public void finalize()
    {
      zzbmv.release();
      zzbmv = null;
    }
    
    public int getStatus()
    {
      return zzbmv.getStatus();
    }
    
    public void reject()
    {
      zzbmv.reject();
    }
    
    public void zza(zzle.zzc<zzfx> paramzzc, zzle.zza paramzza)
    {
      zzbmv.zza(paramzzc, paramzza);
    }
    
    public void zzf(zzfx paramzzfx)
    {
      zzbmv.zzg(paramzzfx);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */