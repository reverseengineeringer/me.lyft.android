package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzqw
{
  private static final ExecutorService uu = new ThreadPoolExecutor(0, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzrr("GAC_Transform"));
  
  public static ExecutorService zzapz()
  {
    return uu;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzqw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */