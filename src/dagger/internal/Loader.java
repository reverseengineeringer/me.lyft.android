package dagger.internal;

public abstract class Loader
{
  private final Memoizer<ClassLoader, Memoizer<String, Class<?>>> caches = new Memoizer()
  {
    protected Memoizer<String, Class<?>> create(final ClassLoader paramAnonymousClassLoader)
    {
      new Memoizer()
      {
        protected Class<?> create(String paramAnonymous2String)
        {
          try
          {
            paramAnonymous2String = paramAnonymousClassLoader.loadClass(paramAnonymous2String);
            return paramAnonymous2String;
          }
          catch (ClassNotFoundException paramAnonymous2String) {}
          return Void.class;
        }
      };
    }
  };
  
  public abstract Binding<?> getAtInjectBinding(String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean);
  
  public abstract <T> ModuleAdapter<T> getModuleAdapter(Class<T> paramClass);
  
  public abstract StaticInjection getStaticInjection(Class<?> paramClass);
  
  protected <T> T instantiate(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramClassLoader = loadClass(paramClassLoader, paramString);
      if (paramClassLoader == Void.class) {
        return null;
      }
      paramClassLoader = paramClassLoader.newInstance();
      return paramClassLoader;
    }
    catch (InstantiationException paramClassLoader)
    {
      throw new RuntimeException("Failed to initialize " + paramString, paramClassLoader);
    }
    catch (IllegalAccessException paramClassLoader)
    {
      throw new RuntimeException("Failed to initialize " + paramString, paramClassLoader);
    }
  }
  
  protected Class<?> loadClass(ClassLoader paramClassLoader, String paramString)
  {
    if (paramClassLoader != null) {}
    for (;;)
    {
      return (Class)((Memoizer)caches.get(paramClassLoader)).get(paramString);
      paramClassLoader = ClassLoader.getSystemClassLoader();
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Loader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */