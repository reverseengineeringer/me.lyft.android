package me.lyft.android.infrastructure;

import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import java.io.File;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.IUserSession;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.studies.SplitFareAnalytics;
import me.lyft.android.analytics.studies.VerificationSmsAnalytics;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.application.IAppInfoService;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.autofill.AutoFillAnalytics;
import me.lyft.android.application.autofill.AutoFillService;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.application.constants.ILeanplumOverrideService;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.application.landing.ILandingService;
import me.lyft.android.application.polling.IAppProcess;
import me.lyft.android.application.polling.IBackgroundLocationAppProcess;
import me.lyft.android.application.polling.IPollingAppProcess;
import me.lyft.android.application.polling.LocationAnalytics;
import me.lyft.android.application.profile.IProfilePhotoFileRecipient;
import me.lyft.android.common.AppFlow;
import me.lyft.android.common.DialogFlow;
import me.lyft.android.deeplinks.DeepLinkManager;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.activity.ActivityServiceRegistry;
import me.lyft.android.infrastructure.androidpay.IAndroidPayService;
import me.lyft.android.infrastructure.api.HttpExecutor;
import me.lyft.android.infrastructure.api.IJsonBodySerializer;
import me.lyft.android.infrastructure.api.ILyftApiHeadersProvider;
import me.lyft.android.infrastructure.api.JsonBodySerializer;
import me.lyft.android.infrastructure.api.LyftApiApiErrorHandler;
import me.lyft.android.infrastructure.api.LyftApiHeadersProvider;
import me.lyft.android.infrastructure.api.S3ApiApiErrorHandler;
import me.lyft.android.infrastructure.appboy.AppboyService;
import me.lyft.android.infrastructure.appboy.IAppboyService;
import me.lyft.android.infrastructure.assets.AssetLoadingService;
import me.lyft.android.infrastructure.assets.AssetPackagingService;
import me.lyft.android.infrastructure.assets.IAssetLoadingService;
import me.lyft.android.infrastructure.assets.IAssetPackagingService;
import me.lyft.android.infrastructure.bootstrap.BootstrapService;
import me.lyft.android.infrastructure.bootstrap.IBootstrapService;
import me.lyft.android.infrastructure.camera.CaptureImageSession;
import me.lyft.android.infrastructure.camera.ICaptureImage;
import me.lyft.android.infrastructure.camera.ICaptureImageSession;
import me.lyft.android.infrastructure.competition.InstallTrackerService;
import me.lyft.android.infrastructure.contacts.AndroidContactsProvider;
import me.lyft.android.infrastructure.contacts.IAndroidContactsProvider;
import me.lyft.android.infrastructure.deferred.DeferredCallService;
import me.lyft.android.infrastructure.deferred.DeferredSyncService;
import me.lyft.android.infrastructure.deferred.IDeferredCallService;
import me.lyft.android.infrastructure.deferred.IDeferredSyncService;
import me.lyft.android.infrastructure.deferred.LyftApiCallDependencyFactory;
import me.lyft.android.infrastructure.device.Device;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.driverdefense.DriverShortcutStarterService;
import me.lyft.android.infrastructure.environment.EnvironmentService;
import me.lyft.android.infrastructure.environment.IEnvironmentService;
import me.lyft.android.infrastructure.environment.IS3Api;
import me.lyft.android.infrastructure.environment.S3Api;
import me.lyft.android.infrastructure.facebook.FacebookTokenModule;
import me.lyft.android.infrastructure.foreground.AppForegroundDetector;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.gallery.GalleryService;
import me.lyft.android.infrastructure.gallery.IGalleryService;
import me.lyft.android.infrastructure.gcm.GcmIdService;
import me.lyft.android.infrastructure.gcm.IGcmIdService;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApi;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googleplaces.GooglePlaceService;
import me.lyft.android.infrastructure.googleplaces.IGooglePlaceService;
import me.lyft.android.infrastructure.googleplay.GoogleApiProvider;
import me.lyft.android.infrastructure.googleplay.IGoogleApiProvider;
import me.lyft.android.infrastructure.instabug.IInstabugService;
import me.lyft.android.infrastructure.instabug.InstabugModule;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.leanplum.ILeanplumService;
import me.lyft.android.infrastructure.leanplum.LeanplumService;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.infrastructure.location.RxLocationService;
import me.lyft.android.infrastructure.locationsettings.ILocationSettingsService;
import me.lyft.android.infrastructure.locationsettings.LocationSettingsService;
import me.lyft.android.infrastructure.lyft.IAppStateHandler;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApi;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;
import me.lyft.android.infrastructure.paypal.IPayPalService;
import me.lyft.android.infrastructure.paypal.PayPalService;
import me.lyft.android.infrastructure.photo.IPhotoPickerService;
import me.lyft.android.infrastructure.photo.PhotoPickerService;
import me.lyft.android.infrastructure.profile.IProfilePhotoLoader;
import me.lyft.android.infrastructure.profile.ProfilePhotoLoader;
import me.lyft.android.infrastructure.servertimestamp.IServerTimestampService;
import me.lyft.android.infrastructure.servertimestamp.ServerTimestampService;
import me.lyft.android.infrastructure.service.AppProcessRegistry;
import me.lyft.android.infrastructure.settings.AutomationOverrideService;
import me.lyft.android.infrastructure.settings.IAutomationOverrideService;
import me.lyft.android.infrastructure.share.IShareService;
import me.lyft.android.infrastructure.share.ShareService;
import me.lyft.android.infrastructure.sms.IVerificationAutoFillService;
import me.lyft.android.infrastructure.sms.VerificationAutoFillService;
import me.lyft.android.infrastructure.stripe.IStripeService;
import me.lyft.android.infrastructure.stripe.StripeService;
import me.lyft.android.infrastructure.viewserver.IViewServerService;
import me.lyft.android.infrastructure.viewserver.ViewServerService;
import me.lyft.android.infrastructure.wallet.AndroidPayService;
import me.lyft.android.locationproviders.android.AndroidLocationClient;
import me.lyft.android.locationproviders.fused.FusedLocationClient;
import me.lyft.android.managers.ImageLoader;
import me.lyft.android.notifications.IStatusBarNotificationsService;
import me.lyft.android.notifications.StatusBarNotificationsService;
import rx.schedulers.Schedulers;

@Module(complete=false, includes={InstabugModule.class, FacebookTokenModule.class}, library=true)
public class InfrastructureServicesModule
{
  @Provides
  @Singleton
  public ActivityServiceRegistry provideActivityServiceRegistry(IGoogleApiProvider paramIGoogleApiProvider, IAndroidPayService paramIAndroidPayService, IGalleryService paramIGalleryService, IAnalyticsService paramIAnalyticsService, IPayPalService paramIPayPalService, ILocationSettingsService paramILocationSettingsService, IViewServerService paramIViewServerService, DriverShortcutStarterService paramDriverShortcutStarterService, InstallTrackerService paramInstallTrackerService, IAppboyService paramIAppboyService, IStatusBarNotificationsService paramIStatusBarNotificationsService, ILeanplumService paramILeanplumService, IInstabugService paramIInstabugService, IDeferredSyncService paramIDeferredSyncService)
  {
    return new ActivityServiceRegistry(new Object[] { paramIGoogleApiProvider, paramIAndroidPayService, paramIGalleryService, paramIAnalyticsService, paramIPayPalService, paramILocationSettingsService, paramIViewServerService, paramDriverShortcutStarterService, paramInstallTrackerService, paramIAppboyService, paramIStatusBarNotificationsService, paramILeanplumService, paramIInstabugService, paramIDeferredSyncService });
  }
  
  @Provides
  @Singleton
  IAppForegroundDetector provideAppForegroundDetector()
  {
    return new AppForegroundDetector();
  }
  
  @Provides
  @Singleton
  public AppProcessRegistry provideAppServiceRegistry(IPollingAppProcess paramIPollingAppProcess, IBackgroundLocationAppProcess paramIBackgroundLocationAppProcess)
  {
    return new AppProcessRegistry(new IAppProcess[] { paramIPollingAppProcess, paramIBackgroundLocationAppProcess });
  }
  
  @Provides
  @Singleton
  IAppboyService provideAppboyService(IUserProvider paramIUserProvider, IGcmIdService paramIGcmIdService, DialogFlow paramDialogFlow, ImageLoader paramImageLoader, InAppNotificationService paramInAppNotificationService)
  {
    return new AppboyService(paramIUserProvider, paramIGcmIdService, paramDialogFlow, paramImageLoader, paramInAppNotificationService);
  }
  
  @Provides
  @Singleton
  IAssetPackagingService provideAssetPackagingService(LyftApplication paramLyftApplication, ILyftPreferences paramILyftPreferences, OkHttpClient paramOkHttpClient)
  {
    return new AssetPackagingService(paramLyftApplication, paramILyftPreferences, paramOkHttpClient);
  }
  
  @Provides
  @Singleton
  IBootstrapService provideBootstrapService(IUserSession paramIUserSession, ILyftPreferences paramILyftPreferences, IAppInfoService paramIAppInfoService, IAssetPackagingService paramIAssetPackagingService, ILandingService paramILandingService, AutoFillService paramAutoFillService, AutoFillAnalytics paramAutoFillAnalytics, IFeaturesProvider paramIFeaturesProvider)
  {
    return new BootstrapService(paramIUserSession, paramILyftPreferences, paramIAppInfoService, paramIAssetPackagingService, paramILandingService, paramAutoFillService, paramAutoFillAnalytics, paramIFeaturesProvider);
  }
  
  @Provides
  @Singleton
  CaptureImageSession provideCaptureImageSession(AppFlow paramAppFlow)
  {
    return new CaptureImageSession(paramAppFlow);
  }
  
  @Provides
  @Singleton
  IDeferredCallService provideDeferredCallService(LyftApplication paramLyftApplication, ILyftApi paramILyftApi, IJsonSerializer paramIJsonSerializer, IDeferredSyncService paramIDeferredSyncService)
  {
    paramLyftApplication = new File(paramLyftApplication.getFilesDir(), "lyftdeferredcalls.tape");
    return new DeferredCallService(Schedulers.io(), paramLyftApplication, new LyftApiCallDependencyFactory(paramILyftApi), paramIJsonSerializer, paramIDeferredSyncService);
  }
  
  @Provides
  @Singleton
  IDeferredSyncService provideDeferredSyncService()
  {
    return new DeferredSyncService(new Handler(Looper.getMainLooper()));
  }
  
  @Provides
  @Singleton
  IDevice provideDevice(LyftApplication paramLyftApplication, WindowManager paramWindowManager, TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager, AccountManager paramAccountManager, PackageManager paramPackageManager)
  {
    return new Device(paramLyftApplication, paramWindowManager, paramTelephonyManager, paramConnectivityManager, paramAccountManager, paramPackageManager);
  }
  
  @Provides
  @Singleton
  DriverShortcutStarterService provideDriverDefenseStarterService(IUserProvider paramIUserProvider, ILyftPreferences paramILyftPreferences, IFeaturesProvider paramIFeaturesProvider)
  {
    return new DriverShortcutStarterService(paramIUserProvider, paramILyftPreferences, paramIFeaturesProvider);
  }
  
  @Provides
  @Singleton
  IEnvironmentService provideEnvironmentHelper(ILyftPreferences paramILyftPreferences, ILyftApi paramILyftApi, IJsonSerializer paramIJsonSerializer, IAnalyticsService paramIAnalyticsService)
  {
    return new EnvironmentService(paramILyftPreferences, paramILyftApi, paramIJsonSerializer, paramIAnalyticsService);
  }
  
  @Provides
  @Singleton
  IGalleryService provideGalleryService(ICaptureImageSession paramICaptureImageSession)
  {
    return new GalleryService(paramICaptureImageSession);
  }
  
  @Provides
  @Singleton
  IPhotoPickerService provideGalleryService(ICaptureImage paramICaptureImage)
  {
    return new PhotoPickerService(paramICaptureImage);
  }
  
  @Provides
  IGcmIdService provideGcmIdService()
  {
    return new GcmIdService();
  }
  
  @Provides
  @Singleton
  IGoogleApiProvider provideGoogleApiProvider(ILyftPreferences paramILyftPreferences)
  {
    return new GoogleApiProvider(paramILyftPreferences);
  }
  
  @Provides
  @Singleton
  IGoogleGeoApi provideGoogleApiService(OkHttpClient paramOkHttpClient, IJsonBodySerializer paramIJsonBodySerializer)
  {
    return new GoogleGeoApi(new HttpExecutor(paramOkHttpClient, paramIJsonBodySerializer));
  }
  
  @Provides
  @Singleton
  IGooglePlaceService provideGooglePlaceService(IGoogleApiProvider paramIGoogleApiProvider)
  {
    return new GooglePlaceService(paramIGoogleApiProvider);
  }
  
  @Provides
  ICaptureImage provideICaptureImage(CaptureImageSession paramCaptureImageSession)
  {
    return paramCaptureImageSession;
  }
  
  @Provides
  ICaptureImageSession provideICaptureImageSession(CaptureImageSession paramCaptureImageSession)
  {
    return paramCaptureImageSession;
  }
  
  @Provides
  @Singleton
  public ILocationSettingsService provideILocationSettingsService(LyftApplication paramLyftApplication)
  {
    return new LocationSettingsService(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  IPayPalService provideIPayPalService()
  {
    return new PayPalService();
  }
  
  @Provides
  IProfilePhotoLoader provideIProfilePhotoLoader(ProfilePhotoLoader paramProfilePhotoLoader)
  {
    return paramProfilePhotoLoader;
  }
  
  @Provides
  @Singleton
  IShareService provideIShareService(LyftApplication paramLyftApplication)
  {
    return new ShareService(paramLyftApplication);
  }
  
  @Provides
  @Singleton
  InAppNotificationService provideInAppNotificationService(ILyftApi paramILyftApi, IUserProvider paramIUserProvider, ILyftPreferences paramILyftPreferences, DialogFlow paramDialogFlow)
  {
    return new InAppNotificationService(paramILyftApi, paramIUserProvider, paramILyftPreferences, paramDialogFlow);
  }
  
  @Provides
  @Singleton
  IAndroidContactsProvider provideInfrastructureContactsProvider(ContentResolver paramContentResolver)
  {
    return new AndroidContactsProvider(paramContentResolver);
  }
  
  @Provides
  @Singleton
  InstallTrackerService provideInstallTrackerService(IConstantsProvider paramIConstantsProvider, IDevice paramIDevice)
  {
    return new InstallTrackerService(paramIConstantsProvider, paramIDevice);
  }
  
  @Provides
  @Singleton
  ILeanplumService provideLeanplumService(LyftApplication paramLyftApplication, ILeanplumOverrideService paramILeanplumOverrideService, ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider, IUserProvider paramIUserProvider)
  {
    return new LeanplumService(paramLyftApplication, paramILeanplumOverrideService, paramILyftPreferences, paramIConstantsProvider, paramIUserProvider);
  }
  
  @Provides
  @Singleton
  IAssetLoadingService provideLoadingService(LyftApplication paramLyftApplication, IDevice paramIDevice, ImageLoader paramImageLoader)
  {
    return new AssetLoadingService(paramLyftApplication, paramIDevice, paramImageLoader);
  }
  
  @Provides
  @Singleton
  ILocationService provideLocationService(LyftApplication paramLyftApplication, IFeaturesProvider paramIFeaturesProvider)
  {
    LocationAnalytics localLocationAnalytics = new LocationAnalytics();
    LocationManager localLocationManager = (LocationManager)paramLyftApplication.getSystemService("location");
    return new RxLocationService(new FusedLocationClient(paramLyftApplication), new AndroidLocationClient(localLocationManager), localLocationAnalytics, paramIFeaturesProvider);
  }
  
  @Provides
  @Singleton
  ILyftApi provideLyftApi(OkHttpClient paramOkHttpClient, IJsonBodySerializer paramIJsonBodySerializer, ILyftPreferences paramILyftPreferences, IDevice paramIDevice, IAppStateHandler paramIAppStateHandler, ILyftApiHeadersProvider paramILyftApiHeadersProvider)
  {
    return new LyftApi(new HttpExecutor(paramOkHttpClient, paramIJsonBodySerializer, new LyftApiApiErrorHandler(paramIJsonBodySerializer)), paramIJsonBodySerializer, paramILyftPreferences, paramIDevice, paramIAppStateHandler, paramILyftApiHeadersProvider);
  }
  
  @Provides
  @Singleton
  ILyftApiHeadersProvider provideLyftApiHeadersProvider(IDevice paramIDevice, ILyftPreferences paramILyftPreferences, IJsonSerializer paramIJsonSerializer)
  {
    return new LyftApiHeadersProvider(paramIDevice, paramILyftPreferences, paramIJsonSerializer);
  }
  
  @Provides
  @Singleton
  AutoFillAnalytics providePrefillAnalyticsService()
  {
    return new AutoFillAnalytics();
  }
  
  @Provides
  IProfilePhotoFileRecipient provideProfilePhotoFileRecipient(ProfilePhotoLoader paramProfilePhotoLoader)
  {
    return paramProfilePhotoLoader;
  }
  
  @Provides
  @Singleton
  IJsonBodySerializer provideResponseBodySerializer(IJsonSerializer paramIJsonSerializer)
  {
    return new JsonBodySerializer(paramIJsonSerializer);
  }
  
  @Provides
  @Singleton
  IS3Api provideS3Api(OkHttpClient paramOkHttpClient, IJsonBodySerializer paramIJsonBodySerializer)
  {
    return new S3Api(new HttpExecutor(paramOkHttpClient, paramIJsonBodySerializer, new S3ApiApiErrorHandler(paramIJsonBodySerializer)));
  }
  
  @Provides
  @Singleton
  IServerTimestampService provideServerTimestampService()
  {
    return new ServerTimestampService();
  }
  
  @Provides
  @Singleton
  IAutomationOverrideService provideSettingsOverrideService(ILyftPreferences paramILyftPreferences, IConstantsProvider paramIConstantsProvider, ILeanplumOverrideService paramILeanplumOverrideService, IJsonSerializer paramIJsonSerializer, IDeveloperTools paramIDeveloperTools)
  {
    return new AutomationOverrideService(paramILyftPreferences, paramIConstantsProvider, paramILeanplumOverrideService, paramIJsonSerializer, paramIDeveloperTools);
  }
  
  @Provides
  @Singleton
  SplitFareAnalytics provideSplitFareAnalytics()
  {
    return new SplitFareAnalytics();
  }
  
  @Provides
  @Singleton
  IStatusBarNotificationsService provideStatusBarService(ImageLoader paramImageLoader, NotificationManager paramNotificationManager, ILyftPreferences paramILyftPreferences, IAppForegroundDetector paramIAppForegroundDetector, IJsonSerializer paramIJsonSerializer, DeepLinkManager paramDeepLinkManager)
  {
    return new StatusBarNotificationsService(paramImageLoader, paramNotificationManager, paramILyftPreferences, paramIAppForegroundDetector, paramIJsonSerializer, paramDeepLinkManager);
  }
  
  @Provides
  @Singleton
  IStripeService provideStripeService(ILyftPreferences paramILyftPreferences)
  {
    return new StripeService(paramILyftPreferences);
  }
  
  @Provides
  IVerificationAutoFillService provideVerificationAutoFillService()
  {
    return new VerificationAutoFillService(new VerificationSmsAnalytics());
  }
  
  @Provides
  @Singleton
  IViewServerService provideViewServerService()
  {
    return new ViewServerService();
  }
  
  @Provides
  @Singleton
  IAndroidPayService provideWalletService(IGoogleApiProvider paramIGoogleApiProvider, ILyftPreferences paramILyftPreferences)
  {
    return new AndroidPayService(paramIGoogleApiProvider, paramILyftPreferences);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.InfrastructureServicesModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */