package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.passenger.IPassengerRideProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRideProviderProvidesAdapter
  extends ProvidesBinding<IPassengerRideProvider>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRideProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.passenger.IPassengerRideProvider", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRideProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IPassengerRideProvider get()
  {
    return module.providePassengerRideProvider();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerRideProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */