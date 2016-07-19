package bolts;

import java.util.concurrent.CancellationException;

final class Task$14
  implements Runnable
{
  Task$14(CancellationToken paramCancellationToken, TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Task paramTask) {}
  
  public void run()
  {
    if ((val$ct != null) && (val$ct.isCancellationRequested()))
    {
      val$tcs.setCancelled();
      return;
    }
    try
    {
      Object localObject = val$continuation.then(val$task);
      val$tcs.setResult(localObject);
      return;
    }
    catch (CancellationException localCancellationException)
    {
      val$tcs.setCancelled();
      return;
    }
    catch (Exception localException)
    {
      val$tcs.setError(localException);
    }
  }
}

/* Location:
 * Qualified Name:     bolts.Task.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */