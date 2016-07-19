package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePickupVenueServiceProvidesAdapter
  extends ProvidesBinding<IVenuePickupService>
{
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePickupVenueServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.venue.IVenuePickupService", true, "me.lyft.android.application.ApplicationServicesModule", "providePickupVenueService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IVenuePickupService get()
  {
    return module.providePickupVenueService((ILyftApi)lyftApi.get(), (IRideRequestSession)rideRequestSession.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(rideRequestSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePickupVenueServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */