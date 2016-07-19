package me.lyft.android.analytics.core;

import me.lyft.android.analytics.core.events.IntentEvent;
import me.lyft.android.analytics.core.events.IntentEvent.Intent;
import me.lyft.android.analytics.core.events.SpanningEvent;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.common.Strings;

public class IntentAnalytics
  extends SpanningAnalytics
{
  private final String intent;
  private String reason;
  
  public IntentAnalytics(IntentEvent.Intent paramIntent)
  {
    intent = paramIntent.toString();
  }
  
  protected IntentEvent createSpanningEvent(SpanningEvent.Type paramType, String paramString)
  {
    return new IntentEvent(paramType, IntentEvent.Intent.fromString(intent), paramString);
  }
  
  protected final void mapBaseProperties(SpanningEvent paramSpanningEvent)
  {
    super.mapBaseProperties(paramSpanningEvent);
    paramSpanningEvent = (IntentEvent)paramSpanningEvent;
    if (!Strings.isNullOrEmpty(reason)) {
      paramSpanningEvent.setReason(reason);
    }
  }
  
  public void trackCanceled(String paramString)
  {
    reason = paramString;
    super.trackCanceled();
  }
  
  public void trackFailure(String paramString)
  {
    reason = paramString;
    super.trackFailure();
  }
  
  public void trackProhibited(String paramString)
  {
    reason = paramString;
    super.trackProhibited();
  }
  
  public void trackSuccess(String paramString)
  {
    reason = paramString;
    super.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.IntentAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */