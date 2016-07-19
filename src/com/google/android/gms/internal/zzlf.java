package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zzir
public class zzlf<T>
  implements zzle<T>
{
  private final Object zzail = new Object();
  protected int zzblz = 0;
  protected final BlockingQueue<zza> zzcof = new LinkedBlockingQueue();
  protected T zzcog;
  
  public int getStatus()
  {
    return zzblz;
  }
  
  public void reject()
  {
    synchronized (zzail)
    {
      if (zzblz != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzblz = -1;
    Iterator localIterator = zzcof.iterator();
    while (localIterator.hasNext()) {
      nextzzcoi.run();
    }
    zzcof.clear();
  }
  
  public void zza(zzle.zzc<T> paramzzc, zzle.zza paramzza)
  {
    for (;;)
    {
      synchronized (zzail)
      {
        if (zzblz == 1)
        {
          paramzzc.zzd(zzcog);
          return;
        }
        if (zzblz == -1) {
          paramzza.run();
        }
      }
      if (zzblz == 0) {
        zzcof.add(new zza(paramzzc, paramzza));
      }
    }
  }
  
  public void zzg(T paramT)
  {
    synchronized (zzail)
    {
      if (zzblz != 0) {
        throw new UnsupportedOperationException();
      }
    }
    zzcog = paramT;
    zzblz = 1;
    Iterator localIterator = zzcof.iterator();
    while (localIterator.hasNext()) {
      nextzzcoh.zzd(paramT);
    }
    zzcof.clear();
  }
  
  class zza
  {
    public final zzle.zzc<T> zzcoh;
    public final zzle.zza zzcoi;
    
    public zza(zzle.zza paramzza)
    {
      zzcoh = paramzza;
      zzle.zza localzza;
      zzcoi = localzza;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */