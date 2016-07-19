package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class zzl
{
  private AtomicInteger zzax = new AtomicInteger();
  private final Map<String, Queue<zzk<?>>> zzay = new HashMap();
  private final Set<zzk<?>> zzaz = new HashSet();
  private final PriorityBlockingQueue<zzk<?>> zzba = new PriorityBlockingQueue();
  private final PriorityBlockingQueue<zzk<?>> zzbb = new PriorityBlockingQueue();
  private zzg[] zzbc;
  private zzc zzbd;
  private List<zza> zzbe = new ArrayList();
  private final zzb zzi;
  private final zzn zzj;
  private final zzf zzy;
  
  public zzl(zzb paramzzb, zzf paramzzf)
  {
    this(paramzzb, paramzzf, 4);
  }
  
  public zzl(zzb paramzzb, zzf paramzzf, int paramInt)
  {
    this(paramzzb, paramzzf, paramInt, new zze(new Handler(Looper.getMainLooper())));
  }
  
  public zzl(zzb paramzzb, zzf paramzzf, int paramInt, zzn paramzzn)
  {
    zzi = paramzzb;
    zzy = paramzzf;
    zzbc = new zzg[paramInt];
    zzj = paramzzn;
  }
  
  public int getSequenceNumber()
  {
    return zzax.incrementAndGet();
  }
  
  public void start()
  {
    stop();
    zzbd = new zzc(zzba, zzbb, zzi, zzj);
    zzbd.start();
    int i = 0;
    while (i < zzbc.length)
    {
      zzg localzzg = new zzg(zzbb, zzy, zzi, zzj);
      zzbc[i] = localzzg;
      localzzg.start();
      i += 1;
    }
  }
  
  public void stop()
  {
    if (zzbd != null) {
      zzbd.quit();
    }
    int i = 0;
    while (i < zzbc.length)
    {
      if (zzbc[i] != null) {
        zzbc[i].quit();
      }
      i += 1;
    }
  }
  
  public <T> zzk<T> zze(zzk<T> paramzzk)
  {
    paramzzk.zza(this);
    synchronized (zzaz)
    {
      zzaz.add(paramzzk);
      paramzzk.zza(getSequenceNumber());
      paramzzk.zzc("add-to-queue");
      if (!paramzzk.zzq())
      {
        zzbb.add(paramzzk);
        return paramzzk;
      }
    }
    for (;;)
    {
      String str;
      synchronized (zzay)
      {
        str = paramzzk.zzg();
        if (zzay.containsKey(str))
        {
          Queue localQueue = (Queue)zzay.get(str);
          ??? = localQueue;
          if (localQueue == null) {
            ??? = new LinkedList();
          }
          ((Queue)???).add(paramzzk);
          zzay.put(str, ???);
          if (zzs.DEBUG) {
            zzs.zza("Request for cacheKey=%s is in flight, putting on hold.", new Object[] { str });
          }
          return paramzzk;
        }
      }
      zzay.put(str, null);
      zzba.add(paramzzk);
    }
  }
  
  <T> void zzf(zzk<T> paramzzk)
  {
    Object localObject2;
    synchronized (zzaz)
    {
      zzaz.remove(paramzzk);
      synchronized (zzbe)
      {
        localObject2 = zzbe.iterator();
        if (((Iterator)localObject2).hasNext()) {
          ((zza)((Iterator)localObject2).next()).zzg(paramzzk);
        }
      }
    }
    if (paramzzk.zzq()) {
      synchronized (zzay)
      {
        paramzzk = paramzzk.zzg();
        localObject2 = (Queue)zzay.remove(paramzzk);
        if (localObject2 != null)
        {
          if (zzs.DEBUG) {
            zzs.zza("Releasing %d waiting requests for cacheKey=%s.", new Object[] { Integer.valueOf(((Queue)localObject2).size()), paramzzk });
          }
          zzba.addAll((Collection)localObject2);
        }
        return;
      }
    }
  }
  
  public static abstract interface zza<T>
  {
    public abstract void zzg(zzk<T> paramzzk);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */