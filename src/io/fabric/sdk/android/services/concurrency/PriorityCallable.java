package io.fabric.sdk.android.services.concurrency;

import java.util.concurrent.Callable;

public abstract class PriorityCallable<V>
  extends PriorityTask
  implements Callable<V>
{}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.PriorityCallable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */