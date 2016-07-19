package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;

class AnswersEventsHandler$3
  implements Runnable
{
  AnswersEventsHandler$3(AnswersEventsHandler paramAnswersEventsHandler) {}
  
  public void run()
  {
    try
    {
      this$0.strategy.sendEvents();
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to send events files", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */