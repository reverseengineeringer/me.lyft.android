package dagger.internal;

import java.util.Set;

class Linker$SingletonBinding<T>
  extends Binding<T>
{
  private final Binding<T> binding;
  private volatile Object onlyInstance = Linker.UNINITIALIZED;
  
  Linker$SingletonBinding(Binding<T> paramBinding)
  {
    super(provideKey, membersKey, true, requiredBy);
    binding = paramBinding;
  }
  
  public void attach(Linker paramLinker)
  {
    binding.attach(paramLinker);
  }
  
  public boolean dependedOn()
  {
    return binding.dependedOn();
  }
  
  public T get()
  {
    if (onlyInstance == Linker.UNINITIALIZED) {}
    try
    {
      if (onlyInstance == Linker.UNINITIALIZED) {
        onlyInstance = binding.get();
      }
      return (T)onlyInstance;
    }
    finally {}
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    binding.getDependencies(paramSet1, paramSet2);
  }
  
  public void injectMembers(T paramT)
  {
    binding.injectMembers(paramT);
  }
  
  public boolean isCycleFree()
  {
    return binding.isCycleFree();
  }
  
  public boolean isLinked()
  {
    return binding.isLinked();
  }
  
  protected boolean isSingleton()
  {
    return true;
  }
  
  public boolean isVisiting()
  {
    return binding.isVisiting();
  }
  
  public boolean library()
  {
    return binding.library();
  }
  
  public void setCycleFree(boolean paramBoolean)
  {
    binding.setCycleFree(paramBoolean);
  }
  
  public void setDependedOn(boolean paramBoolean)
  {
    binding.setDependedOn(paramBoolean);
  }
  
  public void setLibrary(boolean paramBoolean)
  {
    binding.setLibrary(true);
  }
  
  protected void setLinked()
  {
    binding.setLinked();
  }
  
  public void setVisiting(boolean paramBoolean)
  {
    binding.setVisiting(paramBoolean);
  }
  
  public String toString()
  {
    return "@Singleton/" + binding.toString();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Linker.SingletonBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */