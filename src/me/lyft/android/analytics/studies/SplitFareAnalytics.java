package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.definitions.Category;

public class SplitFareAnalytics
{
  private static final String ACCEPT_SPLIT = "accept";
  private static final String DECLINE_SPLIT = "decline";
  private ActionAnalytics respondToSplitRequestAnalytics;
  private ActionAnalytics splitFareAnalytics;
  private ActionAnalytics splitRequestAnalytics;
  
  public void trackOpenSplitScreen()
  {
    splitFareAnalytics = ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SPLIT_INITIATED).setTag(Category.SPLIT_FARE.toString()).trackInitiation());
  }
  
  public void trackReceiveSplitRequest()
  {
    new ActionAnalytics(ActionEvent.Action.SPLIT_REQUEST_RECEIVED).setTag(Category.SPLIT_FARE.toString()).trackInitiation().trackSuccess();
  }
  
  public void trackSendSplitRequest(int paramInt)
  {
    splitRequestAnalytics = ((ActionAnalytics)new ActionAnalytics(ActionEvent.Action.SPLIT_REQUEST_SENT).setTag(Category.SPLIT_FARE.toString()).setValue(paramInt).trackInitiation());
  }
  
  public void trackSendSplitRequestFailure(Throwable paramThrowable)
  {
    splitRequestAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackSendSplitRequestSuccess()
  {
    splitRequestAnalytics.trackSuccess();
  }
  
  public void trackSplitRequestResponse(boolean paramBoolean)
  {
    SpanningAnalytics localSpanningAnalytics = new ActionAnalytics(ActionEvent.Action.SPLIT_REQUEST_RESPONSE).setTag(Category.SPLIT_FARE.toString());
    if (paramBoolean) {}
    for (String str = "accept";; str = "decline")
    {
      respondToSplitRequestAnalytics = ((ActionAnalytics)localSpanningAnalytics.setParameter(str).trackInitiation());
      return;
    }
  }
  
  public void trackSplitResponseFailure(Throwable paramThrowable)
  {
    respondToSplitRequestAnalytics.trackFailure(paramThrowable);
  }
  
  public void trackSplitResponseSuccess()
  {
    respondToSplitRequestAnalytics.trackSuccess();
  }
  
  public void trackSplitScreenCancel(String paramString)
  {
    splitFareAnalytics.trackCanceled(paramString);
  }
  
  public void trackSplitScreenFinish()
  {
    splitFareAnalytics.trackSuccess();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.SplitFareAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */