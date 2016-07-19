package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@zzir
public class zzlb
{
  public static <A, B> zzlc<B> zza(final zzlc<A> paramzzlc, final zza<A, B> paramzza)
  {
    zzkz localzzkz = new zzkz();
    paramzzlc.zzb(new Runnable()
    {
      public void run()
      {
        try
        {
          zzi(paramzza.zzh(paramzzlc.get()));
          return;
        }
        catch (ExecutionException localExecutionException)
        {
          cancel(true);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        catch (CancellationException localCancellationException)
        {
          for (;;) {}
        }
      }
    });
    return localzzkz;
  }
  
  public static <V> zzlc<List<V>> zzn(final List<zzlc<V>> paramList)
  {
    final zzkz localzzkz = new zzkz();
    final int i = paramList.size();
    AtomicInteger localAtomicInteger = new AtomicInteger(0);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((zzlc)localIterator.next()).zzb(new Runnable()
      {
        public void run()
        {
          if (incrementAndGet() >= i) {}
          try
          {
            localzzkz.zzi(zzlb.zzp(paramList));
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
            zzkh.zzd("Unable to convert list of futures to a future of list", localInterruptedException);
            return;
          }
          catch (ExecutionException localExecutionException)
          {
            for (;;) {}
          }
        }
      });
    }
    return localzzkz;
  }
  
  private static <V> List<V> zzo(List<zzlc<V>> paramList)
    throws ExecutionException, InterruptedException
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = ((zzlc)paramList.next()).get();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  public static abstract interface zza<D, R>
  {
    public abstract R zzh(D paramD);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzlb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */