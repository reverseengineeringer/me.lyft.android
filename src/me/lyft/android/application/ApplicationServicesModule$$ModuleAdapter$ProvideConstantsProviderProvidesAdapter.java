package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.constants.IConstantsProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideConstantsProviderProvidesAdapter
  extends ProvidesBinding<IConstantsProvider>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideConstantsProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.constants.IConstantsProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideConstantsProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IConstantsProvider get()
  {
    return module.provideConstantsProvider();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideConstantsProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */