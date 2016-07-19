package me.lyft.android.common;

import dagger.internal.ProvidesBinding;

public final class CommonModule$$ModuleAdapter$ProvideAppFlowProvidesAdapter
  extends ProvidesBinding<AppFlow>
{
  private final CommonModule module;
  
  public CommonModule$$ModuleAdapter$ProvideAppFlowProvidesAdapter(CommonModule paramCommonModule)
  {
    super("me.lyft.android.common.AppFlow", true, "me.lyft.android.common.CommonModule", "provideAppFlow");
    module = paramCommonModule;
    setLibrary(true);
  }
  
  public AppFlow get()
  {
    return module.provideAppFlow();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter.ProvideAppFlowProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */