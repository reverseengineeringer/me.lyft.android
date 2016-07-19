package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzir
public class zzkz<T>
  implements zzlc<T>
{
  private final Object zzail = new Object();
  private boolean zzbpb;
  private T zzcnr;
  private boolean zzcns;
  private final zzld zzcnt = new zzld();
  
  private boolean zztz()
  {
    return (0 != 0) || (zzcns);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return false;
    }
    synchronized (zzail)
    {
      if (zztz()) {
        return false;
      }
    }
    zzbpb = true;
    zzcns = true;
    zzail.notifyAll();
    zzcnt.zzua();
    return true;
  }
  
  public T get()
    throws CancellationException, ExecutionException, InterruptedException
  {
    synchronized (zzail)
    {
      boolean bool = zztz();
      if (bool) {}
    }
    Object localObject3 = zzcnr;
    return (T)localObject3;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
    throws CancellationException, ExecutionException, InterruptedException, TimeoutException
  {
    synchronized (zzail)
    {
      boolean bool = zztz();
      if (bool) {}
    }
    if (zzbpb) {
      throw new CancellationException("CallbackFuture was cancelled.");
    }
    paramTimeUnit = zzcnr;
    return paramTimeUnit;
  }
  
  public boolean isCancelled()
  {
    synchronized (zzail)
    {
      boolean bool = zzbpb;
      return bool;
    }
  }
  
  public boolean isDone()
  {
    synchronized (zzail)
    {
      boolean bool = zztz();
      return bool;
    }
  }
  
  public void zzb(Runnable paramRunnable)
  {
    zzcnt.zzb(paramRunnable);
  }
  
  public void zzc(Runnable paramRunnable)
  {
    zzcnt.zzc(paramRunnable);
  }
  
  public void zzi(T paramT)
  {
    synchronized (zzail)
    {
      if (zzbpb) {
        return;
      }
      if (zztz()) {
        throw new IllegalStateException("Provided CallbackFuture with multiple values.");
      }
    }
    zzcns = true;
    zzcnr = paramT;
    zzail.notifyAll();
    zzcnt.zzua();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */