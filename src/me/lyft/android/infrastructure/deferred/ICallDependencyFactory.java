package me.lyft.android.infrastructure.deferred;

public abstract interface ICallDependencyFactory
{
  public abstract <T> T get(Class<T> paramClass);
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.deferred.ICallDependencyFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */