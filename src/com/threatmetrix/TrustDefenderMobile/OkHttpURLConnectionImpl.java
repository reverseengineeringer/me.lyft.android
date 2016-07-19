package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;

class OkHttpURLConnectionImpl
  implements TDURLConnection
{
  private static final String TAG = StringUtils.getLogTag(OkHttpURLConnectionImpl.class);
  private Call m_call = null;
  private OkHttpClient m_client = null;
  private OkHttpClientImpl m_clientWrapper = null;
  private Map<String, String> m_headers = new HashMap();
  private Request m_request = null;
  private Response m_response = null;
  private CancelState m_state;
  private THMStatusCode m_status = THMStatusCode.THM_NotYet;
  
  OkHttpURLConnectionImpl(OkHttpClientImpl paramOkHttpClientImpl, CancelState paramCancelState)
  {
    m_state = paramCancelState;
    m_clientWrapper = paramOkHttpClientImpl;
    m_client = paramOkHttpClientImpl.getClient();
  }
  
  private void go(String paramString, HttpParameterMap paramHttpParameterMap)
  {
    Request.Builder localBuilder = new Request.Builder().url(paramString);
    m_headers.put("User-Agent", m_clientWrapper.getUserAgent());
    paramString = m_headers.entrySet().iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (Map.Entry)paramString.next();
      if (((Map.Entry)localObject).getValue() == null) {
        Log.d(TAG, "null value for " + (String)((Map.Entry)localObject).getKey());
      } else {
        localBuilder.addHeader((String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
      }
    }
    if (paramHttpParameterMap != null)
    {
      FormEncodingBuilder localFormEncodingBuilder = new FormEncodingBuilder();
      Iterator localIterator = paramHttpParameterMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject = (String)paramHttpParameterMap.get(str);
        if ((localObject != null) && (!((String)localObject).isEmpty()))
        {
          Integer localInteger = paramHttpParameterMap.getKeySpecificLength(str);
          paramString = (String)localObject;
          if (localInteger != null)
          {
            paramString = (String)localObject;
            if (((String)localObject).length() > localInteger.intValue()) {
              paramString = ((String)localObject).substring(0, localInteger.intValue());
            }
          }
          localObject = paramString;
          if (localInteger == null)
          {
            localObject = paramString;
            if (paramHttpParameterMap.getPostValueLengthLimit() != 0)
            {
              localObject = paramString;
              if (paramString.length() > paramHttpParameterMap.getPostValueLengthLimit()) {
                localObject = paramString.substring(0, paramHttpParameterMap.getPostValueLengthLimit());
              }
            }
          }
          localFormEncodingBuilder.add(str, (String)localObject);
        }
      }
      localBuilder.post(localFormEncodingBuilder.build());
    }
    try
    {
      m_request = localBuilder.build();
      return;
    }
    finally
    {
      try
      {
        m_call = m_client.newCall(m_request);
        m_response = m_call.execute();
        m_status = THMStatusCode.THM_OK;
        return;
      }
      catch (IOException paramString)
      {
        if (!(paramString.getCause() instanceof CertificateException)) {
          break label411;
        }
        m_status = THMStatusCode.THM_HostVerification_Error;
        while ((m_state != null) && (m_state.isCancelled()))
        {
          Log.d(TAG, "Connection interrupted due to cancel!");
          abort();
          return;
          if ((paramString instanceof SSLPeerUnverifiedException)) {
            m_status = THMStatusCode.THM_HostVerification_Error;
          } else if ((paramString instanceof UnknownHostException)) {
            m_status = THMStatusCode.THM_HostNotFound_Error;
          } else if ((paramString instanceof SocketTimeoutException)) {
            m_status = THMStatusCode.THM_NetworkTimeout_Error;
          } else if (m_status == THMStatusCode.THM_NotYet) {
            m_status = THMStatusCode.THM_Connection_Error;
          }
        }
        Log.e(TAG, "Failed to retrieve URI", paramString);
        return;
      }
      catch (RuntimeException paramString)
      {
        Log.e(TAG, "Caught runtime exception:", paramString);
        m_status = THMStatusCode.THM_Connection_Error;
      }
      paramString = finally;
    }
  }
  
  public void abort()
  {
    if (m_call != null) {
      m_call.cancel();
    }
  }
  
  public void addHeaders(Map<String, String> paramMap)
  {
    m_headers.putAll(paramMap);
  }
  
  public void consumeContentAndClose()
  {
    if (m_response != null) {}
    try
    {
      m_response.body().close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.e(TAG, "Failed to close response body", localIOException);
    }
  }
  
  public long get(String paramString)
  {
    go(paramString, null);
    if ((m_response == null) || (m_status != THMStatusCode.THM_OK)) {
      return -1L;
    }
    return m_response.code();
  }
  
  public String getHost()
  {
    if (m_request != null) {
      return m_request.url().getHost();
    }
    return null;
  }
  
  public int getHttpStatusCode()
  {
    if (m_response != null) {
      return m_response.code();
    }
    return -1;
  }
  
  public InputStream getResponseStream()
    throws IOException
  {
    if (m_response == null) {
      return null;
    }
    return m_response.body().byteStream();
  }
  
  public THMStatusCode getStatus()
  {
    return m_status;
  }
  
  public String getURL()
  {
    if (m_request != null) {
      return m_request.url().toString();
    }
    return null;
  }
  
  public long post(String paramString, HttpParameterMap paramHttpParameterMap)
  {
    go(paramString, paramHttpParameterMap);
    if ((m_response == null) || (m_status != THMStatusCode.THM_OK)) {
      return -1L;
    }
    return m_response.code();
  }
}

/* Location:
 * Qualified Name:     com.threatmetrix.TrustDefenderMobile.OkHttpURLConnectionImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */