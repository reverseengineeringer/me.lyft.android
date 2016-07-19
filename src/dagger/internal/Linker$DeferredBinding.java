package dagger.internal;

import java.util.Set;

class Linker$DeferredBinding
  extends Binding<Object>
{
  final ClassLoader classLoader;
  final String deferredKey;
  final boolean mustHaveInjections;
  
  Linker$DeferredBinding(String paramString, ClassLoader paramClassLoader, Object paramObject, boolean paramBoolean)
  {
    super(null, null, false, paramObject);
    deferredKey = paramString;
    classLoader = paramClassLoader;
    mustHaveInjections = paramBoolean;
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    throw new UnsupportedOperationException("Deferred bindings must resolve first.");
  }
  
  public void injectMembers(Object paramObject)
  {
    throw new UnsupportedOperationException("Deferred bindings must resolve first.");
  }
  
  public String toString()
  {
    return "DeferredBinding[deferredKey=" + deferredKey + "]";
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Linker.DeferredBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */