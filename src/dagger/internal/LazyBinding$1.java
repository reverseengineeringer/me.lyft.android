package dagger.internal;

import dagger.Lazy;

class LazyBinding$1
  implements Lazy<T>
{
  private volatile Object cacheValue = LazyBinding.NOT_PRESENT;
  
  LazyBinding$1(LazyBinding paramLazyBinding) {}
  
  public T get()
  {
    if (cacheValue == LazyBinding.NOT_PRESENT) {}
    try
    {
      if (cacheValue == LazyBinding.NOT_PRESENT) {
        cacheValue = this$0.delegate.get();
      }
      return (T)cacheValue;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     dagger.internal.LazyBinding.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */