package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

class RetryManager
{
  long lastRetry;
  private RetryState retryState;
  
  public RetryManager(RetryState paramRetryState)
  {
    if (paramRetryState == null) {
      throw new NullPointerException("retryState must not be null");
    }
    retryState = paramRetryState;
  }
  
  public boolean canRetry(long paramLong)
  {
    long l = retryState.getRetryDelay();
    return paramLong - lastRetry >= 1000000L * l;
  }
  
  public void recordRetry(long paramLong)
  {
    lastRetry = paramLong;
    retryState = retryState.nextRetryState();
  }
  
  public void reset()
  {
    lastRetry = 0L;
    retryState = retryState.initialRetryState();
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.RetryManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */