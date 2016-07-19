package me.lyft.android.application.android.mpmetrics;

import android.content.Context;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import java.util.Iterator;
import me.lyft.android.infrastructure.json.IJsonSerializer;
import org.json.JSONException;
import org.json.JSONObject;

public class MixpanelAPI
{
  private static final Object INSTANCE_LOCK = new Object();
  private static final String LOGTAG = "MixpanelAPI";
  private static MixpanelAPI sInstance;
  private String mBaseUrl;
  private final Context mContext;
  private final IJsonSerializer mJsonSerializer;
  private final AnalyticsMessages mMessages;
  private OkHttpClient okHttpClient;
  
  MixpanelAPI(Context paramContext, IJsonSerializer paramIJsonSerializer, String paramString, OkHttpClient paramOkHttpClient)
  {
    mContext = paramContext;
    mJsonSerializer = paramIJsonSerializer;
    okHttpClient = paramOkHttpClient;
    mMessages = getAnalyticsMessages();
    setEndpointHost(paramString);
  }
  
  public static MixpanelAPI getInstance(Context paramContext, IJsonSerializer paramIJsonSerializer, String paramString, OkHttpClient paramOkHttpClient)
  {
    synchronized (INSTANCE_LOCK)
    {
      if (sInstance == null) {
        sInstance = new MixpanelAPI(paramContext.getApplicationContext(), paramIJsonSerializer, paramString, paramOkHttpClient);
      }
      paramContext = sInstance;
      return paramContext;
    }
  }
  
  public void flush()
  {
    mMessages.postToServer();
  }
  
  AnalyticsMessages getAnalyticsMessages()
  {
    return AnalyticsMessages.getInstance(mContext, mJsonSerializer, okHttpClient);
  }
  
  public void setEndpointHost(String paramString)
  {
    mBaseUrl = paramString;
    mMessages.setEndpointHost(mBaseUrl);
  }
  
  public void track(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramJSONObject != null)
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject.put(str, paramJSONObject.get(str));
        }
      }
      mMessages.eventsMessage(localJSONObject);
    }
    catch (JSONException paramJSONObject)
    {
      Log.e("MixpanelAPI", "Exception tracking event " + paramString, paramJSONObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.android.mpmetrics.MixpanelAPI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */