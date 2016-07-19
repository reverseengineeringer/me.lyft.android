package me.lyft.android.controls;

import dagger.internal.Binding;
import dagger.internal.Linker;
import java.util.Set;
import me.lyft.android.common.AppFlow;

public final class BackButtonToolbar$$InjectAdapter
  extends Binding<BackButtonToolbar>
{
  private Binding<AppFlow> appFlow;
  private Binding<Toolbar> supertype;
  
  public BackButtonToolbar$$InjectAdapter()
  {
    super(null, "members/me.lyft.android.controls.BackButtonToolbar", false, BackButtonToolbar.class);
  }
  
  public void attach(Linker paramLinker)
  {
    appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", BackButtonToolbar.class, getClass().getClassLoader());
    supertype = paramLinker.requestBinding("members/me.lyft.android.controls.Toolbar", BackButtonToolbar.class, getClass().getClassLoader(), false, true);
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet2.add(appFlow);
    paramSet2.add(supertype);
  }
  
  public void injectMembers(BackButtonToolbar paramBackButtonToolbar)
  {
    appFlow = ((AppFlow)appFlow.get());
    supertype.injectMembers(paramBackButtonToolbar);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.controls.BackButtonToolbar..InjectAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */