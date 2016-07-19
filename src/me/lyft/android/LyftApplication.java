package me.lyft.android;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import com.crashlytics.android.Crashlytics;
import com.lyft.scoop.Scoop;
import dagger.ObjectGraph;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import javax.inject.Inject;
import me.lyft.android.analytics.studies.AppAnalytics;
import me.lyft.android.analytics.studies.AppLaunchAnalytics;
import me.lyft.android.analytics.trackers.IAnalyticsService;
import me.lyft.android.application.ILogoutService;
import me.lyft.android.common.AndroidClock;
import me.lyft.android.common.DeviceClock;
import me.lyft.android.development.IDeveloperTools;
import me.lyft.android.infrastructure.device.IDevice;
import me.lyft.android.jobs.InitFacebookSdkJob;
import me.lyft.android.jobs.JobManager;
import me.lyft.android.logging.AppStartLogger;
import me.lyft.android.logging.L;

public class LyftApplication
  extends MultiDexApplication
{
  @Inject
  IAnalyticsService analyticsService;
  private ObjectGraph applicationGraph;
  @Inject
  IDeveloperTools developerTools;
  @Inject
  IDevice device;
  @Inject
  JobManager jobManager;
  @Inject
  ILogoutService logoutService;
  @Inject
  ILyftPreferences preferences;
  
  static
  {
    System.setProperty("rx.ring-buffer.size", "128");
    System.setProperty("rx.indexed-ring-buffer.size", "256");
    DeviceClock.setDeviceClock(new AndroidClock());
  }
  
  public static LyftApplication from(Context paramContext)
  {
    return (LyftApplication)paramContext.getApplicationContext();
  }
  
  private void initUncaughtExceptionHandler()
  {
    Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
    {
      public void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
      {
        AppAnalytics.trackAppCrash(paramAnonymousThrowable);
        logoutService.resetCachedState();
        L.w(paramAnonymousThrowable, "Uncaught exception on thread %s, crashing.", new Object[] { paramAnonymousThread });
        val$crashlyticsErrorHandler.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
      }
    });
  }
  
  private void updateInstallStatus()
  {
    if (preferences.getAppVersionCode() == null)
    {
      preferences.setInstallStatus(1);
      preferences.setAppVersionCode(Integer.valueOf(device.getApplicationVersionCode()));
      return;
    }
    if (device.getApplicationVersionCode() > preferences.getAppVersionCode().intValue())
    {
      preferences.setAppVersionCode(Integer.valueOf(device.getApplicationVersionCode()));
      preferences.setInstallStatus(2);
      logoutService.resetCachedState();
      AppAnalytics.trackAppVersionUpdateEvent();
      return;
    }
    preferences.setInstallStatus(0);
  }
  
  public ObjectGraph getApplicationGraph()
  {
    return applicationGraph;
  }
  
  protected Object[] getModules()
  {
    return new Object[] { new AppModule(this) };
  }
  
  public void inject(Object paramObject)
  {
    applicationGraph.inject(paramObject);
  }
  
  public void onCreate()
  {
    super.onCreate();
    AppStartLogger.log("Application onCreate start");
    Fabric.with(this, new Kit[] { new Crashlytics() });
    initUncaughtExceptionHandler();
    AppLaunchAnalytics.onCreateApplication();
    Scoop.setViewBinder(new ButterKnifeViewBinder());
    applicationGraph = ObjectGraph.create(getModules());
    applicationGraph.inject(this);
    applicationGraph.injectStatics();
    developerTools.initDeveloperTools();
    analyticsService.onApplicationCreate();
    jobManager.queueBackgroundJob(new InitFacebookSdkJob());
    updateInstallStatus();
    AppStartLogger.log("Application onCreate finish");
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    L.d("onLowMemory", new Object[0]);
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    L.d("onTerminate", new Object[0]);
  }
  
  public void onTrimMemory(int paramInt)
  {
    super.onTrimMemory(paramInt);
    L.d("onTrimMemory:" + paramInt, new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.LyftApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */