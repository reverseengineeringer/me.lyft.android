package io.fabric.sdk.android.services.concurrency.internal;

public class DefaultRetryPolicy
  implements RetryPolicy
{
  private final int maxRetries;
  
  public DefaultRetryPolicy()
  {
    this(1);
  }
  
  public DefaultRetryPolicy(int paramInt)
  {
    maxRetries = paramInt;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */