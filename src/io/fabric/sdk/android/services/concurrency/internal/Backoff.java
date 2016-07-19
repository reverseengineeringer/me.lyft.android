package io.fabric.sdk.android.services.concurrency.internal;

public abstract interface Backoff
{
  public abstract long getDelayMillis(int paramInt);
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.internal.Backoff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */