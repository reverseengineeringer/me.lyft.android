package dagger.internal;

final class BuiltInBinding<T>
  extends Binding<T>
{
  private final ClassLoader classLoader;
  private Binding<?> delegate;
  private final String delegateKey;
  
  public BuiltInBinding(String paramString1, Object paramObject, ClassLoader paramClassLoader, String paramString2)
  {
    super(paramString1, null, false, paramObject);
    classLoader = paramClassLoader;
    delegateKey = paramString2;
  }
  
  public void attach(Linker paramLinker)
  {
    delegate = paramLinker.requestBinding(delegateKey, requiredBy, classLoader);
  }
  
  public T get()
  {
    return delegate;
  }
  
  public Binding<?> getDelegate()
  {
    return delegate;
  }
  
  public void injectMembers(T paramT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.BuiltInBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */