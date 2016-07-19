package me.lyft.android.common;

import dagger.internal.ProvidesBinding;

public final class CommonModule$$ModuleAdapter$ProvideActivityControllerProvidesAdapter
  extends ProvidesBinding<ActivityController>
{
  private final CommonModule module;
  
  public CommonModule$$ModuleAdapter$ProvideActivityControllerProvidesAdapter(CommonModule paramCommonModule)
  {
    super("me.lyft.android.common.ActivityController", true, "me.lyft.android.common.CommonModule", "provideActivityController");
    module = paramCommonModule;
    setLibrary(true);
  }
  
  public ActivityController get()
  {
    return module.provideActivityController();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.CommonModule..ModuleAdapter.ProvideActivityControllerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */