package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.UUID;

class SessionAnalyticsFilesManager
  extends EventsFilesManager<SessionEvent>
{
  private AnalyticsSettingsData analyticsSettingsData;
  
  SessionAnalyticsFilesManager(Context paramContext, SessionEventTransform paramSessionEventTransform, CurrentTimeProvider paramCurrentTimeProvider, EventsStorage paramEventsStorage)
    throws IOException
  {
    super(paramContext, paramSessionEventTransform, paramCurrentTimeProvider, paramEventsStorage, 100);
  }
  
  protected String generateUniqueRollOverFileName()
  {
    UUID localUUID = UUID.randomUUID();
    return "sa" + "_" + localUUID.toString() + "_" + currentTimeProvider.getCurrentTimeMillis() + ".tap";
  }
  
  protected int getMaxByteSizePerFile()
  {
    if (analyticsSettingsData == null) {
      return super.getMaxByteSizePerFile();
    }
    return analyticsSettingsData.maxByteSizePerFile;
  }
  
  protected int getMaxFilesToKeep()
  {
    if (analyticsSettingsData == null) {
      return super.getMaxFilesToKeep();
    }
    return analyticsSettingsData.maxPendingSendFileCount;
  }
  
  void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData)
  {
    analyticsSettingsData = paramAnalyticsSettingsData;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionAnalyticsFilesManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */