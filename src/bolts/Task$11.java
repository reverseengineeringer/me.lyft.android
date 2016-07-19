package bolts;

import java.util.concurrent.Executor;

class Task$11
  implements Continuation<TResult, Void>
{
  Task$11(Task paramTask, TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken) {}
  
  public Void then(Task<TResult> paramTask)
  {
    Task.access$100(val$tcs, val$continuation, paramTask, val$executor, val$ct);
    return null;
  }
}

/* Location:
 * Qualified Name:     bolts.Task.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */