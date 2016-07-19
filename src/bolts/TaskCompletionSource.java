package bolts;

public class TaskCompletionSource<TResult>
{
  private final Task<TResult> task = new Task();
  
  public Task<TResult> getTask()
  {
    return task;
  }
  
  public void setCancelled()
  {
    if (!trySetCancelled()) {
      throw new IllegalStateException("Cannot cancel a completed task.");
    }
  }
  
  public void setError(Exception paramException)
  {
    if (!trySetError(paramException)) {
      throw new IllegalStateException("Cannot set the error on a completed task.");
    }
  }
  
  public void setResult(TResult paramTResult)
  {
    if (!trySetResult(paramTResult)) {
      throw new IllegalStateException("Cannot set the result of a completed task.");
    }
  }
  
  public boolean trySetCancelled()
  {
    return task.trySetCancelled();
  }
  
  public boolean trySetError(Exception paramException)
  {
    return task.trySetError(paramException);
  }
  
  public boolean trySetResult(TResult paramTResult)
  {
    return task.trySetResult(paramTResult);
  }
}

/* Location:
 * Qualified Name:     bolts.TaskCompletionSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */