package com.facebook.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

class LockOnGetVariable$1
  implements Callable<Void>
{
  LockOnGetVariable$1(LockOnGetVariable paramLockOnGetVariable, Callable paramCallable) {}
  
  public Void call()
    throws Exception
  {
    try
    {
      LockOnGetVariable.access$002(this$0, val$callable.call());
      return null;
    }
    finally
    {
      LockOnGetVariable.access$100(this$0).countDown();
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.internal.LockOnGetVariable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */