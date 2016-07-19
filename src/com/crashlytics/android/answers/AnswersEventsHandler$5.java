package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AnswersEventsHandler$5
  implements Runnable
{
  AnswersEventsHandler$5(AnswersEventsHandler paramAnswersEventsHandler) {}
  
  public void run()
  {
    try
    {
      this$0.strategy.rollFileOver();
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to flush events", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */