package me.lyft.android.analytics.trackers;

import android.content.Context;
import com.squareup.okhttp.OkHttpClient;
import java.util.Map;
import me.lyft.android.application.android.mpmetrics.MixpanelAPI;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import org.json.JSONObject;

public class AnalyticsApi
{
  private final MixpanelAPI mixpanelAPI;
  
  AnalyticsApi(Context paramContext, IJsonSerializer paramIJsonSerializer, String paramString, OkHttpClient paramOkHttpClient)
  {
    mixpanelAPI = MixpanelAPI.getInstance(paramContext, paramIJsonSerializer, paramString, paramOkHttpClient);
  }
  
  void flush()
  {
    mixpanelAPI.flush();
  }
  
  void setEndpointHost(String paramString)
  {
    mixpanelAPI.setEndpointHost(paramString);
  }
  
  void track(String paramString, Map<String, Object> paramMap)
  {
    paramMap = new JSONObject(paramMap);
    mixpanelAPI.track(paramString, paramMap);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.AnalyticsApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */