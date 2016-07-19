package dagger.internal;

import dagger.Lazy;

final class LazyBinding<T>
  extends Binding<Lazy<T>>
{
  static final Object NOT_PRESENT = new Object();
  Binding<T> delegate;
  private final String lazyKey;
  private final ClassLoader loader;
  
  LazyBinding(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    loader = paramClassLoader;
    lazyKey = paramString2;
  }
  
  public void attach(Linker paramLinker)
  {
    delegate = paramLinker.requestBinding(lazyKey, requiredBy, loader);
  }
  
  public Lazy<T> get()
  {
    new Lazy()
    {
      private volatile Object cacheValue = LazyBinding.NOT_PRESENT;
      
      public T get()
      {
        if (cacheValue == LazyBinding.NOT_PRESENT) {}
        try
        {
          if (cacheValue == LazyBinding.NOT_PRESENT) {
            cacheValue = delegate.get();
          }
          return (T)cacheValue;
        }
        finally {}
      }
    };
  }
  
  public void injectMembers(Lazy<T> paramLazy)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.LazyBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */