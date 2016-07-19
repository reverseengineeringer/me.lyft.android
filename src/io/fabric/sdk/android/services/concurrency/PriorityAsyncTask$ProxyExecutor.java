package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.Executor;

class PriorityAsyncTask$ProxyExecutor<Result>
  implements Executor
{
  private final Executor executor;
  private final PriorityAsyncTask task;
  
  public PriorityAsyncTask$ProxyExecutor(Executor paramExecutor, PriorityAsyncTask paramPriorityAsyncTask)
  {
    executor = paramExecutor;
    task = paramPriorityAsyncTask;
  }
  
  public void execute(Runnable paramRunnable)
  {
    executor.execute(new PriorityFutureTask(paramRunnable, null)
    {
      public <T extends Dependency<Task>,  extends PriorityProvider,  extends Task> T getDelegate()
      {
        return task;
      }
    });
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.ProxyExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */