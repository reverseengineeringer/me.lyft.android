package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AnswersEventsHandler$4
  implements Runnable
{
  AnswersEventsHandler$4(AnswersEventsHandler paramAnswersEventsHandler) {}
  
  public void run()
  {
    try
    {
      SessionEventMetadata localSessionEventMetadata = AnswersEventsHandler.access$000(this$0).getMetadata();
      SessionAnalyticsFilesManager localSessionAnalyticsFilesManager = AnswersEventsHandler.access$100(this$0).getAnalyticsFilesManager();
      localSessionAnalyticsFilesManager.registerRollOverListener(this$0);
      this$0.strategy = new EnabledSessionAnalyticsManagerStrategy(AnswersEventsHandler.access$200(this$0), AnswersEventsHandler.access$300(this$0), this$0.executor, localSessionAnalyticsFilesManager, AnswersEventsHandler.access$400(this$0), localSessionEventMetadata);
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to enable events", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */