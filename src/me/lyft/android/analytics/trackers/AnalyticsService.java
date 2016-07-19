package me.lyft.android.analytics.trackers;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.Preconditions;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.Phone;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.infrastructure.activity.ActivityService;
import me.lyft.android.infrastructure.device.IDevice;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.Subscriptions;

public class AnalyticsService
  extends ActivityService
  implements IAnalyticsService
{
  private static boolean initialized = false;
  private final AnalyticsApi analyticsApi;
  private final AppEventTracker appEventTracker;
  private Subscription appTrackerSubscription = Subscriptions.empty();
  private final IDevice device;
  private final LogEventTracker logEventTracker;
  private final ILyftPreferences lyftPreferences;
  private final Action1<Unit> onAppTrackerUpdated = new Action1()
  {
    public void call(Unit paramAnonymousUnit)
    {
      AnalyticsService.this.trackInstallIfNeeded();
      appTrackerSubscription.unsubscribe();
    }
  };
  private final Action1<User> onUserUpdate = new Action1()
  {
    public void call(User paramAnonymousUser)
    {
      appEventTracker.updateUserInfo(paramAnonymousUser);
      AnalyticsService.this.updateCrashlyticsUser(paramAnonymousUser);
    }
  };
  private final RealTimeEventTracker realTimeEventTracker;
  private final IUserProvider userProvider;
  private Subscription userSubscription = Subscriptions.empty();
  private final IUserUiService userUiService;
  
  AnalyticsService(AnalyticsApi paramAnalyticsApi, IDevice paramIDevice, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, ILyftPreferences paramILyftPreferences, AppEventTracker paramAppEventTracker, LogEventTracker paramLogEventTracker, RealTimeEventTracker paramRealTimeEventTracker)
  {
    device = paramIDevice;
    userProvider = paramIUserProvider;
    appEventTracker = paramAppEventTracker;
    logEventTracker = paramLogEventTracker;
    realTimeEventTracker = paramRealTimeEventTracker;
    lyftPreferences = paramILyftPreferences;
    userUiService = paramIUserUiService;
    analyticsApi = paramAnalyticsApi;
    setupCrashlyticsDeviceInfo();
  }
  
  private void setAuthorized(User paramUser)
  {
    if (paramUser.isUnauthorized())
    {
      Crashlytics.setString("user_authorized", "unauthorized");
      return;
    }
    Crashlytics.setString("user_authorized", "authorized");
  }
  
  private void setDispatchable(User paramUser)
  {
    if (paramUser.isDispatchable())
    {
      Crashlytics.setString("user_dispatchable", "online");
      return;
    }
    Crashlytics.setString("user_dispatchable", "offline");
  }
  
  private void setUiState()
  {
    if (userUiService.getUiState().isDriverUi())
    {
      Crashlytics.setString("user_ui", "driver");
      return;
    }
    Crashlytics.setString("user_ui", "passenger");
  }
  
  private void setupCrashlyticsDeviceInfo()
  {
    Crashlytics.setString("device_email", device.getGoogleAccountEmail());
    Crashlytics.setString("device_phone", device.getPhoneNumber());
  }
  
  private void trackInstallIfNeeded()
  {
    if (lyftPreferences.getInstallStatus() == 1) {
      AppAnalytics.trackAppInstall(device.getApplicationInstallTimestamp(), lyftPreferences.getInstallReferrer());
    }
  }
  
  private void updateCrashlyticsUser(User paramUser)
  {
    Crashlytics.setUserIdentifier(paramUser.getId());
    Crashlytics.setUserName(paramUser.getFullName());
    Crashlytics.setUserEmail(paramUser.getEmail());
    Crashlytics.setString("user_id", paramUser.getId());
    setUiState();
    setDispatchable(paramUser);
    setAuthorized(paramUser);
    if (paramUser.hasValidEmail()) {
      Crashlytics.setString("device_email", paramUser.getEmail());
    }
    if (paramUser.hasValidPhoneNumber()) {
      Crashlytics.setString("device_phone", paramUser.getPhone().getNumber());
    }
    Crashlytics.setString("facebook_id", paramUser.getFacebookUid());
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    Preconditions.checkState(initialized, "Initialize before calling onActivityCreated");
    appTrackerSubscription = appEventTracker.observerMobileAppTrackerInit().subscribe(onAppTrackerUpdated);
    appEventTracker.onCreate();
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    userSubscription.unsubscribe();
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    Preconditions.checkState(initialized, "Initialize before calling onActivityResumed");
    userSubscription = userProvider.observeUserUpdates().subscribe(onUserUpdate);
    appEventTracker.onResume(paramActivity);
  }
  
  public void onApplicationCreate()
  {
    if (!initialized) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkState(bool, "You can only call onApplicationCreate once");
      Analytics.add(appEventTracker);
      Analytics.add(realTimeEventTracker);
      initialized = true;
      return;
    }
  }
  
  public void setAnalyticsUrl(String paramString)
  {
    lyftPreferences.setAnalyticsUrl(paramString);
    analyticsApi.setEndpointHost(paramString);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */