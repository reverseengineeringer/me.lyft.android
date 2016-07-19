package bolts;

class Task$15$1
  implements Continuation<TContinuationResult, Void>
{
  Task$15$1(Task.15 param15) {}
  
  public Void then(Task<TContinuationResult> paramTask)
  {
    if ((this$0.val$ct != null) && (this$0.val$ct.isCancellationRequested()))
    {
      this$0.val$tcs.setCancelled();
      return null;
    }
    if (paramTask.isCancelled())
    {
      this$0.val$tcs.setCancelled();
      return null;
    }
    if (paramTask.isFaulted())
    {
      this$0.val$tcs.setError(paramTask.getError());
      return null;
    }
    this$0.val$tcs.setResult(paramTask.getResult());
    return null;
  }
}

/* Location:
 * Qualified Name:     bolts.Task.15.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */