package io.fabric.sdk.android.services.concurrency;

import java.util.LinkedList;
import java.util.concurrent.Executor;

class AsyncTask$SerialExecutor
  implements Executor
{
  Runnable active;
  final LinkedList<Runnable> tasks = new LinkedList();
  
  public void execute(final Runnable paramRunnable)
  {
    try
    {
      tasks.offer(new Runnable()
      {
        public void run()
        {
          try
          {
            paramRunnable.run();
            return;
          }
          finally
          {
            scheduleNext();
          }
        }
      });
      if (active == null) {
        scheduleNext();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  protected void scheduleNext()
  {
    try
    {
      Runnable localRunnable = (Runnable)tasks.poll();
      active = localRunnable;
      if (localRunnable != null) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(active);
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.AsyncTask.SerialExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */