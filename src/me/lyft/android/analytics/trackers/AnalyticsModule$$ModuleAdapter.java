package me.lyft.android.analytics.trackers;

import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.IAnalyticsRideInfoProvider;
import me.lyft.android.analytics.session.AnalyticsSession;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.IAppStore;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.providers.AdvertisingIdProvider;

public final class AnalyticsModule$$ModuleAdapter
  extends ModuleAdapter<AnalyticsModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public AnalyticsModule$$ModuleAdapter()
  {
    super(AnalyticsModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, AnalyticsModule paramAnalyticsModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.trackers.AnalyticsApi", new ProvideAnalyticsApiProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.trackers.IAnalyticsService", new ProvideAnalyticsInitializerProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.session.AnalyticsSession", new ProvideAnalyticsSessionProviderProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.trackers.RealTimeEventTracker", new ProvideRedshiftEventTracker2ProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.IAnalyticsRideInfoProvider", new ProvideAnalitycsRideInfoProviderProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.trackers.AppEventTracker", new ProvideAppEventTrackerProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("com.mobileapptracker.MobileAppTracker", new ProvideMobileAppTrackerProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("com.kochava.android.tracker.Feature", new ProvideKochavaAnalyticsProvidesAdapter(paramAnalyticsModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.trackers.LogEventTracker", new ProvideLogEventTrackerProvidesAdapter(paramAnalyticsModule));
  }
  
  public AnalyticsModule newModule()
  {
    return new AnalyticsModule();
  }
  
  public static final class ProvideAnalitycsRideInfoProviderProvidesAdapter
    extends ProvidesBinding<IAnalyticsRideInfoProvider>
  {
    private Binding<IDriverRideProvider> driverRideProvider;
    private final AnalyticsModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    private Binding<IUserProvider> userProvider;
    
    public ProvideAnalitycsRideInfoProviderProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalitycsRideInfoProvider");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AnalyticsModule.class, getClass().getClassLoader());
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", AnalyticsModule.class, getClass().getClassLoader());
      driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public IAnalyticsRideInfoProvider get()
    {
      return module.provideAnalitycsRideInfoProvider((IUserProvider)userProvider.get(), (IPassengerRideProvider)passengerRideProvider.get(), (IDriverRideProvider)driverRideProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(passengerRideProvider);
      paramSet1.add(driverRideProvider);
    }
  }
  
  public static final class ProvideAnalyticsApiProvidesAdapter
    extends ProvidesBinding<AnalyticsApi>
  {
    private Binding<LyftApplication> appContext;
    private Binding<IDeveloperTools> developerTools;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILyftPreferences> lyftPreferences;
    private final AnalyticsModule module;
    
    public ProvideAnalyticsApiProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsApi");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appContext = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AnalyticsModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
      developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public AnalyticsApi get()
    {
      return module.provideAnalyticsApi((LyftApplication)appContext.get(), (IJsonSerializer)jsonSerializer.get(), (ILyftPreferences)lyftPreferences.get(), (IDeveloperTools)developerTools.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appContext);
      paramSet1.add(jsonSerializer);
      paramSet1.add(lyftPreferences);
      paramSet1.add(developerTools);
    }
  }
  
  public static final class ProvideAnalyticsInitializerProvidesAdapter
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
    
    public ProvideAnalyticsInitializerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsInitializer");
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
  
  public static final class ProvideAnalyticsSessionProviderProvidesAdapter
    extends ProvidesBinding<AnalyticsSession>
  {
    private Binding<IDevice> device;
    private Binding<ILyftPreferences> lyftPreferences;
    private final AnalyticsModule module;
    
    public ProvideAnalyticsSessionProviderProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAnalyticsSessionProvider");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public AnalyticsSession get()
    {
      return module.provideAnalyticsSessionProvider((ILyftPreferences)lyftPreferences.get(), (IDevice)device.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftPreferences);
      paramSet1.add(device);
    }
  }
  
  public static final class ProvideAppEventTrackerProvidesAdapter
    extends ProvidesBinding<AppEventTracker>
  {
    private Binding<AdvertisingIdProvider> advertisingIdProvider;
    private Binding<IDevice> device;
    private Binding<Feature> feature;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILyftPreferences> lyftPreferences;
    private Binding<MobileAppTracker> mobileAppTracker;
    private final AnalyticsModule module;
    
    public ProvideAppEventTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideAppEventTracker");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      feature = paramLinker.requestBinding("com.kochava.android.tracker.Feature", AnalyticsModule.class, getClass().getClassLoader());
      mobileAppTracker = paramLinker.requestBinding("com.mobileapptracker.MobileAppTracker", AnalyticsModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AnalyticsModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AnalyticsModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
      advertisingIdProvider = paramLinker.requestBinding("me.lyft.android.providers.AdvertisingIdProvider", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public AppEventTracker get()
    {
      return module.provideAppEventTracker((Feature)feature.get(), (MobileAppTracker)mobileAppTracker.get(), (IJsonSerializer)jsonSerializer.get(), (IDevice)device.get(), (ILyftPreferences)lyftPreferences.get(), (AdvertisingIdProvider)advertisingIdProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(feature);
      paramSet1.add(mobileAppTracker);
      paramSet1.add(jsonSerializer);
      paramSet1.add(device);
      paramSet1.add(lyftPreferences);
      paramSet1.add(advertisingIdProvider);
    }
  }
  
  public static final class ProvideKochavaAnalyticsProvidesAdapter
    extends ProvidesBinding<Feature>
  {
    private Binding<LyftApplication> lyftApplication;
    private final AnalyticsModule module;
    
    public ProvideKochavaAnalyticsProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideKochavaAnalytics");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public Feature get()
    {
      return module.provideKochavaAnalytics((LyftApplication)lyftApplication.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
    }
  }
  
  public static final class ProvideLogEventTrackerProvidesAdapter
    extends ProvidesBinding<LogEventTracker>
  {
    private final AnalyticsModule module;
    
    public ProvideLogEventTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideLogEventTracker");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public LogEventTracker get()
    {
      return module.provideLogEventTracker();
    }
  }
  
  public static final class ProvideMobileAppTrackerProvidesAdapter
    extends ProvidesBinding<MobileAppTracker>
  {
    private Binding<IAppStore> appStore;
    private Binding<LyftApplication> lyftApplication;
    private Binding<ILyftPreferences> lyftPreferences;
    private final AnalyticsModule module;
    
    public ProvideMobileAppTrackerProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(true, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideMobileAppTracker");
      module = paramAnalyticsModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AnalyticsModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AnalyticsModule.class, getClass().getClassLoader());
      appStore = paramLinker.requestBinding("me.lyft.android.common.IAppStore", AnalyticsModule.class, getClass().getClassLoader());
    }
    
    public MobileAppTracker get()
    {
      return module.provideMobileAppTracker((LyftApplication)lyftApplication.get(), (ILyftPreferences)lyftPreferences.get(), (IAppStore)appStore.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(lyftPreferences);
      paramSet1.add(appStore);
    }
  }
  
  public static final class ProvideRedshiftEventTracker2ProvidesAdapter
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
    
    public ProvideRedshiftEventTracker2ProvidesAdapter(AnalyticsModule paramAnalyticsModule)
    {
      super(false, "me.lyft.android.analytics.trackers.AnalyticsModule", "provideRedshiftEventTracker2");
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
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */