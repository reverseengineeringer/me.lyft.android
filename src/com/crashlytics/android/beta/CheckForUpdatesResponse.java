package com.crashlytics.android.beta;

class CheckForUpdatesResponse
{
  public final String buildVersion;
  public final String displayVersion;
  public final String instanceId;
  public final String packageName;
  public final String url;
  public final String versionString;
  
  public CheckForUpdatesResponse(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    url = paramString1;
    versionString = paramString2;
    displayVersion = paramString3;
    buildVersion = paramString4;
    packageName = paramString5;
    instanceId = paramString6;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.beta.CheckForUpdatesResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */