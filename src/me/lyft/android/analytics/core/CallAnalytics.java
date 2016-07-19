package me.lyft.android.analytics.core;

import me.lyft.android.analytics.core.events.CallEvent;
import me.lyft.android.analytics.core.events.CallEvent.Call;
import me.lyft.android.analytics.core.events.SpanningEvent;
import me.lyft.android.analytics.core.events.SpanningEvent.Result;
import me.lyft.android.analytics.core.events.SpanningEvent.Type;
import me.lyft.android.common.Strings;

public class CallAnalytics
  extends SpanningAnalytics
{
  private final String call;
  private String errorMessage;
  private String errorType;
  
  public CallAnalytics(CallEvent.Call paramCall)
  {
    call = paramCall.toString();
  }
  
  protected CallEvent createSpanningEvent(SpanningEvent.Type paramType, String paramString)
  {
    return new CallEvent(paramType, CallEvent.Call.fromString(call), paramString);
  }
  
  protected final void mapBaseProperties(SpanningEvent paramSpanningEvent)
  {
    super.mapBaseProperties(paramSpanningEvent);
    paramSpanningEvent = (CallEvent)paramSpanningEvent;
    if (!Strings.isNullOrEmpty(errorType)) {
      paramSpanningEvent.setErrorType(errorType);
    }
    if (!Strings.isNullOrEmpty(errorMessage)) {
      paramSpanningEvent.setErrorMessage(errorMessage);
    }
  }
  
  public void trackFailure(String paramString)
  {
    errorMessage = paramString;
    trackResult(SpanningEvent.Result.FAILURE);
  }
  
  public void trackFailure(Throwable paramThrowable)
  {
    errorType = paramThrowable.getClass().getSimpleName();
    errorMessage = paramThrowable.getMessage();
    trackResult(SpanningEvent.Result.FAILURE);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.CallAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */