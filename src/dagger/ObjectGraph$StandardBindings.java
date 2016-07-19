package dagger;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.SetBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ObjectGraph$StandardBindings
  extends BindingsGroup
{
  private final List<SetBinding<?>> setBindings;
  
  public ObjectGraph$StandardBindings()
  {
    setBindings = new ArrayList();
  }
  
  public ObjectGraph$StandardBindings(List<SetBinding<?>> paramList)
  {
    setBindings = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SetBinding localSetBinding = new SetBinding((SetBinding)paramList.next());
      setBindings.add(localSetBinding);
      put(provideKey, localSetBinding);
    }
  }
  
  public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
  {
    setBindings.add(paramSetBinding);
    return super.put(paramString, paramSetBinding);
  }
}

/* Location:
 * Qualified Name:     dagger.ObjectGraph.StandardBindings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */