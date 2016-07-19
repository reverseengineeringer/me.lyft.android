package me.lyft.android;

import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.lyft.rx.MessageBus;
import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.analytics.trackers.AnalyticsModule;
import me.lyft.android.application.ApplicationServicesModule;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.features.FeaturesModule;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.system.ICountryRepository;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.CommonModule;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.data.ContactsDatabaseHelper;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.gcm.IGcmEventExecutor;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.infrastructure.InfrastructureServicesModule;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.navigation.NavigationModule;
import me.lyft.android.notifications.IStatusBarNotificationsService;
import me.lyft.android.persistence.PersistenceModule;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.services.HeatMapService;
import me.lyft.android.ui.MainActivityAnalytics;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.invites.SocialIntentProvider;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.utils.Telephony;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

public final class AppModule$$ModuleAdapter
  extends ModuleAdapter<AppModule>
{
  private static final Class<?>[] INCLUDES = { ApplicationServicesModule.class, InfrastructureServicesModule.class, PersistenceModule.class, CommonModule.class, AnalyticsModule.class, FeaturesModule.class, NavigationModule.class };
  private static final String[] INJECTS = { "members/me.lyft.android.LyftApplication", "members/me.lyft.android.ui.MainActivity", "members/me.lyft.android.services.GcmService", "members/me.lyft.android.services.GcmIdListenerService", "members/me.lyft.android.services.AppService", "members/me.lyft.android.services.WatchListenerService", "members/me.lyft.android.receivers.ReferrerBroadcastReceiver", "members/me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver", "members/me.lyft.android.infrastructure.notifications.InAppNotificationService", "members/me.lyft.android.services.LyftDriverToggleService", "members/me.lyft.android.services.DriverShortcutService", "members/me.lyft.android.services.DeferredCallSyncService" };
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public AppModule$$ModuleAdapter()
  {
    super(AppModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, true, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, AppModule paramAppModule)
  {
    paramBindingsGroup.contributeProvidesBinding("com.lyft.rx.MessageBus", new ProvideMessageBusProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.content.ContentResolver", new ProvideContentResolverProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("com.squareup.okhttp.OkHttpClient", new OkHttpClientProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.json.IJsonSerializer", new ProvideJsonSerializerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.app.NotificationManager", new ProvideNotificationManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.view.WindowManager", new ProvideWindowManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.telephony.TelephonyManager", new ProvideTelephonyManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.net.ConnectivityManager", new ProvideConnectivityManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.media.AudioManager", new ProvideAudioManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.view.inputmethod.InputMethodManager", new ProvideInputMethodManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.utils.Vibrator", new ProvideVibratorProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.app.AlarmManager", new ProvideAlarmManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.managers.ImageLoader", new ProvideImageLoaderProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.os.Handler", new ProvideHandlerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.accounts.AccountManager", new ProvideAccountManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.LyftApplication", new ProvideLyftApplicationProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("com.google.android.gms.common.api.GoogleApiClient$Builder", new ProvideGoogleApiClientBuilderProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.content.pm.PackageManager", new ProvidePackageManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.utils.Telephony", new ProvidesNewTelephonyProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.utils.TextToSpeech", new ProvideTextToSpeechProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.deeplinks.DeepLinkManager", new ProvideDeepLinkManagerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.ui.invites.SocialIntentProvider", new ProvideSocialIntentProviderProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("android.content.res.Resources", new ProvideResourcesProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.data.ContactsDatabaseHelper", new ProvideContactsDatabaseHelperProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.providers.ContactsProvider", new ProvideContactsProviderProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.ILyftPreferences", new ProvidePreferencesProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.IUserSession", new ProvideIUserSessionProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.lyft.IAppStateHandler", new ProvideAppStateHandlerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.system.ICountryRepository", new ProvideCountryRepositoryProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter", new ProvideCarpoolDriverOnboardingRouterProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.ui.MainScreensRouter", new ProvideMainScreensRouterProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IUserDispatchService", new ProvideUserModeServiceProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.services.HeatMapService", new ProvideHeatmapServiceProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.payment.IPricingService", new ProvidePricingServiceProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.ui.MainActivityAnalytics", new ProvideMainActivityAnalyticsProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.development.IDeveloperTools", new ProvideDeveloperToolsProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.gcm.IGcmSerializer", new ProvideGcmSerializerProvidesAdapter(paramAppModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.gcm.IGcmEventExecutor", new ProvideGcmEventExecutorProvidesAdapter(paramAppModule));
  }
  
  public static final class OkHttpClientProvidesAdapter
    extends ProvidesBinding<OkHttpClient>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<IDeveloperTools> developerTools;
    private Binding<IDevice> device;
    private final AppModule module;
    private Binding<ILyftPreferences> preferences;
    
    public OkHttpClientProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "okHttpClient");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", AppModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", AppModule.class, getClass().getClassLoader());
      developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", AppModule.class, getClass().getClassLoader());
    }
    
    public OkHttpClient get()
    {
      return module.okHttpClient((ILyftPreferences)preferences.get(), (IConstantsProvider)constantsProvider.get(), (IDevice)device.get(), (IDeveloperTools)developerTools.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(preferences);
      paramSet1.add(constantsProvider);
      paramSet1.add(device);
      paramSet1.add(developerTools);
    }
  }
  
  public static final class ProvideAccountManagerProvidesAdapter
    extends ProvidesBinding<AccountManager>
  {
    private final AppModule module;
    
    public ProvideAccountManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideAccountManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public AccountManager get()
    {
      return module.provideAccountManager();
    }
  }
  
  public static final class ProvideAlarmManagerProvidesAdapter
    extends ProvidesBinding<AlarmManager>
  {
    private final AppModule module;
    
    public ProvideAlarmManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideAlarmManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public AlarmManager get()
    {
      return module.provideAlarmManager();
    }
  }
  
  public static final class ProvideAppStateHandlerProvidesAdapter
    extends ProvidesBinding<IAppStateHandler>
  {
    private final AppModule module;
    private Binding<IUserSession> userSession;
    
    public ProvideAppStateHandlerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideAppStateHandler");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", AppModule.class, getClass().getClassLoader());
    }
    
    public IAppStateHandler get()
    {
      return module.provideAppStateHandler((IUserSession)userSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userSession);
    }
  }
  
  public static final class ProvideAudioManagerProvidesAdapter
    extends ProvidesBinding<AudioManager>
  {
    private final AppModule module;
    
    public ProvideAudioManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideAudioManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public AudioManager get()
    {
      return module.provideAudioManager();
    }
  }
  
  public static final class ProvideCarpoolDriverOnboardingRouterProvidesAdapter
    extends ProvidesBinding<CarpoolDriverOnboardingRouter>
  {
    private Binding<AppFlow> appFlow;
    private Binding<DialogFlow> dialogFlow;
    private Binding<ILyftPreferences> lyftPreferences;
    private Binding<MainScreensRouter> mainScreensRouter;
    private final AppModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideCarpoolDriverOnboardingRouterProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideCarpoolDriverOnboardingRouter");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
      dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", AppModule.class, getClass().getClassLoader());
      mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", AppModule.class, getClass().getClassLoader());
    }
    
    public CarpoolDriverOnboardingRouter get()
    {
      return module.provideCarpoolDriverOnboardingRouter((AppFlow)appFlow.get(), (ILyftPreferences)lyftPreferences.get(), (IUserProvider)userProvider.get(), (DialogFlow)dialogFlow.get(), (MainScreensRouter)mainScreensRouter.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appFlow);
      paramSet1.add(lyftPreferences);
      paramSet1.add(userProvider);
      paramSet1.add(dialogFlow);
      paramSet1.add(mainScreensRouter);
    }
  }
  
  public static final class ProvideConnectivityManagerProvidesAdapter
    extends ProvidesBinding<ConnectivityManager>
  {
    private final AppModule module;
    
    public ProvideConnectivityManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideConnectivityManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public ConnectivityManager get()
    {
      return module.provideConnectivityManager();
    }
  }
  
  public static final class ProvideContactsDatabaseHelperProvidesAdapter
    extends ProvidesBinding<ContactsDatabaseHelper>
  {
    private final AppModule module;
    
    public ProvideContactsDatabaseHelperProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideContactsDatabaseHelper");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public ContactsDatabaseHelper get()
    {
      return module.provideContactsDatabaseHelper();
    }
  }
  
  public static final class ProvideContactsProviderProvidesAdapter
    extends ProvidesBinding<ContactsProvider>
  {
    private Binding<ContentResolver> contentResolver;
    private final AppModule module;
    
    public ProvideContactsProviderProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideContactsProvider");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      contentResolver = paramLinker.requestBinding("android.content.ContentResolver", AppModule.class, getClass().getClassLoader());
    }
    
    public ContactsProvider get()
    {
      return module.provideContactsProvider((ContentResolver)contentResolver.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(contentResolver);
    }
  }
  
  public static final class ProvideContentResolverProvidesAdapter
    extends ProvidesBinding<ContentResolver>
  {
    private final AppModule module;
    
    public ProvideContentResolverProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideContentResolver");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public ContentResolver get()
    {
      return module.provideContentResolver();
    }
  }
  
  public static final class ProvideCountryRepositoryProvidesAdapter
    extends ProvidesBinding<ICountryRepository>
  {
    private final AppModule module;
    
    public ProvideCountryRepositoryProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideCountryRepository");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public ICountryRepository get()
    {
      return module.provideCountryRepository();
    }
  }
  
  public static final class ProvideDeepLinkManagerProvidesAdapter
    extends ProvidesBinding<DeepLinkManager>
  {
    private Binding<AppFlow> appFlow;
    private Binding<CarpoolDriverOnboardingRouter> carpoolDriverOnboardingRouter;
    private Binding<IEnterpriseService> enterpriseService;
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<JobManager> jobManager;
    private Binding<MainScreensRouter> mainScreensRouter;
    private final AppModule module;
    private Binding<ProfileFlow> profileFlow;
    private Binding<IUserProvider> userProvider;
    private Binding<IUserUiService> userUIService;
    
    public ProvideDeepLinkManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideDeepLinkManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
      jobManager = paramLinker.requestBinding("me.lyft.android.jobs.JobManager", AppModule.class, getClass().getClassLoader());
      profileFlow = paramLinker.requestBinding("me.lyft.android.flows.ProfileFlow", AppModule.class, getClass().getClassLoader());
      mainScreensRouter = paramLinker.requestBinding("me.lyft.android.ui.MainScreensRouter", AppModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", AppModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
      carpoolDriverOnboardingRouter = paramLinker.requestBinding("me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter", AppModule.class, getClass().getClassLoader());
      enterpriseService = paramLinker.requestBinding("me.lyft.android.application.enterprise.IEnterpriseService", AppModule.class, getClass().getClassLoader());
      userUIService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AppModule.class, getClass().getClassLoader());
    }
    
    public DeepLinkManager get()
    {
      return module.provideDeepLinkManager((AppFlow)appFlow.get(), (JobManager)jobManager.get(), (ProfileFlow)profileFlow.get(), (MainScreensRouter)mainScreensRouter.get(), (IFeaturesProvider)featuresProvider.get(), (IUserProvider)userProvider.get(), (CarpoolDriverOnboardingRouter)carpoolDriverOnboardingRouter.get(), (IEnterpriseService)enterpriseService.get(), (IUserUiService)userUIService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appFlow);
      paramSet1.add(jobManager);
      paramSet1.add(profileFlow);
      paramSet1.add(mainScreensRouter);
      paramSet1.add(featuresProvider);
      paramSet1.add(userProvider);
      paramSet1.add(carpoolDriverOnboardingRouter);
      paramSet1.add(enterpriseService);
      paramSet1.add(userUIService);
    }
  }
  
  public static final class ProvideDeveloperToolsProvidesAdapter
    extends ProvidesBinding<IDeveloperTools>
  {
    private Binding<LyftApplication> lyftApplication;
    private Binding<ILyftPreferences> lyftPreferences;
    private final AppModule module;
    
    public ProvideDeveloperToolsProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideDeveloperTools");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", AppModule.class, getClass().getClassLoader());
    }
    
    public IDeveloperTools get()
    {
      return module.provideDeveloperTools((ILyftPreferences)lyftPreferences.get(), (LyftApplication)lyftApplication.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftPreferences);
      paramSet1.add(lyftApplication);
    }
  }
  
  public static final class ProvideGcmEventExecutorProvidesAdapter
    extends ProvidesBinding<IGcmEventExecutor>
  {
    private Binding<IAppStateHandler> appStateHandler;
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<IGcmSerializer> gcmSerializer;
    private final AppModule module;
    private Binding<IPricingService> pricingService;
    private Binding<IStatusBarNotificationsService> statusBarNotificationsService;
    
    public ProvideGcmEventExecutorProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideGcmEventExecutor");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      statusBarNotificationsService = paramLinker.requestBinding("me.lyft.android.notifications.IStatusBarNotificationsService", AppModule.class, getClass().getClassLoader());
      gcmSerializer = paramLinker.requestBinding("me.lyft.android.gcm.IGcmSerializer", AppModule.class, getClass().getClassLoader());
      appStateHandler = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.IAppStateHandler", AppModule.class, getClass().getClassLoader());
      pricingService = paramLinker.requestBinding("me.lyft.android.application.payment.IPricingService", AppModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", AppModule.class, getClass().getClassLoader());
    }
    
    public IGcmEventExecutor get()
    {
      return module.provideGcmEventExecutor((IStatusBarNotificationsService)statusBarNotificationsService.get(), (IGcmSerializer)gcmSerializer.get(), (IAppStateHandler)appStateHandler.get(), (IPricingService)pricingService.get(), (IFeaturesProvider)featuresProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(statusBarNotificationsService);
      paramSet1.add(gcmSerializer);
      paramSet1.add(appStateHandler);
      paramSet1.add(pricingService);
      paramSet1.add(featuresProvider);
    }
  }
  
  public static final class ProvideGcmSerializerProvidesAdapter
    extends ProvidesBinding<IGcmSerializer>
  {
    private Binding<IJsonSerializer> jsonSerializer;
    private final AppModule module;
    
    public ProvideGcmSerializerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideGcmSerializer");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AppModule.class, getClass().getClassLoader());
    }
    
    public IGcmSerializer get()
    {
      return module.provideGcmSerializer((IJsonSerializer)jsonSerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(jsonSerializer);
    }
  }
  
  public static final class ProvideGoogleApiClientBuilderProvidesAdapter
    extends ProvidesBinding<GoogleApiClient.Builder>
  {
    private final AppModule module;
    
    public ProvideGoogleApiClientBuilderProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideGoogleApiClientBuilder");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public GoogleApiClient.Builder get()
    {
      return module.provideGoogleApiClientBuilder();
    }
  }
  
  public static final class ProvideHandlerProvidesAdapter
    extends ProvidesBinding<Handler>
  {
    private final AppModule module;
    
    public ProvideHandlerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideHandler");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public Handler get()
    {
      return module.provideHandler();
    }
  }
  
  public static final class ProvideHeatmapServiceProvidesAdapter
    extends ProvidesBinding<HeatMapService>
  {
    private Binding<IDefaultErrorHandler> defaultErrorHandler;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final AppModule module;
    
    public ProvideHeatmapServiceProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideHeatmapService");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", AppModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", AppModule.class, getClass().getClassLoader());
      defaultErrorHandler = paramLinker.requestBinding("me.lyft.android.errorhandling.IDefaultErrorHandler", AppModule.class, getClass().getClassLoader());
    }
    
    public HeatMapService get()
    {
      return module.provideHeatmapService((ILyftApi)lyftApi.get(), (ILocationService)locationService.get(), (IDefaultErrorHandler)defaultErrorHandler.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(locationService);
      paramSet1.add(defaultErrorHandler);
    }
  }
  
  public static final class ProvideIUserSessionProvidesAdapter
    extends ProvidesBinding<IUserSession>
  {
    private Binding<JobManager> jobManager;
    private final AppModule module;
    private Binding<ILyftPreferences> preferences;
    private Binding<IServerTimestampService> serverTimestampService;
    
    public ProvideIUserSessionProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideIUserSession");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", AppModule.class, getClass().getClassLoader());
      jobManager = paramLinker.requestBinding("me.lyft.android.jobs.JobManager", AppModule.class, getClass().getClassLoader());
      serverTimestampService = paramLinker.requestBinding("me.lyft.android.infrastructure.servertimestamp.IServerTimestampService", AppModule.class, getClass().getClassLoader());
    }
    
    public IUserSession get()
    {
      return module.provideIUserSession((ILyftPreferences)preferences.get(), (JobManager)jobManager.get(), (IServerTimestampService)serverTimestampService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(preferences);
      paramSet1.add(jobManager);
      paramSet1.add(serverTimestampService);
    }
  }
  
  public static final class ProvideImageLoaderProvidesAdapter
    extends ProvidesBinding<ImageLoader>
  {
    private final AppModule module;
    private Binding<OkHttpClient> okHttpClient;
    
    public ProvideImageLoaderProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideImageLoader");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", AppModule.class, getClass().getClassLoader());
    }
    
    public ImageLoader get()
    {
      return module.provideImageLoader((OkHttpClient)okHttpClient.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(okHttpClient);
    }
  }
  
  public static final class ProvideInputMethodManagerProvidesAdapter
    extends ProvidesBinding<InputMethodManager>
  {
    private final AppModule module;
    
    public ProvideInputMethodManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideInputMethodManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public InputMethodManager get()
    {
      return module.provideInputMethodManager();
    }
  }
  
  public static final class ProvideJsonSerializerProvidesAdapter
    extends ProvidesBinding<IJsonSerializer>
  {
    private final AppModule module;
    
    public ProvideJsonSerializerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideJsonSerializer");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public IJsonSerializer get()
    {
      return module.provideJsonSerializer();
    }
  }
  
  public static final class ProvideLyftApplicationProvidesAdapter
    extends ProvidesBinding<LyftApplication>
  {
    private final AppModule module;
    
    public ProvideLyftApplicationProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideLyftApplication");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public LyftApplication get()
    {
      return module.provideLyftApplication();
    }
  }
  
  public static final class ProvideMainActivityAnalyticsProvidesAdapter
    extends ProvidesBinding<MainActivityAnalytics>
  {
    private final AppModule module;
    
    public ProvideMainActivityAnalyticsProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideMainActivityAnalytics");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public MainActivityAnalytics get()
    {
      return module.provideMainActivityAnalytics();
    }
  }
  
  public static final class ProvideMainScreensRouterProvidesAdapter
    extends ProvidesBinding<MainScreensRouter>
  {
    private Binding<AppFlow> appFlow;
    private Binding<IDriverRideProvider> driverRideProvider;
    private final AppModule module;
    private Binding<IUserUiService> userService;
    
    public ProvideMainScreensRouterProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideMainScreensRouter");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", AppModule.class, getClass().getClassLoader());
      userService = paramLinker.requestBinding("me.lyft.android.application.ride.IUserUiService", AppModule.class, getClass().getClassLoader());
      driverRideProvider = paramLinker.requestBinding("me.lyft.android.application.ride.IDriverRideProvider", AppModule.class, getClass().getClassLoader());
    }
    
    public MainScreensRouter get()
    {
      return module.provideMainScreensRouter((AppFlow)appFlow.get(), (IUserUiService)userService.get(), (IDriverRideProvider)driverRideProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appFlow);
      paramSet1.add(userService);
      paramSet1.add(driverRideProvider);
    }
  }
  
  public static final class ProvideMessageBusProvidesAdapter
    extends ProvidesBinding<MessageBus>
  {
    private final AppModule module;
    
    public ProvideMessageBusProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideMessageBus");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public MessageBus get()
    {
      return module.provideMessageBus();
    }
  }
  
  public static final class ProvideNotificationManagerProvidesAdapter
    extends ProvidesBinding<NotificationManager>
  {
    private final AppModule module;
    
    public ProvideNotificationManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideNotificationManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public NotificationManager get()
    {
      return module.provideNotificationManager();
    }
  }
  
  public static final class ProvidePackageManagerProvidesAdapter
    extends ProvidesBinding<PackageManager>
  {
    private final AppModule module;
    
    public ProvidePackageManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "providePackageManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public PackageManager get()
    {
      return module.providePackageManager();
    }
  }
  
  public static final class ProvidePreferencesProvidesAdapter
    extends ProvidesBinding<ILyftPreferences>
  {
    private Binding<LyftApplication> app;
    private Binding<IJsonSerializer> jsonSerializer;
    private final AppModule module;
    
    public ProvidePreferencesProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "providePreferences");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      app = paramLinker.requestBinding("me.lyft.android.LyftApplication", AppModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", AppModule.class, getClass().getClassLoader());
    }
    
    public ILyftPreferences get()
    {
      return module.providePreferences((LyftApplication)app.get(), (IJsonSerializer)jsonSerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(app);
      paramSet1.add(jsonSerializer);
    }
  }
  
  public static final class ProvidePricingServiceProvidesAdapter
    extends ProvidesBinding<IPricingService>
  {
    private final AppModule module;
    
    public ProvidePricingServiceProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "providePricingService");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public IPricingService get()
    {
      return module.providePricingService();
    }
  }
  
  public static final class ProvideResourcesProvidesAdapter
    extends ProvidesBinding<Resources>
  {
    private final AppModule module;
    
    public ProvideResourcesProvidesAdapter(AppModule paramAppModule)
    {
      super(false, "me.lyft.android.AppModule", "provideResources");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public Resources get()
    {
      return module.provideResources();
    }
  }
  
  public static final class ProvideSocialIntentProviderProvidesAdapter
    extends ProvidesBinding<SocialIntentProvider>
  {
    private final AppModule module;
    
    public ProvideSocialIntentProviderProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideSocialIntentProvider");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public SocialIntentProvider get()
    {
      return module.provideSocialIntentProvider();
    }
  }
  
  public static final class ProvideTelephonyManagerProvidesAdapter
    extends ProvidesBinding<TelephonyManager>
  {
    private final AppModule module;
    
    public ProvideTelephonyManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideTelephonyManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public TelephonyManager get()
    {
      return module.provideTelephonyManager();
    }
  }
  
  public static final class ProvideTextToSpeechProvidesAdapter
    extends ProvidesBinding<TextToSpeech>
  {
    private final AppModule module;
    
    public ProvideTextToSpeechProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideTextToSpeech");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public TextToSpeech get()
    {
      return module.provideTextToSpeech();
    }
  }
  
  public static final class ProvideUserModeServiceProvidesAdapter
    extends ProvidesBinding<IUserDispatchService>
  {
    private Binding<ILocationSettingsService> locationSettingsService;
    private Binding<ILyftApi> lyftApi;
    private final AppModule module;
    private Binding<IUserProvider> userProvider;
    private Binding<IVehicleService> vehicleService;
    
    public ProvideUserModeServiceProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideUserModeService");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", AppModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", AppModule.class, getClass().getClassLoader());
      vehicleService = paramLinker.requestBinding("me.lyft.android.application.driver.IVehicleService", AppModule.class, getClass().getClassLoader());
      locationSettingsService = paramLinker.requestBinding("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", AppModule.class, getClass().getClassLoader());
    }
    
    public IUserDispatchService get()
    {
      return module.provideUserModeService((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get(), (IVehicleService)vehicleService.get(), (ILocationSettingsService)locationSettingsService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(lyftApi);
      paramSet1.add(vehicleService);
      paramSet1.add(locationSettingsService);
    }
  }
  
  public static final class ProvideVibratorProvidesAdapter
    extends ProvidesBinding<Vibrator>
  {
    private final AppModule module;
    
    public ProvideVibratorProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideVibrator");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public Vibrator get()
    {
      return module.provideVibrator();
    }
  }
  
  public static final class ProvideWindowManagerProvidesAdapter
    extends ProvidesBinding<WindowManager>
  {
    private final AppModule module;
    
    public ProvideWindowManagerProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "provideWindowManager");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public WindowManager get()
    {
      return module.provideWindowManager();
    }
  }
  
  public static final class ProvidesNewTelephonyProvidesAdapter
    extends ProvidesBinding<Telephony>
  {
    private final AppModule module;
    
    public ProvidesNewTelephonyProvidesAdapter(AppModule paramAppModule)
    {
      super(true, "me.lyft.android.AppModule", "providesNewTelephony");
      module = paramAppModule;
      setLibrary(true);
    }
    
    public Telephony get()
    {
      return module.providesNewTelephony();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */