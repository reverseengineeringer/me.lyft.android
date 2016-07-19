package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zzir
public class zzla<T>
  implements zzlc<T>
{
  private final T zzcnr;
  private final zzld zzcnt;
  
  public zzla(T paramT)
  {
    zzcnr = paramT;
    zzcnt = new zzld();
    zzcnt.zzua();
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public T get()
  {
    return (T)zzcnr;
  }
  
  public T get(long paramLong, TimeUnit paramTimeUnit)
  {
    return (T)zzcnr;
  }
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public boolean isDone()
  {
    return true;
  }
  
  public void zzb(Runnable paramRunnable)
  {
    zzcnt.zzb(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzla
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */