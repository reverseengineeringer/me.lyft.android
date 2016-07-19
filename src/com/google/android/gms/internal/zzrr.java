package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzrr
  implements ThreadFactory
{
  private final String Bf;
  private final AtomicInteger Bg = new AtomicInteger();
  private final ThreadFactory Bh = Executors.defaultThreadFactory();
  private final int mPriority;
  
  public zzrr(String paramString)
  {
    this(paramString, 0);
  }
  
  public zzrr(String paramString, int paramInt)
  {
    Bf = ((String)zzab.zzb(paramString, "Name must not be null"));
    mPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = Bh.newThread(new zzrs(paramRunnable, mPriority));
    String str = Bf;
    int i = Bg.getAndIncrement();
    paramRunnable.setName(String.valueOf(str).length() + 13 + str + "[" + i + "]");
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzrr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */