package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.ThreadFactory;

public final class PriorityThreadPoolExecutor$PriorityThreadFactory
  implements ThreadFactory
{
  private final int threadPriority;
  
  public PriorityThreadPoolExecutor$PriorityThreadFactory(int paramInt)
  {
    threadPriority = paramInt;
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    paramRunnable = new Thread(paramRunnable);
    paramRunnable.setPriority(threadPriority);
    paramRunnable.setName("Queue");
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityThreadPoolExecutor.PriorityThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */