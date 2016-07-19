package me.lyft.android;

import com.lyft.android.api.dto.AppInfoDTO;
import com.lyft.android.api.dto.NotificationDTO;
import com.lyft.android.api.dto.UniversalDTO;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import me.lyft.android.analytics.session.AnalyticsSessionInfo;
import me.lyft.android.domain.User.CarpoolDriverStatus;
import me.lyft.android.domain.job.GoogleNowAuthCode;
import me.lyft.android.domain.passenger.ride.PassengerRideRequest;
import me.lyft.android.domain.tooltips.Tooltip;
import me.lyft.android.services.TimerRecord;
import me.lyft.android.ui.passenger.MatchingStartTime;

public abstract interface ILyftPreferences
{
  public static final int INSTALL_STATUS_NEW_INSTALL = 1;
  public static final int INSTALL_STATUS_NONE = 0;
  public static final int INSTALL_STATUS_UPDATE = 2;
  public static final long MINIMAL_DELAY_BETWEEN_RATE_APP_PROMPT = TimeUnit.DAYS.toMillis(5L);
  public static final long MIN_POLLING_RATE = TimeUnit.SECONDS.toMillis(1L);
  public static final long RIDE_REQUEST_STATE_EXPIRE_TIMEOUT = TimeUnit.MINUTES.toMillis(15L);
  
  public abstract boolean autoFillInfoDialogShown();
  
  public abstract Set<User.CarpoolDriverStatus> carpoolDriverOnboardingStatusesShown();
  
  public abstract void clearRideRequest();
  
  public abstract void clearTooltips();
  
  public abstract Integer decrementCourierDriverOnboardView();
  
  public abstract String getAdvertisingId();
  
  public abstract AnalyticsSessionInfo getAnalyticsSession();
  
  public abstract String getAnalyticsUrl();
  
  public abstract String getApiRoot();
  
  public abstract AppInfoDTO getAppInfo();
  
  public abstract Integer getAppVersionCode();
  
  public abstract String getBusinessOnboardEmail();
  
  public abstract String getEnvironmentName();
  
  public abstract String getFacebookAppId();
  
  public abstract GoogleNowAuthCode getGoogleNowAuthCode();
  
  public abstract String getHttpLoggingLevel();
  
  public abstract List<NotificationDTO> getInAppNotifications();
  
  public abstract boolean getIncludeMockHttpHeader();
  
  public abstract String getInstallReferrer();
  
  public abstract int getInstallStatus();
  
  public abstract UniversalDTO getLastCachedAppState();
  
  public abstract long getLastPushTimestamp();
  
  public abstract String getLastUnpackedAssetsPackageName();
  
  public abstract String getLeanplumAppId();
  
  public abstract String getLeanplumKey();
  
  public abstract boolean getLimitAdvertisingId();
  
  public abstract String getLyftToken();
  
  public abstract String getLyftWebRoot();
  
  public abstract String getMatId();
  
  public abstract int getNumRidesSinceShareDialogLastShown();
  
  public abstract MatchingStartTime getPassengerMatchingStartTime();
  
  public abstract long getPollingRate();
  
  public abstract String getProxyIpAddress();
  
  public abstract RideFlags getRideFlags();
  
  public abstract PassengerRideRequest getRideRequest();
  
  public abstract int getSelectedNavigation(int paramInt);
  
  public abstract int getShareDialogShowCount();
  
  public abstract Set<String> getShownInAppNotifications();
  
  public abstract String getStripeKey();
  
  public abstract TimerRecord getTimerRecord(String paramString);
  
  public abstract Tooltip getTooltip(String paramString);
  
  public abstract void increaseRidesSinceShareDialogLastShown();
  
  public abstract void increaseShareDialogShownCount();
  
  public abstract boolean isAutoNavigationEnabled();
  
  public abstract boolean isAutoSwitchBackEnabled();
  
  public abstract boolean isBusinessOnboardNewUserDescriptionShown();
  
  public abstract boolean isDeveloperMode();
  
  public abstract boolean isDriverShortcutEnabled();
  
  public abstract boolean isFirstTimeDestinyInfoShown();
  
  public abstract boolean isFirstTimeRideTypeShown(String paramString);
  
  public abstract boolean isNavigationAppSelected();
  
  public abstract boolean isProductionEnvironment();
  
  public abstract boolean isProxyEnabled();
  
  public abstract void resetRideFlags();
  
  public abstract void saveCarpoolDriverOnboardingStatusShown(User.CarpoolDriverStatus paramCarpoolDriverStatus);
  
  public abstract void saveTooltip(Tooltip paramTooltip);
  
  public abstract void setAdvertisingId(String paramString);
  
  public abstract void setAnalyticsSession(AnalyticsSessionInfo paramAnalyticsSessionInfo);
  
  public abstract void setAnalyticsUrl(String paramString);
  
  public abstract void setApiRoot(String paramString);
  
  public abstract void setAppInfo(AppInfoDTO paramAppInfoDTO);
  
  public abstract void setAppVersionCode(Integer paramInteger);
  
  public abstract void setAutoNavigationEnabled(boolean paramBoolean);
  
  public abstract void setAutoSwitchBackEnabled(boolean paramBoolean);
  
  public abstract void setBusinessOnboardEmail(String paramString);
  
  public abstract void setDeveloperMode(boolean paramBoolean);
  
  public abstract void setDriverShortcutEnabled(boolean paramBoolean);
  
  public abstract void setEditPickupOnboardingShown();
  
  public abstract void setEnvironmentName(String paramString);
  
  public abstract void setFacebookAppId(String paramString);
  
  public abstract void setFirstTimeDestinyInfoShown(boolean paramBoolean);
  
  public abstract void setFirstTimeRideTypeShown(String paramString);
  
  public abstract void setGoOnlineDialogShown();
  
  public abstract void setGoogleNowAuthCode(GoogleNowAuthCode paramGoogleNowAuthCode);
  
  public abstract void setHttpLoggingLevel(String paramString);
  
  public abstract void setInAppNotifications(List<NotificationDTO> paramList);
  
  public abstract void setIncludeMockHttpHeader(boolean paramBoolean);
  
  public abstract void setInstallReferrer(String paramString);
  
  public abstract void setInstallStatus(int paramInt);
  
  public abstract void setIsBusinessOnboardNewUserDescriptionShown(boolean paramBoolean);
  
  public abstract void setLastCachedAppState(UniversalDTO paramUniversalDTO);
  
  public abstract void setLastPushTimestamp(long paramLong);
  
  public abstract void setLastUnpackedAssetsPackageName(String paramString);
  
  public abstract void setLeanplumAppId(String paramString);
  
  public abstract void setLeanplumKey(String paramString);
  
  public abstract void setLimitAdvertisingId(boolean paramBoolean);
  
  public abstract void setLyftToken(String paramString);
  
  public abstract void setLyftWebRoot(String paramString);
  
  public abstract void setMatId(String paramString);
  
  public abstract void setPassengerMatchingStartTime(MatchingStartTime paramMatchingStartTime);
  
  public abstract void setPollingRate(Long paramLong);
  
  public abstract void setProxyEnabled(Boolean paramBoolean);
  
  public abstract void setProxyIpAddress(String paramString);
  
  public abstract void setRateAppPromptTimestamp(long paramLong);
  
  public abstract void setRideFlags(RideFlags paramRideFlags);
  
  public abstract void setRideRequest(PassengerRideRequest paramPassengerRideRequest);
  
  public abstract void setSelectedNavigation(int paramInt);
  
  public abstract void setShownInAppNotifications(Set<String> paramSet);
  
  public abstract void setStripeKey(String paramString);
  
  public abstract void setTimerRecord(String paramString, TimerRecord paramTimerRecord);
  
  public abstract boolean shouldShowRateAppPrompt();
  
  public abstract boolean wasEditPickupOnboardingShown();
  
  public abstract boolean wasGoOnlineDialogShown();
}

/* Location:
 * Qualified Name:     me.lyft.android.ILyftPreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */