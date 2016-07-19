package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRoutingService;
import me.lyft.android.application.passenger.IPassengerZoomProvider;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePassengerZoomProviderProvidesAdapter
  extends ProvidesBinding<IPassengerZoomProvider>
{
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IPassengerRoutingService> passengerRoutingService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePassengerZoomProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.passenger.IPassengerZoomProvider", true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerZoomProvider");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    passengerRoutingService = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRoutingService", ApplicationServicesModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IPassengerZoomProvider get()
  {
    return module.providePassengerZoomProvider((IPassengerRoutingService)passengerRoutingService.get(), (IPassengerRideProvider)passengerRideProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(passengerRoutingService);
    paramSet1.add(passengerRideProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePassengerZoomProviderProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */