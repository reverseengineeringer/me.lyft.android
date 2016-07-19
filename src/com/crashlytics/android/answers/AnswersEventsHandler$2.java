package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AnswersEventsHandler$2
  implements Runnable
{
  AnswersEventsHandler$2(AnswersEventsHandler paramAnswersEventsHandler) {}
  
  public void run()
  {
    try
    {
      SessionAnalyticsManagerStrategy localSessionAnalyticsManagerStrategy = this$0.strategy;
      this$0.strategy = new DisabledSessionAnalyticsManagerStrategy();
      localSessionAnalyticsManagerStrategy.deleteAllEvents();
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to disable events", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */