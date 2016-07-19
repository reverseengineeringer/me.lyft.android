package dagger;

import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.SetBinding;

final class ObjectGraph$OverridesBindings
  extends BindingsGroup
{
  public Binding<?> contributeSetBinding(String paramString, SetBinding<?> paramSetBinding)
  {
    throw new IllegalArgumentException("Module overrides cannot contribute set bindings.");
  }
}

/* Location:
 * Qualified Name:     dagger.ObjectGraph.OverridesBindings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */