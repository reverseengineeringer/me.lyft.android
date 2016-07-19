package com.crashlytics.android.answers;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

class AnswersEventsHandler$1
  implements Runnable
{
  AnswersEventsHandler$1(AnswersEventsHandler paramAnswersEventsHandler, AnalyticsSettingsData paramAnalyticsSettingsData, String paramString) {}
  
  public void run()
  {
    try
    {
      this$0.strategy.setAnalyticsSettingsData(val$analyticsSettingsData, val$protocolAndHostOverride);
      return;
    }
    catch (Exception localException)
    {
      Fabric.getLogger().e("Answers", "Failed to set analytics settings data", localException);
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */