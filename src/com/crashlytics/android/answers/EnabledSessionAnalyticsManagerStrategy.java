package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ApiKey;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.events.FilesSender;
import io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class EnabledSessionAnalyticsManagerStrategy
  implements SessionAnalyticsManagerStrategy
{
  ApiKey apiKey = new ApiKey();
  private final Context context;
  boolean customEventsEnabled = true;
  EventFilter eventFilter = new KeepAllEventFilter();
  private final ScheduledExecutorService executorService;
  private final SessionAnalyticsFilesManager filesManager;
  FilesSender filesSender;
  private final HttpRequestFactory httpRequestFactory;
  private final Kit kit;
  final SessionEventMetadata metadata;
  boolean predefinedEventsEnabled = true;
  private final AtomicReference<ScheduledFuture<?>> rolloverFutureRef = new AtomicReference();
  volatile int rolloverIntervalSeconds = -1;
  
  public EnabledSessionAnalyticsManagerStrategy(Kit paramKit, Context paramContext, ScheduledExecutorService paramScheduledExecutorService, SessionAnalyticsFilesManager paramSessionAnalyticsFilesManager, HttpRequestFactory paramHttpRequestFactory, SessionEventMetadata paramSessionEventMetadata)
  {
    kit = paramKit;
    context = paramContext;
    executorService = paramScheduledExecutorService;
    filesManager = paramSessionAnalyticsFilesManager;
    httpRequestFactory = paramHttpRequestFactory;
    metadata = paramSessionEventMetadata;
  }
  
  public void cancelTimeBasedFileRollOver()
  {
    if (rolloverFutureRef.get() != null)
    {
      CommonUtils.logControlled(context, "Cancelling time-based rollover because no events are currently being generated.");
      ((ScheduledFuture)rolloverFutureRef.get()).cancel(false);
      rolloverFutureRef.set(null);
    }
  }
  
  public void deleteAllEvents()
  {
    filesManager.deleteAllEventsFiles();
  }
  
  public void processEvent(SessionEvent.Builder paramBuilder)
  {
    paramBuilder = paramBuilder.build(metadata);
    if ((!customEventsEnabled) && (SessionEvent.Type.CUSTOM.equals(type)))
    {
      Fabric.getLogger().d("Answers", "Custom events tracking disabled - skipping event: " + paramBuilder);
      return;
    }
    if ((!predefinedEventsEnabled) && (SessionEvent.Type.PREDEFINED.equals(type)))
    {
      Fabric.getLogger().d("Answers", "Predefined events tracking disabled - skipping event: " + paramBuilder);
      return;
    }
    if (eventFilter.skipEvent(paramBuilder))
    {
      Fabric.getLogger().d("Answers", "Skipping filtered event: " + paramBuilder);
      return;
    }
    try
    {
      filesManager.writeEvent(paramBuilder);
      scheduleTimeBasedRollOverIfNeeded();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Fabric.getLogger().e("Answers", "Failed to write event: " + paramBuilder, localIOException);
      }
    }
  }
  
  public boolean rollFileOver()
  {
    try
    {
      boolean bool = filesManager.rollFileOver();
      return bool;
    }
    catch (IOException localIOException)
    {
      CommonUtils.logControlledError(context, "Failed to roll file over.", localIOException);
    }
    return false;
  }
  
  void scheduleTimeBasedFileRollOver(long paramLong1, long paramLong2)
  {
    if (rolloverFutureRef.get() == null) {}
    for (int i = 1;; i = 0)
    {
      TimeBasedFileRollOverRunnable localTimeBasedFileRollOverRunnable;
      if (i != 0)
      {
        localTimeBasedFileRollOverRunnable = new TimeBasedFileRollOverRunnable(context, this);
        CommonUtils.logControlled(context, "Scheduling time based file roll over every " + paramLong2 + " seconds");
      }
      try
      {
        rolloverFutureRef.set(executorService.scheduleAtFixedRate(localTimeBasedFileRollOverRunnable, paramLong1, paramLong2, TimeUnit.SECONDS));
        return;
      }
      catch (RejectedExecutionException localRejectedExecutionException)
      {
        CommonUtils.logControlledError(context, "Failed to schedule time based file roll over", localRejectedExecutionException);
      }
    }
  }
  
  public void scheduleTimeBasedRollOverIfNeeded()
  {
    if (rolloverIntervalSeconds != -1) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        scheduleTimeBasedFileRollOver(rolloverIntervalSeconds, rolloverIntervalSeconds);
      }
      return;
    }
  }
  
  public void sendEvents()
  {
    if (filesSender == null)
    {
      CommonUtils.logControlled(context, "skipping files send because we don't yet know the target endpoint");
      return;
    }
    CommonUtils.logControlled(context, "Sending all files");
    int j = 0;
    List localList = filesManager.getBatchOfFilesToSend();
    for (;;)
    {
      k = j;
      i = j;
      try
      {
        if (localList.size() > 0)
        {
          i = j;
          CommonUtils.logControlled(context, String.format(Locale.US, "attempt to send batch of %d files", new Object[] { Integer.valueOf(localList.size()) }));
          i = j;
          boolean bool = filesSender.send(localList);
          k = j;
          if (bool)
          {
            i = j;
            k = j + localList.size();
            i = k;
            filesManager.deleteSentFiles(localList);
          }
          if (bool) {
            break label147;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          CommonUtils.logControlledError(context, "Failed to send batch of analytics files to server: " + localException.getMessage(), localException);
          k = i;
        }
      }
      if (k != 0) {
        break;
      }
      filesManager.deleteOldestInRollOverIfOverMax();
      return;
      label147:
      i = k;
      localList = filesManager.getBatchOfFilesToSend();
      j = k;
    }
  }
  
  public void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString)
  {
    filesSender = AnswersRetryFilesSender.build(new SessionAnalyticsFilesSender(kit, paramString, analyticsURL, httpRequestFactory, apiKey.getValue(context)));
    filesManager.setAnalyticsSettingsData(paramAnalyticsSettingsData);
    customEventsEnabled = trackCustomEvents;
    Logger localLogger = Fabric.getLogger();
    StringBuilder localStringBuilder = new StringBuilder().append("Custom event tracking ");
    if (customEventsEnabled)
    {
      paramString = "enabled";
      localLogger.d("Answers", paramString);
      predefinedEventsEnabled = trackPredefinedEvents;
      localLogger = Fabric.getLogger();
      localStringBuilder = new StringBuilder().append("Predefined event tracking ");
      if (!predefinedEventsEnabled) {
        break label218;
      }
    }
    label218:
    for (paramString = "enabled";; paramString = "disabled")
    {
      localLogger.d("Answers", paramString);
      if (samplingRate > 1)
      {
        Fabric.getLogger().d("Answers", "Event sampling enabled");
        eventFilter = new SamplingEventFilter(samplingRate);
      }
      rolloverIntervalSeconds = flushIntervalSeconds;
      scheduleTimeBasedFileRollOver(0L, rolloverIntervalSeconds);
      return;
      paramString = "disabled";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.EnabledSessionAnalyticsManagerStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */