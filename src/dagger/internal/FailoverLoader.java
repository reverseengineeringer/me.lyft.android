package dagger.internal;

import dagger.internal.loaders.ReflectiveAtInjectBinding;
import dagger.internal.loaders.ReflectiveStaticInjection;

public final class FailoverLoader
  extends Loader
{
  private final Memoizer<Class<?>, ModuleAdapter<?>> loadedAdapters = new Memoizer()
  {
    protected ModuleAdapter<?> create(Class<?> paramAnonymousClass)
    {
      ModuleAdapter localModuleAdapter = (ModuleAdapter)instantiate(paramAnonymousClass.getName().concat("$$ModuleAdapter"), paramAnonymousClass.getClassLoader());
      if (localModuleAdapter == null) {
        throw new IllegalStateException("Module adapter for " + paramAnonymousClass + " could not be loaded. " + "Please ensure that code generation was run for this module.");
      }
      return localModuleAdapter;
    }
  };
  
  public Binding<?> getAtInjectBinding(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    Binding localBinding = (Binding)instantiate(paramString2.concat("$$InjectAdapter"), paramClassLoader);
    if (localBinding != null) {
      return localBinding;
    }
    paramClassLoader = loadClass(paramClassLoader, paramString2);
    if (paramClassLoader.equals(Void.class)) {
      throw new IllegalStateException(String.format("Could not load class %s needed for binding %s", new Object[] { paramString2, paramString1 }));
    }
    if (paramClassLoader.isInterface()) {
      return null;
    }
    return ReflectiveAtInjectBinding.create(paramClassLoader, paramBoolean);
  }
  
  public <T> ModuleAdapter<T> getModuleAdapter(Class<T> paramClass)
  {
    return (ModuleAdapter)loadedAdapters.get(paramClass);
  }
  
  public StaticInjection getStaticInjection(Class<?> paramClass)
  {
    StaticInjection localStaticInjection = (StaticInjection)instantiate(paramClass.getName().concat("$$StaticInjection"), paramClass.getClassLoader());
    if (localStaticInjection != null) {
      return localStaticInjection;
    }
    return ReflectiveStaticInjection.create(paramClass);
  }
}

/* Location:
 * Qualified Name:     dagger.internal.FailoverLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */