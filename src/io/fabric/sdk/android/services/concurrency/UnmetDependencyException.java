package io.fabric.sdk.android.services.concurrency;

public class UnmetDependencyException
  extends RuntimeException
{
  public UnmetDependencyException() {}
  
  public UnmetDependencyException(String paramString)
  {
    super(paramString);
  }
  
  public UnmetDependencyException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.UnmetDependencyException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */