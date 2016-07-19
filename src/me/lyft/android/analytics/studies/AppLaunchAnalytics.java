package me.lyft.android.analytics.studies;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.common.DeviceClock;

public class AppLaunchAnalytics
{
  private static final ActionAnalytics APP_LAUNCH_ANALYTICS = new ActionAnalytics(ActionEvent.Action.APP_LAUNCH);
  private static final long TIMER_STOPPED = 0L;
  private static long applicationCreateTime = 0L;
  
  public static void onCreateApplication()
  {
    applicationCreateTime = DeviceClock.getElapsedTimeMs();
  }
  
  public static void onCreateMainActivity()
  {
    if (applicationCreateTime != 0L)
    {
      long l1 = DeviceClock.getElapsedTimeMs();
      long l2 = applicationCreateTime;
      APP_LAUNCH_ANALYTICS.setValue(l1 - l2).trackInitiation();
    }
  }
  
  public static void onLoadingAnimationComplete()
  {
    if (applicationCreateTime != 0L)
    {
      long l1 = DeviceClock.getElapsedTimeMs();
      long l2 = applicationCreateTime;
      APP_LAUNCH_ANALYTICS.setValue(l1 - l2).trackSuccess();
      applicationCreateTime = 0L;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.studies.AppLaunchAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */