package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.riderequest.IRideRequestPollingService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestPollingServiceProvidesAdapter
  extends ProvidesBinding<IRideRequestPollingService>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<ICostService> costService;
  private Binding<ILyftPreferences> lyftPreferences;
  private final ApplicationServicesModule module;
  private Binding<INearbyDriversService> nearbyDriversService;
  private Binding<IPickupEtaService> pickupEtaService;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IRequestRideTypeService> rideTypeService;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRideRequestPollingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.riderequest.IRideRequestPollingService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestPollingService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    pickupEtaService = paramLinker.requestBinding("me.lyft.android.application.eta.IPickupEtaService", ApplicationServicesModule.class, getClass().getClassLoader());
    nearbyDriversService = paramLinker.requestBinding("me.lyft.android.application.drivers.INearbyDriversService", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    rideTypeService = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", ApplicationServicesModule.class, getClass().getClassLoader());
    costService = paramLinker.requestBinding("me.lyft.android.application.cost.ICostService", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IRideRequestPollingService get()
  {
    return module.provideRideRequestPollingService((IAppForegroundDetector)appForegroundDetector.get(), (ILyftPreferences)lyftPreferences.get(), (IPickupEtaService)pickupEtaService.get(), (INearbyDriversService)nearbyDriversService.get(), (IRideRequestSession)rideRequestSession.get(), (IRequestRideTypeService)rideTypeService.get(), (ICostService)costService.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(appForegroundDetector);
    paramSet1.add(lyftPreferences);
    paramSet1.add(pickupEtaService);
    paramSet1.add(nearbyDriversService);
    paramSet1.add(rideRequestSession);
    paramSet1.add(rideTypeService);
    paramSet1.add(costService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRideRequestPollingServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */