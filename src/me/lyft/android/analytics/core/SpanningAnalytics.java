package me.lyft.android.analytics.core;

import java.util.UUID;
import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.events.IEvent.Priority;
import me.lyft.android.analytics.core.events.SpanningEvent;
import me.lyft.android.analytics.core.events.SpanningEvent.Result;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.common.Strings;

public abstract class SpanningAnalytics
{
  private boolean isComplete;
  private String parameter;
  private IEvent.Priority priority = IEvent.Priority.NORMAL;
  private Float sampleRate;
  private Long startTime;
  private String tag;
  private String uuid;
  private Long value;
  
  protected abstract SpanningEvent createSpanningEvent(SpanningEvent.Type paramType, String paramString);
  
  public final String getId()
  {
    return uuid;
  }
  
  public final String getParameter()
  {
    return parameter;
  }
  
  public final String getTag()
  {
    return tag;
  }
  
  public final boolean isComplete()
  {
    return isComplete;
  }
  
  protected void mapBaseProperties(SpanningEvent paramSpanningEvent)
  {
    if (!Strings.isNullOrEmpty(tag)) {
      paramSpanningEvent.setTag(tag);
    }
    if (!Strings.isNullOrEmpty(parameter)) {
      paramSpanningEvent.setParameter(parameter);
    }
    if (value != null) {
      paramSpanningEvent.setValue(value.longValue());
    }
    if (sampleRate != null) {
      paramSpanningEvent.setSampleRate(sampleRate.floatValue());
    }
  }
  
  public final <T extends SpanningAnalytics> T setParameter(String paramString)
  {
    parameter = paramString;
    return this;
  }
  
  public final <T extends SpanningAnalytics> T setPriority(IEvent.Priority paramPriority)
  {
    priority = paramPriority;
    return this;
  }
  
  public final <T extends SpanningAnalytics> T setSampleRate(float paramFloat)
  {
    sampleRate = Float.valueOf(paramFloat);
    return this;
  }
  
  public final <T extends SpanningAnalytics> T setTag(String paramString)
  {
    tag = paramString;
    return this;
  }
  
  public final <T extends SpanningAnalytics> T setValue(long paramLong)
  {
    value = Long.valueOf(paramLong);
    return this;
  }
  
  public final void trackAborted()
  {
    trackResult(SpanningEvent.Result.ABORTED);
  }
  
  public final void trackCanceled()
  {
    trackResult(SpanningEvent.Result.CANCELED);
  }
  
  public final void trackFailure()
  {
    trackResult(SpanningEvent.Result.FAILURE);
  }
  
  public final <T extends SpanningAnalytics> T trackInitiation()
  {
    uuid = UUID.randomUUID().toString();
    startTime = Long.valueOf(DeviceClock.getElapsedTimeMs());
    SpanningEvent localSpanningEvent = createSpanningEvent(SpanningEvent.Type.INITIATION, uuid);
    mapBaseProperties(localSpanningEvent);
    Analytics.track(localSpanningEvent);
    return this;
  }
  
  public final void trackProhibited()
  {
    trackResult(SpanningEvent.Result.PROHIBITED);
  }
  
  protected void trackResult(SpanningEvent.Result paramResult)
  {
    SpanningEvent localSpanningEvent = createSpanningEvent(SpanningEvent.Type.RESULT, uuid);
    localSpanningEvent.setResult(paramResult);
    mapBaseProperties(localSpanningEvent);
    localSpanningEvent.setPriority(priority);
    if (startTime != null)
    {
      localSpanningEvent.setDurationMs((int)(DeviceClock.getElapsedTimeMs() - startTime.longValue()));
      startTime = null;
    }
    isComplete = true;
    Analytics.track(localSpanningEvent);
  }
  
  public final void trackSuccess()
  {
    trackResult(SpanningEvent.Result.SUCCESS);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.SpanningAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */