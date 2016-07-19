package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@zzir
public final class zzkk
{
  private static final ExecutorService zzcky = Executors.newFixedThreadPool(10, zzco("Default"));
  private static final ExecutorService zzckz = Executors.newFixedThreadPool(5, zzco("Loader"));
  
  public static zzlc<Void> zza(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1) {
      zza(zzckz, new Callable()
      {
        public Void zzcy()
        {
          run();
          return null;
        }
      });
    }
    zza(zzcky, new Callable()
    {
      public Void zzcy()
      {
        run();
        return null;
      }
    });
  }
  
  public static zzlc<Void> zza(Runnable paramRunnable)
  {
    return zza(0, paramRunnable);
  }
  
  public static <T> zzlc<T> zza(Callable<T> paramCallable)
  {
    return zza(zzcky, paramCallable);
  }
  
  public static <T> zzlc<T> zza(ExecutorService paramExecutorService, final Callable<T> paramCallable)
  {
    zzkz localzzkz = new zzkz();
    try
    {
      localzzkz.zzc(new Runnable()
      {
        public void run()
        {
          try
          {
            Process.setThreadPriority(10);
            zzi(paramCallable.call());
            return;
          }
          catch (Exception localException)
          {
            zzu.zzft().zzb(localException, true);
            cancel(true);
          }
        }
      }
      {
        public void run()
        {
          if (isCancelled()) {
            zzcld.cancel(true);
          }
        }
      });
      return localzzkz;
    }
    catch (RejectedExecutionException paramExecutorService)
    {
      zzkh.zzd("Thread execution is rejected.", paramExecutorService);
      localzzkz.cancel(true);
    }
    return localzzkz;
  }
  
  private static ThreadFactory zzco(String paramString)
  {
    new ThreadFactory()
    {
      private final AtomicInteger zzcle = new AtomicInteger(1);
      
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        String str = zzkk.this;
        int i = zzcle.getAndIncrement();
        return new Thread(paramAnonymousRunnable, String.valueOf(str).length() + 23 + "AdWorker(" + str + ") #" + i);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */