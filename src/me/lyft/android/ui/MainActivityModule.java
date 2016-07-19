package me.lyft.android.ui;

import android.content.ContentResolver;
import android.content.res.Resources;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import me.lyft.android.AppModule;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.DriverConsoleAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.driver.DriverStatsProvider;
import me.lyft.android.application.driver.IDriverStatsProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.application.settings.ISignUrlService;
import me.lyft.android.application.settings.ITrainingRideService;
import me.lyft.android.application.settings.TrainingRideService;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.common.DriverFlow;
import me.lyft.android.controls.BackButtonToolbar;
import me.lyft.android.controls.CameraToolbar;
import me.lyft.android.controls.MenuButtonToolbar;
import me.lyft.android.driver.service.IPreloadStaticMapService;
import me.lyft.android.driver.service.PreloadStaticMapService;
import me.lyft.android.driver.ui.DriverAssetService;
import me.lyft.android.driver.ui.IDriverAssetService;
import me.lyft.android.errorhandling.IDefaultErrorHandler;
import me.lyft.android.infrastructure.activity.IActivityLifecycleService;
import me.lyft.android.infrastructure.appboy.CustomAppboyInAppDialog;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.infrastructure.cardscan.CardScanModule;
import me.lyft.android.infrastructure.facebook.FacebookLoginModule;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.maps.LyftMapView;
import me.lyft.android.maps.MapOwner;
import me.lyft.android.maps.MapsModule;
import me.lyft.android.maps.renderers.DriverCarRenderer;
import me.lyft.android.maps.renderers.DriverRouteRenderer;
import me.lyft.android.maps.renderers.HeatmapRenderer;
import me.lyft.android.maps.renderers.LineDriverRouteRenderer;
import me.lyft.android.maps.renderers.NearbyDriversRenderer;
import me.lyft.android.maps.renderers.PassengerLineStopsRenderer;
import me.lyft.android.maps.renderers.PassengerLocationRenderer;
import me.lyft.android.maps.renderers.ShortcutRenderer;
import me.lyft.android.maps.renderers.passenger.routing.PassengerRouteRenderer;
import me.lyft.android.maps.zooming.FitToShortcuts;
import me.lyft.android.maps.zooming.FollowCurrentLocation;
import me.lyft.android.notifications.InAppNotificationDialogView;
import me.lyft.android.providers.TopContactsProvider;
import me.lyft.android.ui.business.BusinessProfileModule;
import me.lyft.android.ui.camera.CameraModule;
import me.lyft.android.ui.development.DevelopmentModule;
import me.lyft.android.ui.dialogs.AlertDialogView;
import me.lyft.android.ui.dialogs.CallConfirmationDialogView;
import me.lyft.android.ui.dialogs.DatePickerDialogView;
import me.lyft.android.ui.dialogs.DialogButton;
import me.lyft.android.ui.dialogs.DialogContainerView;
import me.lyft.android.ui.dialogs.EditPickupOnboardingDialogView;
import me.lyft.android.ui.dialogs.InsuranceExpiringDialogView;
import me.lyft.android.ui.dialogs.MockLocationsWarningDialogView;
import me.lyft.android.ui.dialogs.ToastController;
import me.lyft.android.ui.dialogs.UpdateAppDialogView;
import me.lyft.android.ui.driver.DriverModule;
import me.lyft.android.ui.driver.RideProgressPassengerItem;
import me.lyft.android.ui.driver.achievements.card.AchievementCardFactory;
import me.lyft.android.ui.driver.carpool.screens.CarpoolDriverRideController;
import me.lyft.android.ui.enterprise.EnterpriseModule;
import me.lyft.android.ui.gallery.GalleryModule;
import me.lyft.android.ui.help.HelpModule;
import me.lyft.android.ui.invites.InvitesModule;
import me.lyft.android.ui.landing.CountryPickerController;
import me.lyft.android.ui.landing.LandingModule;
import me.lyft.android.ui.onboarding.OnboardingModule;
import me.lyft.android.ui.passenger.PassengerModule;
import me.lyft.android.ui.passenger.v2.inride.DriverDetailView;
import me.lyft.android.ui.passenger.v2.inride.EditPickupMapTooltipView;
import me.lyft.android.ui.passenger.v2.inride.PassengersDetailView;
import me.lyft.android.ui.passenger.v2.inride.RideDetailView;
import me.lyft.android.ui.payment.PaymentModule;
import me.lyft.android.ui.payment.cardinput.CreditCardInput;
import me.lyft.android.ui.placesearch.PlaceSearchModule;
import me.lyft.android.ui.profile.ProfileModule;
import me.lyft.android.ui.ride.AcceptTermsView;
import me.lyft.android.ui.ride.IUserModeErrorHandler;
import me.lyft.android.ui.ride.PassengerRideView;
import me.lyft.android.ui.ride.RideMap;
import me.lyft.android.ui.ride.UserModeErrorHandler;
import me.lyft.android.ui.ridehistory.RideHistoryModule;
import me.lyft.android.ui.settings.SettingsModule;
import me.lyft.android.ui.splitfare.SplitFareModule;
import me.lyft.android.ui.terms.TermsModule;
import me.lyft.android.ui.webview.WebviewModule;
import me.lyft.android.utils.WebBrowser;

@Module(addsTo=AppModule.class, includes={LandingModule.class, ProfileModule.class, SettingsModule.class, RideHistoryModule.class, CameraModule.class, DevelopmentModule.class, DriverModule.class, EnterpriseModule.class, BusinessProfileModule.class, HelpModule.class, InvitesModule.class, PassengerModule.class, PaymentModule.class, OnboardingModule.class, SplitFareModule.class, GalleryModule.class, PlaceSearchModule.class, MapsModule.class, WebviewModule.class, TermsModule.class, FacebookLoginModule.class, CardScanModule.class}, injects={ScreensContainer.class, MenuView.class, InviteMenuItem.class, BackButtonToolbar.class, CameraToolbar.class, MenuButtonToolbar.class, PassengerRideView.class, FullscreenPhotoView.class, WarningView.class, RideDetailView.class, PassengersDetailView.class, PassengerMyPhotoView.class, UserImageView.class, DriverDetailView.class, RideProgressPassengerItem.class, AcceptTermsView.class, DriverModeToggleView.class, EditPickupMapTooltipView.class, CountryPickerController.class, ModeSwitchLoadingController.class, CreditCardInput.class, AlertDialogView.class, DialogButton.class, ToastController.class, DialogContainerView.class, CallConfirmationDialogView.class, UpdateAppDialogView.class, InAppNotificationDialogView.class, DatePickerDialogView.class, MockLocationsWarningDialogView.class, InsuranceExpiringDialogView.class, CustomAppboyInAppDialog.class, EditPickupOnboardingDialogView.class, CarpoolDriverRideController.class, GlobalTermsOfServiceController.class, GlobalTermsOfServiceDetailController.class}, library=true)
public class MainActivityModule
{
  private MainActivity activity;
  
  public MainActivityModule(MainActivity paramMainActivity)
  {
    activity = paramMainActivity;
  }
  
  @Provides
  AchievementCardFactory provideAchievementCardFactory()
  {
    return new AchievementCardFactory();
  }
  
  @Provides
  @Singleton
  public IActivityLifecycleService provideActivityLifecycleService()
  {
    return activity.activityLifecycleService;
  }
  
  @Provides
  @Singleton
  IDriverAssetService provideDriverAssetService(Resources paramResources, IAssetLoadingService paramIAssetLoadingService)
  {
    return new DriverAssetService(paramResources, paramIAssetLoadingService);
  }
  
  @Provides
  @Singleton
  DriverConsoleAnalytics provideDriverConsoleAnalytics()
  {
    return new DriverConsoleAnalytics();
  }
  
  @Provides
  public DriverFlow provideDriverFlow()
  {
    return new DriverFlow(new AppFlow(true));
  }
  
  @Provides
  IDriverStatsProvider provideDriverStats(ILyftApi paramILyftApi)
  {
    return new DriverStatsProvider(paramILyftApi);
  }
  
  @Provides
  public GlobalTermsOfServiceAnalytics provideGlobalTermsOfServiceAnalytics()
  {
    return new GlobalTermsOfServiceAnalytics();
  }
  
  @Provides
  @Singleton
  LayoutInflater provideInflater()
  {
    return LayoutInflater.from(activity);
  }
  
  @Provides
  @Singleton
  public LyftMapView provideMapView()
  {
    return activity.mapView;
  }
  
  @Provides
  public IPreloadStaticMapService providePreloadStaticMapService(ILyftPreferences paramILyftPreferences, IDriverRideProvider paramIDriverRideProvider, ImageLoader paramImageLoader)
  {
    return new PreloadStaticMapService(paramILyftPreferences, paramIDriverRideProvider, paramImageLoader);
  }
  
  @Provides
  @Singleton
  public IProgressController provideProgressController()
  {
    return activity.progressController;
  }
  
  @Provides
  @Singleton
  RideMap provideRideView(LyftApplication paramLyftApplication, MapOwner paramMapOwner, IPassengerRideProvider paramIPassengerRideProvider, ILocationService paramILocationService, Resources paramResources, NearbyDriversRenderer paramNearbyDriversRenderer, PassengerRouteRenderer paramPassengerRouteRenderer, DriverCarRenderer paramDriverCarRenderer, ShortcutRenderer paramShortcutRenderer, DriverRouteRenderer paramDriverRouteRenderer, LineDriverRouteRenderer paramLineDriverRouteRenderer, PassengerLineStopsRenderer paramPassengerLineStopsRenderer, PassengerLocationRenderer paramPassengerLocationRenderer, HeatmapRenderer paramHeatmapRenderer, FollowCurrentLocation paramFollowCurrentLocation, FitToShortcuts paramFitToShortcuts)
  {
    return new RideMap(paramLyftApplication, paramMapOwner, paramIPassengerRideProvider, paramILocationService, paramResources, paramNearbyDriversRenderer, paramPassengerRouteRenderer, paramDriverCarRenderer, paramShortcutRenderer, paramDriverRouteRenderer, paramLineDriverRouteRenderer, paramPassengerLineStopsRenderer, paramPassengerLocationRenderer, paramHeatmapRenderer, paramFollowCurrentLocation, paramFitToShortcuts);
  }
  
  @Provides
  @Singleton
  SlideMenuController provideSlideController()
  {
    return activity.slideMenuController;
  }
  
  @Provides
  ToastController provideToastController(DialogFlow paramDialogFlow)
  {
    return new ToastController(paramDialogFlow);
  }
  
  @Provides
  TopContactsProvider provideTopContactsProvider(ContentResolver paramContentResolver, IUserProvider paramIUserProvider)
  {
    return new TopContactsProvider(paramContentResolver, paramIUserProvider);
  }
  
  @Provides
  ITrainingRideService provideTrainingRideService(ILyftApi paramILyftApi)
  {
    return new TrainingRideService(paramILyftApi);
  }
  
  @Provides
  @Singleton
  IUserModeErrorHandler provideUserModeErrorHandler(IViewErrorHandler paramIViewErrorHandler, AppFlow paramAppFlow, DialogFlow paramDialogFlow)
  {
    return new UserModeErrorHandler(paramIViewErrorHandler, paramAppFlow, paramDialogFlow);
  }
  
  @Provides
  public IViewErrorHandler provideViewErrorHandler(IDefaultErrorHandler paramIDefaultErrorHandler, DialogFlow paramDialogFlow, Resources paramResources, IUserProvider paramIUserProvider)
  {
    return new ViewErrorHandler(paramIDefaultErrorHandler, paramDialogFlow, paramResources, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  public WebBrowser provideWebBrowser(IProgressController paramIProgressController, ISignUrlService paramISignUrlService)
  {
    return new WebBrowser(activity, paramIProgressController, paramISignUrlService);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainActivityModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */