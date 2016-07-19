package me.lyft.android.infrastructure;

import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.squareup.okhttp.OkHttpClient;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.activity.ActivityServiceRegistry;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.api.ILyftApiHeadersProvider;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.bootstrap.IBootstrapService;
import me.lyft.android.infrastructure.camera.CaptureImageSession;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.infrastructure.competition.InstallTrackerService;
import me.lyft.android.infrastructure.contacts.IAndroidContactsProvider;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.deferred.IDeferredSyncService;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService;
import me.lyft.android.infrastructure.environment.IEnvironmentService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.facebook.FacebookTokenModule;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.gallery.IGalleryService;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.instabug.InstabugModule;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.leanplum.ILeanplumService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.infrastructure.profile.ProfilePhotoLoader;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.infrastructure.service.AppProcessRegistry;
import me.lyft.android.infrastructure.settings.IAutomationOverrideService;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.infrastructure.sms.IVerificationAutoFillService;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.infrastructure.viewserver.IViewServerService;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.notifications.IStatusBarNotificationsService;

public final class InfrastructureServicesModule$$ModuleAdapter
  extends ModuleAdapter<InfrastructureServicesModule>
{
  private static final Class<?>[] INCLUDES = { InstabugModule.class, FacebookTokenModule.class };
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public InfrastructureServicesModule$$ModuleAdapter()
  {
    super(InfrastructureServicesModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, InfrastructureServicesModule paramInfrastructureServicesModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.activity.ActivityServiceRegistry", new ProvideActivityServiceRegistryProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.service.AppProcessRegistry", new ProvideAppServiceRegistryProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", new ProvideAppForegroundDetectorProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.location.ILocationService", new ProvideLocationServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", new ProvideGoogleApiProviderProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.androidpay.IAndroidPayService", new ProvideWalletServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.stripe.IStripeService", new ProvideStripeServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.googleplaces.IGooglePlaceService", new ProvideGooglePlaceServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", new ProvideGoogleApiServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.gallery.IGalleryService", new ProvideGalleryServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.photo.IPhotoPickerService", new ProvideGalleryServiceProvidesAdapter2(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.sms.IVerificationAutoFillService", new ProvideVerificationAutoFillServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.camera.CaptureImageSession", new ProvideCaptureImageSessionProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.camera.ICaptureImageSession", new ProvideICaptureImageSessionProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.camera.ICaptureImage", new ProvideICaptureImageProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.profile.IProfilePhotoLoader", new ProvideIProfilePhotoLoaderProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.profile.IProfilePhotoFileRecipient", new ProvideProfilePhotoFileRecipientProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.paypal.IPayPalService", new ProvideIPayPalServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", new ProvideResponseBodySerializerProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.api.ILyftApiHeadersProvider", new ProvideLyftApiHeadersProviderProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.environment.IS3Api", new ProvideS3ApiProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.lyft.ILyftApi", new ProvideLyftApiProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.environment.IEnvironmentService", new ProvideEnvironmentHelperProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.settings.IAutomationOverrideService", new ProvideSettingsOverrideServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.share.IShareService", new ProvideIShareServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", new ProvideILocationSettingsServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.assets.IAssetLoadingService", new ProvideLoadingServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.assets.IAssetPackagingService", new ProvideAssetPackagingServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.appboy.IAppboyService", new ProvideAppboyServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.notifications.IStatusBarNotificationsService", new ProvideStatusBarServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.viewserver.IViewServerService", new ProvideViewServerServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.device.IDevice", new ProvideDeviceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService", new ProvideDriverDefenseStarterServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.notifications.InAppNotificationService", new ProvideInAppNotificationServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.competition.InstallTrackerService", new ProvideInstallTrackerServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.leanplum.ILeanplumService", new ProvideLeanplumServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.bootstrap.IBootstrapService", new ProvideBootstrapServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.autofill.AutoFillAnalytics", new ProvidePrefillAnalyticsServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.studies.SplitFareAnalytics", new ProvideSplitFareAnalyticsProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.contacts.IAndroidContactsProvider", new ProvideInfrastructureContactsProviderProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.gcm.IGcmIdService", new ProvideGcmIdServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.deferred.IDeferredCallService", new ProvideDeferredCallServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.deferred.IDeferredSyncService", new ProvideDeferredSyncServiceProvidesAdapter(paramInfrastructureServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.servertimestamp.IServerTimestampService", new ProvideServerTimestampServiceProvidesAdapter(paramInfrastructureServicesModule));
  }
  
  public InfrastructureServicesModule newModule()
  {
    return new InfrastructureServicesModule();
  }
  
  public static final class ProvideActivityServiceRegistryProvidesAdapter
    extends ProvidesBinding<ActivityServiceRegistry>
  {
    private Binding<IAnalyticsService> analyticsService;
    private Binding<IAppboyService> appboyService;
    private Binding<IDeferredSyncService> deferredSyncService;
    private Binding<DriverShortcutStarterService> driverShortcutStarterService;
    private Binding<IGalleryService> galleryService;
    private Binding<IGoogleApiProvider> googleApiProvider;
    private Binding<IInstabugService> instabugService;
    private Binding<InstallTrackerService> installTrackerService;
    private Binding<ILeanplumService> leanplumService;
    private Binding<ILocationSettingsService> locationSettingsService;
    private final InfrastructureServicesModule module;
    private Binding<IPayPalService> payPalService;
    private Binding<IStatusBarNotificationsService> statusBarNotificationsService;
    private Binding<IViewServerService> viewServerService;
    private Binding<IAndroidPayService> walletService;
    
    public ProvideActivityServiceRegistryProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideActivityServiceRegistry");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      walletService = paramLinker.requestBinding("me.lyft.android.infrastructure.androidpay.IAndroidPayService", InfrastructureServicesModule.class, getClass().getClassLoader());
      galleryService = paramLinker.requestBinding("me.lyft.android.infrastructure.gallery.IGalleryService", InfrastructureServicesModule.class, getClass().getClassLoader());
      analyticsService = paramLinker.requestBinding("me.lyft.android.analytics.trackers.IAnalyticsService", InfrastructureServicesModule.class, getClass().getClassLoader());
      payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", InfrastructureServicesModule.class, getClass().getClassLoader());
      locationSettingsService = paramLinker.requestBinding("me.lyft.android.infrastructure.locationsettings.ILocationSettingsService", InfrastructureServicesModule.class, getClass().getClassLoader());
      viewServerService = paramLinker.requestBinding("me.lyft.android.infrastructure.viewserver.IViewServerService", InfrastructureServicesModule.class, getClass().getClassLoader());
      driverShortcutStarterService = paramLinker.requestBinding("me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService", InfrastructureServicesModule.class, getClass().getClassLoader());
      installTrackerService = paramLinker.requestBinding("me.lyft.android.infrastructure.competition.InstallTrackerService", InfrastructureServicesModule.class, getClass().getClassLoader());
      appboyService = paramLinker.requestBinding("me.lyft.android.infrastructure.appboy.IAppboyService", InfrastructureServicesModule.class, getClass().getClassLoader());
      statusBarNotificationsService = paramLinker.requestBinding("me.lyft.android.notifications.IStatusBarNotificationsService", InfrastructureServicesModule.class, getClass().getClassLoader());
      leanplumService = paramLinker.requestBinding("me.lyft.android.infrastructure.leanplum.ILeanplumService", InfrastructureServicesModule.class, getClass().getClassLoader());
      instabugService = paramLinker.requestBinding("me.lyft.android.infrastructure.instabug.IInstabugService", InfrastructureServicesModule.class, getClass().getClassLoader());
      deferredSyncService = paramLinker.requestBinding("me.lyft.android.infrastructure.deferred.IDeferredSyncService", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ActivityServiceRegistry get()
    {
      return module.provideActivityServiceRegistry((IGoogleApiProvider)googleApiProvider.get(), (IAndroidPayService)walletService.get(), (IGalleryService)galleryService.get(), (IAnalyticsService)analyticsService.get(), (IPayPalService)payPalService.get(), (ILocationSettingsService)locationSettingsService.get(), (IViewServerService)viewServerService.get(), (DriverShortcutStarterService)driverShortcutStarterService.get(), (InstallTrackerService)installTrackerService.get(), (IAppboyService)appboyService.get(), (IStatusBarNotificationsService)statusBarNotificationsService.get(), (ILeanplumService)leanplumService.get(), (IInstabugService)instabugService.get(), (IDeferredSyncService)deferredSyncService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(googleApiProvider);
      paramSet1.add(walletService);
      paramSet1.add(galleryService);
      paramSet1.add(analyticsService);
      paramSet1.add(payPalService);
      paramSet1.add(locationSettingsService);
      paramSet1.add(viewServerService);
      paramSet1.add(driverShortcutStarterService);
      paramSet1.add(installTrackerService);
      paramSet1.add(appboyService);
      paramSet1.add(statusBarNotificationsService);
      paramSet1.add(leanplumService);
      paramSet1.add(instabugService);
      paramSet1.add(deferredSyncService);
    }
  }
  
  public static final class ProvideAppForegroundDetectorProvidesAdapter
    extends ProvidesBinding<IAppForegroundDetector>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideAppForegroundDetectorProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppForegroundDetector");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IAppForegroundDetector get()
    {
      return module.provideAppForegroundDetector();
    }
  }
  
  public static final class ProvideAppServiceRegistryProvidesAdapter
    extends ProvidesBinding<AppProcessRegistry>
  {
    private Binding<IBackgroundLocationAppProcess> backgroundLocationSupervisor;
    private final InfrastructureServicesModule module;
    private Binding<IPollingAppProcess> pollingSupervisor;
    
    public ProvideAppServiceRegistryProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppServiceRegistry");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      pollingSupervisor = paramLinker.requestBinding("me.lyft.android.application.polling.IPollingAppProcess", InfrastructureServicesModule.class, getClass().getClassLoader());
      backgroundLocationSupervisor = paramLinker.requestBinding("me.lyft.android.application.polling.IBackgroundLocationAppProcess", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public AppProcessRegistry get()
    {
      return module.provideAppServiceRegistry((IPollingAppProcess)pollingSupervisor.get(), (IBackgroundLocationAppProcess)backgroundLocationSupervisor.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(pollingSupervisor);
      paramSet1.add(backgroundLocationSupervisor);
    }
  }
  
  public static final class ProvideAppboyServiceProvidesAdapter
    extends ProvidesBinding<IAppboyService>
  {
    private Binding<DialogFlow> dialogFlow;
    private Binding<IGcmIdService> gcmIdService;
    private Binding<ImageLoader> imageLoader;
    private Binding<InAppNotificationService> inAppNotificationService;
    private final InfrastructureServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideAppboyServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAppboyService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      gcmIdService = paramLinker.requestBinding("me.lyft.android.infrastructure.gcm.IGcmIdService", InfrastructureServicesModule.class, getClass().getClassLoader());
      dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
      imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
      inAppNotificationService = paramLinker.requestBinding("me.lyft.android.infrastructure.notifications.InAppNotificationService", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAppboyService get()
    {
      return module.provideAppboyService((IUserProvider)userProvider.get(), (IGcmIdService)gcmIdService.get(), (DialogFlow)dialogFlow.get(), (ImageLoader)imageLoader.get(), (InAppNotificationService)inAppNotificationService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(gcmIdService);
      paramSet1.add(dialogFlow);
      paramSet1.add(imageLoader);
      paramSet1.add(inAppNotificationService);
    }
  }
  
  public static final class ProvideAssetPackagingServiceProvidesAdapter
    extends ProvidesBinding<IAssetPackagingService>
  {
    private Binding<LyftApplication> lyftApplication;
    private final InfrastructureServicesModule module;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideAssetPackagingServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideAssetPackagingService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAssetPackagingService get()
    {
      return module.provideAssetPackagingService((LyftApplication)lyftApplication.get(), (ILyftPreferences)preferences.get(), (OkHttpClient)okHttpClient.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(preferences);
      paramSet1.add(okHttpClient);
    }
  }
  
  public static final class ProvideBootstrapServiceProvidesAdapter
    extends ProvidesBinding<IBootstrapService>
  {
    private Binding<IAppInfoService> appInfoService;
    private Binding<IAssetPackagingService> assetPackagingService;
    private Binding<AutoFillAnalytics> autoFillAnalytics;
    private Binding<AutoFillService> autoFillService;
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<ILandingService> landingService;
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    private Binding<IUserSession> userSession;
    
    public ProvideBootstrapServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideBootstrapService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", InfrastructureServicesModule.class, getClass().getClassLoader());
      assetPackagingService = paramLinker.requestBinding("me.lyft.android.infrastructure.assets.IAssetPackagingService", InfrastructureServicesModule.class, getClass().getClassLoader());
      landingService = paramLinker.requestBinding("me.lyft.android.application.landing.ILandingService", InfrastructureServicesModule.class, getClass().getClassLoader());
      autoFillService = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillService", InfrastructureServicesModule.class, getClass().getClassLoader());
      autoFillAnalytics = paramLinker.requestBinding("me.lyft.android.application.autofill.AutoFillAnalytics", InfrastructureServicesModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IBootstrapService get()
    {
      return module.provideBootstrapService((IUserSession)userSession.get(), (ILyftPreferences)lyftPreferences.get(), (IAppInfoService)appInfoService.get(), (IAssetPackagingService)assetPackagingService.get(), (ILandingService)landingService.get(), (AutoFillService)autoFillService.get(), (AutoFillAnalytics)autoFillAnalytics.get(), (IFeaturesProvider)featuresProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userSession);
      paramSet1.add(lyftPreferences);
      paramSet1.add(appInfoService);
      paramSet1.add(assetPackagingService);
      paramSet1.add(landingService);
      paramSet1.add(autoFillService);
      paramSet1.add(autoFillAnalytics);
      paramSet1.add(featuresProvider);
    }
  }
  
  public static final class ProvideCaptureImageSessionProvidesAdapter
    extends ProvidesBinding<CaptureImageSession>
  {
    private Binding<AppFlow> appFlow;
    private final InfrastructureServicesModule module;
    
    public ProvideCaptureImageSessionProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideCaptureImageSession");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appFlow = paramLinker.requestBinding("me.lyft.android.common.AppFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public CaptureImageSession get()
    {
      return module.provideCaptureImageSession((AppFlow)appFlow.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appFlow);
    }
  }
  
  public static final class ProvideDeferredCallServiceProvidesAdapter
    extends ProvidesBinding<IDeferredCallService>
  {
    private Binding<LyftApplication> application;
    private Binding<IDeferredSyncService> deferredSyncService;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILyftApi> lyftApi;
    private final InfrastructureServicesModule module;
    
    public ProvideDeferredCallServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDeferredCallService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      application = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
      deferredSyncService = paramLinker.requestBinding("me.lyft.android.infrastructure.deferred.IDeferredSyncService", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IDeferredCallService get()
    {
      return module.provideDeferredCallService((LyftApplication)application.get(), (ILyftApi)lyftApi.get(), (IJsonSerializer)jsonSerializer.get(), (IDeferredSyncService)deferredSyncService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(application);
      paramSet1.add(lyftApi);
      paramSet1.add(jsonSerializer);
      paramSet1.add(deferredSyncService);
    }
  }
  
  public static final class ProvideDeferredSyncServiceProvidesAdapter
    extends ProvidesBinding<IDeferredSyncService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideDeferredSyncServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDeferredSyncService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IDeferredSyncService get()
    {
      return module.provideDeferredSyncService();
    }
  }
  
  public static final class ProvideDeviceProvidesAdapter
    extends ProvidesBinding<IDevice>
  {
    private Binding<AccountManager> accountManager;
    private Binding<LyftApplication> app;
    private Binding<ConnectivityManager> connectivityManager;
    private final InfrastructureServicesModule module;
    private Binding<PackageManager> packageManager;
    private Binding<TelephonyManager> telephonyManager;
    private Binding<WindowManager> windowManager;
    
    public ProvideDeviceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDevice");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      app = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      windowManager = paramLinker.requestBinding("android.view.WindowManager", InfrastructureServicesModule.class, getClass().getClassLoader());
      telephonyManager = paramLinker.requestBinding("android.telephony.TelephonyManager", InfrastructureServicesModule.class, getClass().getClassLoader());
      connectivityManager = paramLinker.requestBinding("android.net.ConnectivityManager", InfrastructureServicesModule.class, getClass().getClassLoader());
      accountManager = paramLinker.requestBinding("android.accounts.AccountManager", InfrastructureServicesModule.class, getClass().getClassLoader());
      packageManager = paramLinker.requestBinding("android.content.pm.PackageManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IDevice get()
    {
      return module.provideDevice((LyftApplication)app.get(), (WindowManager)windowManager.get(), (TelephonyManager)telephonyManager.get(), (ConnectivityManager)connectivityManager.get(), (AccountManager)accountManager.get(), (PackageManager)packageManager.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(app);
      paramSet1.add(windowManager);
      paramSet1.add(telephonyManager);
      paramSet1.add(connectivityManager);
      paramSet1.add(accountManager);
      paramSet1.add(packageManager);
    }
  }
  
  public static final class ProvideDriverDefenseStarterServiceProvidesAdapter
    extends ProvidesBinding<DriverShortcutStarterService>
  {
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideDriverDefenseStarterServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideDriverDefenseStarterService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public DriverShortcutStarterService get()
    {
      return module.provideDriverDefenseStarterService((IUserProvider)userProvider.get(), (ILyftPreferences)lyftPreferences.get(), (IFeaturesProvider)featuresProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(lyftPreferences);
      paramSet1.add(featuresProvider);
    }
  }
  
  public static final class ProvideEnvironmentHelperProvidesAdapter
    extends ProvidesBinding<IEnvironmentService>
  {
    private Binding<IAnalyticsService> analyticsService;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILyftApi> lyftApi;
    private final InfrastructureServicesModule module;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideEnvironmentHelperProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideEnvironmentHelper");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
      analyticsService = paramLinker.requestBinding("me.lyft.android.analytics.trackers.IAnalyticsService", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IEnvironmentService get()
    {
      return module.provideEnvironmentHelper((ILyftPreferences)preferences.get(), (ILyftApi)lyftApi.get(), (IJsonSerializer)jsonSerializer.get(), (IAnalyticsService)analyticsService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(preferences);
      paramSet1.add(lyftApi);
      paramSet1.add(jsonSerializer);
      paramSet1.add(analyticsService);
    }
  }
  
  public static final class ProvideGalleryServiceProvidesAdapter
    extends ProvidesBinding<IGalleryService>
  {
    private Binding<ICaptureImageSession> captureImageSession;
    private final InfrastructureServicesModule module;
    
    public ProvideGalleryServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGalleryService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      captureImageSession = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.ICaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IGalleryService get()
    {
      return module.provideGalleryService((ICaptureImageSession)captureImageSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(captureImageSession);
    }
  }
  
  public static final class ProvideGalleryServiceProvidesAdapter2
    extends ProvidesBinding<IPhotoPickerService>
  {
    private Binding<ICaptureImage> captureImage;
    private final InfrastructureServicesModule module;
    
    public ProvideGalleryServiceProvidesAdapter2(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGalleryService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      captureImage = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.ICaptureImage", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IPhotoPickerService get()
    {
      return module.provideGalleryService((ICaptureImage)captureImage.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(captureImage);
    }
  }
  
  public static final class ProvideGcmIdServiceProvidesAdapter
    extends ProvidesBinding<IGcmIdService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideGcmIdServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGcmIdService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IGcmIdService get()
    {
      return module.provideGcmIdService();
    }
  }
  
  public static final class ProvideGoogleApiProviderProvidesAdapter
    extends ProvidesBinding<IGoogleApiProvider>
  {
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    
    public ProvideGoogleApiProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGoogleApiProvider");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IGoogleApiProvider get()
    {
      return module.provideGoogleApiProvider((ILyftPreferences)lyftPreferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftPreferences);
    }
  }
  
  public static final class ProvideGoogleApiServiceProvidesAdapter
    extends ProvidesBinding<IGoogleGeoApi>
  {
    private Binding<IJsonBodySerializer> jsonBodySerializer;
    private final InfrastructureServicesModule module;
    private Binding<OkHttpClient> okHttpClient;
    
    public ProvideGoogleApiServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGoogleApiService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonBodySerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IGoogleGeoApi get()
    {
      return module.provideGoogleApiService((OkHttpClient)okHttpClient.get(), (IJsonBodySerializer)jsonBodySerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(okHttpClient);
      paramSet1.add(jsonBodySerializer);
    }
  }
  
  public static final class ProvideGooglePlaceServiceProvidesAdapter
    extends ProvidesBinding<IGooglePlaceService>
  {
    private Binding<IGoogleApiProvider> googleApiProvider;
    private final InfrastructureServicesModule module;
    
    public ProvideGooglePlaceServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideGooglePlaceService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IGooglePlaceService get()
    {
      return module.provideGooglePlaceService((IGoogleApiProvider)googleApiProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(googleApiProvider);
    }
  }
  
  public static final class ProvideICaptureImageProvidesAdapter
    extends ProvidesBinding<ICaptureImage>
  {
    private final InfrastructureServicesModule module;
    private Binding<CaptureImageSession> session;
    
    public ProvideICaptureImageProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideICaptureImage");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      session = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.CaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ICaptureImage get()
    {
      return module.provideICaptureImage((CaptureImageSession)session.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(session);
    }
  }
  
  public static final class ProvideICaptureImageSessionProvidesAdapter
    extends ProvidesBinding<ICaptureImageSession>
  {
    private final InfrastructureServicesModule module;
    private Binding<CaptureImageSession> session;
    
    public ProvideICaptureImageSessionProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideICaptureImageSession");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      session = paramLinker.requestBinding("me.lyft.android.infrastructure.camera.CaptureImageSession", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ICaptureImageSession get()
    {
      return module.provideICaptureImageSession((CaptureImageSession)session.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(session);
    }
  }
  
  public static final class ProvideILocationSettingsServiceProvidesAdapter
    extends ProvidesBinding<ILocationSettingsService>
  {
    private Binding<LyftApplication> lyftApplication;
    private final InfrastructureServicesModule module;
    
    public ProvideILocationSettingsServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideILocationSettingsService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ILocationSettingsService get()
    {
      return module.provideILocationSettingsService((LyftApplication)lyftApplication.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
    }
  }
  
  public static final class ProvideIPayPalServiceProvidesAdapter
    extends ProvidesBinding<IPayPalService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideIPayPalServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIPayPalService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IPayPalService get()
    {
      return module.provideIPayPalService();
    }
  }
  
  public static final class ProvideIProfilePhotoLoaderProvidesAdapter
    extends ProvidesBinding<IProfilePhotoLoader>
  {
    private final InfrastructureServicesModule module;
    private Binding<ProfilePhotoLoader> myProfilePhotoLoader;
    
    public ProvideIProfilePhotoLoaderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIProfilePhotoLoader");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      myProfilePhotoLoader = paramLinker.requestBinding("me.lyft.android.infrastructure.profile.ProfilePhotoLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IProfilePhotoLoader get()
    {
      return module.provideIProfilePhotoLoader((ProfilePhotoLoader)myProfilePhotoLoader.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(myProfilePhotoLoader);
    }
  }
  
  public static final class ProvideIShareServiceProvidesAdapter
    extends ProvidesBinding<IShareService>
  {
    private Binding<LyftApplication> application;
    private final InfrastructureServicesModule module;
    
    public ProvideIShareServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideIShareService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      application = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IShareService get()
    {
      return module.provideIShareService((LyftApplication)application.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(application);
    }
  }
  
  public static final class ProvideInAppNotificationServiceProvidesAdapter
    extends ProvidesBinding<InAppNotificationService>
  {
    private Binding<DialogFlow> dialogFlow;
    private Binding<ILyftApi> lyftApi;
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideInAppNotificationServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInAppNotificationService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", InfrastructureServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public InAppNotificationService get()
    {
      return module.provideInAppNotificationService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (ILyftPreferences)lyftPreferences.get(), (DialogFlow)dialogFlow.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
      paramSet1.add(lyftPreferences);
      paramSet1.add(dialogFlow);
    }
  }
  
  public static final class ProvideInfrastructureContactsProviderProvidesAdapter
    extends ProvidesBinding<IAndroidContactsProvider>
  {
    private Binding<ContentResolver> contentResolver;
    private final InfrastructureServicesModule module;
    
    public ProvideInfrastructureContactsProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInfrastructureContactsProvider");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      contentResolver = paramLinker.requestBinding("android.content.ContentResolver", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAndroidContactsProvider get()
    {
      return module.provideInfrastructureContactsProvider((ContentResolver)contentResolver.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(contentResolver);
    }
  }
  
  public static final class ProvideInstallTrackerServiceProvidesAdapter
    extends ProvidesBinding<InstallTrackerService>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<IDevice> device;
    private final InfrastructureServicesModule module;
    
    public ProvideInstallTrackerServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideInstallTrackerService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public InstallTrackerService get()
    {
      return module.provideInstallTrackerService((IConstantsProvider)constantsProvider.get(), (IDevice)device.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(constantsProvider);
      paramSet1.add(device);
    }
  }
  
  public static final class ProvideLeanplumServiceProvidesAdapter
    extends ProvidesBinding<ILeanplumService>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<ILeanplumOverrideService> leanplumOverrideService;
    private Binding<LyftApplication> lyftApplication;
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideLeanplumServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLeanplumService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      leanplumOverrideService = paramLinker.requestBinding("me.lyft.android.application.constants.ILeanplumOverrideService", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ILeanplumService get()
    {
      return module.provideLeanplumService((LyftApplication)lyftApplication.get(), (ILeanplumOverrideService)leanplumOverrideService.get(), (ILyftPreferences)lyftPreferences.get(), (IConstantsProvider)constantsProvider.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(leanplumOverrideService);
      paramSet1.add(lyftPreferences);
      paramSet1.add(constantsProvider);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvideLoadingServiceProvidesAdapter
    extends ProvidesBinding<IAssetLoadingService>
  {
    private Binding<IDevice> device;
    private Binding<ImageLoader> imageLoader;
    private Binding<LyftApplication> lyftApplication;
    private final InfrastructureServicesModule module;
    
    public ProvideLoadingServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLoadingService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
      imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAssetLoadingService get()
    {
      return module.provideLoadingService((LyftApplication)lyftApplication.get(), (IDevice)device.get(), (ImageLoader)imageLoader.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(device);
      paramSet1.add(imageLoader);
    }
  }
  
  public static final class ProvideLocationServiceProvidesAdapter
    extends ProvidesBinding<ILocationService>
  {
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<LyftApplication> lyftApplication;
    private final InfrastructureServicesModule module;
    
    public ProvideLocationServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLocationService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", InfrastructureServicesModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ILocationService get()
    {
      return module.provideLocationService((LyftApplication)lyftApplication.get(), (IFeaturesProvider)featuresProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(featuresProvider);
    }
  }
  
  public static final class ProvideLyftApiHeadersProviderProvidesAdapter
    extends ProvidesBinding<ILyftApiHeadersProvider>
  {
    private Binding<IDevice> device;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    
    public ProvideLyftApiHeadersProviderProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLyftApiHeadersProvider");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ILyftApiHeadersProvider get()
    {
      return module.provideLyftApiHeadersProvider((IDevice)device.get(), (ILyftPreferences)lyftPreferences.get(), (IJsonSerializer)jsonSerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(device);
      paramSet1.add(lyftPreferences);
      paramSet1.add(jsonSerializer);
    }
  }
  
  public static final class ProvideLyftApiProvidesAdapter
    extends ProvidesBinding<ILyftApi>
  {
    private Binding<IDevice> device;
    private Binding<IAppStateHandler> handler;
    private Binding<IJsonBodySerializer> jsonBodySerializer;
    private Binding<ILyftApiHeadersProvider> lyftApiHeadersProvider;
    private final InfrastructureServicesModule module;
    private Binding<OkHttpClient> okHttpClient;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideLyftApiProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideLyftApi");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonBodySerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      device = paramLinker.requestBinding("me.lyft.android.infrastructure.device.IDevice", InfrastructureServicesModule.class, getClass().getClassLoader());
      handler = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.IAppStateHandler", InfrastructureServicesModule.class, getClass().getClassLoader());
      lyftApiHeadersProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.api.ILyftApiHeadersProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public ILyftApi get()
    {
      return module.provideLyftApi((OkHttpClient)okHttpClient.get(), (IJsonBodySerializer)jsonBodySerializer.get(), (ILyftPreferences)preferences.get(), (IDevice)device.get(), (IAppStateHandler)handler.get(), (ILyftApiHeadersProvider)lyftApiHeadersProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(okHttpClient);
      paramSet1.add(jsonBodySerializer);
      paramSet1.add(preferences);
      paramSet1.add(device);
      paramSet1.add(handler);
      paramSet1.add(lyftApiHeadersProvider);
    }
  }
  
  public static final class ProvidePrefillAnalyticsServiceProvidesAdapter
    extends ProvidesBinding<AutoFillAnalytics>
  {
    private final InfrastructureServicesModule module;
    
    public ProvidePrefillAnalyticsServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "providePrefillAnalyticsService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public AutoFillAnalytics get()
    {
      return module.providePrefillAnalyticsService();
    }
  }
  
  public static final class ProvideProfilePhotoFileRecipientProvidesAdapter
    extends ProvidesBinding<IProfilePhotoFileRecipient>
  {
    private final InfrastructureServicesModule module;
    private Binding<ProfilePhotoLoader> myProfilePhotoLoader;
    
    public ProvideProfilePhotoFileRecipientProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideProfilePhotoFileRecipient");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      myProfilePhotoLoader = paramLinker.requestBinding("me.lyft.android.infrastructure.profile.ProfilePhotoLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IProfilePhotoFileRecipient get()
    {
      return module.provideProfilePhotoFileRecipient((ProfilePhotoLoader)myProfilePhotoLoader.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(myProfilePhotoLoader);
    }
  }
  
  public static final class ProvideResponseBodySerializerProvidesAdapter
    extends ProvidesBinding<IJsonBodySerializer>
  {
    private Binding<IJsonSerializer> jsonSerializer;
    private final InfrastructureServicesModule module;
    
    public ProvideResponseBodySerializerProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideResponseBodySerializer");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IJsonBodySerializer get()
    {
      return module.provideResponseBodySerializer((IJsonSerializer)jsonSerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(jsonSerializer);
    }
  }
  
  public static final class ProvideS3ApiProvidesAdapter
    extends ProvidesBinding<IS3Api>
  {
    private Binding<IJsonBodySerializer> jsonBodySerializer;
    private final InfrastructureServicesModule module;
    private Binding<OkHttpClient> okHttpClient;
    
    public ProvideS3ApiProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideS3Api");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      okHttpClient = paramLinker.requestBinding("com.squareup.okhttp.OkHttpClient", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonBodySerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.api.IJsonBodySerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IS3Api get()
    {
      return module.provideS3Api((OkHttpClient)okHttpClient.get(), (IJsonBodySerializer)jsonBodySerializer.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(okHttpClient);
      paramSet1.add(jsonBodySerializer);
    }
  }
  
  public static final class ProvideServerTimestampServiceProvidesAdapter
    extends ProvidesBinding<IServerTimestampService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideServerTimestampServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideServerTimestampService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IServerTimestampService get()
    {
      return module.provideServerTimestampService();
    }
  }
  
  public static final class ProvideSettingsOverrideServiceProvidesAdapter
    extends ProvidesBinding<IAutomationOverrideService>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<IDeveloperTools> developerTools;
    private Binding<IJsonSerializer> jsonSerializer;
    private Binding<ILeanplumOverrideService> leanplumOverrideService;
    private final InfrastructureServicesModule module;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideSettingsOverrideServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideSettingsOverrideService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      leanplumOverrideService = paramLinker.requestBinding("me.lyft.android.application.constants.ILeanplumOverrideService", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
      developerTools = paramLinker.requestBinding("me.lyft.android.development.IDeveloperTools", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAutomationOverrideService get()
    {
      return module.provideSettingsOverrideService((ILyftPreferences)preferences.get(), (IConstantsProvider)constantsProvider.get(), (ILeanplumOverrideService)leanplumOverrideService.get(), (IJsonSerializer)jsonSerializer.get(), (IDeveloperTools)developerTools.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(preferences);
      paramSet1.add(constantsProvider);
      paramSet1.add(leanplumOverrideService);
      paramSet1.add(jsonSerializer);
      paramSet1.add(developerTools);
    }
  }
  
  public static final class ProvideSplitFareAnalyticsProvidesAdapter
    extends ProvidesBinding<SplitFareAnalytics>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideSplitFareAnalyticsProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideSplitFareAnalytics");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public SplitFareAnalytics get()
    {
      return module.provideSplitFareAnalytics();
    }
  }
  
  public static final class ProvideStatusBarServiceProvidesAdapter
    extends ProvidesBinding<IStatusBarNotificationsService>
  {
    private Binding<IAppForegroundDetector> appForegroundDetector;
    private Binding<DeepLinkManager> deepLinkManager;
    private Binding<ImageLoader> imageLoader;
    private Binding<IJsonSerializer> jsonSerializer;
    private final InfrastructureServicesModule module;
    private Binding<NotificationManager> notificationManager;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideStatusBarServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideStatusBarService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      imageLoader = paramLinker.requestBinding("me.lyft.android.managers.ImageLoader", InfrastructureServicesModule.class, getClass().getClassLoader());
      notificationManager = paramLinker.requestBinding("android.app.NotificationManager", InfrastructureServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
      appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", InfrastructureServicesModule.class, getClass().getClassLoader());
      jsonSerializer = paramLinker.requestBinding("me.lyft.android.infrastructure.json.IJsonSerializer", InfrastructureServicesModule.class, getClass().getClassLoader());
      deepLinkManager = paramLinker.requestBinding("me.lyft.android.deeplinks.DeepLinkManager", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IStatusBarNotificationsService get()
    {
      return module.provideStatusBarService((ImageLoader)imageLoader.get(), (NotificationManager)notificationManager.get(), (ILyftPreferences)preferences.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IJsonSerializer)jsonSerializer.get(), (DeepLinkManager)deepLinkManager.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(imageLoader);
      paramSet1.add(notificationManager);
      paramSet1.add(preferences);
      paramSet1.add(appForegroundDetector);
      paramSet1.add(jsonSerializer);
      paramSet1.add(deepLinkManager);
    }
  }
  
  public static final class ProvideStripeServiceProvidesAdapter
    extends ProvidesBinding<IStripeService>
  {
    private Binding<ILyftPreferences> lyftPreferences;
    private final InfrastructureServicesModule module;
    
    public ProvideStripeServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideStripeService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IStripeService get()
    {
      return module.provideStripeService((ILyftPreferences)lyftPreferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftPreferences);
    }
  }
  
  public static final class ProvideVerificationAutoFillServiceProvidesAdapter
    extends ProvidesBinding<IVerificationAutoFillService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideVerificationAutoFillServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(false, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideVerificationAutoFillService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IVerificationAutoFillService get()
    {
      return module.provideVerificationAutoFillService();
    }
  }
  
  public static final class ProvideViewServerServiceProvidesAdapter
    extends ProvidesBinding<IViewServerService>
  {
    private final InfrastructureServicesModule module;
    
    public ProvideViewServerServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideViewServerService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public IViewServerService get()
    {
      return module.provideViewServerService();
    }
  }
  
  public static final class ProvideWalletServiceProvidesAdapter
    extends ProvidesBinding<IAndroidPayService>
  {
    private Binding<IGoogleApiProvider> googleApiProvider;
    private final InfrastructureServicesModule module;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideWalletServiceProvidesAdapter(InfrastructureServicesModule paramInfrastructureServicesModule)
    {
      super(true, "me.lyft.android.infrastructure.InfrastructureServicesModule", "provideWalletService");
      module = paramInfrastructureServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      googleApiProvider = paramLinker.requestBinding("me.lyft.android.infrastructure.googleplay.IGoogleApiProvider", InfrastructureServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", InfrastructureServicesModule.class, getClass().getClassLoader());
    }
    
    public IAndroidPayService get()
    {
      return module.provideWalletService((IGoogleApiProvider)googleApiProvider.get(), (ILyftPreferences)preferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(googleApiProvider);
      paramSet1.add(preferences);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */