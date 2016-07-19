package dagger.internal;

class Loader$1
  extends Memoizer<ClassLoader, Memoizer<String, Class<?>>>
{
  Loader$1(Loader paramLoader) {}
  
  protected Memoizer<String, Class<?>> create(final ClassLoader paramClassLoader)
  {
    new Memoizer()
    {
      protected Class<?> create(String paramAnonymousString)
      {
        try
        {
          paramAnonymousString = paramClassLoader.loadClass(paramAnonymousString);
          return paramAnonymousString;
        }
        catch (ClassNotFoundException paramAnonymousString) {}
        return Void.class;
      }
    };
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Loader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */