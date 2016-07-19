package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IFollowLocationManager;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.location.ILocationService;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideFollowLocationManagerProvidesAdapter
  extends ProvidesBinding<IFollowLocationManager>
{
  private Binding<ILocationService> locationService;
  private final ApplicationServicesModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideFollowLocationManagerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IFollowLocationManager", true, "me.lyft.android.application.ApplicationServicesModule", "provideFollowLocationManager");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IFollowLocationManager get()
  {
    return module.provideFollowLocationManager((ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(locationService);
    paramSet1.add(rideRequestSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideFollowLocationManagerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */