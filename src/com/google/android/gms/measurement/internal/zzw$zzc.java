package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

final class zzw$zzc<V>
  extends FutureTask<V>
  implements Comparable<zzc>
{
  private final String amg;
  private final long ami;
  private final boolean amj;
  
  zzw$zzc(zzw paramzzw, Runnable paramRunnable, boolean paramBoolean, String paramString)
  {
    super(paramRunnable, null);
    zzab.zzaa(paramString);
    ami = zzw.zzbuj().getAndIncrement();
    amg = paramString;
    amj = paramBoolean;
    if (ami == Long.MAX_VALUE) {
      paramzzw.zzbsz().zzbtr().log("Tasks index overflow");
    }
  }
  
  zzw$zzc(Callable<V> paramCallable, boolean paramBoolean, String paramString)
  {
    super(paramBoolean);
    Object localObject;
    zzab.zzaa(localObject);
    ami = zzw.zzbuj().getAndIncrement();
    amg = ((String)localObject);
    amj = paramString;
    if (ami == Long.MAX_VALUE) {
      paramCallable.zzbsz().zzbtr().log("Tasks index overflow");
    }
  }
  
  protected void setException(Throwable paramThrowable)
  {
    amh.zzbsz().zzbtr().zzj(amg, paramThrowable);
    if ((paramThrowable instanceof zzw.zza)) {
      Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), paramThrowable);
    }
    super.setException(paramThrowable);
  }
  
  public int zzb(zzc paramzzc)
  {
    if (amj != amj) {
      if (!amj) {}
    }
    while (ami < ami)
    {
      return -1;
      return 1;
    }
    if (ami > ami) {
      return 1;
    }
    amh.zzbsz().zzbts().zzj("Two tasks share the same index. index", Long.valueOf(ami));
    return 0;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.measurement.internal.zzw.zzc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */