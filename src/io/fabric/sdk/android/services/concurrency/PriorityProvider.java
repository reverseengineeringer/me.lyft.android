package io.fabric.sdk.android.services.concurrency;

public abstract interface PriorityProvider<T>
  extends Comparable<T>
{
  public abstract Priority getPriority();
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */