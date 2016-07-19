package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AnswersEventsHandler$6
  implements Runnable
{
  AnswersEventsHandler$6(AnswersEventsHandler paramAnswersEventsHandler, SessionEvent.Builder paramBuilder, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      this$0.strategy.processEvent(val$eventBuilder);
      if (val$flush) {
        this$0.strategy.rollFileOver();
      }
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to process event", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */