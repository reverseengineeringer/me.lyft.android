package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class PriorityAsyncTask<Params, Progress, Result>
  extends AsyncTask<Params, Progress, Result>
  implements Dependency<Task>, PriorityProvider, Task
{
  private final PriorityTask priorityTask = new PriorityTask();
  
  public void addDependency(Task paramTask)
  {
    if (getStatus() != AsyncTask.Status.PENDING) {
      throw new IllegalStateException("Must not add Dependency after task is running");
    }
    ((Dependency)getDelegate()).addDependency(paramTask);
  }
  
  public boolean areDependenciesMet()
  {
    return ((Dependency)getDelegate()).areDependenciesMet();
  }
  
  public int compareTo(Object paramObject)
  {
    return Priority.compareTo(this, paramObject);
  }
  
  public final void executeOnExecutor(ExecutorService paramExecutorService, Params... paramVarArgs)
  {
    super.executeOnExecutor(new ProxyExecutor(paramExecutorService, this), paramVarArgs);
  }
  
  public <T extends Dependency<Task>,  extends PriorityProvider,  extends Task> T getDelegate()
  {
    return priorityTask;
  }
  
  public Collection<Task> getDependencies()
  {
    return ((Dependency)getDelegate()).getDependencies();
  }
  
  public Priority getPriority()
  {
    return ((PriorityProvider)getDelegate()).getPriority();
  }
  
  public boolean isFinished()
  {
    return ((Task)getDelegate()).isFinished();
  }
  
  public void setError(Throwable paramThrowable)
  {
    ((Task)getDelegate()).setError(paramThrowable);
  }
  
  public void setFinished(boolean paramBoolean)
  {
    ((Task)getDelegate()).setFinished(paramBoolean);
  }
  
  private static class ProxyExecutor<Result>
    implements Executor
  {
    private final Executor executor;
    private final PriorityAsyncTask task;
    
    public ProxyExecutor(Executor paramExecutor, PriorityAsyncTask paramPriorityAsyncTask)
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
          return PriorityAsyncTask.this;
        }
      });
    }
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityAsyncTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */