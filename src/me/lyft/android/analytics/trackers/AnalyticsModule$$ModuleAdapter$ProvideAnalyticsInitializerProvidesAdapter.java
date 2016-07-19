package me.lyft.android.analytics.trackers;

import dagger.internal.Binding;
import dagger.internal.Linker;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.infrastructure.device.IDevice;

public final class AnalyticsModule$$ModuleAdapter$ProvideAnalyticsInitializerProvidesAdapter
  extends ProvidesBinding<IAnalyticsService>
{
  private Binding<AnalyticsApi> analyticsApi;
  private Binding<AppEventTracker> appEventTracker;
  private Binding<IDevice> device;
  private Binding<LogEventTracker> logEventTracker;
  private Binding<ILyftPreferences> lyftPreferences;
  private final AnalyticsModule module;
  private Binding<RealTimeEventTracker> realTimeEventTracker;
  private Binding<IUserProvider> userProvider;
  private Binding<IUserUiService> userUiService;
  
  public AnalyticsModule$$ModuleAdapter$ProvideAnalyticsInitializerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
  {
    super("me.lyft.android.analytics.trackers.IAnalyticsService", true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsInitializer");
    module = paramAnalyticsModule;
    setLibrary(true);
  }
  
  public void attach(Linker paramLinker)
  {
    analyticsApi = paramLinker.requestBinding("me.lyft.android.analytics.trackers.AnalyticsApi", AnalyticsModule.class, getClass().getClassLoader());
    device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
    userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AnalyticsModule.class, getClass().getClassLoader());
    userUiService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AnalyticsModule.class, getClass().getClassLoader());
    lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
    appEventTracker = paramLinker.requestBinding("me.lyft.android.analytics.trackers.AppEventTracker", AnalyticsModule.class, getClass().getClassLoader());
    logEventTracker = paramLinker.requestBinding("me.lyft.android.analytics.trackers.LogEventTracker", AnalyticsModule.class, getClass().getClassLoader());
    realTimeEventTracker = paramLinker.requestBinding("me.lyft.android.analytics.trackers.RealTimeEventTracker", AnalyticsModule.class, getClass().getClassLoader());
  }
  
  public IAnalyticsService get()
  {
    return module.provideAnalyticsInitializer((AnalyticsApi)analyticsApi.get(), (IDevice)device.get(), (IUserProvider)userProvider.get(), (IUserUiService)userUiService.get(), (ILyftPreferences)lyftPreferences.get(), (AppEventTracker)appEventTracker.get(), (LogEventTracker)logEventTracker.get(), (RealTimeEventTracker)realTimeEventTracker.get());
  }
  
  public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
  {
    paramSet1.add(analyticsApi);
    paramSet1.add(device);
    paramSet1.add(userProvider);
    paramSet1.add(userUiService);
    paramSet1.add(lyftPreferences);
    paramSet1.add(appEventTracker);
    paramSet1.add(logEventTracker);
    paramSet1.add(realTimeEventTracker);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter.ProvideAnalyticsInitializerProvidesAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */