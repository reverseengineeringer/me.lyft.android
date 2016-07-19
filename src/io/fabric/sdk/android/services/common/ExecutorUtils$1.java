package io.fabric.sdk.android.services.common;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class ExecutorUtils$1
  implements ThreadFactory
{
  ExecutorUtils$1(String paramString, AtomicLong paramAtomicLong) {}
  
  public Thread newThread(final Runnable paramRunnable)
  {
    paramRunnable = Executors.defaultThreadFactory().newThread(new BackgroundPriorityRunnable()
    {
      public void onRun()
      {
        paramRunnable.run();
      }
    });
    paramRunnable.setName(val$threadNameTemplate + val$count.getAndIncrement());
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.common.ExecutorUtils.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */