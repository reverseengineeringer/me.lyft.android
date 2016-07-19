package me.lyft.android.application;

import dagger.internal.ProvidesBinding;
import me.lyft.android.application.ride.IDriverRideProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRouteProviderProvidesAdapter
  extends ProvidesBinding<IDriverRideProvider>
{
  private final ApplicationServicesModule module;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRouteProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IDriverRideProvider", true, "me.lyft.android.application.ApplicationServicesModule", "provideRouteProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public IDriverRideProvider get()
  {
    return module.provideRouteProvider();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRouteProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */