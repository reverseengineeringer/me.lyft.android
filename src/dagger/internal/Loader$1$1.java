package dagger.internal;

class Loader$1$1
  extends Memoizer<String, Class<?>>
{
  Loader$1$1(Loader.1 param1, ClassLoader paramClassLoader) {}
  
  protected Class<?> create(String paramString)
  {
    try
    {
      paramString = val$classLoader.loadClass(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString) {}
    return Void.class;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Loader.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */