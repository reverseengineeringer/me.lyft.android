package dagger.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BindingsGroup
{
  private final Map<String, Binding<?>> bindings = new LinkedHashMap();
  
  public Binding<?> contributeProvidesBinding(String paramString, ProvidesBinding<?> paramProvidesBinding)
  {
    return put(paramString, paramProvidesBinding);
  }
  
  public abstract Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding);
  
  public final Set<Map.Entry<String, Binding<?>>> entrySet()
  {
    return bindings.entrySet();
  }
  
  public Binding<?> get(String paramString)
  {
    return (Binding)bindings.get(paramString);
  }
  
  protected Binding<?> put(String paramString, Binding<?> paramBinding)
  {
    Binding localBinding = (Binding)bindings.put(paramString, paramBinding);
    if (localBinding != null)
    {
      bindings.put(paramString, localBinding);
      throw new IllegalArgumentException("Duplicate:\n    " + localBinding + "\n    " + paramBinding);
    }
    return null;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + bindings.toString();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.BindingsGroup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */