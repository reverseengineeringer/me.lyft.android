package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.Analytics;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.ExperimentAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.definitions.Experiment;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.analytics.core.events.CoreEvent;
import me.lyft.android.analytics.core.events.IEvent.Priority;
import me.lyft.android.analytics.core.events.LifecycleEvent;
import me.lyft.android.analytics.core.events.LifecycleEvent.Type;

public class AppAnalytics
{
  public static void trackAppClose()
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.APP_CLOSE));
  }
  
  public static void trackAppCrash(Throwable paramThrowable)
  {
    Analytics.trackSync(new LifecycleEvent(LifecycleEvent.Type.APP_CRASH).setParameter(paramThrowable.getClass().getSimpleName()));
  }
  
  public static void trackAppError(String paramString1, String paramString2)
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.APP_ERROR).setTag(paramString1).setParameter(paramString2));
  }
  
  public static void trackAppInstall(long paramLong, String paramString)
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.APP_INSTALL).setOccurredAt(paramLong).setParameter(paramString));
  }
  
  public static void trackAppOpen(boolean paramBoolean)
  {
    LifecycleEvent localLifecycleEvent = new LifecycleEvent(LifecycleEvent.Type.APP_OPEN);
    if (paramBoolean) {}
    for (String str = "cold";; str = "warm")
    {
      Analytics.track(localLifecycleEvent.setParameter(str));
      ExperimentAnalytics.trackExposure(Experiment.AA);
      return;
    }
  }
  
  public static void trackAppVersionUpdateEvent()
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.APP_UPDATE));
  }
  
  public static void trackCompetitiveAppInstalled(String paramString1, String paramString2, boolean paramBoolean)
  {
    Analytics.track(new LifecycleEvent(LifecycleEvent.Type.COMPETITIVE_APP_INSTALLED).setTag(paramString1).setParameter(paramString2).setValue(paramBoolean));
  }
  
  public static ActionAnalytics trackHandleDeepLink(String paramString)
  {
    return (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.HANDLE_DEEPLINK).setPriority(IEvent.Priority.CRITICAL).setParameter(paramString).trackInitiation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.AppAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */