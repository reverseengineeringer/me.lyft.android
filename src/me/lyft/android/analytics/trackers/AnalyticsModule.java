package me.lyft.android.analytics.trackers;

import com.kochava.android.tracker.Feature;
import com.mobileapptracker.MobileAppTracker;
import com.squareup.okhttp.OkHttpClient;
import dagger.Module;
import dagger.Provides;
import java.util.List;
import javax.inject.Singleton;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.LyftApplication;
import me.lyft.android.analytics.AnalyticsRideInfoProvider;
import me.lyft.android.analytics.IAnalyticsRideInfoProvider;
import me.lyft.android.analytics.IAnalyticsSessionInfoRepository;
import me.lyft.android.analytics.session.AnalyticsSession;
import me.lyft.android.analytics.session.AnalyticsSessionInfo;
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
import me.lyft.android.logging.L;
import me.lyft.android.providers.AdvertisingIdProvider;

@Module(complete=false, library=true)
public class AnalyticsModule
{
  @Provides
  @Singleton
  IAnalyticsRideInfoProvider provideAnalitycsRideInfoProvider(IUserProvider paramIUserProvider, IPassengerRideProvider paramIPassengerRideProvider, IDriverRideProvider paramIDriverRideProvider)
  {
    return new AnalyticsRideInfoProvider(paramIUserProvider, paramIPassengerRideProvider, paramIDriverRideProvider);
  }
  
  @Provides
  @Singleton
  AnalyticsApi provideAnalyticsApi(LyftApplication paramLyftApplication, IJsonSerializer paramIJsonSerializer, ILyftPreferences paramILyftPreferences, IDeveloperTools paramIDeveloperTools)
  {
    OkHttpClient localOkHttpClient = new OkHttpClient();
    localOkHttpClient.interceptors().add(paramIDeveloperTools.getHttpLoggingInterceptor());
    return new AnalyticsApi(paramLyftApplication, paramIJsonSerializer, paramILyftPreferences.getAnalyticsUrl(), localOkHttpClient);
  }
  
  @Provides
  @Singleton
  IAnalyticsService provideAnalyticsInitializer(AnalyticsApi paramAnalyticsApi, IDevice paramIDevice, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, ILyftPreferences paramILyftPreferences, AppEventTracker paramAppEventTracker, LogEventTracker paramLogEventTracker, RealTimeEventTracker paramRealTimeEventTracker)
  {
    return new AnalyticsService(paramAnalyticsApi, paramIDevice, paramIUserProvider, paramIUserUiService, paramILyftPreferences, paramAppEventTracker, paramLogEventTracker, paramRealTimeEventTracker);
  }
  
  @Provides
  @Singleton
  AnalyticsSession provideAnalyticsSessionProvider(final ILyftPreferences paramILyftPreferences, IDevice paramIDevice)
  {
    new AnalyticsSession(new IAnalyticsSessionInfoRepository()
    {
      public AnalyticsSessionInfo getAnalyticsSessionInfo()
      {
        return paramILyftPreferences.getAnalyticsSession();
      }
      
      public void setAnalyticsSessionInfo(AnalyticsSessionInfo paramAnonymousAnalyticsSessionInfo)
      {
        paramILyftPreferences.setAnalyticsSession(paramAnonymousAnalyticsSessionInfo);
      }
    });
  }
  
  @Provides
  AppEventTracker provideAppEventTracker(Feature paramFeature, MobileAppTracker paramMobileAppTracker, IJsonSerializer paramIJsonSerializer, IDevice paramIDevice, ILyftPreferences paramILyftPreferences, AdvertisingIdProvider paramAdvertisingIdProvider)
  {
    return new AppEventTracker(paramFeature, paramMobileAppTracker, paramIJsonSerializer, paramIDevice, paramILyftPreferences, paramAdvertisingIdProvider);
  }
  
  @Provides
  Feature provideKochavaAnalytics(LyftApplication paramLyftApplication)
  {
    return new Feature(paramLyftApplication, paramLyftApplication.getString(2131165849));
  }
  
  @Provides
  LogEventTracker provideLogEventTracker()
  {
    return new LogEventTracker();
  }
  
  @Provides
  @Singleton
  MobileAppTracker provideMobileAppTracker(LyftApplication paramLyftApplication, ILyftPreferences paramILyftPreferences, IAppStore paramIAppStore)
  {
    try
    {
      MobileAppTracker.init(paramLyftApplication, paramLyftApplication.getString(2131165747), paramLyftApplication.getString(2131165748));
      paramLyftApplication = MobileAppTracker.getInstance();
      paramILyftPreferences.setMatId(paramLyftApplication.getMatId());
      if (paramIAppStore.wasInstalledFromSamsungStore()) {
        paramLyftApplication.setPackageName("me.lyft.android.samsung");
      }
      return paramLyftApplication;
    }
    catch (Exception paramLyftApplication)
    {
      L.e(paramLyftApplication, "provideMobileAppTracker failed", new Object[0]);
    }
    return null;
  }
  
  @Provides
  RealTimeEventTracker provideRedshiftEventTracker2(AnalyticsApi paramAnalyticsApi, AnalyticsSession paramAnalyticsSession, ILyftPreferences paramILyftPreferences, ILocationService paramILocationService, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, IRideRequestSession paramIRideRequestSession, IDevice paramIDevice, IAppForegroundDetector paramIAppForegroundDetector, IAnalyticsRideInfoProvider paramIAnalyticsRideInfoProvider)
  {
    return new RealTimeEventTracker(paramAnalyticsApi, paramAnalyticsSession, paramILyftPreferences, paramILocationService, paramIUserProvider, paramIUserUiService, paramIRideRequestSession, paramIDevice, paramIAppForegroundDetector, paramIAnalyticsRideInfoProvider);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsModule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */