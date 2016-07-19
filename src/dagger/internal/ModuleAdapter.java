package dagger.internal;

public abstract class ModuleAdapter<T>
{
  public final boolean complete;
  public final Class<?>[] includes;
  public final String[] injectableTypes;
  public final boolean library;
  public final Class<T> moduleClass;
  public final boolean overrides;
  public final Class<?>[] staticInjections;
  
  protected ModuleAdapter(Class<T> paramClass, String[] paramArrayOfString, Class<?>[] paramArrayOfClass1, boolean paramBoolean1, Class<?>[] paramArrayOfClass2, boolean paramBoolean2, boolean paramBoolean3)
  {
    moduleClass = paramClass;
    injectableTypes = paramArrayOfString;
    staticInjections = paramArrayOfClass1;
    overrides = paramBoolean1;
    includes = paramArrayOfClass2;
    complete = paramBoolean2;
    library = paramBoolean3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof ModuleAdapter))
    {
      paramObject = (ModuleAdapter)paramObject;
      return moduleClass.equals(moduleClass);
    }
    return false;
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, T paramT) {}
  
  public final int hashCode()
  {
    return moduleClass.hashCode();
  }
  
  protected T newModule()
  {
    throw new UnsupportedOperationException("No no-args constructor on " + getClass().getName());
  }
}

/* Location:
 * Qualified Name:     dagger.internal.ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */