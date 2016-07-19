package com.google.android.gms.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzkk$5
  implements ThreadFactory
{
  private final AtomicInteger zzcle = new AtomicInteger(1);
  
  zzkk$5(String paramString) {}
  
  public Thread newThread(Runnable paramRunnable)
  {
    String str = zzclf;
    int i = zzcle.getAndIncrement();
    return new Thread(paramRunnable, String.valueOf(str).length() + 23 + "AdWorker(" + str + ") #" + i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzkk.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */