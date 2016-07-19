package me.lyft.android.application;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;

public final class ApplicationServicesModule$$ModuleAdapter$ProvideRouteServiceProvidesAdapter
  extends ProvidesBinding<IDriverRouteService>
{
  private Binding<IDeferredCallService> deferredCallService;
  private Binding<IFeaturesProvider> featuresProvider;
  private Binding<IGooglePlaceService> googlePlaceService;
  private Binding<ILocationService> locationService;
  private Binding<ILyftApi> lyftApi;
  private final ApplicationServicesModule module;
  private Binding<IRatingSession> ratingSession;
  private Binding<IDriverRideProvider> routeProvider;
  private Binding<IUserDispatchService> userModeService;
  private Binding<IUserProvider> userProvider;
  
  public ApplicationServicesModule$$ModuleAdapter$ProvideRouteServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
  {
    super("me.lyft.android.application.ride.IDriverRouteService", true, "me.lyft.android.application.ApplicationServicesModule", "provideRouteService");
    module = paramApplicationServicesModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    routeProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    googlePlaceService = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplaces.IGooglePlaceService", ApplicationServicesModule.class, getClass().getClassLoader());
    ratingSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRatingSession", ApplicationServicesModule.class, getClass().getClassLoader());
    userModeService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserDispatchService", ApplicationServicesModule.class, getClass().getClassLoader());
    deferredCallService = paramLinker.requestBinding("me.lyft.android.infrastructure.deferred.IDeferredCallService", ApplicationServicesModule.class, getClass().getClassLoader());
    featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", ApplicationServicesModule.class, getClass().getClassLoader());
  }
  
  public IDriverRouteService get()
  {
    return module.provideRouteService((ILyftApi)lyftApi.get(), (IDriverRideProvider)routeProvider.get(), (ILocationService)locationService.get(), (IUserProvider)userProvider.get(), (IGooglePlaceService)googlePlaceService.get(), (IRatingSession)ratingSession.get(), (IUserDispatchService)userModeService.get(), (IDeferredCallService)deferredCallService.get(), (IFeaturesProvider)featuresProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(lyftApi);
    paramSet1.add(routeProvider);
    paramSet1.add(locationService);
    paramSet1.add(userProvider);
    paramSet1.add(googlePlaceService);
    paramSet1.add(ratingSession);
    paramSet1.add(userModeService);
    paramSet1.add(deferredCallService);
    paramSet1.add(featuresProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter.ProvideRouteServiceProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */