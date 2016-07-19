package me.lyft.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.NotificationDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.lyft.android.analytics.session.AnalyticsSessionInfo;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.domain.User.CarpoolDriverStatus;
import me.lyft.android.domain.UserConstants;
import me.lyft.android.domain.job.GoogleNowAuthCode;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest;
import me.lyft.android.domain.tooltips.Tooltip;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.logging.L;
import me.lyft.android.services.TimerRecord;
import me.lyft.android.ui.passenger.MatchingStartTime;

public class LyftPreferences
  implements ILyftPreferences
{
  private static final String ADVERTISING_ID = "advertising_id";
  private static final String ANALYTICS_SESSION = "analytics_session";
  private static final String ANALYTICS_URL = "analytics_url";
  private static final String API_ROOT = "api_root";
  private static final String APP_INFO = "app_info";
  private static final String APP_VERSION_CODE = "app_version_code";
  private static final String AUTO_FILL_INFO_DIALOG_SHOWN = "auto_fill_info_dialog_shown";
  private static final String AUTO_NAVIGATION_ENABLED = "auto_navigation_enabled";
  private static final String AUTO_SWITCH_BACK_ENABLED = "auto_switch_back_enabled";
  private static final String BUSINESS_ONBOARD_EMAIL = "business_onboard_email";
  private static final String BUSINESS_ONBOARD_NEW_USER_DESCRIPTION_SHOWN = "business_onboard_new_user_description_shown";
  private static final String CARPOOL_DRIVER_ONBOARDING_SHOWN = "carpool_driver_onboarding_shown";
  private static final String CARPOOL_LAST_ONBOARDING_STEP_SHOWN = "carpool_last_onboarding_step_shown";
  private static final String COURIER_ONBOARD_VIEW_COUNT = "courier_onboard_view_count";
  private static final String DEVELOPER_MODE = "developer_mode";
  private static final String DRIVER_SHORTCUT_ENABLED = "driver_shortcut_enabled";
  private static final String EDIT_PICKUP_ONBOARDING_SHOWN = "edit_pickup_onboarding_shown";
  private static final String ENVIRONMENT_NAME = "environment_name";
  private static final String ENVIRONMENT_PRODUCTION = "production";
  private static final String FACEBOOK_APP_ID = "facebook_app_id";
  private static final String FIRST_TIME_DESTINY_DIALOG_SHOWN = "destiny_info_dialog_shown";
  private static final String GOOGLE_NOW_AUTH_CODE = "google_now_auth_code";
  private static final String GO_ONLINE_DIALOG_SHOWN = "go_online_description_shown";
  private static final String HTTP_LOGGING_LEVEL = "http_logging_level";
  private static final String INCLUDE_MOCK_HTTP_HEADER = "include_mock_http_header";
  private static final String INSTALL_REFERRER = "install_referral";
  private static final String INSTALL_STATUS = "install_status";
  private static final String IN_APP_NOTIFICATIONS = "in_app_notifications";
  private static final String LAST_CACHED_APP_STATE = "last_cached_app_state";
  private static final String LAST_PUSH_TIMESTAMP = "last_push_timestamp";
  private static final String LAST_UPDATED_ASSETS_PACKAGE_NAME = "last_updated_assets_package_name";
  private static final String LEANPLUM_APP_ID = "leanplum_app_id";
  private static final String LEANPLUM_KEY = "leanplum_key";
  private static final String LIMIT_ADVERTISING_ID = "limit_advertising_id";
  private static final String LYFT_PREFERENCES = "LyftPreferences";
  private static final String LYFT_TOKEN = "lyft_token";
  private static final String LYFT_WEB_ROOT = "lyft_web_root";
  private static final String MAT_ID = "mat_id";
  private static final String PASSENGER_MATCHING_START_TIME = "passenger_matching_start_time";
  private static final String POLLING_RATE = "polling_rate";
  private static final String PROXY_ENABLED = "proxy_enabled";
  private static final String PROXY_IP_ADDRESS = "proxy_ip_address";
  private static final String RATE_APP_PROMPT_TIMESTAMP = "rate_app_prompt_timestamp";
  private static final String RIDE_FLAGS = "ride_flags";
  private static final String RIDE_REQUEST_STATE = "ride_request_state";
  private static final String RIDE_TYPE_SHOWN_PREFIX = "ride_type_shown_";
  private static final String SELECTED_NAVIGATION = "selected_navigation";
  private static final String SHOWN_IN_APP_NOTIFICATIONS = "shown_in_app_notifications";
  private static final String SOCIAL_DIALOG_RIDES_SINCE_LAST_SHOWN = "social_dialog_rides_since_shown";
  private static final String SOCIAL_DIALOG_SHOW_COUNT = "social_dialog_show_count";
  private static final String STRIPE_KEY = "stripe_key";
  private static final String TOOLTIPS_PREFIX = "tooltip_";
  final Context context;
  final IJsonSerializer jsonSerializer;
  final SharedPreferences preferences;
  
  public LyftPreferences(Context paramContext, IJsonSerializer paramIJsonSerializer)
  {
    context = paramContext;
    jsonSerializer = paramIJsonSerializer;
    preferences = paramContext.getSharedPreferences("LyftPreferences", 0);
  }
  
  private <T> T getSerializable(String paramString, Class<T> paramClass)
  {
    String str = preferences.getString(paramString, null);
    if (Strings.isNullOrEmpty(str)) {
      return null;
    }
    try
    {
      paramClass = jsonSerializer.fromJson(str, paramClass);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      paramClass = preferences.edit();
      paramClass.remove(paramString);
      paramClass.apply();
    }
    return null;
  }
  
  private void putSerializable(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    if (paramObject == null) {
      localEditor.remove(paramString);
    }
    for (;;)
    {
      localEditor.apply();
      return;
      try
      {
        localEditor.putString(paramString, jsonSerializer.toJson(paramObject));
      }
      catch (Exception paramString)
      {
        L.e(paramString, "putSerializable", new Object[0]);
      }
    }
  }
  
  public boolean autoFillInfoDialogShown()
  {
    if (!preferences.getBoolean("auto_fill_info_dialog_shown", false))
    {
      SharedPreferences.Editor localEditor = preferences.edit();
      localEditor.putBoolean("auto_fill_info_dialog_shown", true);
      localEditor.apply();
      return false;
    }
    return true;
  }
  
  public Set<User.CarpoolDriverStatus> carpoolDriverOnboardingStatusesShown()
  {
    Set localSet = (Set)getSerializable("carpool_last_onboarding_step_shown", CarpoolStatusesSet.class);
    Object localObject = localSet;
    if (localSet == null) {
      localObject = new HashSet();
    }
    if (preferences.getBoolean("carpool_driver_onboarding_shown", false)) {
      ((Set)localObject).add(User.CarpoolDriverStatus.NEEDS_POST_APPROVAL_ONBOARDING);
    }
    return (Set<User.CarpoolDriverStatus>)localObject;
  }
  
  public void clearRideRequest()
  {
    PassengerRideRequest localPassengerRideRequest1 = getRideRequest();
    PassengerRideRequest localPassengerRideRequest2 = new PassengerRideRequest(localPassengerRideRequest1.getSelectedRideTypeId());
    localPassengerRideRequest2.setIsBusinessProfileEnabled(localPassengerRideRequest1.isBusinessProfileEnabled());
    setRideRequest(localPassengerRideRequest2);
  }
  
  public void clearTooltips()
  {
    Object localObject = preferences.getAll().keySet();
    SharedPreferences.Editor localEditor = preferences.edit();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (str.startsWith("tooltip_")) {
        localEditor.remove(str);
      }
    }
    localEditor.apply();
  }
  
  public Integer decrementCourierDriverOnboardView()
  {
    int i = preferences.getInt("courier_onboard_view_count", 3);
    if (i > 0)
    {
      SharedPreferences.Editor localEditor = preferences.edit();
      localEditor.putInt("courier_onboard_view_count", i - 1);
      localEditor.apply();
    }
    return Integer.valueOf(i);
  }
  
  public String getAdvertisingId()
  {
    return preferences.getString("advertising_id", null);
  }
  
  public AnalyticsSessionInfo getAnalyticsSession()
  {
    return (AnalyticsSessionInfo)getSerializable("analytics_session", AnalyticsSessionInfo.class);
  }
  
  public String getAnalyticsUrl()
  {
    return preferences.getString("analytics_url", context.getString(2131165299));
  }
  
  public String getApiRoot()
  {
    return preferences.getString("api_root", context.getString(2131165300));
  }
  
  public AppInfoDTO getAppInfo()
  {
    return (AppInfoDTO)getSerializable("app_info", AppInfoDTO.class);
  }
  
  public Integer getAppVersionCode()
  {
    int i = preferences.getInt("app_version_code", -1);
    if (i >= 0) {
      return Integer.valueOf(i);
    }
    return null;
  }
  
  public String getBusinessOnboardEmail()
  {
    return preferences.getString("business_onboard_email", "");
  }
  
  public String getEnvironmentName()
  {
    return preferences.getString("environment_name", context.getString(2131165696));
  }
  
  public String getFacebookAppId()
  {
    return preferences.getString("facebook_app_id", context.getString(2131165706));
  }
  
  public GoogleNowAuthCode getGoogleNowAuthCode()
  {
    return (GoogleNowAuthCode)getSerializable("google_now_auth_code", GoogleNowAuthCode.class);
  }
  
  public String getHttpLoggingLevel()
  {
    return preferences.getString("http_logging_level", null);
  }
  
  public List<NotificationDTO> getInAppNotifications()
  {
    ArrayList localArrayList2 = (ArrayList)getSerializable("in_app_notifications", InAppNotificationList.class);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public boolean getIncludeMockHttpHeader()
  {
    return preferences.getBoolean("include_mock_http_header", false);
  }
  
  public String getInstallReferrer()
  {
    return preferences.getString("install_referral", null);
  }
  
  public int getInstallStatus()
  {
    return preferences.getInt("install_status", 0);
  }
  
  public UniversalDTO getLastCachedAppState()
  {
    return (UniversalDTO)getSerializable("last_cached_app_state", UniversalDTO.class);
  }
  
  public long getLastPushTimestamp()
  {
    return preferences.getLong("last_push_timestamp", 0L);
  }
  
  public String getLastUnpackedAssetsPackageName()
  {
    return preferences.getString("last_updated_assets_package_name", "");
  }
  
  public String getLeanplumAppId()
  {
    return preferences.getString("leanplum_app_id", context.getString(2131165876));
  }
  
  public String getLeanplumKey()
  {
    return preferences.getString("leanplum_key", context.getString(2131165877));
  }
  
  public boolean getLimitAdvertisingId()
  {
    return preferences.getBoolean("limit_advertising_id", false);
  }
  
  public String getLyftToken()
  {
    return preferences.getString("lyft_token", null);
  }
  
  public String getLyftWebRoot()
  {
    return preferences.getString("lyft_web_root", context.getString(2131165911));
  }
  
  public String getMatId()
  {
    return preferences.getString("mat_id", null);
  }
  
  public int getNumRidesSinceShareDialogLastShown()
  {
    return preferences.getInt("social_dialog_rides_since_shown", 0);
  }
  
  public MatchingStartTime getPassengerMatchingStartTime()
  {
    return (MatchingStartTime)Objects.firstNonNull(getSerializable("passenger_matching_start_time", MatchingStartTime.class), new MatchingStartTime(""));
  }
  
  public long getPollingRate()
  {
    return preferences.getLong("polling_rate", UserConstants.DEFAULT_POLLING_RATE);
  }
  
  public String getProxyIpAddress()
  {
    return preferences.getString("proxy_ip_address", "");
  }
  
  public RideFlags getRideFlags()
  {
    return (RideFlags)Objects.firstNonNull((RideFlags)getSerializable("ride_flags", RideFlags.class), new RideFlags());
  }
  
  public PassengerRideRequest getRideRequest()
  {
    PassengerRideRequest localPassengerRideRequest2 = (PassengerRideRequest)getSerializable("ride_request_state", PassengerRideRequest.class);
    if (localPassengerRideRequest2 != null)
    {
      String str = localPassengerRideRequest2.getSelectedRideTypeId();
      PassengerRideRequest localPassengerRideRequest1 = localPassengerRideRequest2;
      if (Math.abs(localPassengerRideRequest2.getTimestamp().longValue() - System.currentTimeMillis()) > RIDE_REQUEST_STATE_EXPIRE_TIMEOUT) {
        localPassengerRideRequest1 = new PassengerRideRequest(str);
      }
      return localPassengerRideRequest1;
    }
    return new PassengerRideRequest("");
  }
  
  public int getSelectedNavigation(int paramInt)
  {
    return preferences.getInt("selected_navigation", paramInt);
  }
  
  public int getShareDialogShowCount()
  {
    return preferences.getInt("social_dialog_show_count", 0);
  }
  
  public Set<String> getShownInAppNotifications()
  {
    LinkedHashSet localLinkedHashSet2 = (LinkedHashSet)getSerializable("shown_in_app_notifications", new LinkedHashSet().getClass());
    LinkedHashSet localLinkedHashSet1 = localLinkedHashSet2;
    if (localLinkedHashSet2 == null) {
      localLinkedHashSet1 = new LinkedHashSet();
    }
    return localLinkedHashSet1;
  }
  
  public String getStripeKey()
  {
    return preferences.getString("stripe_key", context.getString(2131166356));
  }
  
  public TimerRecord getTimerRecord(String paramString)
  {
    return (TimerRecord)getSerializable(paramString, TimerRecord.class);
  }
  
  public Tooltip getTooltip(String paramString)
  {
    return (Tooltip)getSerializable("tooltip_" + paramString, Tooltip.class);
  }
  
  public void increaseRidesSinceShareDialogLastShown()
  {
    preferences.edit().putInt("social_dialog_rides_since_shown", getNumRidesSinceShareDialogLastShown() + 1).apply();
  }
  
  public void increaseShareDialogShownCount()
  {
    preferences.edit().putInt("social_dialog_show_count", getShareDialogShowCount() + 1).putInt("social_dialog_rides_since_shown", 0).apply();
  }
  
  public boolean isAutoNavigationEnabled()
  {
    return preferences.getBoolean("auto_navigation_enabled", true);
  }
  
  public boolean isAutoSwitchBackEnabled()
  {
    return preferences.getBoolean("auto_switch_back_enabled", true);
  }
  
  public boolean isBusinessOnboardNewUserDescriptionShown()
  {
    return preferences.getBoolean("business_onboard_new_user_description_shown", false);
  }
  
  public boolean isDeveloperMode()
  {
    return preferences.getBoolean("developer_mode", false);
  }
  
  public boolean isDriverShortcutEnabled()
  {
    return preferences.getBoolean("driver_shortcut_enabled", false);
  }
  
  public boolean isFirstTimeDestinyInfoShown()
  {
    return preferences.getBoolean("destiny_info_dialog_shown", false);
  }
  
  public boolean isFirstTimeRideTypeShown(String paramString)
  {
    return preferences.getBoolean("ride_type_shown_" + paramString, false);
  }
  
  public boolean isNavigationAppSelected()
  {
    return preferences.contains("selected_navigation");
  }
  
  public boolean isProductionEnvironment()
  {
    return "production".equalsIgnoreCase(getEnvironmentName());
  }
  
  public boolean isProxyEnabled()
  {
    return preferences.getBoolean("proxy_enabled", false);
  }
  
  public void resetRideFlags()
  {
    setRideFlags(null);
  }
  
  public void saveCarpoolDriverOnboardingStatusShown(User.CarpoolDriverStatus paramCarpoolDriverStatus)
  {
    Set localSet = carpoolDriverOnboardingStatusesShown();
    localSet.add(paramCarpoolDriverStatus);
    putSerializable("carpool_last_onboarding_step_shown", localSet);
  }
  
  public void saveTooltip(Tooltip paramTooltip)
  {
    putSerializable("tooltip_" + paramTooltip.getId(), paramTooltip);
  }
  
  public void setAdvertisingId(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("advertising_id", paramString);
    localEditor.apply();
  }
  
  public void setAnalyticsSession(AnalyticsSessionInfo paramAnalyticsSessionInfo)
  {
    putSerializable("analytics_session", paramAnalyticsSessionInfo);
  }
  
  public void setAnalyticsUrl(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("analytics_url", paramString);
    localEditor.apply();
  }
  
  public void setApiRoot(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("api_root", paramString);
    localEditor.apply();
  }
  
  public void setAppInfo(AppInfoDTO paramAppInfoDTO)
  {
    putSerializable("app_info", paramAppInfoDTO);
  }
  
  public void setAppVersionCode(Integer paramInteger)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putInt("app_version_code", paramInteger.intValue());
    localEditor.apply();
  }
  
  public void setAutoNavigationEnabled(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("auto_navigation_enabled", paramBoolean);
    localEditor.apply();
  }
  
  public void setAutoSwitchBackEnabled(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("auto_switch_back_enabled", paramBoolean);
    localEditor.apply();
  }
  
  public void setBusinessOnboardEmail(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("business_onboard_email", paramString);
    localEditor.apply();
  }
  
  public void setDeveloperMode(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("developer_mode", paramBoolean);
    localEditor.apply();
  }
  
  public void setDriverShortcutEnabled(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("driver_shortcut_enabled", paramBoolean);
    localEditor.apply();
  }
  
  public void setEditPickupOnboardingShown()
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("edit_pickup_onboarding_shown", true);
    localEditor.apply();
  }
  
  public void setEnvironmentName(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("environment_name", paramString);
    localEditor.apply();
  }
  
  public void setFacebookAppId(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("facebook_app_id", paramString);
    localEditor.apply();
  }
  
  public void setFirstTimeDestinyInfoShown(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("destiny_info_dialog_shown", paramBoolean);
    localEditor.apply();
  }
  
  public void setFirstTimeRideTypeShown(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("ride_type_shown_" + paramString, true);
    localEditor.apply();
  }
  
  public void setGoOnlineDialogShown()
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("go_online_description_shown", true);
    localEditor.apply();
  }
  
  public void setGoogleNowAuthCode(GoogleNowAuthCode paramGoogleNowAuthCode)
  {
    putSerializable("google_now_auth_code", paramGoogleNowAuthCode);
  }
  
  public void setHttpLoggingLevel(String paramString)
  {
    preferences.edit().putString("http_logging_level", paramString).apply();
  }
  
  public void setInAppNotifications(List<NotificationDTO> paramList)
  {
    putSerializable("in_app_notifications", paramList);
  }
  
  public void setIncludeMockHttpHeader(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("include_mock_http_header", paramBoolean);
    localEditor.apply();
  }
  
  public void setInstallReferrer(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("install_referral", paramString);
    localEditor.apply();
  }
  
  public void setInstallStatus(int paramInt)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putInt("install_status", paramInt);
    localEditor.apply();
  }
  
  public void setIsBusinessOnboardNewUserDescriptionShown(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("business_onboard_new_user_description_shown", true);
    localEditor.apply();
  }
  
  public void setLastCachedAppState(UniversalDTO paramUniversalDTO)
  {
    putSerializable("last_cached_app_state", paramUniversalDTO);
  }
  
  public void setLastPushTimestamp(long paramLong)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putLong("last_push_timestamp", paramLong);
    localEditor.apply();
  }
  
  public void setLastUnpackedAssetsPackageName(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("last_updated_assets_package_name", paramString);
    localEditor.apply();
  }
  
  public void setLeanplumAppId(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("leanplum_app_id", paramString);
    localEditor.apply();
  }
  
  public void setLeanplumKey(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("leanplum_key", paramString);
    localEditor.apply();
  }
  
  public void setLimitAdvertisingId(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("limit_advertising_id", paramBoolean);
    localEditor.apply();
  }
  
  public void setLyftToken(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("lyft_token", paramString);
    localEditor.apply();
  }
  
  public void setLyftWebRoot(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("lyft_web_root", paramString);
    localEditor.apply();
  }
  
  public void setMatId(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("mat_id", paramString);
    localEditor.apply();
  }
  
  public void setPassengerMatchingStartTime(MatchingStartTime paramMatchingStartTime)
  {
    putSerializable("passenger_matching_start_time", paramMatchingStartTime);
  }
  
  public void setPollingRate(Long paramLong)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putLong("polling_rate", paramLong.longValue());
    localEditor.apply();
  }
  
  public void setProxyEnabled(Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putBoolean("proxy_enabled", paramBoolean.booleanValue());
    localEditor.apply();
  }
  
  public void setProxyIpAddress(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("proxy_ip_address", paramString);
    localEditor.apply();
  }
  
  public void setRateAppPromptTimestamp(long paramLong)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putLong("rate_app_prompt_timestamp", paramLong);
    localEditor.apply();
  }
  
  public void setRideFlags(RideFlags paramRideFlags)
  {
    putSerializable("ride_flags", Objects.firstNonNull(paramRideFlags, new RideFlags()));
  }
  
  public void setRideRequest(PassengerRideRequest paramPassengerRideRequest)
  {
    putSerializable("ride_request_state", paramPassengerRideRequest);
  }
  
  public void setSelectedNavigation(int paramInt)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putInt("selected_navigation", paramInt);
    localEditor.apply();
  }
  
  public void setShownInAppNotifications(Set<String> paramSet)
  {
    putSerializable("shown_in_app_notifications", paramSet);
  }
  
  public void setStripeKey(String paramString)
  {
    SharedPreferences.Editor localEditor = preferences.edit();
    localEditor.putString("stripe_key", paramString);
    localEditor.apply();
  }
  
  public void setTimerRecord(String paramString, TimerRecord paramTimerRecord)
  {
    putSerializable(paramString, paramTimerRecord);
  }
  
  public boolean shouldShowRateAppPrompt()
  {
    long l = preferences.getLong("rate_app_prompt_timestamp", 0L);
    return System.currentTimeMillis() - l > MINIMAL_DELAY_BETWEEN_RATE_APP_PROMPT;
  }
  
  public boolean wasEditPickupOnboardingShown()
  {
    return preferences.getBoolean("edit_pickup_onboarding_shown", false);
  }
  
  public boolean wasGoOnlineDialogShown()
  {
    return preferences.getBoolean("go_online_description_shown", false);
  }
  
  public static class CarpoolStatusesSet
    extends HashSet<User.CarpoolDriverStatus>
  {}
  
  public static class InAppNotificationList
    extends ArrayList<NotificationDTO>
  {}
}

/* Location:
 * Qualified Name:     me.lyft.android.LyftPreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */