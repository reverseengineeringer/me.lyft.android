package com.crashlytics.android.answers;

import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.events.GZIPQueueFileEventStorage;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

class AnswersFilesManagerProvider
{
  final Context context;
  final FileStore fileStore;
  
  public AnswersFilesManagerProvider(Context paramContext, FileStore paramFileStore)
  {
    context = paramContext;
    fileStore = paramFileStore;
  }
  
  public SessionAnalyticsFilesManager getAnalyticsFilesManager()
    throws IOException
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("AnswersFilesManagerProvider cannot be called on the main thread");
    }
    SessionEventTransform localSessionEventTransform = new SessionEventTransform();
    SystemCurrentTimeProvider localSystemCurrentTimeProvider = new SystemCurrentTimeProvider();
    Object localObject = fileStore.getFilesDir();
    localObject = new GZIPQueueFileEventStorage(context, (File)localObject, "session_analytics.tap", "session_analytics_to_send");
    return new SessionAnalyticsFilesManager(context, localSessionEventTransform, localSystemCurrentTimeProvider, (EventsStorage)localObject);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersFilesManagerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */