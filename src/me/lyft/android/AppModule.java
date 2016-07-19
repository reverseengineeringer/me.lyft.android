package me.lyft.android;

import android.accounts.AccountManager;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lyft.rx.MessageBus;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.Builder;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import me.lyft.android.analytics.NetworkAnalyticsInterceptor;
import me.lyft.android.analytics.trackers.AnalyticsModule;
import me.lyft.android.application.ApplicationServicesModule;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.FeaturesModule;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.payment.IPricingService;
import me.lyft.android.application.payment.PricingService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.ride.UserDispatchService;
import me.lyft.android.application.system.CountryRepository;
import me.lyft.android.application.system.ICountryRepository;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.CommonModule;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.data.ContactsDatabaseHelper;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.development.DeveloperTools;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.development.StethoSupport;
import me.lyft.android.domain.payment.ChargeAccount;
import me.lyft.android.domain.time.Time;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.flows.ProfileFlow;
import me.lyft.android.gcm.GcmEventExecutor;
import me.lyft.android.gcm.GcmEventHandler;
import me.lyft.android.gcm.IGcmEventExecutor;
import me.lyft.android.gcm.IGcmSerializer;
import me.lyft.android.gcm.JsonGcmSerializer;
import me.lyft.android.gcm.commands.HideMessageGcmEventHandler;
import me.lyft.android.gcm.commands.PricingGcmEventHandler;
import me.lyft.android.gcm.commands.RideUpdateGcmEventHandler;
import me.lyft.android.gcm.commands.ShowMessageGcmEventHandler;
import me.lyft.android.gcm.commands.StartServiceGcmEventHandler;
import me.lyft.android.infrastructure.InfrastructureServicesModule;
import me.lyft.android.infrastructure.appboy.AppboyBroadcastReceiver;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.json.GsonSerializer;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.navigation.NavigationModule;
import me.lyft.android.notifications.IStatusBarNotificationsService;
import me.lyft.android.persistence.PersistenceModule;
import me.lyft.android.persistence.PolymorphAdpater;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.receivers.ReferrerBroadcastReceiver;
import me.lyft.android.services.AppService;
import me.lyft.android.services.DeferredCallSyncService;
import me.lyft.android.services.DriverShortcutService;
import me.lyft.android.services.GcmIdListenerService;
import me.lyft.android.services.GcmService;
import me.lyft.android.services.HeatMapService;
import me.lyft.android.services.LyftDriverToggleService;
import me.lyft.android.services.WatchListenerService;
import me.lyft.android.threading.AndroidMainThreadChecker;
import me.lyft.android.ui.MainActivity;
import me.lyft.android.ui.MainActivityAnalytics;
import me.lyft.android.ui.MainScreensRouter;
import me.lyft.android.ui.invites.SocialIntentProvider;
import me.lyft.android.ui.onboarding.CarpoolDriverOnboardingRouter;
import me.lyft.android.utils.Telephony;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

@Module(includes={ApplicationServicesModule.class, InfrastructureServicesModule.class, PersistenceModule.class, CommonModule.class, AnalyticsModule.class, FeaturesModule.class, NavigationModule.class}, injects={LyftApplication.class, MainActivity.class, GcmService.class, GcmIdListenerService.class, AppService.class, WatchListenerService.class, ReferrerBroadcastReceiver.class, AppboyBroadcastReceiver.class, InAppNotificationService.class, LyftDriverToggleService.class, DriverShortcutService.class, DeferredCallSyncService.class}, library=true)
public class AppModule
{
  private static final String HTTP_CACHE_DIR = "okhttp";
  private static final long HTTP_CACHE_SIZE = 20971520L;
  private static final long HTTP_CONNECTION_TIMEOUT_SEC = 15L;
  private static final long HTTP_READ_TIMEOUT_SEC = 20L;
  private static final long HTTP_WRITE_TIMEOUT_SEC = 20L;
  private final Context appContext;
  
  AppModule(Context paramContext)
  {
    appContext = paramContext;
  }
  
  private GcmEventExecutor getDefaultGcmEvenExecutor(IStatusBarNotificationsService paramIStatusBarNotificationsService, IGcmSerializer paramIGcmSerializer, IAppStateHandler paramIAppStateHandler)
  {
    return new GcmEventExecutor(new GcmEventHandler[] { new HideMessageGcmEventHandler(paramIStatusBarNotificationsService), new ShowMessageGcmEventHandler(paramIStatusBarNotificationsService), new RideUpdateGcmEventHandler(paramIGcmSerializer, paramIAppStateHandler), new StartServiceGcmEventHandler() });
  }
  
  static IJsonSerializer getJsonSerializer()
  {
    Gson localGson = new Gson();
    return new GsonSerializer(new GsonBuilder().registerTypeHierarchyAdapter(ChargeAccount.class, new PolymorphAdpater(localGson)).registerTypeHierarchyAdapter(Time.class, new PolymorphAdpater(localGson)).create());
  }
  
  private GcmEventExecutor getShortcutGcmEventExecutor(IStatusBarNotificationsService paramIStatusBarNotificationsService, IGcmSerializer paramIGcmSerializer, IAppStateHandler paramIAppStateHandler, IPricingService paramIPricingService)
  {
    return new GcmEventExecutor(new GcmEventHandler[] { new HideMessageGcmEventHandler(paramIStatusBarNotificationsService), new ShowMessageGcmEventHandler(paramIStatusBarNotificationsService), new RideUpdateGcmEventHandler(paramIGcmSerializer, paramIAppStateHandler), new PricingGcmEventHandler(paramIGcmSerializer, paramIPricingService), new StartServiceGcmEventHandler() });
  }
  
  Cache getOkHttpClientCache()
  {
    return new Cache(new File(appContext.getCacheDir(), "okhttp"), 20971520L);
  }
  
  @Provides
  @Singleton
  OkHttpClient okHttpClient(ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider, IDevice paramIDevice, IDeveloperTools paramIDeveloperTools)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.setConnectTimeout(15L, TimeUnit.SECONDS);
    localOkHttpClient.setReadTimeout(20L, TimeUnit.SECONDS);
    localOkHttpClient.setWriteTimeout(20L, TimeUnit.SECONDS);
    localOkHttpClient.setProtocols(Arrays.asList(new Protocol[] { Protocol.HTTP_1_1, Protocol.HTTP_2 }));
    localOkHttpClient.setCache(getOkHttpClientCache());
    StethoSupport.addStethoInterceptor(localOkHttpClient);
    localOkHttpClient.interceptors().add(paramIDeveloperTools.getHttpLoggingInterceptor());
    localOkHttpClient.interceptors().add(new NetworkAnalyticsInterceptor(paramIConstantsProvider, paramIDevice));
    if (paramILyftPreferences.isProxyEnabled()) {
      localOkHttpClient.setProxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramILyftPreferences.getProxyIpAddress(), 8888)));
    }
    return localOkHttpClient;
  }
  
  @Provides
  AccountManager provideAccountManager()
  {
    return AccountManager.get(appContext);
  }
  
  @Provides
  @Singleton
  AlarmManager provideAlarmManager()
  {
    return (AlarmManager)appContext.getSystemService("alarm");
  }
  
  @Provides
  @Singleton
  IAppStateHandler provideAppStateHandler(IUserSession paramIUserSession)
  {
    return new AppStateHandler(paramIUserSession);
  }
  
  @Provides
  @Singleton
  AudioManager provideAudioManager()
  {
    return (AudioManager)appContext.getSystemService("audio");
  }
  
  @Provides
  @Singleton
  CarpoolDriverOnboardingRouter provideCarpoolDriverOnboardingRouter(AppFlow paramAppFlow, ILyftPreferences paramILyftPreferences, IUserProvider paramIUserProvider, DialogFlow paramDialogFlow, MainScreensRouter paramMainScreensRouter)
  {
    return new CarpoolDriverOnboardingRouter(paramAppFlow, paramILyftPreferences, paramIUserProvider, paramDialogFlow, paramMainScreensRouter);
  }
  
  @Provides
  @Singleton
  ConnectivityManager provideConnectivityManager()
  {
    return (ConnectivityManager)appContext.getSystemService("connectivity");
  }
  
  @Provides
  ContactsDatabaseHelper provideContactsDatabaseHelper()
  {
    return new ContactsDatabaseHelper(appContext);
  }
  
  @Provides
  @Singleton
  ContactsProvider provideContactsProvider(ContentResolver paramContentResolver)
  {
    return new ContactsProvider(paramContentResolver);
  }
  
  @Provides
  ContentResolver provideContentResolver()
  {
    return appContext.getContentResolver();
  }
  
  @Provides
  @Singleton
  public ICountryRepository provideCountryRepository()
  {
    return new CountryRepository();
  }
  
  @Provides
  @Singleton
  DeepLinkManager provideDeepLinkManager(AppFlow paramAppFlow, JobManager paramJobManager, ProfileFlow paramProfileFlow, MainScreensRouter paramMainScreensRouter, IFeaturesProvider paramIFeaturesProvider, IUserProvider paramIUserProvider, CarpoolDriverOnboardingRouter paramCarpoolDriverOnboardingRouter, IEnterpriseService paramIEnterpriseService, IUserUiService paramIUserUiService)
  {
    return new DeepLinkManager(paramAppFlow, paramJobManager, paramProfileFlow, paramMainScreensRouter, paramIFeaturesProvider, paramIUserProvider, paramCarpoolDriverOnboardingRouter, paramIEnterpriseService, paramIUserUiService);
  }
  
  @Provides
  @Singleton
  IDeveloperTools provideDeveloperTools(ILyftPreferences paramILyftPreferences, LyftApplication paramLyftApplication)
  {
    return new DeveloperTools(paramILyftPreferences, paramLyftApplication);
  }
  
  @Provides
  @Singleton
  IGcmEventExecutor provideGcmEventExecutor(IStatusBarNotificationsService paramIStatusBarNotificationsService, IGcmSerializer paramIGcmSerializer, IAppStateHandler paramIAppStateHandler, IPricingService paramIPricingService, IFeaturesProvider paramIFeaturesProvider)
  {
    if (paramIFeaturesProvider.isEnabled(Features.DRIVER_SHORTCUT_V2)) {
      return getShortcutGcmEventExecutor(paramIStatusBarNotificationsService, paramIGcmSerializer, paramIAppStateHandler, paramIPricingService);
    }
    return getDefaultGcmEvenExecutor(paramIStatusBarNotificationsService, paramIGcmSerializer, paramIAppStateHandler);
  }
  
  @Provides
  @Singleton
  IGcmSerializer provideGcmSerializer(IJsonSerializer paramIJsonSerializer)
  {
    return new JsonGcmSerializer(paramIJsonSerializer);
  }
  
  @Provides
  GoogleApiClient.Builder provideGoogleApiClientBuilder()
  {
    return new GoogleApiClient.Builder(appContext);
  }
  
  @Provides
  @Singleton
  Handler provideHandler()
  {
    return new Handler(Looper.getMainLooper());
  }
  
  @Provides
  @Singleton
  HeatMapService provideHeatmapService(ILyftApi paramILyftApi, ILocationService paramILocationService, IDefaultErrorHandler paramIDefaultErrorHandler)
  {
    return new HeatMapService(paramILyftApi, paramILocationService, paramIDefaultErrorHandler);
  }
  
  @Provides
  @Singleton
  IUserSession provideIUserSession(ILyftPreferences paramILyftPreferences, JobManager paramJobManager, IServerTimestampService paramIServerTimestampService)
  {
    return new UserSession(paramILyftPreferences, paramJobManager, new AndroidMainThreadChecker(), paramIServerTimestampService);
  }
  
  @Provides
  @Singleton
  ImageLoader provideImageLoader(OkHttpClient paramOkHttpClient)
  {
    paramOkHttpClient = new Picasso.Builder(appContext).downloader(new OkHttpDownloader(paramOkHttpClient)).build();
    paramOkHttpClient.setIndicatorsEnabled(false);
    return new ImageLoader(paramOkHttpClient);
  }
  
  @Provides
  @Singleton
  InputMethodManager provideInputMethodManager()
  {
    return (InputMethodManager)appContext.getSystemService("input_method");
  }
  
  @Provides
  @Singleton
  IJsonSerializer provideJsonSerializer()
  {
    return getJsonSerializer();
  }
  
  @Provides
  LyftApplication provideLyftApplication()
  {
    return (LyftApplication)appContext;
  }
  
  @Provides
  @Singleton
  MainActivityAnalytics provideMainActivityAnalytics()
  {
    return new MainActivityAnalytics();
  }
  
  @Provides
  @Singleton
  MainScreensRouter provideMainScreensRouter(AppFlow paramAppFlow, IUserUiService paramIUserUiService, IDriverRideProvider paramIDriverRideProvider)
  {
    return new MainScreensRouter(paramAppFlow, paramIUserUiService, paramIDriverRideProvider);
  }
  
  @Provides
  @Singleton
  MessageBus provideMessageBus()
  {
    return new MessageBus();
  }
  
  @Provides
  @Singleton
  NotificationManager provideNotificationManager()
  {
    return (NotificationManager)appContext.getSystemService("notification");
  }
  
  @Provides
  @Singleton
  PackageManager providePackageManager()
  {
    return appContext.getPackageManager();
  }
  
  @Provides
  @Singleton
  ILyftPreferences providePreferences(LyftApplication paramLyftApplication, IJsonSerializer paramIJsonSerializer)
  {
    return new LyftPreferences(paramLyftApplication, paramIJsonSerializer);
  }
  
  @Provides
  @Singleton
  IPricingService providePricingService()
  {
    return new PricingService();
  }
  
  @Provides
  Resources provideResources()
  {
    return appContext.getResources();
  }
  
  @Provides
  @Singleton
  SocialIntentProvider provideSocialIntentProvider()
  {
    return new SocialIntentProvider(appContext.getPackageManager());
  }
  
  @Provides
  @Singleton
  TelephonyManager provideTelephonyManager()
  {
    return (TelephonyManager)appContext.getSystemService("phone");
  }
  
  @Provides
  @Singleton
  TextToSpeech provideTextToSpeech()
  {
    return new TextToSpeech(appContext);
  }
  
  @Provides
  @Singleton
  IUserDispatchService provideUserModeService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi, IVehicleService paramIVehicleService, ILocationSettingsService paramILocationSettingsService)
  {
    return new UserDispatchService(paramIUserProvider, paramILyftApi, paramIVehicleService, paramILocationSettingsService);
  }
  
  @Provides
  @Singleton
  Vibrator provideVibrator()
  {
    return new Vibrator(appContext);
  }
  
  @Provides
  @Singleton
  WindowManager provideWindowManager()
  {
    return (WindowManager)appContext.getSystemService("window");
  }
  
  @Provides
  @Singleton
  Telephony providesNewTelephony()
  {
    return new Telephony(appContext);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.AppModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */