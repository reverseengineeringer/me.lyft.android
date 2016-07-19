package bolts;

import java.util.concurrent.Executor;

class Task$10
  implements Continuation<TResult, Void>
{
  Task$10(Task paramTask, TaskCompletionSource paramTaskCompletionSource, Continuation paramContinuation, Executor paramExecutor, CancellationToken paramCancellationToken) {}
  
  public Void then(Task<TResult> paramTask)
  {
    Task.access$000(val$tcs, val$continuation, paramTask, val$executor, val$ct);
    return null;
  }
}

/* Location:
 * Qualified Name:     bolts.Task.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */