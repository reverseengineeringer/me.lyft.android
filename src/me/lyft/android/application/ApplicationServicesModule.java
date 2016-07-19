package me.lyft.android.application;

import android.content.res.Resources;
import android.os.Handler;
import com.google.gson.reflect.TypeToken;
import dagger.Module;
import dagger.Provides;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import javax.inject.Named;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.EditPickupAnalytics;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.application.ats.AtsService;
import me.lyft.android.application.ats.IAtsService;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.business.BusinessOnboardingAnalytics;
import me.lyft.android.application.checkout.CheckoutSession;
import me.lyft.android.application.checkout.ICheckoutSession;
import me.lyft.android.application.cleanup.CleanupRegistry;
import me.lyft.android.application.cleanup.ICleanupRegistry;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.ConstantsProvider;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.constants.LeanplumOverrideService;
import me.lyft.android.application.cost.CostService;
import me.lyft.android.application.cost.ICostService;
import me.lyft.android.application.driver.DailyTotalsRepository;
import me.lyft.android.application.driver.DriverDestinationService;
import me.lyft.android.application.driver.IDailyTotalsRepository;
import me.lyft.android.application.driver.IDriverDestinationService;
import me.lyft.android.application.driver.IVehicleService;
import me.lyft.android.application.driver.VehicleService;
import me.lyft.android.application.driver.expresspay.ExpressPayRepository;
import me.lyft.android.application.driver.expresspay.ExpressPayService;
import me.lyft.android.application.driver.expresspay.IExpressPayRepository;
import me.lyft.android.application.driver.expresspay.IExpressPayService;
import me.lyft.android.application.drivers.INearbyDriversService;
import me.lyft.android.application.drivers.NearbyDriversService;
import me.lyft.android.application.enterprise.EnterpriseService;
import me.lyft.android.application.enterprise.IEnterpriseService;
import me.lyft.android.application.eta.IPickupEtaFallbackService;
import me.lyft.android.application.eta.IPickupEtaService;
import me.lyft.android.application.eta.PickupEtaFallbackService;
import me.lyft.android.application.eta.PickupEtaService;
import me.lyft.android.application.features.FeaturesProvider;
import me.lyft.android.application.features.IFeatureFlagOverrideStorage;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.geo.DirectionsFallbackDecorator;
import me.lyft.android.application.geo.EtaAnalyticService;
import me.lyft.android.application.geo.EtaRepository;
import me.lyft.android.application.geo.GeoService;
import me.lyft.android.application.geo.GoogleDirectionsService;
import me.lyft.android.application.geo.GoogleGeoAnalytics;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.application.geo.IEtaAnalyticService;
import me.lyft.android.application.geo.IEtaRepository;
import me.lyft.android.application.geo.IGeoService;
import me.lyft.android.application.geo.ReverseGeocodeService;
import me.lyft.android.application.geo.routecache.DirectionsCacheDecorator;
import me.lyft.android.application.geo.routecache.DriverDeviationBasedCache;
import me.lyft.android.application.geo.routecache.TimeBasedCache;
import me.lyft.android.application.invite.IReferralService;
import me.lyft.android.application.invite.IWarmWelcomeService;
import me.lyft.android.application.invite.ReferralService;
import me.lyft.android.application.invite.WarmWelcomeService;
import me.lyft.android.application.jobs.GoogleNowService;
import me.lyft.android.application.jobs.IGoogleNowService;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.landing.LandingService;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.passenger.IPassengerRideService;
import me.lyft.android.application.passenger.IPassengerRoutingService;
import me.lyft.android.application.passenger.IPassengerZoomProvider;
import me.lyft.android.application.passenger.PassengerRideProvider;
import me.lyft.android.application.passenger.PassengerRideService;
import me.lyft.android.application.passenger.PassengerRoutingService;
import me.lyft.android.application.passenger.PassengerZoomProvider;
import me.lyft.android.application.payment.CouponService;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.payment.IPaymentDefaultsService;
import me.lyft.android.application.payment.IPaymentService;
import me.lyft.android.application.payment.PaymentService;
import me.lyft.android.application.polling.BackgroundLocationAppProcess;
import me.lyft.android.application.polling.BackgroundLocationTracker;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IBackgroundLocationTracker;
import me.lyft.android.application.polling.ILocationUpdateService;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.application.polling.IPollingService;
import me.lyft.android.application.polling.LocationAnalytics;
import me.lyft.android.application.polling.LocationUpdateService;
import me.lyft.android.application.polling.PollingAppProcess;
import me.lyft.android.application.polling.PollingService;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.profile.IRideProfileService;
import me.lyft.android.application.profile.ProfileService;
import me.lyft.android.application.profile.RideProfileService;
import me.lyft.android.application.requestridetypes.IRequestRideTypeService;
import me.lyft.android.application.requestridetypes.IRideTypeMetaService;
import me.lyft.android.application.requestridetypes.RequestRideTypeService;
import me.lyft.android.application.requestridetypes.RideTypeMetaService;
import me.lyft.android.application.ride.CancellationOptionsProvider;
import me.lyft.android.application.ride.DestinyService;
import me.lyft.android.application.ride.DriverRideProvider;
import me.lyft.android.application.ride.DriverRouteService;
import me.lyft.android.application.ride.ExpenseNoteSession;
import me.lyft.android.application.ride.FollowLocationManager;
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
import me.lyft.android.application.ride.RatingSession;
import me.lyft.android.application.ride.RideRequestService;
import me.lyft.android.application.ride.RideRequestSession;
import me.lyft.android.application.ride.RideSession;
import me.lyft.android.application.ride.ScheduledRideTimesService;
import me.lyft.android.application.ride.UserUiService;
import me.lyft.android.application.ride.WearRideRequestService;
import me.lyft.android.application.ride.flow.IRequestFlowProvider;
import me.lyft.android.application.ride.flow.RequestFlowProvider;
import me.lyft.android.application.ride.services.CarpoolRideService;
import me.lyft.android.application.ride.services.ICarpoolRideService;
import me.lyft.android.application.riderequest.IRideRequestPollingService;
import me.lyft.android.application.riderequest.RideRequestPollingService;
import me.lyft.android.application.settings.AccessibilitySettingsService;
import me.lyft.android.application.settings.IAccessibilitySettingsService;
import me.lyft.android.application.settings.INavigationSettingsService;
import me.lyft.android.application.settings.ISettingsService;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.application.settings.NavigationSettingsService;
import me.lyft.android.application.settings.SettingsService;
import me.lyft.android.application.settings.SignUrlService;
import me.lyft.android.application.shortcuts.IShortcutService;
import me.lyft.android.application.shortcuts.ShortcutService;
import me.lyft.android.application.tooltip.ITooltipService;
import me.lyft.android.application.tooltip.TooltipService;
import me.lyft.android.application.topdestinations.ITopDestinationsService;
import me.lyft.android.application.topdestinations.TopDestinationsService;
import me.lyft.android.application.venue.IVenuePickupService;
import me.lyft.android.application.venue.VenuePickupService;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.IAppStore;
import me.lyft.android.common.Preconditions;
import me.lyft.android.data.ContactsDatabaseHelper;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.payment.Credit;
import me.lyft.android.domain.payment.IPaymentFactory;
import me.lyft.android.domain.payment.IPaymentFactory.IPaymentMetadataProvider;
import me.lyft.android.domain.payment.PaymentFactory;
import me.lyft.android.driver.notifications.DriverNotificationService;
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
import me.lyft.android.infrastructure.splitfare.SplitFareService;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.navigation.Navigator;
import me.lyft.android.persistence.ISimpleRepository;
import me.lyft.android.persistence.ISimpleRepositoryFactory;
import me.lyft.android.persistence.expensenotes.IExpenseNoteStorage;
import me.lyft.android.persistence.landing.ISignUpUserRepository;
import me.lyft.android.persistence.payment.IChargeAccountsProvider;
import me.lyft.android.persistence.rating.IRatingStateStorage;
import me.lyft.android.providers.ContactsProvider;
import me.lyft.android.providers.SplitFareDatabaseProvider;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.utils.SoundManager;
import me.lyft.android.utils.TextToSpeech;
import me.lyft.android.utils.Vibrator;

@Module(complete=false, library=true)
public class ApplicationServicesModule
{
  public static final String NAMED_CHAUFFEUR_SERVICE = "chauffeur_service";
  public static final String NAMED_STANDARD_SERVICE = "standard_service";
  
  @Provides
  @Singleton
  INavigationSettingsService navigationSettingsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    return new NavigationSettingsService(paramILyftApi, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  IAccessibilitySettingsService provideAccessibilityServiceSettings(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    return new AccessibilitySettingsService(paramIUserProvider, paramILyftApi);
  }
  
  @Provides
  @Singleton
  public IAppInfoService provideAppInfoService(ILocationService paramILocationService, ILyftApi paramILyftApi, IConstantsProvider paramIConstantsProvider, ITooltipService paramITooltipService, IAssetPackagingService paramIAssetPackagingService, ILyftPreferences paramILyftPreferences)
  {
    return new AppInfoService(paramILocationService, paramILyftApi, paramIConstantsProvider, paramITooltipService, paramIAssetPackagingService, paramILyftPreferences);
  }
  
  @Provides
  @Singleton
  IAtsService provideAtsService(ILyftApi paramILyftApi)
  {
    return new AtsService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  AutoFillService provideAutofillService(ILocationService paramILocationService, ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IRideRequestSession paramIRideRequestSession, IAppInfoService paramIAppInfoService)
  {
    return new AutoFillService(paramILocationService, paramILyftApi, paramIUserProvider, paramIRideRequestSession, paramIAppInfoService);
  }
  
  @Provides
  @Singleton
  IBackgroundLocationAppProcess provideBackgroundLocationSupervisor(IBackgroundLocationTracker paramIBackgroundLocationTracker, IAppForegroundDetector paramIAppForegroundDetector, IUserProvider paramIUserProvider)
  {
    return new BackgroundLocationAppProcess(paramIBackgroundLocationTracker, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  IBackgroundLocationTracker provideBackgroundLocationTracker(ILocationUpdateService paramILocationUpdateService, ILocationService paramILocationService)
  {
    return new BackgroundLocationTracker(paramILocationUpdateService, paramILocationService);
  }
  
  @Provides
  @Singleton
  BusinessOnboardingAnalytics provideBusinessOnboardAnalytics()
  {
    return new BusinessOnboardingAnalytics();
  }
  
  @Provides
  @Singleton
  public ICancellationOptionsProvider provideCancellationOptionsProvider(IConstantsProvider paramIConstantsProvider)
  {
    return new CancellationOptionsProvider(paramIConstantsProvider);
  }
  
  @Provides
  @Singleton
  ICheckoutSession provideCheckoutSession(CheckoutSession paramCheckoutSession)
  {
    return paramCheckoutSession;
  }
  
  @Provides
  @Singleton
  ICleanupRegistry provideCleanupRegistry()
  {
    return new CleanupRegistry();
  }
  
  @Provides
  @Singleton
  public IConstantsProvider provideConstantsProvider()
  {
    return new ConstantsProvider();
  }
  
  @Provides
  @Singleton
  public ICostService provideCostService(ILyftApi paramILyftApi)
  {
    return new CostService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  ICouponService provideCouponService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    Type localType = new TypeToken() {}.getType();
    return new CouponService(paramILyftApi, paramIUserProvider, paramISimpleRepositoryFactory.createRepository("credits", Collections.emptyList(), localType));
  }
  
  @Provides
  @Singleton
  IDailyTotalsRepository provideDailyTotalsRepository()
  {
    return new DailyTotalsRepository();
  }
  
  @Provides
  @Singleton
  public IDestinyService provideDestinyService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    return new DestinyService(paramIUserProvider, paramILyftApi);
  }
  
  @Provides
  @Singleton
  public IDriverDestinationService provideDriverDestinationService()
  {
    return new DriverDestinationService(ReactiveProperty.create(Location.empty()));
  }
  
  @Provides
  @Singleton
  DriverDeviationBasedCache provideDriverDeviationBasedCache(IPassengerRideProvider paramIPassengerRideProvider, IConstantsProvider paramIConstantsProvider)
  {
    return new DriverDeviationBasedCache(paramIPassengerRideProvider, ((Long)paramIConstantsProvider.get(Constants.ROUTE_DEVIATE_THRESHOLD)).intValue(), ((Long)paramIConstantsProvider.get(Constants.ROUTE_DEVIATE_MAX)).intValue());
  }
  
  @Provides
  @Named("driver")
  @Singleton
  IDirectionsService provideDriverDirectionsService(IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics, IConstantsProvider paramIConstantsProvider)
  {
    return new DirectionsCacheDecorator(new GoogleDirectionsService(paramIGoogleGeoApi, paramGoogleGeoAnalytics), new TimeBasedCache(paramIConstantsProvider));
  }
  
  @Provides
  @Singleton
  public IDriverNotificationService provideDriverNotificationService(TextToSpeech paramTextToSpeech, DialogFlow paramDialogFlow, SoundManager paramSoundManager, Resources paramResources, IAppForegroundDetector paramIAppForegroundDetector, Navigator paramNavigator, Vibrator paramVibrator, Handler paramHandler)
  {
    return new DriverNotificationService(paramTextToSpeech, paramDialogFlow, paramSoundManager, paramResources, paramIAppForegroundDetector, paramNavigator, paramVibrator, paramHandler);
  }
  
  @Provides
  @Singleton
  EditPickupAnalytics provideEditPickupAnalytics()
  {
    return new EditPickupAnalytics();
  }
  
  @Provides
  @Singleton
  IEtaAnalyticService provideEtaAnalyticService(IRideRequestSession paramIRideRequestSession)
  {
    return new EtaAnalyticService(paramIRideRequestSession);
  }
  
  @Provides
  @Singleton
  IEtaRepository provideEtaRepository()
  {
    return new EtaRepository();
  }
  
  @Provides
  @Singleton
  IExpenseNoteSession provideExpenseNoteSession(IExpenseNoteStorage paramIExpenseNoteStorage, IUserProvider paramIUserProvider)
  {
    return new ExpenseNoteSession(paramIExpenseNoteStorage, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  IExpressPayRepository provideExpressPayRepository()
  {
    return new ExpressPayRepository();
  }
  
  @Provides
  @Singleton
  IExpressPayService provideExpressPayService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IExpressPayRepository paramIExpressPayRepository, IStripeService paramIStripeService)
  {
    return new ExpressPayService(paramILyftApi, paramIUserProvider, paramIExpressPayRepository, paramIStripeService);
  }
  
  @Provides
  @Singleton
  public IFeaturesProvider provideFeaturesProvider(IConstantsProvider paramIConstantsProvider, IFeatureFlagOverrideStorage paramIFeatureFlagOverrideStorage)
  {
    return new FeaturesProvider(paramIConstantsProvider, paramIFeatureFlagOverrideStorage);
  }
  
  @Provides
  @Singleton
  public IFollowLocationManager provideFollowLocationManager(ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession)
  {
    return new FollowLocationManager(paramILocationService, paramIRideRequestSession);
  }
  
  @Provides
  @Singleton
  IGeoService provideGeoService(ReverseGeocodeService paramReverseGeocodeService, IGoogleGeoApi paramIGoogleGeoApi, IEtaRepository paramIEtaRepository, IEtaAnalyticService paramIEtaAnalyticService, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    return new GeoService(paramReverseGeocodeService, paramIGoogleGeoApi, paramIEtaRepository, paramIEtaAnalyticService, paramGoogleGeoAnalytics);
  }
  
  @Provides
  @Singleton
  GoogleGeoAnalytics provideGoogleGeoAnalytics()
  {
    return new GoogleGeoAnalytics();
  }
  
  @Provides
  @Singleton
  GooglePlaceTypeAnalytics provideGooglePlaceTypeAnalytics()
  {
    return new GooglePlaceTypeAnalytics();
  }
  
  @Provides
  @Singleton
  IGoogleNowService provideJobService(ILyftApi paramILyftApi)
  {
    return new GoogleNowService(paramILyftApi);
  }
  
  @Provides
  ILandingService provideLandingService(ISignUpUserRepository paramISignUpUserRepository, IUserProvider paramIUserProvider, ILyftApi paramILyftApi, ILocationService paramILocationService, ILyftPreferences paramILyftPreferences, IPaymentService paramIPaymentService, IChargeAccountsProvider paramIChargeAccountsProvider, IConstantsProvider paramIConstantsProvider, IAppStore paramIAppStore)
  {
    return new LandingService(paramISignUpUserRepository, paramIUserProvider, paramILyftApi, paramILocationService, paramILyftPreferences, paramIPaymentService, paramIChargeAccountsProvider, paramIConstantsProvider, paramIAppStore);
  }
  
  @Provides
  @Singleton
  ILogoutService provideLogoutService(LyftApplication paramLyftApplication, IUserSession paramIUserSession, IRideRequestSession paramIRideRequestSession, ILyftApi paramILyftApi, ILyftPreferences paramILyftPreferences, IFacebookTokenService paramIFacebookTokenService, IUserProvider paramIUserProvider, ICleanupRegistry paramICleanupRegistry)
  {
    return new LogoutService(paramLyftApplication, paramIUserSession, paramIRideRequestSession, paramILyftApi, paramILyftPreferences, paramIFacebookTokenService, paramIUserProvider, paramICleanupRegistry);
  }
  
  @Provides
  @Singleton
  INearbyDriversService provideNearbyDriverService(ILyftApi paramILyftApi)
  {
    return new NearbyDriversService(paramILyftApi);
  }
  
  @Provides
  @Named("passenger")
  @Singleton
  IDirectionsService providePassengerDirectionsService(ILyftApi paramILyftApi, IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics, DriverDeviationBasedCache paramDriverDeviationBasedCache)
  {
    return new DirectionsCacheDecorator(new DirectionsFallbackDecorator(new GoogleDirectionsService(paramIGoogleGeoApi, paramGoogleGeoAnalytics), paramILyftApi), paramDriverDeviationBasedCache);
  }
  
  @Provides
  @Singleton
  IRatingSession providePassengerRateDriverSession(IRatingStateStorage paramIRatingStateStorage)
  {
    return new RatingSession(paramIRatingStateStorage);
  }
  
  @Provides
  @Singleton
  IPassengerRideProvider providePassengerRideProvider()
  {
    return new PassengerRideProvider();
  }
  
  @Provides
  @Singleton
  IPassengerRideService providePassengerRideService(ILyftApi paramILyftApi, IPassengerRideProvider paramIPassengerRideProvider, ICheckoutSession paramICheckoutSession, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, IRatingSession paramIRatingSession, IExpenseNoteSession paramIExpenseNoteSession)
  {
    return new PassengerRideService(paramILyftApi, paramIPassengerRideProvider, paramICheckoutSession, paramILocationService, paramIRideRequestSession, paramIRatingSession, paramIExpenseNoteSession);
  }
  
  @Provides
  @Singleton
  IPassengerRoutingService providePassengerRoutingService(IPassengerRideProvider paramIPassengerRideProvider, @Named("passenger") IDirectionsService paramIDirectionsService)
  {
    return new PassengerRoutingService(paramIPassengerRideProvider, paramIDirectionsService);
  }
  
  @Provides
  @Singleton
  IPassengerZoomProvider providePassengerZoomProvider(IPassengerRoutingService paramIPassengerRoutingService, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new PassengerZoomProvider(paramIPassengerRoutingService, paramIPassengerRideProvider);
  }
  
  @Provides
  IPaymentFactory providePaymentFactory(IPaymentFactory.IPaymentMetadataProvider paramIPaymentMetadataProvider)
  {
    return new PaymentFactory(paramIPaymentMetadataProvider);
  }
  
  @Provides
  IPaymentFactory.IPaymentMetadataProvider providePaymentMetadataProvider(IPayPalService paramIPayPalService)
  {
    Preconditions.checkArgument(paramIPayPalService instanceof IPaymentFactory.IPaymentMetadataProvider, "PayPalService must be implement IPaymentMetadataProvider to provide chargeToken");
    return (IPaymentFactory.IPaymentMetadataProvider)paramIPayPalService;
  }
  
  @Provides
  @Singleton
  IPaymentService providePaymentService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, IStripeService paramIStripeService, IAndroidPayService paramIAndroidPayService, IPayPalService paramIPayPalService, IChargeAccountsProvider paramIChargeAccountsProvider)
  {
    return new PaymentService(paramILyftApi, paramIUserProvider, paramIStripeService, paramIAndroidPayService, paramIPayPalService, paramIChargeAccountsProvider);
  }
  
  @Provides
  @Singleton
  IPickupEtaFallbackService providePickupEtaFallbackService(INearbyDriversService paramINearbyDriversService, IRideRequestSession paramIRideRequestSession, IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    return new PickupEtaFallbackService(paramINearbyDriversService, paramIRideRequestSession, paramIGoogleGeoApi, paramGoogleGeoAnalytics);
  }
  
  @Provides
  @Singleton
  IPickupEtaService providePickupEtaService(ILyftApi paramILyftApi, IPickupEtaFallbackService paramIPickupEtaFallbackService, IEtaAnalyticService paramIEtaAnalyticService)
  {
    return new PickupEtaService(paramILyftApi, paramIEtaAnalyticService, paramIPickupEtaFallbackService);
  }
  
  @Provides
  @Singleton
  IVenuePickupService providePickupVenueService(ILyftApi paramILyftApi, IRideRequestSession paramIRideRequestSession)
  {
    return new VenuePickupService(paramILyftApi, paramIRideRequestSession);
  }
  
  @Provides
  @Singleton
  IPollingAppProcess providePollingOverseer(IPollingService paramIPollingService, IAppForegroundDetector paramIAppForegroundDetector, IUserProvider paramIUserProvider)
  {
    return new PollingAppProcess(paramIPollingService, paramIAppForegroundDetector, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  ILocationUpdateService providePollingRequestService(ILocationService paramILocationService, IAppForegroundDetector paramIAppForegroundDetector, IRideRequestSession paramIRideRequestSession, IEtaAnalyticService paramIEtaAnalyticService, ILyftApi paramILyftApi, IAppInfoService paramIAppInfoService, IUserProvider paramIUserProvider, IDriverRideProvider paramIDriverRideProvider, IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new LocationUpdateService(paramILocationService, paramIAppForegroundDetector, paramIRideRequestSession, paramIEtaAnalyticService, paramILyftApi, paramIAppInfoService, paramIUserProvider, paramIDriverRideProvider, paramIPassengerRideProvider, new LocationAnalytics());
  }
  
  @Provides
  @Singleton
  IPollingService providePollingService(ILocationUpdateService paramILocationUpdateService, ILocationService paramILocationService, ILyftPreferences paramILyftPreferences)
  {
    return new PollingService(paramILocationUpdateService, paramILocationService, paramILyftPreferences);
  }
  
  @Provides
  @Singleton
  IProfileService provideProfileService(IUserProvider paramIUserProvider, IS3Api paramIS3Api, ILyftApi paramILyftApi, IProfilePhotoFileRecipient paramIProfilePhotoFileRecipient)
  {
    return new ProfileService(paramIUserProvider, paramIS3Api, paramILyftApi, paramIProfilePhotoFileRecipient);
  }
  
  @Provides
  @Singleton
  IReferralService provideReferralService(ILyftApi paramILyftApi)
  {
    return new ReferralService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  IRequestFlowProvider provideRequestFlowProvider(IRideRequestSession paramIRideRequestSession, IVenuePickupService paramIVenuePickupService)
  {
    return new RequestFlowProvider(paramIRideRequestSession, paramIVenuePickupService);
  }
  
  @Provides
  @Singleton
  public IRequestRideTypeService provideRequestRideTypeService(ILyftApi paramILyftApi, IAppInfoService paramIAppInfoService, ISimpleRepository<List<RequestRideType>> paramISimpleRepository)
  {
    return new RequestRideTypeService(paramILyftApi, paramIAppInfoService, paramISimpleRepository);
  }
  
  @Provides
  @Singleton
  ReverseGeocodeService provideReverseGeocodeService(IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    return new ReverseGeocodeService(paramIGoogleGeoApi, paramGoogleGeoAnalytics);
  }
  
  @Provides
  @Singleton
  IRideProfileService provideRideProfileService()
  {
    return new RideProfileService();
  }
  
  @Provides
  @Singleton
  IRideRequestPollingService provideRideRequestPollingService(IAppForegroundDetector paramIAppForegroundDetector, ILyftPreferences paramILyftPreferences, IPickupEtaService paramIPickupEtaService, INearbyDriversService paramINearbyDriversService, IRideRequestSession paramIRideRequestSession, IRequestRideTypeService paramIRequestRideTypeService, ICostService paramICostService)
  {
    return new RideRequestPollingService(paramIAppForegroundDetector, paramILyftPreferences, paramIPickupEtaService, paramINearbyDriversService, paramIRideRequestSession, paramIRequestRideTypeService, paramICostService);
  }
  
  @Provides
  @Singleton
  IRideRequestService provideRideRequestService(IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider, ILocationService paramILocationService, IRideRequestSession paramIRideRequestSession, ILyftApi paramILyftApi, ICheckoutSession paramICheckoutSession, IConstantsProvider paramIConstantsProvider, IFeaturesProvider paramIFeaturesProvider, IPaymentService paramIPaymentService, IPaymentDefaultsService paramIPaymentDefaultsService, IPayPalService paramIPayPalService, ICostService paramICostService, IPassengerRideProvider paramIPassengerRideProvider, IRequestRideTypeService paramIRequestRideTypeService)
  {
    return new RideRequestService(paramIUserProvider, paramIChargeAccountsProvider, paramILocationService, paramIRideRequestSession, paramILyftApi, paramICheckoutSession, paramIConstantsProvider, paramIFeaturesProvider, paramIPaymentService, paramIPaymentDefaultsService, paramIPayPalService, paramICostService, paramIPassengerRideProvider, paramIRequestRideTypeService);
  }
  
  @Provides
  @Singleton
  IRideRequestSession provideRideRequestSession(ILyftPreferences paramILyftPreferences, IRequestRideTypeService paramIRequestRideTypeService)
  {
    return new RideRequestSession(paramILyftPreferences, paramIRequestRideTypeService);
  }
  
  @Provides
  @Singleton
  IRideSession provideRideSession(IPassengerRideProvider paramIPassengerRideProvider)
  {
    return new RideSession(paramIPassengerRideProvider);
  }
  
  @Provides
  @Singleton
  public IRideTypeMetaService provideRideTypeMetaService(IAppInfoService paramIAppInfoService)
  {
    return new RideTypeMetaService(paramIAppInfoService);
  }
  
  @Provides
  @Singleton
  public IDriverRideProvider provideRouteProvider()
  {
    return new DriverRideProvider();
  }
  
  @Provides
  @Singleton
  public IDriverRouteService provideRouteService(ILyftApi paramILyftApi, IDriverRideProvider paramIDriverRideProvider, ILocationService paramILocationService, IUserProvider paramIUserProvider, IGooglePlaceService paramIGooglePlaceService, IRatingSession paramIRatingSession, IUserDispatchService paramIUserDispatchService, IDeferredCallService paramIDeferredCallService, IFeaturesProvider paramIFeaturesProvider)
  {
    return new DriverRouteService(paramILyftApi, paramIDriverRideProvider, paramIUserProvider, paramILocationService, paramIGooglePlaceService, paramIUserDispatchService, paramIRatingSession, paramIDeferredCallService, paramIFeaturesProvider);
  }
  
  @Provides
  @Singleton
  IScheduledRideTimesService provideScheduledRideTimesService(ILyftApi paramILyftApi)
  {
    return new ScheduledRideTimesService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  ISettingsService provideSettingsService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider)
  {
    return new SettingsService(paramILyftApi, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  public IShortcutService provideShortcutService(IUserProvider paramIUserProvider, ILyftApi paramILyftApi)
  {
    return new ShortcutService(paramIUserProvider, paramILyftApi);
  }
  
  @Provides
  @Singleton
  ISignUrlService provideSignUrlService(ILyftApi paramILyftApi)
  {
    return new SignUrlService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  ISplitFareService provideSplitFareService(ContactsDatabaseHelper paramContactsDatabaseHelper, ILyftApi paramILyftApi, IPassengerRideProvider paramIPassengerRideProvider, ContactsProvider paramContactsProvider, Resources paramResources, SplitFareAnalytics paramSplitFareAnalytics)
  {
    return new SplitFareService(paramILyftApi, new SplitFareDatabaseProvider(paramContactsDatabaseHelper), paramContactsProvider, paramResources, paramIPassengerRideProvider, paramSplitFareAnalytics);
  }
  
  @Provides
  @Singleton
  public ITooltipService provideTooltipService(ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider)
  {
    return new TooltipService(paramILyftPreferences, paramIConstantsProvider);
  }
  
  @Provides
  @Singleton
  public ITopDestinationsService provideTopDestinationsService(ILyftApi paramILyftApi)
  {
    return new TopDestinationsService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  public IUserProvider provideUserProvider()
  {
    return new UserProvider();
  }
  
  @Provides
  @Singleton
  public IUserUiService provideUserService(IUserProvider paramIUserProvider, ISimpleRepositoryFactory paramISimpleRepositoryFactory, IPassengerRideProvider paramIPassengerRideProvider)
  {
    Type localType = new TypeToken() {}.getType();
    return new UserUiService(paramISimpleRepositoryFactory.createRepository("uiState", UiState.empty(), localType), paramIUserProvider, paramIPassengerRideProvider);
  }
  
  @Provides
  @Singleton
  IVehicleService provideVehicleService(ILyftApi paramILyftApi, IS3Api paramIS3Api)
  {
    return new VehicleService(paramILyftApi, paramIS3Api);
  }
  
  @Provides
  @Singleton
  IWarmWelcomeService provideWarmWelcomeService(ILyftApi paramILyftApi, ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    return new WarmWelcomeService(paramILyftApi, paramISimpleRepositoryFactory.createRepository("warm_welcome_browser_id", null, String.class));
  }
  
  @Provides
  IWearRideRequestService provideWearRideRequestService(IUserProvider paramIUserProvider, IChargeAccountsProvider paramIChargeAccountsProvider, ILyftApi paramILyftApi, ICheckoutSession paramICheckoutSession)
  {
    return new WearRideRequestService(paramIUserProvider, paramIChargeAccountsProvider, paramILyftApi, paramICheckoutSession);
  }
  
  @Provides
  @Singleton
  IEnterpriseService provideWorkService(ILyftApi paramILyftApi, ILyftPreferences paramILyftPreferences)
  {
    return new EnterpriseService(paramILyftApi, paramILyftPreferences);
  }
  
  @Provides
  @Singleton
  public ILeanplumOverrideService provideleanplumOverrideService(ISimpleRepositoryFactory paramISimpleRepositoryFactory)
  {
    new LeanplumOverrideService(paramISimpleRepositoryFactory.createRepository("leanplumOverride", Boolean.valueOf(true), new TypeToken() {}.getType()));
  }
  
  @Provides
  @Singleton
  ICarpoolRideService providesCarpoolRideService(ILyftApi paramILyftApi, ILocationService paramILocationService)
  {
    return new CarpoolRideService(paramILyftApi, paramILocationService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ApplicationServicesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */