package me.lyft.android.infrastructure.environment;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.logging.L;

public class EnvironmentService
  implements IEnvironmentService
{
  private final IAnalyticsService analyticsService;
  private final IJsonSerializer jsonSerializer;
  private final ILyftApi lyftApi;
  private final ILyftPreferences preferences;
  
  public EnvironmentService(ILyftPreferences paramILyftPreferences, ILyftApi paramILyftApi, IJsonSerializer paramIJsonSerializer, IAnalyticsService paramIAnalyticsService)
  {
    preferences = paramILyftPreferences;
    lyftApi = paramILyftApi;
    jsonSerializer = paramIJsonSerializer;
    analyticsService = paramIAnalyticsService;
  }
  
  public void updateFromConfig(ConfigDTO paramConfigDTO)
  {
    L.i("Updating environment from config: " + jsonSerializer.toJson(paramConfigDTO), new Object[0]);
    if (paramConfigDTO.getUrl() != null) {
      preferences.setApiRoot(paramConfigDTO.getUrl());
    }
    if (paramConfigDTO.getFacebookAppId() != null) {
      preferences.setFacebookAppId(paramConfigDTO.getFacebookAppId());
    }
    if (paramConfigDTO.getStripeKey() != null) {
      preferences.setStripeKey(paramConfigDTO.getStripeKey());
    }
    if (paramConfigDTO.getDisplayName() != null) {
      preferences.setEnvironmentName(paramConfigDTO.getDisplayName());
    }
    if (paramConfigDTO.getWebUrl() != null) {
      preferences.setLyftWebRoot(paramConfigDTO.getWebUrl());
    }
    if (paramConfigDTO.getAnalyticsUrl() != null) {
      analyticsService.setAnalyticsUrl(paramConfigDTO.getAnalyticsUrl());
    }
    lyftApi.setApiRoot(preferences.getApiRoot());
  }
  
  public void updateFromJsonString(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      paramString = (ConfigDTO)jsonSerializer.fromJson(paramString, ConfigDTO.class);
      if (paramString != null) {
        updateFromConfig(paramString);
      }
      return;
    }
    catch (UnsupportedEncodingException paramString) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.environment.EnvironmentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */