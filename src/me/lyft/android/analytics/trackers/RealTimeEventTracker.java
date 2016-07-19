package me.lyft.android.analytics.trackers;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.UUID;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.IAnalyticsRideInfoProvider;
import me.lyft.android.analytics.IEventTracker;
import me.lyft.android.analytics.core.definitions.Subevent;
import me.lyft.android.analytics.core.events.CoreEvent;
import me.lyft.android.analytics.core.events.IEvent;
import me.lyft.android.analytics.definitions.MapParameterStore;
import me.lyft.android.analytics.definitions.Parameter;
import me.lyft.android.analytics.definitions.ParameterStore;
import me.lyft.android.analytics.session.AnalyticsSession;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.common.DateUtils;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.infrastructure.device.BatteryStatus;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.infrastructure.foreground.IAppForegroundDetector;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.logging.L;
import org.json.JSONException;

public class RealTimeEventTracker
  implements IEventTracker
{
  private final AnalyticsApi analyticsApi;
  private final IAnalyticsRideInfoProvider analyticsRideInfoProvider;
  private final AnalyticsSession analyticsSession;
  private final IDevice device;
  private final IAppForegroundDetector foregroundDetector;
  private final ILocationService locationService;
  private final ILyftPreferences lyftPreferences;
  private final IRideRequestSession rideRequestSession;
  private final IUserProvider userProvider;
  private final IUserUiService userService;
  
  RealTimeEventTracker(AnalyticsApi paramAnalyticsApi, AnalyticsSession paramAnalyticsSession, ILyftPreferences paramILyftPreferences, ILocationService paramILocationService, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService, IRideRequestSession paramIRideRequestSession, IDevice paramIDevice, IAppForegroundDetector paramIAppForegroundDetector, IAnalyticsRideInfoProvider paramIAnalyticsRideInfoProvider)
  {
    analyticsApi = paramAnalyticsApi;
    lyftPreferences = paramILyftPreferences;
    analyticsSession = paramAnalyticsSession;
    locationService = paramILocationService;
    userProvider = paramIUserProvider;
    userService = paramIUserUiService;
    rideRequestSession = paramIRideRequestSession;
    device = paramIDevice;
    foregroundDetector = paramIAppForegroundDetector;
    analyticsRideInfoProvider = paramIAnalyticsRideInfoProvider;
  }
  
  static void mapClientInfo(ParameterStore paramParameterStore, IDevice paramIDevice, IAppForegroundDetector paramIAppForegroundDetector)
  {
    paramParameterStore.put(Parameter.APP_ID, "me.lyft.android");
    paramParameterStore.put(Parameter.APP_VERSION, paramIDevice.getApplicationVersion());
    paramParameterStore.put(Parameter.OS, "Android");
    paramParameterStore.put(Parameter.OS_VERSION, Build.VERSION.RELEASE);
    paramParameterStore.put(Parameter.MANUFACTURER, Build.MANUFACTURER);
    paramParameterStore.put(Parameter.MODEL, Build.MODEL);
    paramParameterStore.put(Parameter.DEVICE_ID, paramIDevice.getAndroidId());
    Parameter localParameter = Parameter.BACKGROUND;
    if (!paramIAppForegroundDetector.isForegrounded()) {}
    for (boolean bool = true;; bool = false)
    {
      paramParameterStore.put(localParameter, Boolean.valueOf(bool));
      paramParameterStore.put(Parameter.LOCALE, paramIDevice.getDeviceLocale());
      return;
    }
  }
  
  static void mapDeviceInfo(ParameterStore paramParameterStore, IDevice paramIDevice)
  {
    paramParameterStore.put(Parameter.SCREEN_DPI, Integer.valueOf(paramIDevice.getDensityDpi()));
    paramParameterStore.put(Parameter.SCREEN_HEIGHT, paramIDevice.getScreenHeight());
    paramParameterStore.put(Parameter.SCREEN_WIDTH, paramIDevice.getScreenWidth());
    paramIDevice = paramIDevice.getBatteryStatus();
    paramParameterStore.put(Parameter.BATTERY_LEVEL, Float.valueOf(paramIDevice.getBatteryLevel()));
    paramParameterStore.put(Parameter.BATTERY_CHARGING, Boolean.valueOf(paramIDevice.isCharging()));
  }
  
  static void mapLocationInfo(ParameterStore paramParameterStore, IUserProvider paramIUserProvider, ILocationService paramILocationService)
  {
    paramIUserProvider = paramIUserProvider.getUser();
    if (!paramIUserProvider.isNull()) {
      paramParameterStore.put(Parameter.REGION, paramIUserProvider.getRegion());
    }
    paramIUserProvider = paramILocationService.getLastCachedLocation();
    if (!paramIUserProvider.isNull())
    {
      paramParameterStore.put(Parameter.LATITUDE, Double.valueOf(paramIUserProvider.getLat()));
      paramParameterStore.put(Parameter.LONGITUDE, Double.valueOf(paramIUserProvider.getLng()));
      paramParameterStore.put(Parameter.ALTITUDE, paramIUserProvider.getAltitude());
      if ((paramIUserProvider.getBearing() != null) && (paramIUserProvider.getBearing().doubleValue() != -1.0D)) {
        paramParameterStore.put(Parameter.BEARING, paramIUserProvider.getBearing());
      }
      paramParameterStore.put(Parameter.SPEED, paramIUserProvider.getSpeed());
      paramParameterStore.put(Parameter.ACCURACY, paramIUserProvider.getAccuracy());
      paramParameterStore.put(Parameter.SAMPLED_AT, paramIUserProvider.getTime());
    }
  }
  
  static void mapNetworkInfo(ParameterStore paramParameterStore, IDevice paramIDevice)
  {
    paramParameterStore.put(Parameter.NETWORK_TYPE, paramIDevice.getNetworkType());
    paramParameterStore.put(Parameter.RADIO_TYPE, paramIDevice.getRadioType());
    paramParameterStore.put(Parameter.CARRIER, paramIDevice.getOperatorName());
    paramParameterStore.put(Parameter.CARRIER_ISO, paramIDevice.getNetworkIso());
    paramParameterStore.put(Parameter.CARRIER_MCC, paramIDevice.getMobileCountryCode());
    paramParameterStore.put(Parameter.CARRIER_MNC, paramIDevice.getMobileNetworkCode());
  }
  
  static void mapRideInfo(ParameterStore paramParameterStore, IAnalyticsRideInfoProvider paramIAnalyticsRideInfoProvider, IRideRequestSession paramIRideRequestSession)
  {
    if (paramIAnalyticsRideInfoProvider.hasRide())
    {
      paramParameterStore.put(Parameter.RIDE_ID, paramIAnalyticsRideInfoProvider.getRideId());
      paramParameterStore.put(Parameter.RIDE_STATE, paramIAnalyticsRideInfoProvider.getRideStatus());
      paramParameterStore.put(Parameter.RIDE_TYPE, paramIAnalyticsRideInfoProvider.getRideType());
      return;
    }
    paramIAnalyticsRideInfoProvider = paramIRideRequestSession.getCurrentRideType().getPublicId();
    paramParameterStore.put(Parameter.RIDE_TYPE, paramIAnalyticsRideInfoProvider);
  }
  
  static void mapUserInfo(ParameterStore paramParameterStore, IUserProvider paramIUserProvider, IUserUiService paramIUserUiService)
  {
    User localUser = paramIUserProvider.getUser();
    if ((localUser != null) && (!localUser.isNull()))
    {
      paramParameterStore.put(Parameter.USER_ID, localUser.getId());
      if (!paramIUserUiService.getUiState().isDriverUi()) {
        break label88;
      }
    }
    label88:
    for (paramIUserProvider = "driver";; paramIUserProvider = "passenger")
    {
      paramParameterStore.put(Parameter.USER_MODE, paramIUserProvider);
      paramParameterStore.put(Parameter.DISPATCHABLE, Boolean.valueOf(localUser.isDispatchable()));
      paramParameterStore.put(Parameter.USER_REFERRAL_CODE, (String)Objects.firstNonNull(localUser.getReferralCode(), ""));
      return;
    }
  }
  
  static void mapVendorInfo(ParameterStore paramParameterStore, IDevice paramIDevice, ILyftPreferences paramILyftPreferences)
  {
    paramParameterStore.put(Parameter.ANDROID_ID, paramIDevice.getAndroidId());
    paramParameterStore.put(Parameter.GOOGLE_AID, paramILyftPreferences.getAdvertisingId());
    paramParameterStore.put(Parameter.TUNE_MAT_ID, paramILyftPreferences.getMatId());
  }
  
  private void trackEvent(CoreEvent paramCoreEvent)
    throws JSONException
  {
    MapParameterStore localMapParameterStore = new MapParameterStore();
    String str = paramCoreEvent.getName();
    localMapParameterStore.put(Parameter.EVENT_NAME, str);
    localMapParameterStore.put(Parameter.EVENT_ID, UUID.randomUUID().toString());
    localMapParameterStore.put(Parameter.EVENT_VERSION, Integer.valueOf(paramCoreEvent.getEventVersion()));
    localMapParameterStore.put(Parameter.SAMPLE_RATE, Float.valueOf(1.0F));
    localMapParameterStore.put(Parameter.OCCURRED_AT, DateUtils.convertEpochToISO(DeviceClock.getCurrentTimeMs()));
    localMapParameterStore.put(Parameter.SESSION_ID, analyticsSession.getSessionId());
    if (paramCoreEvent.contains(Subevent.USER)) {
      mapUserInfo(localMapParameterStore, userProvider, userService);
    }
    if (paramCoreEvent.contains(Subevent.CLIENT)) {
      mapClientInfo(localMapParameterStore, device, foregroundDetector);
    }
    if (paramCoreEvent.contains(Subevent.RIDE)) {
      mapRideInfo(localMapParameterStore, analyticsRideInfoProvider, rideRequestSession);
    }
    if (paramCoreEvent.contains(Subevent.VENDOR)) {
      mapVendorInfo(localMapParameterStore, device, lyftPreferences);
    }
    if (paramCoreEvent.contains(Subevent.DEVICE)) {
      mapDeviceInfo(localMapParameterStore, device);
    }
    if (paramCoreEvent.contains(Subevent.LOCATION)) {
      mapLocationInfo(localMapParameterStore, userProvider, locationService);
    }
    if (paramCoreEvent.contains(Subevent.NETWORK)) {
      mapNetworkInfo(localMapParameterStore, device);
    }
    localMapParameterStore.overrideParameters(paramCoreEvent.getParameters());
    analyticsApi.track(str, localMapParameterStore.getMap());
  }
  
  public void flush()
  {
    analyticsApi.flush();
  }
  
  public void track(IEvent paramIEvent)
  {
    if ((paramIEvent instanceof CoreEvent)) {}
    try
    {
      trackEvent((CoreEvent)paramIEvent);
      return;
    }
    catch (Exception localException)
    {
      L.w(localException, "failed to track the event: %s", new Object[] { paramIEvent.getName() });
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.RealTimeEventTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */