package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.events.EventsStorageListener;
import io.fabric.sdk.android.services.network.HttpRequestFactory;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

class AnswersEventsHandler
  implements EventsStorageListener
{
  private final Context context;
  final ScheduledExecutorService executor;
  private final AnswersFilesManagerProvider filesManagerProvider;
  private final Kit kit;
  private final SessionMetadataCollector metadataCollector;
  private final HttpRequestFactory requestFactory;
  SessionAnalyticsManagerStrategy strategy = new DisabledSessionAnalyticsManagerStrategy();
  
  public AnswersEventsHandler(Kit paramKit, Context paramContext, AnswersFilesManagerProvider paramAnswersFilesManagerProvider, SessionMetadataCollector paramSessionMetadataCollector, HttpRequestFactory paramHttpRequestFactory, ScheduledExecutorService paramScheduledExecutorService)
  {
    kit = paramKit;
    context = paramContext;
    filesManagerProvider = paramAnswersFilesManagerProvider;
    metadataCollector = paramSessionMetadataCollector;
    requestFactory = paramHttpRequestFactory;
    executor = paramScheduledExecutorService;
  }
  
  private void executeAsync(Runnable paramRunnable)
  {
    try
    {
      executor.submit(paramRunnable);
      return;
    }
    catch (Exception paramRunnable)
    {
      Fabric.getLogger().e("Answers", "Failed to submit events task", paramRunnable);
    }
  }
  
  private void executeSync(Runnable paramRunnable)
  {
    try
    {
      executor.submit(paramRunnable).get();
      return;
    }
    catch (Exception paramRunnable)
    {
      Fabric.getLogger().e("Answers", "Failed to run events task", paramRunnable);
    }
  }
  
  public void disable()
  {
    executeAsync(new Runnable()
    {
      public void run()
      {
        try
        {
          SessionAnalyticsManagerStrategy localSessionAnalyticsManagerStrategy = strategy;
          strategy = new DisabledSessionAnalyticsManagerStrategy();
          localSessionAnalyticsManagerStrategy.deleteAllEvents();
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to disable events", localException);
        }
      }
    });
  }
  
  public void enable()
  {
    executeAsync(new Runnable()
    {
      public void run()
      {
        try
        {
          SessionEventMetadata localSessionEventMetadata = metadataCollector.getMetadata();
          SessionAnalyticsFilesManager localSessionAnalyticsFilesManager = filesManagerProvider.getAnalyticsFilesManager();
          localSessionAnalyticsFilesManager.registerRollOverListener(AnswersEventsHandler.this);
          strategy = new EnabledSessionAnalyticsManagerStrategy(kit, context, executor, localSessionAnalyticsFilesManager, requestFactory, localSessionEventMetadata);
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to enable events", localException);
        }
      }
    });
  }
  
  public void flushEvents()
  {
    executeAsync(new Runnable()
    {
      public void run()
      {
        try
        {
          strategy.rollFileOver();
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to flush events", localException);
        }
      }
    });
  }
  
  public void onRollOver(String paramString)
  {
    executeAsync(new Runnable()
    {
      public void run()
      {
        try
        {
          strategy.sendEvents();
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to send events files", localException);
        }
      }
    });
  }
  
  void processEvent(final SessionEvent.Builder paramBuilder, boolean paramBoolean1, final boolean paramBoolean2)
  {
    paramBuilder = new Runnable()
    {
      public void run()
      {
        try
        {
          strategy.processEvent(paramBuilder);
          if (paramBoolean2) {
            strategy.rollFileOver();
          }
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to process event", localException);
        }
      }
    };
    if (paramBoolean1)
    {
      executeSync(paramBuilder);
      return;
    }
    executeAsync(paramBuilder);
  }
  
  public void processEventAsync(SessionEvent.Builder paramBuilder)
  {
    processEvent(paramBuilder, false, false);
  }
  
  public void processEventAsyncAndFlush(SessionEvent.Builder paramBuilder)
  {
    processEvent(paramBuilder, false, true);
  }
  
  public void processEventSync(SessionEvent.Builder paramBuilder)
  {
    processEvent(paramBuilder, true, false);
  }
  
  public void setAnalyticsSettingsData(final AnalyticsSettingsData paramAnalyticsSettingsData, final String paramString)
  {
    executeAsync(new Runnable()
    {
      public void run()
      {
        try
        {
          strategy.setAnalyticsSettingsData(paramAnalyticsSettingsData, paramString);
          return;
        }
        catch (Exception localException)
        {
          Fabric.getLogger().e("Answers", "Failed to set analytics settings data", localException);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersEventsHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */