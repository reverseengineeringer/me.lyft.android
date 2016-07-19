package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class LockOnGetVariable<T>
{
  private CountDownLatch initLatch;
  private T value;
  
  public LockOnGetVariable(T paramT)
  {
    value = paramT;
  }
  
  public LockOnGetVariable(final Callable<T> paramCallable)
  {
    initLatch = new CountDownLatch(1);
    FacebookSdk.getExecutor().execute(new FutureTask(new Callable()
    {
      public Void call()
        throws Exception
      {
        try
        {
          LockOnGetVariable.access$002(LockOnGetVariable.this, paramCallable.call());
          return null;
        }
        finally
        {
          initLatch.countDown();
        }
      }
    }));
  }
  
  private void waitOnInit()
  {
    if (initLatch == null) {
      return;
    }
    try
    {
      initLatch.await();
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public T getValue()
  {
    waitOnInit();
    return (T)value;
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.LockOnGetVariable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */