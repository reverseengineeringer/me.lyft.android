package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.driver.IDriverDestinationService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideDriverDestinationServiceProvidesAdapter
  extends ProvidesBinding<IDriverDestinationService>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideDriverDestinationServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.driver.IDriverDestinationService", true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDestinationService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IDriverDestinationService get()
  {
    return module.provideDriverDestinationService();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideDriverDestinationServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */