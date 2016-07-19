package io.fabric.sdk.android.services.concurrency;

public abstract interface Task
{
  public abstract boolean isFinished();
  
  public abstract void setError(Throwable paramThrowable);
  
  public abstract void setFinished(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.Task
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */