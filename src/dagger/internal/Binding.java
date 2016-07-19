package dagger.internal;

import dagger.MembersInjector;
import java.util.Set;
import javax.inject.Provider;

public abstract class Binding<T>
  implements MembersInjector<T>, Provider<T>
{
  private static final int CYCLE_FREE = 8;
  private static final int DEPENDED_ON = 16;
  protected static final boolean IS_SINGLETON = true;
  private static final int LIBRARY = 32;
  private static final int LINKED = 2;
  protected static final boolean NOT_SINGLETON = false;
  private static final int SINGLETON = 1;
  public static final Binding<Object> UNRESOLVED = new Binding(null, null, false, null)
  {
    public Object get()
    {
      throw new AssertionError("Unresolved binding should never be called to inject.");
    }
    
    public void injectMembers(Object paramAnonymousObject)
    {
      throw new AssertionError("Unresolved binding should never be called to inject.");
    }
  };
  private static final int VISITING = 4;
  private int bits;
  public final String membersKey;
  public final String provideKey;
  public final Object requiredBy;
  
  protected Binding(String paramString1, String paramString2, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramString1 == null)) {
      throw new InvalidBindingException(Keys.getClassName(paramString2), "is exclusively members injected and therefore cannot be scoped");
    }
    provideKey = paramString1;
    membersKey = paramString2;
    requiredBy = paramObject;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      bits = i;
      return;
    }
  }
  
  public void attach(Linker paramLinker) {}
  
  public boolean dependedOn()
  {
    return (bits & 0x10) != 0;
  }
  
  public T get()
  {
    throw new UnsupportedOperationException("No injectable constructor on " + getClass().getName());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2) {}
  
  public void injectMembers(T paramT) {}
  
  public boolean isCycleFree()
  {
    return (bits & 0x8) != 0;
  }
  
  public boolean isLinked()
  {
    return (bits & 0x2) != 0;
  }
  
  boolean isSingleton()
  {
    return (bits & 0x1) != 0;
  }
  
  public boolean isVisiting()
  {
    return (bits & 0x4) != 0;
  }
  
  public boolean library()
  {
    return (bits & 0x20) != 0;
  }
  
  public void setCycleFree(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = bits | 0x8;; i = bits & 0xFFFFFFF7)
    {
      bits = i;
      return;
    }
  }
  
  public void setDependedOn(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = bits | 0x10;; i = bits & 0xFFFFFFEF)
    {
      bits = i;
      return;
    }
  }
  
  public void setLibrary(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = bits | 0x20;; i = bits & 0xFFFFFFDF)
    {
      bits = i;
      return;
    }
  }
  
  void setLinked()
  {
    bits |= 0x2;
  }
  
  public void setVisiting(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = bits | 0x4;; i = bits & 0xFFFFFFFB)
    {
      bits = i;
      return;
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[provideKey=\"" + provideKey + "\", memberskey=\"" + membersKey + "\"]";
  }
  
  public static class InvalidBindingException
    extends RuntimeException
  {
    public final String type;
    
    public InvalidBindingException(String paramString1, String paramString2)
    {
      super();
      type = paramString1;
    }
  }
}

/* Location:
 * Qualified Name:     dagger.internal.Binding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */