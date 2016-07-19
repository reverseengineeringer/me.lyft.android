package me.lyft.android.application;

import android.content.res.Resources;
import android.os.Handler;
import dagger.internal.Binding;
import dagger.internal.BindingsGroup;
import dagger.internal.Linker;
import dagger.internal.ModuleAdapter;
import dagger.internal.ProvidesBinding;
import java.util.List;
import java.util.Set;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.checkout.CheckoutSession;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.cleanup.ICleanupRegistry;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.driver.IDailyTotalsRepository;
import me.lyft.android.application.driver.IDriverDestinationService;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.eta.IPickupEtaFallbackService;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.features.IFeatureFlagOverrideStorage;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.geo.IEtaRepository;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.geo.ReverseGeocodeService;
import me.lyft.android.application.geo.routecache.DriverDeviationBasedCache;
import me.lyft.android.application.invite.IReferralService;
import me.lyft.android.application.invite.IWarmWelcomeService;
import me.lyft.android.application.jobs.IGoogleNowService;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.passenger.IPassengerRoutingService;
import me.lyft.android.application.passenger.IPassengerZoomProvider;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.payment.IPaymentDefaultsService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IBackgroundLocationTracker;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.application.polling.IPollingService;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.profile.IRideProfileService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.ride.GooglePlaceTypeAnalytics;
import me.lyft.android.application.ride.ICancellationOptionsProvider;
import me.lyft.android.application.ride.IDestinyService;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.ride.IDriverRouteService;
import me.lyft.android.application.ride.IExpenseNoteSession;
import me.lyft.android.application.ride.IFollowLocationManager;
import me.lyft.android.application.ride.IRatingSession;
import me.lyft.android.application.ride.IRideRequestService;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IRideSession;
import me.lyft.android.application.ride.IScheduledRideTimesService;
import me.lyft.android.application.ride.IUserDispatchService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.application.ride.IWearRideRequestService;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.services.ICarpoolRideService;
import me.lyft.android.application.riderequest.IRideRequestPollingService;
import me.lyft.android.application.settings.IAccessibilitySettingsService;
import me.lyft.android.application.settings.INavigationSettingsService;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.application.topdestinations.ITopDestinationsService;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.IAppStore;
import me.lyft.android.data.ContactsDatabaseHelper;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.payment.IPaymentFactory;
import me.lyft.android.domain.payment.IPaymentFactory.IPaymentMetadataProvider;
import me.lyft.android.driver.notifications.IDriverNotificationService;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.facebook.IFacebookTokenService;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.splitfare.ISplitFareService;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.persistence.ISimpleRepository;
import me.lyft.android.persistence.ISimpleRepositoryFactory;
import me.lyft.android.persistence.expensenotes.IExpenseNoteStorage;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.rating.IRatingStateStorage;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.utils.SoundManager;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

public final class ApplicationServicesModule$$ModuleAdapter
  extends ModuleAdapter<ApplicationServicesModule>
{
  private static final Class<?>[] INCLUDES = new Class[0];
  private static final String[] INJECTS = new String[0];
  private static final Class<?>[] STATIC_INJECTIONS = new Class[0];
  
  public ApplicationServicesModule$$ModuleAdapter()
  {
    super(ApplicationServicesModule.class, INJECTS, STATIC_INJECTIONS, false, INCLUDES, false, true);
  }
  
  public void getBindings(BindingsGroup paramBindingsGroup, ApplicationServicesModule paramApplicationServicesModule)
  {
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.payment.IPaymentService", new ProvidePaymentServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.payment.ICouponService", new ProvideCouponServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.driver.expresspay.IExpressPayRepository", new ProvideExpressPayRepositoryProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.passenger.IPassengerRideService", new ProvidePassengerRideServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.passenger.IPassengerRoutingService", new ProvidePassengerRoutingServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.checkout.ICheckoutSession", new ProvideCheckoutSessionProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IRatingSession", new ProvidePassengerRateDriverSessionProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IExpenseNoteSession", new ProvideExpenseNoteSessionProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.domain.payment.IPaymentFactory", new ProvidePaymentFactoryProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.domain.payment.IPaymentFactory$IPaymentMetadataProvider", new ProvidePaymentMetadataProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.IEtaAnalyticService", new ProvideEtaAnalyticServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.IEtaRepository", new ProvideEtaRepositoryProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.IGeoService", new ProvideGeoServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.routecache.DriverDeviationBasedCache", new ProvideDriverDeviationBasedCacheProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("@javax.inject.Named(value=passenger)/me.lyft.android.application.geo.IDirectionsService", new ProvidePassengerDirectionsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("@javax.inject.Named(value=driver)/me.lyft.android.application.geo.IDirectionsService", new ProvideDriverDirectionsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", new ProvideGoogleGeoAnalyticsProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.analytics.EditPickupAnalytics", new ProvideEditPickupAnalyticsProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.geo.ReverseGeocodeService", new ProvideReverseGeocodeServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.driver.IDailyTotalsRepository", new ProvideDailyTotalsRepositoryProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.landing.ILandingService", new ProvideLandingServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IRideRequestSession", new ProvideRideRequestSessionProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IRideSession", new ProvideRideSessionProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.venue.IVenuePickupService", new ProvidePickupVenueServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IScheduledRideTimesService", new ProvideScheduledRideTimesServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.flow.IRequestFlowProvider", new ProvideRequestFlowProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IFollowLocationManager", new ProvideFollowLocationManagerProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.IUserProvider", new ProvideUserProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IUserUiService", new ProvideUserServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.shortcuts.IShortcutService", new ProvideShortcutServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.topdestinations.ITopDestinationsService", new ProvideTopDestinationsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.constants.IConstantsProvider", new ProvideConstantsProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.tooltip.ITooltipService", new ProvideTooltipServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.constants.ILeanplumOverrideService", new ProvideleanplumOverrideServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.features.IFeaturesProvider", new ProvideFeaturesProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.IAppInfoService", new ProvideAppInfoServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IDestinyService", new ProvideDestinyServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IDriverRideProvider", new ProvideRouteProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.driver.IDriverDestinationService", new ProvideDriverDestinationServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.driver.notifications.IDriverNotificationService", new ProvideDriverNotificationServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.ICancellationOptionsProvider", new ProvideCancellationOptionsProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IDriverRouteService", new ProvideRouteServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.passenger.IPassengerRideProvider", new ProvidePassengerRideProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.passenger.IPassengerZoomProvider", new ProvidePassengerZoomProviderProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.settings.IAccessibilitySettingsService", new ProvideAccessibilityServiceSettingsProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.settings.INavigationSettingsService", new NavigationSettingsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.settings.ISettingsService", new ProvideSettingsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.settings.ISignUrlService", new ProvideSignUrlServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.enterprise.IEnterpriseService", new ProvideWorkServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.business.BusinessOnboardingAnalytics", new ProvideBusinessOnboardAnalyticsProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.GooglePlaceTypeAnalytics", new ProvideGooglePlaceTypeAnalyticsProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IRideRequestService", new ProvideRideRequestServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.IWearRideRequestService", new ProvideWearRideRequestServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ILogoutService", new ProvideLogoutServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.infrastructure.splitfare.ISplitFareService", new ProvideSplitFareServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.polling.IPollingAppProcess", new ProvidePollingOverseerProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.polling.IPollingService", new ProvidePollingServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.polling.ILocationUpdateService", new ProvidePollingRequestServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.driver.expresspay.IExpressPayService", new ProvideExpressPayServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.polling.IBackgroundLocationTracker", new ProvideBackgroundLocationTrackerProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.polling.IBackgroundLocationAppProcess", new ProvideBackgroundLocationSupervisorProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.invite.IReferralService", new ProvideReferralServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.invite.IWarmWelcomeService", new ProvideWarmWelcomeServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ats.IAtsService", new ProvideAtsServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.jobs.IGoogleNowService", new ProvideJobServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.driver.IVehicleService", new ProvideVehicleServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.riderequest.IRideRequestPollingService", new ProvideRideRequestPollingServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.eta.IPickupEtaFallbackService", new ProvidePickupEtaFallbackServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.eta.IPickupEtaService", new ProvidePickupEtaServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.drivers.INearbyDriversService", new ProvideNearbyDriverServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.cleanup.ICleanupRegistry", new ProvideCleanupRegistryProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.autofill.AutoFillService", new ProvideAutofillServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", new ProvideRequestRideTypeServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.requestridetypes.IRideTypeMetaService", new ProvideRideTypeMetaServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.cost.ICostService", new ProvideCostServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.profile.IProfileService", new ProvideProfileServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.profile.IRideProfileService", new ProvideRideProfileServiceProvidesAdapter(paramApplicationServicesModule));
    paramBindingsGroup.contributeProvidesBinding("me.lyft.android.application.ride.services.ICarpoolRideService", new ProvidesCarpoolRideServiceProvidesAdapter(paramApplicationServicesModule));
  }
  
  public ApplicationServicesModule newModule()
  {
    return new ApplicationServicesModule();
  }
  
  public static final class NavigationSettingsServiceProvidesAdapter
    extends ProvidesBinding<INavigationSettingsService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public NavigationSettingsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "navigationSettingsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public INavigationSettingsService get()
    {
      return module.navigationSettingsService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvideAccessibilityServiceSettingsProvidesAdapter
    extends ProvidesBinding<IAccessibilitySettingsService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideAccessibilityServiceSettingsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideAccessibilityServiceSettings");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IAccessibilitySettingsService get()
    {
      return module.provideAccessibilityServiceSettings((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideAppInfoServiceProvidesAdapter
    extends ProvidesBinding<IAppInfoService>
  {
    private Binding<IAssetPackagingService> assetPackagingService;
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<ILyftPreferences> preferences;
    private Binding<ITooltipService> tooltipService;
    
    public ProvideAppInfoServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideAppInfoService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      tooltipService = paramLinker.requestBinding("me.lyft.android.application.tooltip.ITooltipService", ApplicationServicesModule.class, getClass().getClassLoader());
      assetPackagingService = paramLinker.requestBinding("me.lyft.android.infrastructure.assets.IAssetPackagingService", ApplicationServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IAppInfoService get()
    {
      return module.provideAppInfoService((ILocationService)locationService.get(), (ILyftApi)lyftApi.get(), (IConstantsProvider)constantsProvider.get(), (ITooltipService)tooltipService.get(), (IAssetPackagingService)assetPackagingService.get(), (ILyftPreferences)preferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(locationService);
      paramSet1.add(lyftApi);
      paramSet1.add(constantsProvider);
      paramSet1.add(tooltipService);
      paramSet1.add(assetPackagingService);
      paramSet1.add(preferences);
    }
  }
  
  public static final class ProvideAtsServiceProvidesAdapter
    extends ProvidesBinding<IAtsService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideAtsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideAtsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IAtsService get()
    {
      return module.provideAtsService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideAutofillServiceProvidesAdapter
    extends ProvidesBinding<AutoFillService>
  {
    private Binding<IAppInfoService> appInfoService;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IRideRequestSession> rideRequestSession;
    private Binding<IUserProvider> userProvider;
    
    public ProvideAutofillServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideAutofillService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public AutoFillService get()
    {
      return module.provideAutofillService((ILocationService)locationService.get(), (ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IRideRequestSession)rideRequestSession.get(), (IAppInfoService)appInfoService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(locationService);
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
      paramSet1.add(rideRequestSession);
      paramSet1.add(appInfoService);
    }
  }
  
  public static final class ProvideBackgroundLocationSupervisorProvidesAdapter
    extends ProvidesBinding<IBackgroundLocationAppProcess>
  {
    private Binding<IAppForegroundDetector> appForegroundDetector;
    private Binding<IBackgroundLocationTracker> backgroundLocationTracker;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideBackgroundLocationSupervisorProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideBackgroundLocationSupervisor");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      backgroundLocationTracker = paramLinker.requestBinding("me.lyft.android.application.polling.IBackgroundLocationTracker", ApplicationServicesModule.class, getClass().getClassLoader());
      appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IBackgroundLocationAppProcess get()
    {
      return module.provideBackgroundLocationSupervisor((IBackgroundLocationTracker)backgroundLocationTracker.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(backgroundLocationTracker);
      paramSet1.add(appForegroundDetector);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvideBackgroundLocationTrackerProvidesAdapter
    extends ProvidesBinding<IBackgroundLocationTracker>
  {
    private Binding<ILocationService> locationService;
    private Binding<ILocationUpdateService> locationUpdateService;
    private final ApplicationServicesModule module;
    
    public ProvideBackgroundLocationTrackerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideBackgroundLocationTracker");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      locationUpdateService = paramLinker.requestBinding("me.lyft.android.application.polling.ILocationUpdateService", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IBackgroundLocationTracker get()
    {
      return module.provideBackgroundLocationTracker((ILocationUpdateService)locationUpdateService.get(), (ILocationService)locationService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(locationUpdateService);
      paramSet1.add(locationService);
    }
  }
  
  public static final class ProvideBusinessOnboardAnalyticsProvidesAdapter
    extends ProvidesBinding<BusinessOnboardingAnalytics>
  {
    private final ApplicationServicesModule module;
    
    public ProvideBusinessOnboardAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideBusinessOnboardAnalytics");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public BusinessOnboardingAnalytics get()
    {
      return module.provideBusinessOnboardAnalytics();
    }
  }
  
  public static final class ProvideCancellationOptionsProviderProvidesAdapter
    extends ProvidesBinding<ICancellationOptionsProvider>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private final ApplicationServicesModule module;
    
    public ProvideCancellationOptionsProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideCancellationOptionsProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ICancellationOptionsProvider get()
    {
      return module.provideCancellationOptionsProvider((IConstantsProvider)constantsProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(constantsProvider);
    }
  }
  
  public static final class ProvideCheckoutSessionProvidesAdapter
    extends ProvidesBinding<ICheckoutSession>
  {
    private Binding<CheckoutSession> checkoutSession;
    private final ApplicationServicesModule module;
    
    public ProvideCheckoutSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideCheckoutSession");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.CheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ICheckoutSession get()
    {
      return module.provideCheckoutSession((CheckoutSession)checkoutSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(checkoutSession);
    }
  }
  
  public static final class ProvideCleanupRegistryProvidesAdapter
    extends ProvidesBinding<ICleanupRegistry>
  {
    private final ApplicationServicesModule module;
    
    public ProvideCleanupRegistryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideCleanupRegistry");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public ICleanupRegistry get()
    {
      return module.provideCleanupRegistry();
    }
  }
  
  public static final class ProvideConstantsProviderProvidesAdapter
    extends ProvidesBinding<IConstantsProvider>
  {
    private final ApplicationServicesModule module;
    
    public ProvideConstantsProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideConstantsProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IConstantsProvider get()
    {
      return module.provideConstantsProvider();
    }
  }
  
  public static final class ProvideCostServiceProvidesAdapter
    extends ProvidesBinding<ICostService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideCostServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideCostService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ICostService get()
    {
      return module.provideCostService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideCouponServiceProvidesAdapter
    extends ProvidesBinding<ICouponService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
    private Binding<IUserProvider> userProvider;
    
    public ProvideCouponServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideCouponService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ICouponService get()
    {
      return module.provideCouponService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (ISimpleRepositoryFactory)simpleRepositoryFactory.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
      paramSet1.add(simpleRepositoryFactory);
    }
  }
  
  public static final class ProvideDailyTotalsRepositoryProvidesAdapter
    extends ProvidesBinding<IDailyTotalsRepository>
  {
    private final ApplicationServicesModule module;
    
    public ProvideDailyTotalsRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDailyTotalsRepository");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IDailyTotalsRepository get()
    {
      return module.provideDailyTotalsRepository();
    }
  }
  
  public static final class ProvideDestinyServiceProvidesAdapter
    extends ProvidesBinding<IDestinyService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideDestinyServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDestinyService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IDestinyService get()
    {
      return module.provideDestinyService((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideDriverDestinationServiceProvidesAdapter
    extends ProvidesBinding<IDriverDestinationService>
  {
    private final ApplicationServicesModule module;
    
    public ProvideDriverDestinationServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDestinationService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IDriverDestinationService get()
    {
      return module.provideDriverDestinationService();
    }
  }
  
  public static final class ProvideDriverDeviationBasedCacheProvidesAdapter
    extends ProvidesBinding<DriverDeviationBasedCache>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    
    public ProvideDriverDeviationBasedCacheProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDeviationBasedCache");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public DriverDeviationBasedCache get()
    {
      return module.provideDriverDeviationBasedCache((IPassengerRideProvider)passengerRideProvider.get(), (IConstantsProvider)constantsProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(passengerRideProvider);
      paramSet1.add(constantsProvider);
    }
  }
  
  public static final class ProvideDriverDirectionsServiceProvidesAdapter
    extends ProvidesBinding<IDirectionsService>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
    private Binding<IGoogleGeoApi> googleGeoApi;
    private final ApplicationServicesModule module;
    
    public ProvideDriverDirectionsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverDirectionsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IDirectionsService get()
    {
      return module.provideDriverDirectionsService((IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get(), (IConstantsProvider)constantsProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(googleGeoApi);
      paramSet1.add(googleGeoAnalytics);
      paramSet1.add(constantsProvider);
    }
  }
  
  public static final class ProvideDriverNotificationServiceProvidesAdapter
    extends ProvidesBinding<IDriverNotificationService>
  {
    private Binding<IAppForegroundDetector> appForegroundDetector;
    private Binding<DialogFlow> dialogFlow;
    private Binding<Handler> handler;
    private final ApplicationServicesModule module;
    private Binding<Navigator> navigator;
    private Binding<Resources> resources;
    private Binding<SoundManager> soundManager;
    private Binding<TextToSpeech> textToSpeech;
    private Binding<Vibrator> vibrator;
    
    public ProvideDriverNotificationServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideDriverNotificationService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      textToSpeech = paramLinker.requestBinding("me.lyft.android.utils.TextToSpeech", ApplicationServicesModule.class, getClass().getClassLoader());
      dialogFlow = paramLinker.requestBinding("me.lyft.android.common.DialogFlow", ApplicationServicesModule.class, getClass().getClassLoader());
      soundManager = paramLinker.requestBinding("me.lyft.android.utils.SoundManager", ApplicationServicesModule.class, getClass().getClassLoader());
      resources = paramLinker.requestBinding("android.content.res.Resources", ApplicationServicesModule.class, getClass().getClassLoader());
      appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
      navigator = paramLinker.requestBinding("me.lyft.android.navigation.Navigator", ApplicationServicesModule.class, getClass().getClassLoader());
      vibrator = paramLinker.requestBinding("me.lyft.android.utils.Vibrator", ApplicationServicesModule.class, getClass().getClassLoader());
      handler = paramLinker.requestBinding("android.os.Handler", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IDriverNotificationService get()
    {
      return module.provideDriverNotificationService((TextToSpeech)textToSpeech.get(), (DialogFlow)dialogFlow.get(), (SoundManager)soundManager.get(), (Resources)resources.get(), (IAppForegroundDetector)appForegroundDetector.get(), (Navigator)navigator.get(), (Vibrator)vibrator.get(), (Handler)handler.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(textToSpeech);
      paramSet1.add(dialogFlow);
      paramSet1.add(soundManager);
      paramSet1.add(resources);
      paramSet1.add(appForegroundDetector);
      paramSet1.add(navigator);
      paramSet1.add(vibrator);
      paramSet1.add(handler);
    }
  }
  
  public static final class ProvideEditPickupAnalyticsProvidesAdapter
    extends ProvidesBinding<EditPickupAnalytics>
  {
    private final ApplicationServicesModule module;
    
    public ProvideEditPickupAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideEditPickupAnalytics");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public EditPickupAnalytics get()
    {
      return module.provideEditPickupAnalytics();
    }
  }
  
  public static final class ProvideEtaAnalyticServiceProvidesAdapter
    extends ProvidesBinding<IEtaAnalyticService>
  {
    private final ApplicationServicesModule module;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvideEtaAnalyticServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideEtaAnalyticService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IEtaAnalyticService get()
    {
      return module.provideEtaAnalyticService((IRideRequestSession)rideRequestSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(rideRequestSession);
    }
  }
  
  public static final class ProvideEtaRepositoryProvidesAdapter
    extends ProvidesBinding<IEtaRepository>
  {
    private final ApplicationServicesModule module;
    
    public ProvideEtaRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideEtaRepository");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IEtaRepository get()
    {
      return module.provideEtaRepository();
    }
  }
  
  public static final class ProvideExpenseNoteSessionProvidesAdapter
    extends ProvidesBinding<IExpenseNoteSession>
  {
    private Binding<IExpenseNoteStorage> expenseNoteStorage;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideExpenseNoteSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideExpenseNoteSession");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      expenseNoteStorage = paramLinker.requestBinding("me.lyft.android.persistence.expensenotes.IExpenseNoteStorage", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IExpenseNoteSession get()
    {
      return module.provideExpenseNoteSession((IExpenseNoteStorage)expenseNoteStorage.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(expenseNoteStorage);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvideExpressPayRepositoryProvidesAdapter
    extends ProvidesBinding<IExpressPayRepository>
  {
    private final ApplicationServicesModule module;
    
    public ProvideExpressPayRepositoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideExpressPayRepository");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IExpressPayRepository get()
    {
      return module.provideExpressPayRepository();
    }
  }
  
  public static final class ProvideExpressPayServiceProvidesAdapter
    extends ProvidesBinding<IExpressPayService>
  {
    private Binding<IExpressPayRepository> expressPayRepository;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IStripeService> stripeService;
    private Binding<IUserProvider> userProvider;
    
    public ProvideExpressPayServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideExpressPayService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      expressPayRepository = paramLinker.requestBinding("me.lyft.android.application.driver.expresspay.IExpressPayRepository", ApplicationServicesModule.class, getClass().getClassLoader());
      stripeService = paramLinker.requestBinding("me.lyft.android.infrastructure.stripe.IStripeService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IExpressPayService get()
    {
      return module.provideExpressPayService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IExpressPayRepository)expressPayRepository.get(), (IStripeService)stripeService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
      paramSet1.add(expressPayRepository);
      paramSet1.add(stripeService);
    }
  }
  
  public static final class ProvideFeaturesProviderProvidesAdapter
    extends ProvidesBinding<IFeaturesProvider>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<IFeatureFlagOverrideStorage> featureFlagOverrideStorage;
    private final ApplicationServicesModule module;
    
    public ProvideFeaturesProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideFeaturesProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      featureFlagOverrideStorage = paramLinker.requestBinding("me.lyft.android.application.features.IFeatureFlagOverrideStorage", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IFeaturesProvider get()
    {
      return module.provideFeaturesProvider((IConstantsProvider)constantsProvider.get(), (IFeatureFlagOverrideStorage)featureFlagOverrideStorage.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(constantsProvider);
      paramSet1.add(featureFlagOverrideStorage);
    }
  }
  
  public static final class ProvideFollowLocationManagerProvidesAdapter
    extends ProvidesBinding<IFollowLocationManager>
  {
    private Binding<ILocationService> locationService;
    private final ApplicationServicesModule module;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvideFollowLocationManagerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideFollowLocationManager");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IFollowLocationManager get()
    {
      return module.provideFollowLocationManager((ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(locationService);
      paramSet1.add(rideRequestSession);
    }
  }
  
  public static final class ProvideGeoServiceProvidesAdapter
    extends ProvidesBinding<IGeoService>
  {
    private Binding<IEtaAnalyticService> etaAnalyticService;
    private Binding<IEtaRepository> etaRepository;
    private Binding<IGoogleGeoApi> googleApiService;
    private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
    private final ApplicationServicesModule module;
    private Binding<ReverseGeocodeService> reverseGeocodeService;
    
    public ProvideGeoServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideGeoService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      reverseGeocodeService = paramLinker.requestBinding("me.lyft.android.application.geo.ReverseGeocodeService", ApplicationServicesModule.class, getClass().getClassLoader());
      googleApiService = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
      etaRepository = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaRepository", ApplicationServicesModule.class, getClass().getClassLoader());
      etaAnalyticService = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaAnalyticService", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IGeoService get()
    {
      return module.provideGeoService((ReverseGeocodeService)reverseGeocodeService.get(), (IGoogleGeoApi)googleApiService.get(), (IEtaRepository)etaRepository.get(), (IEtaAnalyticService)etaAnalyticService.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(reverseGeocodeService);
      paramSet1.add(googleApiService);
      paramSet1.add(etaRepository);
      paramSet1.add(etaAnalyticService);
      paramSet1.add(googleGeoAnalytics);
    }
  }
  
  public static final class ProvideGoogleGeoAnalyticsProvidesAdapter
    extends ProvidesBinding<GoogleGeoAnalytics>
  {
    private final ApplicationServicesModule module;
    
    public ProvideGoogleGeoAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideGoogleGeoAnalytics");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public GoogleGeoAnalytics get()
    {
      return module.provideGoogleGeoAnalytics();
    }
  }
  
  public static final class ProvideGooglePlaceTypeAnalyticsProvidesAdapter
    extends ProvidesBinding<GooglePlaceTypeAnalytics>
  {
    private final ApplicationServicesModule module;
    
    public ProvideGooglePlaceTypeAnalyticsProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideGooglePlaceTypeAnalytics");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public GooglePlaceTypeAnalytics get()
    {
      return module.provideGooglePlaceTypeAnalytics();
    }
  }
  
  public static final class ProvideJobServiceProvidesAdapter
    extends ProvidesBinding<IGoogleNowService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideJobServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideJobService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IGoogleNowService get()
    {
      return module.provideJobService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideLandingServiceProvidesAdapter
    extends ProvidesBinding<ILandingService>
  {
    private Binding<IAppStore> appStore;
    private Binding<IChargeAccountsProvider> chargeAccountsProvider;
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IPaymentService> paymentService;
    private Binding<ILyftPreferences> preferences;
    private Binding<ISignUpUserRepository> singUpUserRepository;
    private Binding<IUserProvider> userProvider;
    
    public ProvideLandingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(false, "me.lyft.android.application.ApplicationServicesModule", "provideLandingService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      singUpUserRepository = paramLinker.requestBinding("me.lyft.android.persistence.landing.ISignUpUserRepository", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
      paymentService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentService", ApplicationServicesModule.class, getClass().getClassLoader());
      chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      appStore = paramLinker.requestBinding("me.lyft.android.common.IAppStore", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ILandingService get()
    {
      return module.provideLandingService((ISignUpUserRepository)singUpUserRepository.get(), (IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get(), (ILocationService)locationService.get(), (ILyftPreferences)preferences.get(), (IPaymentService)paymentService.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (IConstantsProvider)constantsProvider.get(), (IAppStore)appStore.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(singUpUserRepository);
      paramSet1.add(userProvider);
      paramSet1.add(lyftApi);
      paramSet1.add(locationService);
      paramSet1.add(preferences);
      paramSet1.add(paymentService);
      paramSet1.add(chargeAccountsProvider);
      paramSet1.add(constantsProvider);
      paramSet1.add(appStore);
    }
  }
  
  public static final class ProvideLogoutServiceProvidesAdapter
    extends ProvidesBinding<ILogoutService>
  {
    private Binding<ICleanupRegistry> cleanupRegistry;
    private Binding<IFacebookTokenService> facebookService;
    private Binding<ILyftApi> lyftApi;
    private Binding<LyftApplication> lyftApplication;
    private final ApplicationServicesModule module;
    private Binding<ILyftPreferences> preferences;
    private Binding<IRideRequestSession> rideRequestSession;
    private Binding<IUserProvider> userProvider;
    private Binding<IUserSession> userSession;
    
    public ProvideLogoutServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideLogoutService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApplication = paramLinker.requestBinding("me.lyft.android.LyftApplication", ApplicationServicesModule.class, getClass().getClassLoader());
      userSession = paramLinker.requestBinding("me.lyft.android.IUserSession", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
      facebookService = paramLinker.requestBinding("me.lyft.android.infrastructure.facebook.IFacebookTokenService", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      cleanupRegistry = paramLinker.requestBinding("me.lyft.android.application.cleanup.ICleanupRegistry", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ILogoutService get()
    {
      return module.provideLogoutService((LyftApplication)lyftApplication.get(), (IUserSession)userSession.get(), (IRideRequestSession)rideRequestSession.get(), (ILyftApi)lyftApi.get(), (ILyftPreferences)preferences.get(), (IFacebookTokenService)facebookService.get(), (IUserProvider)userProvider.get(), (ICleanupRegistry)cleanupRegistry.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApplication);
      paramSet1.add(userSession);
      paramSet1.add(rideRequestSession);
      paramSet1.add(lyftApi);
      paramSet1.add(preferences);
      paramSet1.add(facebookService);
      paramSet1.add(userProvider);
      paramSet1.add(cleanupRegistry);
    }
  }
  
  public static final class ProvideNearbyDriverServiceProvidesAdapter
    extends ProvidesBinding<INearbyDriversService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideNearbyDriverServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideNearbyDriverService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public INearbyDriversService get()
    {
      return module.provideNearbyDriverService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvidePassengerDirectionsServiceProvidesAdapter
    extends ProvidesBinding<IDirectionsService>
  {
    private Binding<DriverDeviationBasedCache> driverDeviationBasedCache;
    private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
    private Binding<IGoogleGeoApi> googleGeoApi;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvidePassengerDirectionsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerDirectionsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
      driverDeviationBasedCache = paramLinker.requestBinding("me.lyft.android.application.geo.routecache.DriverDeviationBasedCache", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IDirectionsService get()
    {
      return module.providePassengerDirectionsService((ILyftApi)lyftApi.get(), (IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get(), (DriverDeviationBasedCache)driverDeviationBasedCache.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(googleGeoApi);
      paramSet1.add(googleGeoAnalytics);
      paramSet1.add(driverDeviationBasedCache);
    }
  }
  
  public static final class ProvidePassengerRateDriverSessionProvidesAdapter
    extends ProvidesBinding<IRatingSession>
  {
    private final ApplicationServicesModule module;
    private Binding<IRatingStateStorage> stateStorage;
    
    public ProvidePassengerRateDriverSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRateDriverSession");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      stateStorage = paramLinker.requestBinding("me.lyft.android.persistence.rating.IRatingStateStorage", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRatingSession get()
    {
      return module.providePassengerRateDriverSession((IRatingStateStorage)stateStorage.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(stateStorage);
    }
  }
  
  public static final class ProvidePassengerRideProviderProvidesAdapter
    extends ProvidesBinding<IPassengerRideProvider>
  {
    private final ApplicationServicesModule module;
    
    public ProvidePassengerRideProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRideProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IPassengerRideProvider get()
    {
      return module.providePassengerRideProvider();
    }
  }
  
  public static final class ProvidePassengerRideServiceProvidesAdapter
    extends ProvidesBinding<IPassengerRideService>
  {
    private Binding<ICheckoutSession> checkoutSession;
    private Binding<IExpenseNoteSession> expenseNoteSession;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    private Binding<IRatingSession> ratingSession;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvidePassengerRideServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRideService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      ratingSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRatingSession", ApplicationServicesModule.class, getClass().getClassLoader());
      expenseNoteSession = paramLinker.requestBinding("me.lyft.android.application.ride.IExpenseNoteSession", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPassengerRideService get()
    {
      return module.providePassengerRideService((ILyftApi)lyftApi.get(), (IPassengerRideProvider)passengerRideProvider.get(), (ICheckoutSession)checkoutSession.get(), (ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get(), (IRatingSession)ratingSession.get(), (IExpenseNoteSession)expenseNoteSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(passengerRideProvider);
      paramSet1.add(checkoutSession);
      paramSet1.add(locationService);
      paramSet1.add(rideRequestSession);
      paramSet1.add(ratingSession);
      paramSet1.add(expenseNoteSession);
    }
  }
  
  public static final class ProvidePassengerRoutingServiceProvidesAdapter
    extends ProvidesBinding<IPassengerRoutingService>
  {
    private Binding<IDirectionsService> directionsService;
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    
    public ProvidePassengerRoutingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerRoutingService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      directionsService = paramLinker.requestBinding("@javax.inject.Named(value=passenger)/me.lyft.android.application.geo.IDirectionsService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPassengerRoutingService get()
    {
      return module.providePassengerRoutingService((IPassengerRideProvider)passengerRideProvider.get(), (IDirectionsService)directionsService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(passengerRideProvider);
      paramSet1.add(directionsService);
    }
  }
  
  public static final class ProvidePassengerZoomProviderProvidesAdapter
    extends ProvidesBinding<IPassengerZoomProvider>
  {
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    private Binding<IPassengerRoutingService> passengerRoutingService;
    
    public ProvidePassengerZoomProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePassengerZoomProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      passengerRoutingService = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRoutingService", ApplicationServicesModule.class, getClass().getClassLoader());
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPassengerZoomProvider get()
    {
      return module.providePassengerZoomProvider((IPassengerRoutingService)passengerRoutingService.get(), (IPassengerRideProvider)passengerRideProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(passengerRoutingService);
      paramSet1.add(passengerRideProvider);
    }
  }
  
  public static final class ProvidePaymentFactoryProvidesAdapter
    extends ProvidesBinding<IPaymentFactory>
  {
    private final ApplicationServicesModule module;
    private Binding<IPaymentFactory.IPaymentMetadataProvider> provider;
    
    public ProvidePaymentFactoryProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(false, "me.lyft.android.application.ApplicationServicesModule", "providePaymentFactory");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      provider = paramLinker.requestBinding("me.lyft.android.domain.payment.IPaymentFactory$IPaymentMetadataProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPaymentFactory get()
    {
      return module.providePaymentFactory((IPaymentFactory.IPaymentMetadataProvider)provider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(provider);
    }
  }
  
  public static final class ProvidePaymentMetadataProviderProvidesAdapter
    extends ProvidesBinding<IPaymentFactory.IPaymentMetadataProvider>
  {
    private final ApplicationServicesModule module;
    private Binding<IPayPalService> service;
    
    public ProvidePaymentMetadataProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(false, "me.lyft.android.application.ApplicationServicesModule", "providePaymentMetadataProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      service = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPaymentFactory.IPaymentMetadataProvider get()
    {
      return module.providePaymentMetadataProvider((IPayPalService)service.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(service);
    }
  }
  
  public static final class ProvidePaymentServiceProvidesAdapter
    extends ProvidesBinding<IPaymentService>
  {
    private Binding<IChargeAccountsProvider> chargeAccountsProvider;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IPayPalService> payPalService;
    private Binding<IStripeService> stripeService;
    private Binding<IUserProvider> userProvider;
    private Binding<IAndroidPayService> walletService;
    
    public ProvidePaymentServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePaymentService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      stripeService = paramLinker.requestBinding("me.lyft.android.infrastructure.stripe.IStripeService", ApplicationServicesModule.class, getClass().getClassLoader());
      walletService = paramLinker.requestBinding("me.lyft.android.infrastructure.androidpay.IAndroidPayService", ApplicationServicesModule.class, getClass().getClassLoader());
      payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
      chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPaymentService get()
    {
      return module.providePaymentService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get(), (IStripeService)stripeService.get(), (IAndroidPayService)walletService.get(), (IPayPalService)payPalService.get(), (IChargeAccountsProvider)chargeAccountsProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
      paramSet1.add(stripeService);
      paramSet1.add(walletService);
      paramSet1.add(payPalService);
      paramSet1.add(chargeAccountsProvider);
    }
  }
  
  public static final class ProvidePickupEtaFallbackServiceProvidesAdapter
    extends ProvidesBinding<IPickupEtaFallbackService>
  {
    private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
    private Binding<IGoogleGeoApi> googleGeoApi;
    private final ApplicationServicesModule module;
    private Binding<INearbyDriversService> nearbyDriversService;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvidePickupEtaFallbackServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePickupEtaFallbackService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      nearbyDriversService = paramLinker.requestBinding("me.lyft.android.application.drivers.INearbyDriversService", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoApi = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPickupEtaFallbackService get()
    {
      return module.providePickupEtaFallbackService((INearbyDriversService)nearbyDriversService.get(), (IRideRequestSession)rideRequestSession.get(), (IGoogleGeoApi)googleGeoApi.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(nearbyDriversService);
      paramSet1.add(rideRequestSession);
      paramSet1.add(googleGeoApi);
      paramSet1.add(googleGeoAnalytics);
    }
  }
  
  public static final class ProvidePickupEtaServiceProvidesAdapter
    extends ProvidesBinding<IPickupEtaService>
  {
    private Binding<IEtaAnalyticService> etaAnalyticService;
    private Binding<IPickupEtaFallbackService> fallbackService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvidePickupEtaServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePickupEtaService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      fallbackService = paramLinker.requestBinding("me.lyft.android.application.eta.IPickupEtaFallbackService", ApplicationServicesModule.class, getClass().getClassLoader());
      etaAnalyticService = paramLinker.requestBinding("me.lyft.android.application.geo.IEtaAnalyticService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPickupEtaService get()
    {
      return module.providePickupEtaService((ILyftApi)lyftApi.get(), (IPickupEtaFallbackService)fallbackService.get(), (IEtaAnalyticService)etaAnalyticService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(fallbackService);
      paramSet1.add(etaAnalyticService);
    }
  }
  
  public static final class ProvidePickupVenueServiceProvidesAdapter
    extends ProvidesBinding<IVenuePickupService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IRideRequestSession> rideRequestSession;
    
    public ProvidePickupVenueServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePickupVenueService");
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
  
  public static final class ProvidePollingOverseerProvidesAdapter
    extends ProvidesBinding<IPollingAppProcess>
  {
    private Binding<IAppForegroundDetector> appForegroundDetector;
    private final ApplicationServicesModule module;
    private Binding<IPollingService> pollingService;
    private Binding<IUserProvider> userProvider;
    
    public ProvidePollingOverseerProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePollingOverseer");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      pollingService = paramLinker.requestBinding("me.lyft.android.application.polling.IPollingService", ApplicationServicesModule.class, getClass().getClassLoader());
      appForegroundDetector = paramLinker.requestBinding("me.lyft.android.infrastructure.foreground.IAppForegroundDetector", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPollingAppProcess get()
    {
      return module.providePollingOverseer((IPollingService)pollingService.get(), (IAppForegroundDetector)appForegroundDetector.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(pollingService);
      paramSet1.add(appForegroundDetector);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvidePollingRequestServiceProvidesAdapter
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
    
    public ProvidePollingRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePollingRequestService");
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
  
  public static final class ProvidePollingServiceProvidesAdapter
    extends ProvidesBinding<IPollingService>
  {
    private Binding<ILocationService> locationService;
    private Binding<ILyftPreferences> lyftPreferences;
    private final ApplicationServicesModule module;
    private Binding<ILocationUpdateService> pollingRequestService;
    
    public ProvidePollingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providePollingService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      pollingRequestService = paramLinker.requestBinding("me.lyft.android.application.polling.ILocationUpdateService", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IPollingService get()
    {
      return module.providePollingService((ILocationUpdateService)pollingRequestService.get(), (ILocationService)locationService.get(), (ILyftPreferences)lyftPreferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(pollingRequestService);
      paramSet1.add(locationService);
      paramSet1.add(lyftPreferences);
    }
  }
  
  public static final class ProvideProfileServiceProvidesAdapter
    extends ProvidesBinding<IProfileService>
  {
    private Binding<ILyftApi> api;
    private final ApplicationServicesModule module;
    private Binding<IProfilePhotoFileRecipient> profilePhotoFileRecipient;
    private Binding<IS3Api> s3Api;
    private Binding<IUserProvider> userProvider;
    
    public ProvideProfileServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideProfileService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      s3Api = paramLinker.requestBinding("me.lyft.android.infrastructure.environment.IS3Api", ApplicationServicesModule.class, getClass().getClassLoader());
      api = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      profilePhotoFileRecipient = paramLinker.requestBinding("me.lyft.android.application.profile.IProfilePhotoFileRecipient", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IProfileService get()
    {
      return module.provideProfileService((IUserProvider)userProvider.get(), (IS3Api)s3Api.get(), (ILyftApi)api.get(), (IProfilePhotoFileRecipient)profilePhotoFileRecipient.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(s3Api);
      paramSet1.add(api);
      paramSet1.add(profilePhotoFileRecipient);
    }
  }
  
  public static final class ProvideReferralServiceProvidesAdapter
    extends ProvidesBinding<IReferralService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideReferralServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideReferralService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IReferralService get()
    {
      return module.provideReferralService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideRequestFlowProviderProvidesAdapter
    extends ProvidesBinding<IRequestFlowProvider>
  {
    private final ApplicationServicesModule module;
    private Binding<IRideRequestSession> session;
    private Binding<IVenuePickupService> venueService;
    
    public ProvideRequestFlowProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRequestFlowProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      session = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      venueService = paramLinker.requestBinding("me.lyft.android.application.venue.IVenuePickupService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRequestFlowProvider get()
    {
      return module.provideRequestFlowProvider((IRideRequestSession)session.get(), (IVenuePickupService)venueService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(session);
      paramSet1.add(venueService);
    }
  }
  
  public static final class ProvideRequestRideTypeServiceProvidesAdapter
    extends ProvidesBinding<IRequestRideTypeService>
  {
    private Binding<IAppInfoService> appInfoService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<ISimpleRepository<List<RequestRideType>>> rideTypesRepository;
    
    public ProvideRequestRideTypeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRequestRideTypeService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
      rideTypesRepository = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepository<java.util.List<me.lyft.android.domain.passenger.ridetypes.RequestRideType>>", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRequestRideTypeService get()
    {
      return module.provideRequestRideTypeService((ILyftApi)lyftApi.get(), (IAppInfoService)appInfoService.get(), (ISimpleRepository)rideTypesRepository.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(appInfoService);
      paramSet1.add(rideTypesRepository);
    }
  }
  
  public static final class ProvideReverseGeocodeServiceProvidesAdapter
    extends ProvidesBinding<ReverseGeocodeService>
  {
    private Binding<GoogleGeoAnalytics> googleGeoAnalytics;
    private Binding<IGoogleGeoApi> googleGeoApiService;
    private final ApplicationServicesModule module;
    
    public ProvideReverseGeocodeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideReverseGeocodeService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      googleGeoApiService = paramLinker.requestBinding("me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi", ApplicationServicesModule.class, getClass().getClassLoader());
      googleGeoAnalytics = paramLinker.requestBinding("me.lyft.android.application.geo.GoogleGeoAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ReverseGeocodeService get()
    {
      return module.provideReverseGeocodeService((IGoogleGeoApi)googleGeoApiService.get(), (GoogleGeoAnalytics)googleGeoAnalytics.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(googleGeoApiService);
      paramSet1.add(googleGeoAnalytics);
    }
  }
  
  public static final class ProvideRideProfileServiceProvidesAdapter
    extends ProvidesBinding<IRideProfileService>
  {
    private final ApplicationServicesModule module;
    
    public ProvideRideProfileServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideProfileService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IRideProfileService get()
    {
      return module.provideRideProfileService();
    }
  }
  
  public static final class ProvideRideRequestPollingServiceProvidesAdapter
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
    
    public ProvideRideRequestPollingServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestPollingService");
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
  
  public static final class ProvideRideRequestServiceProvidesAdapter
    extends ProvidesBinding<IRideRequestService>
  {
    private Binding<IChargeAccountsProvider> chargeAccountsProvider;
    private Binding<ICheckoutSession> checkoutSession;
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<ICostService> costService;
    private Binding<IPaymentDefaultsService> defaultPaymentSettingsService;
    private Binding<IFeaturesProvider> featuresProvider;
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    private Binding<IPayPalService> payPalService;
    private Binding<IPaymentService> paymentService;
    private Binding<IRequestRideTypeService> requestRideTypeService;
    private Binding<IRideRequestSession> rideRequestSession;
    private Binding<IUserProvider> userProvider;
    
    public ProvideRideRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
      rideRequestSession = paramLinker.requestBinding("me.lyft.android.application.ride.IRideRequestSession", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      featuresProvider = paramLinker.requestBinding("me.lyft.android.application.features.IFeaturesProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      paymentService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentService", ApplicationServicesModule.class, getClass().getClassLoader());
      defaultPaymentSettingsService = paramLinker.requestBinding("me.lyft.android.application.payment.IPaymentDefaultsService", ApplicationServicesModule.class, getClass().getClassLoader());
      payPalService = paramLinker.requestBinding("me.lyft.android.infrastructure.paypal.IPayPalService", ApplicationServicesModule.class, getClass().getClassLoader());
      costService = paramLinker.requestBinding("me.lyft.android.application.cost.ICostService", ApplicationServicesModule.class, getClass().getClassLoader());
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      requestRideTypeService = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRideRequestService get()
    {
      return module.provideRideRequestService((IUserProvider)userProvider.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (ILocationService)locationService.get(), (IRideRequestSession)rideRequestSession.get(), (ILyftApi)lyftApi.get(), (ICheckoutSession)checkoutSession.get(), (IConstantsProvider)constantsProvider.get(), (IFeaturesProvider)featuresProvider.get(), (IPaymentService)paymentService.get(), (IPaymentDefaultsService)defaultPaymentSettingsService.get(), (IPayPalService)payPalService.get(), (ICostService)costService.get(), (IPassengerRideProvider)passengerRideProvider.get(), (IRequestRideTypeService)requestRideTypeService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(chargeAccountsProvider);
      paramSet1.add(locationService);
      paramSet1.add(rideRequestSession);
      paramSet1.add(lyftApi);
      paramSet1.add(checkoutSession);
      paramSet1.add(constantsProvider);
      paramSet1.add(featuresProvider);
      paramSet1.add(paymentService);
      paramSet1.add(defaultPaymentSettingsService);
      paramSet1.add(payPalService);
      paramSet1.add(costService);
      paramSet1.add(passengerRideProvider);
      paramSet1.add(requestRideTypeService);
    }
  }
  
  public static final class ProvideRideRequestSessionProvidesAdapter
    extends ProvidesBinding<IRideRequestSession>
  {
    private final ApplicationServicesModule module;
    private Binding<ILyftPreferences> preferences;
    private Binding<IRequestRideTypeService> requestRideTypeProvider;
    
    public ProvideRideRequestSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideRequestSession");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
      requestRideTypeProvider = paramLinker.requestBinding("me.lyft.android.application.requestridetypes.IRequestRideTypeService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRideRequestSession get()
    {
      return module.provideRideRequestSession((ILyftPreferences)preferences.get(), (IRequestRideTypeService)requestRideTypeProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(preferences);
      paramSet1.add(requestRideTypeProvider);
    }
  }
  
  public static final class ProvideRideSessionProvidesAdapter
    extends ProvidesBinding<IRideSession>
  {
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    
    public ProvideRideSessionProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideSession");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRideSession get()
    {
      return module.provideRideSession((IPassengerRideProvider)passengerRideProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(passengerRideProvider);
    }
  }
  
  public static final class ProvideRideTypeMetaServiceProvidesAdapter
    extends ProvidesBinding<IRideTypeMetaService>
  {
    private Binding<IAppInfoService> appInfoService;
    private final ApplicationServicesModule module;
    
    public ProvideRideTypeMetaServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRideTypeMetaService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      appInfoService = paramLinker.requestBinding("me.lyft.android.application.IAppInfoService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IRideTypeMetaService get()
    {
      return module.provideRideTypeMetaService((IAppInfoService)appInfoService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(appInfoService);
    }
  }
  
  public static final class ProvideRouteProviderProvidesAdapter
    extends ProvidesBinding<IDriverRideProvider>
  {
    private final ApplicationServicesModule module;
    
    public ProvideRouteProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRouteProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IDriverRideProvider get()
    {
      return module.provideRouteProvider();
    }
  }
  
  public static final class ProvideRouteServiceProvidesAdapter
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
    
    public ProvideRouteServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideRouteService");
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
  
  public static final class ProvideScheduledRideTimesServiceProvidesAdapter
    extends ProvidesBinding<IScheduledRideTimesService>
  {
    private Binding<ILyftApi> api;
    private final ApplicationServicesModule module;
    
    public ProvideScheduledRideTimesServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideScheduledRideTimesService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      api = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IScheduledRideTimesService get()
    {
      return module.provideScheduledRideTimesService((ILyftApi)api.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(api);
    }
  }
  
  public static final class ProvideSettingsServiceProvidesAdapter
    extends ProvidesBinding<ISettingsService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideSettingsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideSettingsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ISettingsService get()
    {
      return module.provideSettingsService((ILyftApi)lyftApi.get(), (IUserProvider)userProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(userProvider);
    }
  }
  
  public static final class ProvideShortcutServiceProvidesAdapter
    extends ProvidesBinding<IShortcutService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideShortcutServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideShortcutService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IShortcutService get()
    {
      return module.provideShortcutService((IUserProvider)userProvider.get(), (ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideSignUrlServiceProvidesAdapter
    extends ProvidesBinding<ISignUrlService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideSignUrlServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideSignUrlService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ISignUrlService get()
    {
      return module.provideSignUrlService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideSplitFareServiceProvidesAdapter
    extends ProvidesBinding<ISplitFareService>
  {
    private Binding<ContactsDatabaseHelper> contactsDatabaseHelper;
    private Binding<ContactsProvider> contactsProvider;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<Resources> resources;
    private Binding<IPassengerRideProvider> rideProvider;
    private Binding<SplitFareAnalytics> splitFareAnalytics;
    
    public ProvideSplitFareServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideSplitFareService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      contactsDatabaseHelper = paramLinker.requestBinding("me.lyft.android.data.ContactsDatabaseHelper", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      rideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      contactsProvider = paramLinker.requestBinding("me.lyft.android.providers.ContactsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      resources = paramLinker.requestBinding("android.content.res.Resources", ApplicationServicesModule.class, getClass().getClassLoader());
      splitFareAnalytics = paramLinker.requestBinding("me.lyft.android.analytics.studies.SplitFareAnalytics", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ISplitFareService get()
    {
      return module.provideSplitFareService((ContactsDatabaseHelper)contactsDatabaseHelper.get(), (ILyftApi)lyftApi.get(), (IPassengerRideProvider)rideProvider.get(), (ContactsProvider)contactsProvider.get(), (Resources)resources.get(), (SplitFareAnalytics)splitFareAnalytics.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(contactsDatabaseHelper);
      paramSet1.add(lyftApi);
      paramSet1.add(rideProvider);
      paramSet1.add(contactsProvider);
      paramSet1.add(resources);
      paramSet1.add(splitFareAnalytics);
    }
  }
  
  public static final class ProvideTooltipServiceProvidesAdapter
    extends ProvidesBinding<ITooltipService>
  {
    private Binding<IConstantsProvider> constantsProvider;
    private Binding<ILyftPreferences> lyftPreferences;
    private final ApplicationServicesModule module;
    
    public ProvideTooltipServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideTooltipService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftPreferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
      constantsProvider = paramLinker.requestBinding("me.lyft.android.application.constants.IConstantsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ITooltipService get()
    {
      return module.provideTooltipService((ILyftPreferences)lyftPreferences.get(), (IConstantsProvider)constantsProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftPreferences);
      paramSet1.add(constantsProvider);
    }
  }
  
  public static final class ProvideTopDestinationsServiceProvidesAdapter
    extends ProvidesBinding<ITopDestinationsService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideTopDestinationsServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideTopDestinationsService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ITopDestinationsService get()
    {
      return module.provideTopDestinationsService((ILyftApi)lyftApi.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
    }
  }
  
  public static final class ProvideUserProviderProvidesAdapter
    extends ProvidesBinding<IUserProvider>
  {
    private final ApplicationServicesModule module;
    
    public ProvideUserProviderProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideUserProvider");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public IUserProvider get()
    {
      return module.provideUserProvider();
    }
  }
  
  public static final class ProvideUserServiceProvidesAdapter
    extends ProvidesBinding<IUserUiService>
  {
    private final ApplicationServicesModule module;
    private Binding<IPassengerRideProvider> passengerRideProvider;
    private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
    private Binding<IUserProvider> userProvider;
    
    public ProvideUserServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideUserService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
      passengerRideProvider = paramLinker.requestBinding("me.lyft.android.application.passenger.IPassengerRideProvider", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IUserUiService get()
    {
      return module.provideUserService((IUserProvider)userProvider.get(), (ISimpleRepositoryFactory)simpleRepositoryFactory.get(), (IPassengerRideProvider)passengerRideProvider.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(simpleRepositoryFactory);
      paramSet1.add(passengerRideProvider);
    }
  }
  
  public static final class ProvideVehicleServiceProvidesAdapter
    extends ProvidesBinding<IVehicleService>
  {
    private Binding<IS3Api> is3Api;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvideVehicleServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideVehicleService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      is3Api = paramLinker.requestBinding("me.lyft.android.infrastructure.environment.IS3Api", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IVehicleService get()
    {
      return module.provideVehicleService((ILyftApi)lyftApi.get(), (IS3Api)is3Api.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(is3Api);
    }
  }
  
  public static final class ProvideWarmWelcomeServiceProvidesAdapter
    extends ProvidesBinding<IWarmWelcomeService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
    
    public ProvideWarmWelcomeServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideWarmWelcomeService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IWarmWelcomeService get()
    {
      return module.provideWarmWelcomeService((ILyftApi)lyftApi.get(), (ISimpleRepositoryFactory)simpleRepositoryFactory.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(simpleRepositoryFactory);
    }
  }
  
  public static final class ProvideWearRideRequestServiceProvidesAdapter
    extends ProvidesBinding<IWearRideRequestService>
  {
    private Binding<IChargeAccountsProvider> chargeAccountsProvider;
    private Binding<ICheckoutSession> checkoutSession;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<IUserProvider> userProvider;
    
    public ProvideWearRideRequestServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(false, "me.lyft.android.application.ApplicationServicesModule", "provideWearRideRequestService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      userProvider = paramLinker.requestBinding("me.lyft.android.application.IUserProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      chargeAccountsProvider = paramLinker.requestBinding("me.lyft.android.persistence.payment.IChargeAccountsProvider", ApplicationServicesModule.class, getClass().getClassLoader());
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      checkoutSession = paramLinker.requestBinding("me.lyft.android.application.checkout.ICheckoutSession", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IWearRideRequestService get()
    {
      return module.provideWearRideRequestService((IUserProvider)userProvider.get(), (IChargeAccountsProvider)chargeAccountsProvider.get(), (ILyftApi)lyftApi.get(), (ICheckoutSession)checkoutSession.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(userProvider);
      paramSet1.add(chargeAccountsProvider);
      paramSet1.add(lyftApi);
      paramSet1.add(checkoutSession);
    }
  }
  
  public static final class ProvideWorkServiceProvidesAdapter
    extends ProvidesBinding<IEnterpriseService>
  {
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    private Binding<ILyftPreferences> preferences;
    
    public ProvideWorkServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideWorkService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      preferences = paramLinker.requestBinding("me.lyft.android.ILyftPreferences", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public IEnterpriseService get()
    {
      return module.provideWorkService((ILyftApi)lyftApi.get(), (ILyftPreferences)preferences.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(preferences);
    }
  }
  
  public static final class ProvideleanplumOverrideServiceProvidesAdapter
    extends ProvidesBinding<ILeanplumOverrideService>
  {
    private final ApplicationServicesModule module;
    private Binding<ISimpleRepositoryFactory> simpleRepositoryFactory;
    
    public ProvideleanplumOverrideServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "provideleanplumOverrideService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      simpleRepositoryFactory = paramLinker.requestBinding("me.lyft.android.persistence.ISimpleRepositoryFactory", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ILeanplumOverrideService get()
    {
      return module.provideleanplumOverrideService((ISimpleRepositoryFactory)simpleRepositoryFactory.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(simpleRepositoryFactory);
    }
  }
  
  public static final class ProvidesCarpoolRideServiceProvidesAdapter
    extends ProvidesBinding<ICarpoolRideService>
  {
    private Binding<ILocationService> locationService;
    private Binding<ILyftApi> lyftApi;
    private final ApplicationServicesModule module;
    
    public ProvidesCarpoolRideServiceProvidesAdapter(ApplicationServicesModule paramApplicationServicesModule)
    {
      super(true, "me.lyft.android.application.ApplicationServicesModule", "providesCarpoolRideService");
      module = paramApplicationServicesModule;
      setLibrary(true);
    }
    
    public void attach(Linker paramLinker)
    {
      lyftApi = paramLinker.requestBinding("me.lyft.android.infrastructure.lyft.ILyftApi", ApplicationServicesModule.class, getClass().getClassLoader());
      locationService = paramLinker.requestBinding("me.lyft.android.infrastructure.location.ILocationService", ApplicationServicesModule.class, getClass().getClassLoader());
    }
    
    public ICarpoolRideService get()
    {
      return module.providesCarpoolRideService((ILyftApi)lyftApi.get(), (ILocationService)locationService.get());
    }
    
    public void getDependencies(Set<Binding<?>> paramSet1, Set<Binding<?>> paramSet2)
    {
      paramSet1.add(lyftApi);
      paramSet1.add(locationService);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule..ModuleAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */