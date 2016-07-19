package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzar;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzdc;
import com.google.android.gms.internal.zzir;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzir
class zzi
  implements zzan, Runnable
{
  private zzv zzajs;
  private final List<Object[]> zzala = new Vector();
  private final AtomicReference<zzan> zzalb = new AtomicReference();
  CountDownLatch zzalc = new CountDownLatch(1);
  
  public zzi(zzv paramzzv)
  {
    zzajs = paramzzv;
    if (zzm.zziw().zzty())
    {
      zzkk.zza(this);
      return;
    }
    run();
  }
  
  private void zzep()
  {
    if (zzala.isEmpty()) {
      return;
    }
    Iterator localIterator = zzala.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1) {
        ((zzan)zzalb.get()).zza((MotionEvent)arrayOfObject[0]);
      } else if (arrayOfObject.length == 3) {
        ((zzan)zzalb.get()).zza(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
      }
    }
    zzala.clear();
  }
  
  private Context zzi(Context paramContext)
  {
    if (!((Boolean)zzdc.zzayi.get()).booleanValue()) {}
    Context localContext;
    do
    {
      return paramContext;
      localContext = paramContext.getApplicationContext();
    } while (localContext == null);
    return localContext;
  }
  
  public void run()
  {
    label94:
    for (;;)
    {
      try
      {
        if (((Boolean)zzdc.zzayu.get()).booleanValue()) {
          if (zzajs.zzaou.zzcnq)
          {
            break label94;
            zza(zzd(zzajs.zzaou.zzcs, zzi(zzajs.zzagf), bool));
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally
      {
        zzalc.countDown();
        zzajs = null;
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    zzan localzzan = (zzan)zzalb.get();
    if (localzzan != null)
    {
      zzep();
      localzzan.zza(paramInt1, paramInt2, paramInt3);
      return;
    }
    zzala.add(new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
  }
  
  public void zza(MotionEvent paramMotionEvent)
  {
    zzan localzzan = (zzan)zzalb.get();
    if (localzzan != null)
    {
      zzep();
      localzzan.zza(paramMotionEvent);
      return;
    }
    zzala.add(new Object[] { paramMotionEvent });
  }
  
  protected void zza(zzan paramzzan)
  {
    zzalb.set(paramzzan);
  }
  
  public String zzb(Context paramContext)
  {
    if (zzeo())
    {
      zzan localzzan = (zzan)zzalb.get();
      if (localzzan != null)
      {
        zzep();
        return localzzan.zzb(zzi(paramContext));
      }
    }
    return "";
  }
  
  public String zzb(Context paramContext, String paramString)
  {
    if (zzeo())
    {
      zzan localzzan = (zzan)zzalb.get();
      if (localzzan != null)
      {
        zzep();
        return localzzan.zzb(zzi(paramContext), paramString);
      }
    }
    return "";
  }
  
  protected zzan zzd(String paramString, Context paramContext, boolean paramBoolean)
  {
    return zzar.zza(paramString, paramContext, paramBoolean);
  }
  
  protected boolean zzeo()
  {
    try
    {
      zzalc.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzkh.zzd("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.zzi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */