package bolts;

import java.util.concurrent.CancellationException;

final class Task$15
  implements Runnable
{
  Task$15(CancellationToken paramCancellationToken, TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Task paramTask) {}
  
  public void run()
  {
    if ((val$ct != null) && (val$ct.isCancellationRequested()))
    {
      val$tcs.setCancelled();
      return;
    }
    try
    {
      Task localTask = (Task)val$continuation.then(val$task);
      if (localTask == null)
      {
        val$tcs.setResult(null);
        return;
      }
    }
    catch (CancellationException localCancellationException)
    {
      val$tcs.setCancelled();
      return;
      localCancellationException.continueWith(new Continuation()
      {
        public Void then(Task<TContinuationResult> paramAnonymousTask)
        {
          if ((val$ct != null) && (val$ct.isCancellationRequested()))
          {
            val$tcs.setCancelled();
            return null;
          }
          if (paramAnonymousTask.isCancelled())
          {
            val$tcs.setCancelled();
            return null;
          }
          if (paramAnonymousTask.isFaulted())
          {
            val$tcs.setError(paramAnonymousTask.getError());
            return null;
          }
          val$tcs.setResult(paramAnonymousTask.getResult());
          return null;
        }
      });
      return;
    }
    catch (Exception localException)
    {
      val$tcs.setError(localException);
    }
  }
}

/* Location:
 * Qualified Name:     bolts.Task.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */