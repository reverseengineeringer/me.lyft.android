package com.google.android.gms.internal;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

class zzpg$2
  implements ThreadFactory
{
  zzpg$2(zzpg paramzzpg) {}
  
  public Thread newThread(final Runnable paramRunnable)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        Process.setThreadPriority(10);
        paramRunnable.run();
      }
    }, "ClearcutLoggerApiImpl");
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpg.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */