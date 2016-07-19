package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

class SessionAnalyticsManager
  implements BackgroundManager.Listener
{
  final BackgroundManager backgroundManager;
  final AnswersEventsHandler eventsHandler;
  private final long installedAt;
  final ActivityLifecycleManager lifecycleManager;
  final AnswersPreferenceManager preferenceManager;
  
  SessionAnalyticsManager(AnswersEventsHandler paramAnswersEventsHandler, ActivityLifecycleManager paramActivityLifecycleManager, BackgroundManager paramBackgroundManager, AnswersPreferenceManager paramAnswersPreferenceManager, long paramLong)
  {
    eventsHandler = paramAnswersEventsHandler;
    lifecycleManager = paramActivityLifecycleManager;
    backgroundManager = paramBackgroundManager;
    preferenceManager = paramAnswersPreferenceManager;
    installedAt = paramLong;
  }
  
  public static SessionAnalyticsManager build(Kit paramKit, Context paramContext, IdManager paramIdManager, String paramString1, String paramString2, long paramLong)
  {
    paramIdManager = new SessionMetadataCollector(paramContext, paramIdManager, paramString1, paramString2);
    paramString1 = new AnswersFilesManagerProvider(paramContext, new FileStoreImpl(paramKit));
    paramString2 = new DefaultHttpRequestFactory(Fabric.getLogger());
    ActivityLifecycleManager localActivityLifecycleManager = new ActivityLifecycleManager(paramContext);
    ScheduledExecutorService localScheduledExecutorService = ExecutorUtils.buildSingleThreadScheduledExecutorService("Answers Events Handler");
    BackgroundManager localBackgroundManager = new BackgroundManager(localScheduledExecutorService);
    return new SessionAnalyticsManager(new AnswersEventsHandler(paramKit, paramContext, paramString1, paramIdManager, paramString2, localScheduledExecutorService), localActivityLifecycleManager, localBackgroundManager, AnswersPreferenceManager.build(paramContext), paramLong);
  }
  
  public void disable()
  {
    lifecycleManager.resetCallbacks();
    eventsHandler.disable();
  }
  
  public void enable()
  {
    eventsHandler.enable();
    lifecycleManager.registerCallbacks(new AnswersLifecycleCallbacks(this, backgroundManager));
    backgroundManager.registerListener(this);
    if (isFirstLaunch(installedAt))
    {
      onInstall();
      preferenceManager.setAnalyticsLaunched();
    }
  }
  
  boolean installedRecently(long paramLong)
  {
    return System.currentTimeMillis() - paramLong < 3600000L;
  }
  
  boolean isFirstLaunch(long paramLong)
  {
    return (!preferenceManager.hasAnalyticsLaunched()) && (installedRecently(paramLong));
  }
  
  public void onBackground()
  {
    Fabric.getLogger().d("Answers", "Flush events when app is backgrounded");
    eventsHandler.flushEvents();
  }
  
  public void onCrash(String paramString)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("onCrash called from main thread!!!");
    }
    Fabric.getLogger().d("Answers", "Logged crash");
    eventsHandler.processEventSync(SessionEvent.crashEventBuilder(paramString));
  }
  
  public void onError(String paramString) {}
  
  public void onInstall()
  {
    Fabric.getLogger().d("Answers", "Logged install");
    eventsHandler.processEventAsyncAndFlush(SessionEvent.installEventBuilder());
  }
  
  public void onLifecycle(Activity paramActivity, SessionEvent.Type paramType)
  {
    Fabric.getLogger().d("Answers", "Logged lifecycle event: " + paramType.name());
    eventsHandler.processEventAsync(SessionEvent.lifecycleEventBuilder(paramType, paramActivity));
  }
  
  public void setAnalyticsSettingsData(AnalyticsSettingsData paramAnalyticsSettingsData, String paramString)
  {
    backgroundManager.setFlushOnBackground(flushOnBackground);
    eventsHandler.setAnalyticsSettingsData(paramAnalyticsSettingsData, paramString);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionAnalyticsManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */