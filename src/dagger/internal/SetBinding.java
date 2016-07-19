package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class SetBinding<T>
  extends Binding<Set<T>>
{
  private final List<Binding<?>> contributors;
  private final SetBinding<T> parent;
  
  public SetBinding(SetBinding<T> paramSetBinding)
  {
    super(provideKey, null, false, requiredBy);
    parent = paramSetBinding;
    setLibrary(paramSetBinding.library());
    setDependedOn(paramSetBinding.dependedOn());
    contributors = new ArrayList();
  }
  
  public SetBinding(String paramString, Object paramObject)
  {
    super(paramString, null, false, paramObject);
    parent = null;
    contributors = new ArrayList();
  }
  
  public static <T> void add(BindingsGroup paramBindingsGroup, String paramString, Binding<?> paramBinding)
  {
    prepareSetBindingcontributors.add(Linker.scope(paramBinding));
  }
  
  private static <T> SetBinding<T> prepareSetBinding(BindingsGroup paramBindingsGroup, String paramString, Binding<?> paramBinding)
  {
    Object localObject = paramBindingsGroup.get(paramString);
    if ((localObject instanceof SetBinding))
    {
      paramBindingsGroup = (SetBinding)localObject;
      if ((paramBindingsGroup.library()) && (paramBinding.library())) {}
      for (boolean bool = true;; bool = false)
      {
        paramBindingsGroup.setLibrary(bool);
        return paramBindingsGroup;
      }
    }
    if (localObject != null) {
      throw new IllegalArgumentException("Duplicate:\n    " + localObject + "\n    " + paramBinding);
    }
    localObject = new SetBinding(paramString, requiredBy);
    ((SetBinding)localObject).setLibrary(paramBinding.library());
    paramBindingsGroup.contributeSetBinding(paramString, (SetBinding)localObject);
    return (SetBinding)paramBindingsGroup.get(paramString);
  }
  
  public void attach(Linker paramLinker)
  {
    Iterator localIterator = contributors.iterator();
    while (localIterator.hasNext()) {
      ((Binding)localIterator.next()).attach(paramLinker);
    }
  }
  
  public Set<T> get()
  {
    ArrayList localArrayList = new ArrayList();
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = parent)
    {
      int i = 0;
      int j = contributors.size();
      if (i < j)
      {
        Binding localBinding = (Binding)contributors.get(i);
        Object localObject = localBinding.get();
        if (provideKey.equals(provideKey)) {
          localArrayList.addAll((Set)localObject);
        }
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(localObject);
        }
      }
    }
    return Collections.unmodifiableSet(new LinkedHashSet(localArrayList));
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    for (paramSet2 = this; paramSet2 != null; paramSet2 = parent) {
      paramSet1.addAll(contributors);
    }
  }
  
  public void injectMembers(Set<T> paramSet)
  {
    throw new UnsupportedOperationException("Cannot inject members on a contributed Set<T>.");
  }
  
  public int size()
  {
    int i = 0;
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = parent) {
      i += contributors.size();
    }
    return i;
  }
  
  public String toString()
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder("SetBinding[");
    for (SetBinding localSetBinding = this; localSetBinding != null; localSetBinding = parent)
    {
      int i = 0;
      int k = contributors.size();
      while (i < k)
      {
        if (j == 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(contributors.get(i));
        j = 0;
        i += 1;
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     dagger.internal.SetBinding
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */