package dagger.internal;

class FailoverLoader$1
  extends Memoizer<Class<?>, ModuleAdapter<?>>
{
  FailoverLoader$1(FailoverLoader paramFailoverLoader) {}
  
  protected ModuleAdapter<?> create(Class<?> paramClass)
  {
    ModuleAdapter localModuleAdapter = (ModuleAdapter)this$0.instantiate(paramClass.getName().concat("$$ModuleAdapter"), paramClass.getClassLoader());
    if (localModuleAdapter == null) {
      throw new IllegalStateException("Module adapter for " + paramClass + " could not be loaded. " + "Please ensure that code generation was run for this module.");
    }
    return localModuleAdapter;
  }
}

/* Location:
 * Qualified Name:     dagger.internal.FailoverLoader.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */