package me.lyft.android.analytics;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.util.UUID;
import me.lyft.android.analytics.core.events.CallEvent;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.infrastructure.device.IDevice;

class NetworkAnalyticsInterceptor$NetworkAnalytics
{
  private String callId;
  private final IDevice device;
  private double samplingRate;
  private long startTime;
  
  NetworkAnalyticsInterceptor$NetworkAnalytics(IDevice paramIDevice)
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

/* Location:
 * Qualified Name:     me.lyft.android.analytics.NetworkAnalyticsInterceptor.NetworkAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */