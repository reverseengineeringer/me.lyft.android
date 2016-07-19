package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class AsyncTask$1
  implements ThreadFactory
{
  private final AtomicInteger count = new AtomicInteger(1);
  
  public Thread newThread(Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "AsyncTask #" + count.getAndIncrement());
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */