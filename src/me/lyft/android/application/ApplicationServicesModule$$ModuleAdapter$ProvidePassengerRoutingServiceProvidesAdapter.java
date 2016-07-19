package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRoutingService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRoutingServiceProvidesAdapter
  extends ProvidesBinding<IPassengerRoutingService>
{
  private Binding<IDirectionsService> directionsService;
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerRoutingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.passenger.IPassengerRoutingService", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRoutingService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    directionsService = paramLinker.requestBinding("@javax.inject.Named(value=passenger)/me.lyft.android.application.geo.IDirectionsService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPassengerRoutingService get()
  {
    return module.providePassengerRoutingService((IPassengerRideProvider)passengerRideProvider.get(), (IDirectionsService)directionsService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(passengerRideProvider);
    paramSet1.add(directionsService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerRoutingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */