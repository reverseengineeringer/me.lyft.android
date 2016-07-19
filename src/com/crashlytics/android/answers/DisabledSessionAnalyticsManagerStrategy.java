package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;

class DisabledSessionAnalyticsManagerStrategy
  implements SessionAnalyticsManagerStrategy
{
  public void cancelTimeBasedFileRollOver() {}
  
  public void deleteAllEvents() {}
  
  public void processEvent(SessionEvent.Builder paramBuilder) {}
  
  public boolean rollFileOver()
    throws IOException
  {
    return false;
  }
  
  public void sendEvents() {}
  
  public void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString) {}
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.DisabledSessionAnalyticsManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */