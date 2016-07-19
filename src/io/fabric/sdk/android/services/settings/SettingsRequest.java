package io.fabric.sdk.android.services.settings;

public class SettingsRequest
{
  public final String advertisingId;
  public final String androidId;
  public final String apiKey;
  public final String buildVersion;
  public final String deviceModel;
  public final String displayVersion;
  public final String iconHash;
  public final String installationId;
  public final String instanceId;
  public final String osBuildVersion;
  public final String osDisplayVersion;
  public final int source;
  
  public SettingsRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, int paramInt, String paramString11)
  {
    apiKey = paramString1;
    deviceModel = paramString2;
    osBuildVersion = paramString3;
    osDisplayVersion = paramString4;
    advertisingId = paramString5;
    installationId = paramString6;
    androidId = paramString7;
    instanceId = paramString8;
    displayVersion = paramString9;
    buildVersion = paramString10;
    source = paramInt;
    iconHash = paramString11;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.SettingsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */