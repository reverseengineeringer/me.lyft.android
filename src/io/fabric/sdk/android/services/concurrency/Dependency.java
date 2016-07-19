package io.fabric.sdk.android.services.concurrency;

import java.util.Collection;

public abstract interface Dependency<T>
{
  public abstract void addDependency(T paramT);
  
  public abstract boolean areDependenciesMet();
  
  public abstract Collection<T> getDependencies();
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.concurrency.Dependency
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */