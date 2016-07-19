package me.lyft.android.analytics;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import me.lyft.android.analytics.core.events.CallEvent;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.analytics.core.events.SpanningEvent.Result;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.application.constants.Constants;
import me.lyft.android.application.constants.IConstantsProvider;
import me.lyft.android.common.ExceptionUtils;
import me.lyft.android.common.Preconditions;
import me.lyft.android.infrastructure.device.IDevice;

public class NetworkAnalyticsInterceptor
  implements Interceptor
{
  private final IConstantsProvider constantsProvider;
  private final ThreadLocal<NetworkAnalytics> networkAnalyticsLocal;
  private Random random = new Random();
  
  public NetworkAnalyticsInterceptor(IConstantsProvider paramIConstantsProvider, final IDevice paramIDevice)
  {
    constantsProvider = paramIConstantsProvider;
    networkAnalyticsLocal = new ThreadLocal()
    {
      public NetworkAnalyticsInterceptor.NetworkAnalytics initialValue()
      {
        return new NetworkAnalyticsInterceptor.NetworkAnalytics(paramIDevice);
      }
    };
  }
  
  private Response interceptWithTracking(Interceptor.Chain paramChain)
    throws IOException
  {
    double d = ((Double)constantsProvider.get(Constants.NETWORK_ANALYTICS_SAMPLING_RATE)).doubleValue();
    NetworkAnalytics localNetworkAnalytics = (NetworkAnalytics)networkAnalyticsLocal.get();
    Request localRequest = paramChain.request();
    localNetworkAnalytics.trackRequest(localRequest, d);
    try
    {
      paramChain = paramChain.proceed(localRequest);
      localNetworkAnalytics.trackResponse(paramChain);
      return paramChain;
    }
    catch (Throwable paramChain)
    {
      localNetworkAnalytics.trackResponseFailure(localRequest, paramChain);
      throw paramChain;
    }
  }
  
  private Response interceptWithoutTracking(Interceptor.Chain paramChain)
    throws IOException
  {
    return paramChain.proceed(paramChain.request());
  }
  
  static void mapFailureInfo(Throwable paramThrowable, CallEvent paramCallEvent)
  {
    String str1 = paramThrowable.getClass().getSimpleName();
    String str2 = paramThrowable.getMessage();
    if (ExceptionUtils.isInterruptedException(paramThrowable))
    {
      paramCallEvent.setResult(SpanningEvent.Result.CANCELED);
      paramCallEvent.setErrorType("interrupted");
      paramCallEvent.setErrorMessage(String.format("%s: %s", new Object[] { str1, str2 }));
      return;
    }
    if (ExceptionUtils.isNetworkException(paramThrowable))
    {
      paramCallEvent.setResult(SpanningEvent.Result.FAILURE);
      paramCallEvent.setErrorType("network_failure");
      paramCallEvent.setErrorMessage(String.format("%s: %s", new Object[] { str1, str2 }));
      return;
    }
    paramCallEvent.setErrorType(str1);
    paramCallEvent.setErrorMessage(str2);
    paramCallEvent.setResult(SpanningEvent.Result.FAILURE);
  }
  
  static void mapRequestInfo(Request paramRequest, CallEvent paramCallEvent)
  {
    URL localURL = paramRequest.url();
    paramCallEvent.setMethod(paramRequest.method());
    paramCallEvent.setScheme(localURL.getProtocol());
    paramCallEvent.setAuthority(localURL.getAuthority());
    paramCallEvent.setHost(localURL.getHost());
    paramCallEvent.setQuery(localURL.getQuery());
    paramCallEvent.setPath(localURL.getPath());
  }
  
  static void mapResponseInfo(Response paramResponse, CallEvent paramCallEvent)
  {
    int i = paramResponse.code();
    paramCallEvent.setStatusCode(i);
    Object localObject;
    if (paramResponse.isSuccessful())
    {
      localObject = SpanningEvent.Result.SUCCESS;
      paramCallEvent.setResult((SpanningEvent.Result)localObject);
      localObject = paramResponse.protocol();
      if (Protocol.HTTP_2 != localObject) {
        break label125;
      }
      localObject = "http/2";
      label41:
      paramCallEvent.setProtocol((String)localObject);
      paramResponse = paramResponse.headers();
      localObject = paramResponse.names().iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      String str = (String)((Iterator)localObject).next();
      if (str.equalsIgnoreCase("server"))
      {
        paramCallEvent.setServer(paramResponse.get(str));
        continue;
        if (i >= 500)
        {
          localObject = SpanningEvent.Result.FAILURE;
          break;
        }
        localObject = SpanningEvent.Result.PROHIBITED;
        break;
        label125:
        localObject = ((Protocol)localObject).toString();
        break label41;
      }
      if (str.equalsIgnoreCase("x-envoy-upstream-service-time")) {
        paramCallEvent.setServiceMs(paramResponse.get(str));
      }
    }
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    try
    {
      if (trackThisInterception()) {
        return interceptWithTracking(paramChain);
      }
      paramChain = interceptWithoutTracking(paramChain);
      return paramChain;
    }
    catch (IOException paramChain)
    {
      throw paramChain;
    }
    catch (Exception paramChain)
    {
      throw new IOException("Intercepted exception", paramChain);
    }
  }
  
  void setRandom(Random paramRandom)
  {
    Preconditions.checkNotNull(paramRandom);
    random = paramRandom;
  }
  
  boolean trackThisInterception()
  {
    double d = Math.min(1.0D, Math.max(0.0D, ((Double)constantsProvider.get(Constants.NETWORK_ANALYTICS_SAMPLING_RATE)).doubleValue()));
    return random.nextDouble() < d;
  }
  
  static class NetworkAnalytics
  {
    private String callId;
    private final IDevice device;
    private double samplingRate;
    private long startTime;
    
    NetworkAnalytics(IDevice paramIDevice)
    {
      device = paramIDevice;
    }
    
    private void trackResult(CallEvent paramCallEvent, long paramLong1, long paramLong2)
    {
      paramCallEvent.setDurationMs((int)(paramLong2 - paramLong1));
      Analytics.track(paramCallEvent);
    }
    
    public void trackRequest(Request paramRequest, double paramDouble)
    {
      startTime = device.getElapsedRealtime();
      samplingRate = paramDouble;
      callId = UUID.randomUUID().toString();
      CallEvent localCallEvent = new CallEvent(SpanningEvent.Type.INITIATION, CallEvent.Call.HTTP_REQUEST, callId);
      localCallEvent.setSampleRate(paramDouble);
      NetworkAnalyticsInterceptor.mapRequestInfo(paramRequest, localCallEvent);
      Analytics.track(localCallEvent);
    }
    
    public void trackResponse(Response paramResponse)
    {
      long l = device.getElapsedRealtime();
      CallEvent localCallEvent = new CallEvent(SpanningEvent.Type.RESULT, CallEvent.Call.HTTP_REQUEST, callId);
      localCallEvent.setSampleRate(samplingRate);
      NetworkAnalyticsInterceptor.mapRequestInfo(paramResponse.request(), localCallEvent);
      NetworkAnalyticsInterceptor.mapResponseInfo(paramResponse, localCallEvent);
      trackResult(localCallEvent, startTime, l);
    }
    
    public void trackResponseFailure(Request paramRequest, Throwable paramThrowable)
    {
      long l = device.getElapsedRealtime();
      CallEvent localCallEvent = new CallEvent(SpanningEvent.Type.RESULT, CallEvent.Call.HTTP_REQUEST, callId);
      localCallEvent.setSampleRate(samplingRate);
      NetworkAnalyticsInterceptor.mapRequestInfo(paramRequest, localCallEvent);
      NetworkAnalyticsInterceptor.mapFailureInfo(paramThrowable, localCallEvent);
      trackResult(localCallEvent, startTime, l);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.NetworkAnalyticsInterceptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */