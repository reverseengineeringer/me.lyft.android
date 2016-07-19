package io.fabric.sdk.android.services.settings;

public class AppSettingsData
{
  public final AppIconSettingsData icon;
  public final String identifier;
  public final String reportsUrl;
  public final String status;
  public final boolean updateRequired;
  public final String url;
  
  public AppSettingsData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, AppIconSettingsData paramAppIconSettingsData)
  {
    identifier = paramString1;
    status = paramString2;
    url = paramString3;
    reportsUrl = paramString4;
    updateRequired = paramBoolean;
    icon = paramAppIconSettingsData;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.AppSettingsData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */