package me.lyft.android.application;

import dagger.internal.ProvidesBinding;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideUserProviderProvidesAdapter
  extends ProvidesBinding<IUserProvider>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideUserProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.IUserProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideUserProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IUserProvider get()
  {
    return module.provideUserProvider();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideUserProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */