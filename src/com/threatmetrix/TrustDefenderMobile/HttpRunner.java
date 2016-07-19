package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.util.Log;
import java.util.Map;

class HttpRunner
  implements Runnable
{
  private static final String TAG = StringUtils.getLogTag(HttpRunner.class);
  final TDURLConnection m_connection;
  private Context m_context = null;
  final HttpParameterMap m_params;
  private final TrustDefenderMobile m_sdk;
  private CancelState m_state = null;
  private final HttpRunnerType m_type;
  final String m_url;
  
  public HttpRunner(TDHttpClient paramTDHttpClient, HttpRunnerType paramHttpRunnerType, String paramString, HttpParameterMap paramHttpParameterMap, Map<String, String> paramMap, TrustDefenderMobile paramTrustDefenderMobile, Context paramContext, CancelState paramCancelState)
  {
    m_state = paramCancelState;
    m_connection = paramTDHttpClient.getURLConnection(paramCancelState);
    m_connection.addHeaders(paramMap);
    m_type = paramHttpRunnerType;
    m_url = paramString;
    m_params = paramHttpParameterMap;
    m_sdk = paramTrustDefenderMobile;
    m_context = paramContext;
  }
  
  public void abort()
  {
    m_connection.abort();
  }
  
  public int getHttpStatusCode()
  {
    return m_connection.getHttpStatusCode();
  }
  
  public THMStatusCode getStatusCode()
  {
    return m_connection.getStatus();
  }
  
  public void run()
  {
    long l2 = System.nanoTime();
    Log.d(TAG, "starting retrieval: " + m_url);
    long l1 = -1L;
    if ((m_type == HttpRunnerType.GET) || (m_type == HttpRunnerType.GET_CONSUME)) {}
    label255:
    do
    {
      for (;;)
      {
        try
        {
          l1 = m_connection.get(m_url + "?" + m_params.getUrlEncodedParamString());
          l2 = (System.nanoTime() - l2) / 1000000L;
          if (l1 >= 0L) {
            break;
          }
          Log.w(TAG, "failed to retrieve from " + m_connection.getHost() + " with " + m_connection.getStatus().toString() + " in " + l2 + "ms");
          if (m_sdk != null) {
            m_sdk.setStatus(m_connection.getStatus());
          }
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          if (m_state == null) {
            break label255;
          }
        }
        if (m_state.isCancelled()) {
          Log.d(TAG, "interrupted due to cancel");
        }
        while (m_sdk != null)
        {
          m_sdk.setStatus(THMStatusCode.THM_Interrupted_Error);
          return;
          Log.e(TAG, "interrupted, aborting connection", localInterruptedException);
        }
        continue;
        if ((m_type == HttpRunnerType.POST) || (m_type == HttpRunnerType.POST_CONSUME)) {
          l1 = m_connection.post(m_url, m_params);
        }
      }
      Log.d(TAG, "retrieved: " + m_connection.getURL() + " in " + l2 + "ms");
      if (l1 != 200L)
      {
        Log.w(TAG, "error (" + l1 + ") status on request to " + m_connection.getHost());
        return;
      }
    } while ((m_type != HttpRunnerType.GET_CONSUME) && (m_type != HttpRunnerType.POST_CONSUME));
    Log.d(TAG, "consuming content");
    m_connection.consumeContentAndClose();
  }
  
  static enum HttpRunnerType
  {
    GET,  GET_CONSUME,  POST,  POST_CONSUME;
    
    private HttpRunnerType() {}
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.HttpRunner
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */