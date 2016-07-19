package me.lyft.android.analytics.core;

import me.lyft.android.analytics.core.events.ActionEvent;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.core.events.SpanningEvent;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.analytics.utils.AnalyticsUtils;
import me.lyft.android.common.Strings;

public class ActionAnalytics
  extends SpanningAnalytics
{
  private final String action;
  private String intentId;
  private String reason;
  
  public ActionAnalytics(ActionEvent.Action paramAction)
  {
    action = paramAction.toString();
  }
  
  protected ActionEvent createSpanningEvent(SpanningEvent.Type paramType, String paramString)
  {
    return new ActionEvent(paramType, ActionEvent.Action.fromString(action), paramString);
  }
  
  protected final void mapBaseProperties(SpanningEvent paramSpanningEvent)
  {
    super.mapBaseProperties(paramSpanningEvent);
    paramSpanningEvent = (ActionEvent)paramSpanningEvent;
    if (!Strings.isNullOrEmpty(reason)) {
      paramSpanningEvent.setReason(reason);
    }
    if (!Strings.isNullOrEmpty(intentId)) {
      paramSpanningEvent.setIntentId(intentId);
    }
  }
  
  public ActionAnalytics setIntentId(String paramString)
  {
    intentId = paramString;
    return this;
  }
  
  public ActionAnalytics setReason(String paramString)
  {
    reason = paramString;
    return this;
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
  
  public void trackFailure(Throwable paramThrowable)
  {
    reason = AnalyticsUtils.resolveReason(paramThrowable);
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
 * Qualified Name:     me.lyft.android.analytics.core.ActionAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */