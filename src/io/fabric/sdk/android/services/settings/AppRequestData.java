package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.KitInfo;
import java.util.Collection;

public class AppRequestData
{
  public final String apiKey;
  public final String appId;
  public final String buildVersion;
  public final String builtSdkVersion;
  public final String displayVersion;
  public final IconRequest icon;
  public final String instanceIdentifier;
  public final String minSdkVersion;
  public final String name;
  public final Collection<KitInfo> sdkKits;
  public final int source;
  
  public AppRequestData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, String paramString8, IconRequest paramIconRequest, Collection<KitInfo> paramCollection)
  {
    apiKey = paramString1;
    appId = paramString2;
    displayVersion = paramString3;
    buildVersion = paramString4;
    instanceIdentifier = paramString5;
    name = paramString6;
    source = paramInt;
    minSdkVersion = paramString7;
    builtSdkVersion = paramString8;
    icon = paramIconRequest;
    sdkKits = paramCollection;
  }
}

/* Location:
 * Qualified Name:     io.fabric.sdk.android.services.settings.AppRequestData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */