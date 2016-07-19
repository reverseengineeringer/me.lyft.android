package me.lyft.android.infrastructure.instabug;

import dagger.internal.ProvidesBinding;

public final class InstabugModule$$ModuleAdapter$ProvideIInstabugServiceProvidesAdapter
  extends ProvidesBinding<IInstabugService>
{
  private final InstabugModule module;
  
  public InstabugModule$$ModuleAdapter$ProvideIInstabugServiceProvidesAdapter(InstabugModule paramInstabugModule)
  {
    super("me.lyft.android.infrastructure.instabug.IInstabugService", true, "me.lyft.android.infrastructure.instabug.InstabugModule", "provideIInstabugService");
    module = paramInstabugModule;
    setLibrary(true);
  }
  
  public IInstabugService get()
  {
    return module.provideIInstabugService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.instabug.InstabugModule..ModuleAdapter.ProvideIInstabugServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */