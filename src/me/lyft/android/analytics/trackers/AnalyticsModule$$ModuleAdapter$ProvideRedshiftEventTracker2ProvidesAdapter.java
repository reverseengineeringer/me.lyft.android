package me.lyft.android.analytics.trackers;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.IAnalyticsRideInfoProvider;
import me.lyft.android.analytics.session.AnalyticsSession;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;

public final class AnalyticsModule$$ModuleAdapter$ProvideRedshiftEventTracker2ProvidesAdapter
  extends ProvidesBinding<RealTimeEventTracker>
{
  private Binding<AnalyticsApi> analyticsApi;
  private Binding<IAnalyticsRideInfoProvider> analyticsRideInfoProvider;
  private Binding<AnalyticsSession> analyticsSession;
  private Binding<IAppForegroundDetector> appForegroundDetector;
  private Binding<IDevice> device;
  private Binding<ILocationService> locationService;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AnalyticsModule module;
  private Binding<IRideRequestSession> rideRequestSession;
  private Binding<IUserProvider> userProvider;
  private Binding<IUserUiService> userService;
  
  public AnalyticsModule$$ModuleAdapter$ProvideRedshiftEventTracker2ProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.trackers.RealTimeEventTracker", false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideRedshiftEventTracker2");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    analyticsApi = paramLinker.requestBinding("me.lyft.android.analytics.trackers.AnalyticsApi", AnalyticsModule.class, getClass().getClassLoader());
    analyticsSession = paramLinker.requestBinding("me.lyft.android.analytics.session.AnalyticsSession", AnalyticsModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", AnalyticsModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AnalyticsModule.class, getClass().getClassLoader());
    userService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AnalyticsModule.class, getClass().getClassLoader());
    rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", AnalyticsModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
    appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", AnalyticsModule.class, getClass().getClassLoader());
    analyticsRideInfoProvider = paramLinker.requestBinding("me.lyft.android.analytics.IAnalyticsRideInfoProvider", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public RealTimeEventTracker get()
  {
    return module.provideRedshiftEventTracker2((AnalyticsApi)analyticsApi.get(), (AnalyticsSession)analyticsSession.get(), (ILyftPreferences)lyftPreferences.get(), (ILocationService)locationService.get(), (IUserProvider)userProvider.get(), (IUserUiService)userService.get(), (IRideRequestSession)rideRequestSession.get(), (IDevice)device.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IAnalyticsRideInfoProvider)analyticsRideInfoProvider.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(analyticsApi);
    paramSet1.add(analyticsSession);
    paramSet1.add(lyftPreferences);
    paramSet1.add(locationService);
    paramSet1.add(userProvider);
    paramSet1.add(userService);
    paramSet1.add(rideRequestSession);
    paramSet1.add(device);
    paramSet1.add(appForegroundDetector);
    paramSet1.add(analyticsRideInfoProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideRedshiftEventTracker2ProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */