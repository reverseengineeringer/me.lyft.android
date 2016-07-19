package bolts;

public abstract interface Continuation<TTaskResult, TContinuationResult>
{
  public abstract TContinuationResult then(Task<TTaskResult> paramTask)
    throws Exception;
}

/* Location:
 * Qualified Name:     bolts.Continuation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */