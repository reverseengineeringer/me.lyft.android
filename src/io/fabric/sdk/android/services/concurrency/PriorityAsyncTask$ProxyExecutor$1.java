package io.fabric.sdk.android.services.concurrency;

class PriorityAsyncTask$ProxyExecutor$1
  extends PriorityFutureTask<Result>
{
  PriorityAsyncTask$ProxyExecutor$1(PriorityAsyncTask.ProxyExecutor paramProxyExecutor, Runnable paramRunnable, Object paramObject)
  {
    super(paramRunnable, paramObject);
  }
  
  public <T extends Dependency<Task>,  extends PriorityProvider,  extends Task> T getDelegate()
  {
    return PriorityAsyncTask.ProxyExecutor.access$000(this$0);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityAsyncTask.ProxyExecutor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */