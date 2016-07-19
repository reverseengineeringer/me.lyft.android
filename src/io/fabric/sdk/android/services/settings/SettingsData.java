package io.fabric.sdk.android.services.settings;

public class SettingsData
{
  public final AnalyticsSettingsData analyticsSettingsData;
  public final AppSettingsData appData;
  public final BetaSettingsData betaSettingsData;
  public final int cacheDuration;
  public final long expiresAtMillis;
  public final FeaturesSettingsData featuresData;
  public final PromptSettingsData promptData;
  public final SessionSettingsData sessionData;
  public final int settingsVersion;
  
  public SettingsData(long paramLong, AppSettingsData paramAppSettingsData, SessionSettingsData paramSessionSettingsData, PromptSettingsData paramPromptSettingsData, FeaturesSettingsData paramFeaturesSettingsData, AnalyticsSettingsData paramAnalyticsSettingsData, BetaSettingsData paramBetaSettingsData, int paramInt1, int paramInt2)
  {
    expiresAtMillis = paramLong;
    appData = paramAppSettingsData;
    sessionData = paramSessionSettingsData;
    promptData = paramPromptSettingsData;
    featuresData = paramFeaturesSettingsData;
    settingsVersion = paramInt1;
    cacheDuration = paramInt2;
    analyticsSettingsData = paramAnalyticsSettingsData;
    betaSettingsData = paramBetaSettingsData;
  }
  
  public boolean isExpired(long paramLong)
  {
    return expiresAtMillis < paramLong;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */