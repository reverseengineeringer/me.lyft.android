package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzab;

public class zzfw$zzd
  extends zzlf<zzft>
{
  private final Object zzail = new Object();
  private zzkp<zzft> zzblx;
  private boolean zzbmp;
  private int zzbmq;
  
  public zzfw$zzd(zzkp<zzft> paramzzkp)
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

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzfw.zzd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */