package dagger.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public final class Linker
{
  static final Object UNINITIALIZED = new Object();
  private boolean attachSuccess = true;
  private final Linker base;
  private final Map<String, Binding<?>> bindings = new HashMap();
  private final ErrorHandler errorHandler;
  private final List<String> errors = new ArrayList();
  private volatile Map<String, Binding<?>> linkedBindings = null;
  private final Loader plugin;
  private final Queue<Binding<?>> toLink = new ArrayQueue();
  
  public Linker(Linker paramLinker, Loader paramLoader, ErrorHandler paramErrorHandler)
  {
    if (paramLoader == null) {
      throw new NullPointerException("plugin");
    }
    if (paramErrorHandler == null) {
      throw new NullPointerException("errorHandler");
    }
    base = paramLinker;
    plugin = paramLoader;
    errorHandler = paramErrorHandler;
  }
  
  private void addError(String paramString)
  {
    errors.add(paramString);
  }
  
  private void assertLockHeld()
  {
    if (!Thread.holdsLock(this)) {
      throw new AssertionError();
    }
  }
  
  private Binding<?> createBinding(String paramString, Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean)
  {
    String str = Keys.getBuiltInBindingsKey(paramString);
    if (str != null) {
      paramObject = new BuiltInBinding(paramString, paramObject, paramClassLoader, str);
    }
    do
    {
      return (Binding<?>)paramObject;
      str = Keys.getLazyKey(paramString);
      if (str != null) {
        return new LazyBinding(paramString, paramObject, paramClassLoader, str);
      }
      str = Keys.getClassName(paramString);
      if (str == null) {
        throw new Binding.InvalidBindingException(paramString, "is a generic class or an array and can only be bound with concrete type parameter(s) in a @Provides method.");
      }
      if (Keys.isAnnotated(paramString)) {
        throw new Binding.InvalidBindingException(paramString, "is a @Qualifier-annotated type and must be bound by a @Provides method.");
      }
      paramClassLoader = plugin.getAtInjectBinding(paramString, str, paramClassLoader, paramBoolean);
      paramObject = paramClassLoader;
    } while (paramClassLoader != null);
    throw new Binding.InvalidBindingException(str, "could not be bound with key " + paramString);
  }
  
  private <T> void putBinding(Binding<T> paramBinding)
  {
    if (provideKey != null) {
      putIfAbsent(bindings, provideKey, paramBinding);
    }
    if (membersKey != null) {
      putIfAbsent(bindings, membersKey, paramBinding);
    }
  }
  
  private <K, V> void putIfAbsent(Map<K, V> paramMap, K paramK, V paramV)
  {
    paramV = paramMap.put(paramK, paramV);
    if (paramV != null) {
      paramMap.put(paramK, paramV);
    }
  }
  
  static <T> Binding<T> scope(Binding<T> paramBinding)
  {
    if ((!paramBinding.isSingleton()) || ((paramBinding instanceof SingletonBinding))) {
      return paramBinding;
    }
    return new SingletonBinding(paramBinding);
  }
  
  public Map<String, Binding<?>> fullyLinkedBindings()
  {
    return linkedBindings;
  }
  
  public void installBindings(BindingsGroup paramBindingsGroup)
  {
    if (linkedBindings != null) {
      throw new IllegalStateException("Cannot install further bindings after calling linkAll().");
    }
    paramBindingsGroup = paramBindingsGroup.entrySet().iterator();
    while (paramBindingsGroup.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramBindingsGroup.next();
      bindings.put(localEntry.getKey(), scope((Binding)localEntry.getValue()));
    }
  }
  
  public Map<String, Binding<?>> linkAll()
  {
    assertLockHeld();
    if (linkedBindings != null) {
      return linkedBindings;
    }
    Iterator localIterator = bindings.values().iterator();
    while (localIterator.hasNext())
    {
      Binding localBinding = (Binding)localIterator.next();
      if (!localBinding.isLinked()) {
        toLink.add(localBinding);
      }
    }
    linkRequested();
    linkedBindings = Collections.unmodifiableMap(bindings);
    return linkedBindings;
  }
  
  public void linkRequested()
  {
    assertLockHeld();
    for (;;)
    {
      Binding localBinding1 = (Binding)toLink.poll();
      if (localBinding1 == null) {
        break;
      }
      if ((localBinding1 instanceof DeferredBinding))
      {
        Object localObject2 = (DeferredBinding)localBinding1;
        String str = deferredKey;
        boolean bool = mustHaveInjections;
        if (!bindings.containsKey(str)) {
          try
          {
            localObject2 = createBinding(str, requiredBy, classLoader, bool);
            ((Binding)localObject2).setLibrary(localBinding1.library());
            ((Binding)localObject2).setDependedOn(localBinding1.dependedOn());
            if ((!str.equals(provideKey)) && (!str.equals(membersKey))) {
              throw new IllegalStateException("Unable to create binding for " + str);
            }
          }
          catch (Binding.InvalidBindingException localInvalidBindingException)
          {
            addError(type + " " + localInvalidBindingException.getMessage() + " required by " + requiredBy);
            bindings.put(str, Binding.UNRESOLVED);
            continue;
            Binding localBinding2 = scope(localInvalidBindingException);
            toLink.add(localBinding2);
            putBinding(localBinding2);
          }
          catch (UnsupportedOperationException localUnsupportedOperationException)
          {
            addError("Unsupported: " + localUnsupportedOperationException.getMessage() + " required by " + requiredBy);
            bindings.put(str, Binding.UNRESOLVED);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            addError(localIllegalArgumentException.getMessage() + " required by " + requiredBy);
            bindings.put(str, Binding.UNRESOLVED);
          }
          catch (RuntimeException localRuntimeException)
          {
            throw localRuntimeException;
          }
          catch (Exception localException)
          {
            throw new RuntimeException(localException);
          }
        }
      }
      else
      {
        attachSuccess = true;
        localException.attach(this);
        if (attachSuccess) {
          localException.setLinked();
        } else {
          toLink.add(localException);
        }
      }
    }
    try
    {
      errorHandler.handleErrors(errors);
      return;
    }
    finally
    {
      errors.clear();
    }
  }
  
  @Deprecated
  public Binding<?> requestBinding(String paramString, Object paramObject)
  {
    return requestBinding(paramString, paramObject, getClass().getClassLoader(), true, true);
  }
  
  public Binding<?> requestBinding(String paramString, Object paramObject, ClassLoader paramClassLoader)
  {
    return requestBinding(paramString, paramObject, paramClassLoader, true, true);
  }
  
  public Binding<?> requestBinding(String paramString, Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    assertLockHeld();
    Binding localBinding1 = null;
    Binding localBinding2;
    for (Linker localLinker = this;; localLinker = base)
    {
      localBinding2 = localBinding1;
      if (localLinker == null) {
        break;
      }
      localBinding1 = (Binding)bindings.get(paramString);
      if (localBinding1 != null)
      {
        localBinding2 = localBinding1;
        if (localLinker == this) {
          break;
        }
        localBinding2 = localBinding1;
        if (localBinding1.isLinked()) {
          break;
        }
        throw new AssertionError();
      }
    }
    if (localBinding2 == null)
    {
      paramString = new DeferredBinding(paramString, paramClassLoader, paramObject, paramBoolean1);
      paramString.setLibrary(paramBoolean2);
      paramString.setDependedOn(true);
      toLink.add(paramString);
      attachSuccess = false;
      return null;
    }
    if (!localBinding2.isLinked()) {
      toLink.add(localBinding2);
    }
    localBinding2.setLibrary(paramBoolean2);
    localBinding2.setDependedOn(true);
    return localBinding2;
  }
  
  @Deprecated
  public Binding<?> requestBinding(String paramString, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    return requestBinding(paramString, paramObject, getClass().getClassLoader(), paramBoolean1, paramBoolean2);
  }
  
  private static class DeferredBinding
    extends Binding<Object>
  {
    final ClassLoader classLoader;
    final String deferredKey;
    final boolean mustHaveInjections;
    
    DeferredBinding(String paramString, ClassLoader paramClassLoader, Object paramObject, boolean paramBoolean)
    {
      super(null, false, paramObject);
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
  
  public static abstract interface ErrorHandler
  {
    public static final ErrorHandler NULL = new ErrorHandler()
    {
      public void handleErrors(List<String> paramAnonymousList) {}
    };
    
    public abstract void handleErrors(List<String> paramList);
  }
  
  private static class SingletonBinding<T>
    extends Binding<T>
  {
    private final Binding<T> binding;
    private volatile Object onlyInstance = Linker.UNINITIALIZED;
    
    SingletonBinding(Binding<T> paramBinding)
    {
      super(membersKey, true, requiredBy);
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
}

/* Location:
 * Qualified Name:     dagger.internal.Linker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */