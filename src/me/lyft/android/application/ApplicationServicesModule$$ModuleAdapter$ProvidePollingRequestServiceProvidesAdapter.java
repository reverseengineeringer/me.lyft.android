package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvidePollingRequestServiceProvidesAdapter
  extends ProvidesBinding<ILocationUpdateService>
{
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<IAppInfoService> appInfoService;
  private Binding<IDriverRideProvider> driverRideProvider;
  private Binding<IEtaAnalyticService> etaAnalyticService;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IPassengerRideProvider> passengerRideProvider;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvidePollingRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.polling.ILocationUpdateService", true, "me.lyft.android.application.ApplicationServicesModule", "providePollingRequestService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    etaAnalyticService = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaAnalyticService", ApplicationServicesModule.class, getClass().getClassLoader());
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public ILocationUpdateService get()
  {
    return module.providePollingRequestService((ILocationService)locationService.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IRideRequestSession)rideRequestSession.get(), (IEtaAnalyticService)etaAnalyticService.get(), (ILyftApi)lyftApi.get(), (IAppInfoService)appInfoService.get(), (IUserProvider)userProvider.get(), (IDriverRideProvider)driverRideProvider.get(), (IPassengerRideProvider)passengerRideProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(locationService);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(rideRequestSession);
    paramSet1.add(etaAnalyticService);
    paramSet1.add(lyftApi);
    paramSet1.add(appInfoService);
    paramSet1.add(userProvider);
    paramSet1.add(driverRideProvider);
    paramSet1.add(passengerRideProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvidePollingRequestServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */