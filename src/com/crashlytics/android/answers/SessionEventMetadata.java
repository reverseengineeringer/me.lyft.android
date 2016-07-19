package com.crashlytics.android.answers;

final class SessionEventMetadata
{
  public final String advertisingId;
  public final String androidId;
  public final String appBundleId;
  public final String appVersionCode;
  public final String appVersionName;
  public final String betaDeviceToken;
  public final String buildId;
  public final String deviceModel;
  public final String executionId;
  public final String installationId;
  public final Boolean limitAdTrackingEnabled;
  public final String osVersion;
  private String stringRepresentation;
  
  public SessionEventMetadata(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Boolean paramBoolean, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11)
  {
    appBundleId = paramString1;
    executionId = paramString2;
    installationId = paramString3;
    androidId = paramString4;
    advertisingId = paramString5;
    limitAdTrackingEnabled = paramBoolean;
    betaDeviceToken = paramString6;
    buildId = paramString7;
    osVersion = paramString8;
    deviceModel = paramString9;
    appVersionCode = paramString10;
    appVersionName = paramString11;
  }
  
  public String toString()
  {
    if (stringRepresentation == null) {
      stringRepresentation = ("appBundleId=" + appBundleId + ", executionId=" + executionId + ", installationId=" + installationId + ", androidId=" + androidId + ", advertisingId=" + advertisingId + ", limitAdTrackingEnabled=" + limitAdTrackingEnabled + ", betaDeviceToken=" + betaDeviceToken + ", buildId=" + buildId + ", osVersion=" + osVersion + ", deviceModel=" + deviceModel + ", appVersionCode=" + appVersionCode + ", appVersionName=" + appVersionName);
    }
    return stringRepresentation;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionEventMetadata
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */