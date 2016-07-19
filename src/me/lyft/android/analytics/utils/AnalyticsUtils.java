package me.lyft.android.analytics.utils;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.common.ExceptionUtils;
import me.lyft.android.common.IHasReason;
import rx.Notification;

public class AnalyticsUtils
{
  public static String resolveReason(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IHasReason)) {
      return ((IHasReason)paramThrowable).getReason();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (ExceptionUtils.isInterruptedException(paramThrowable)) {
      localStringBuilder.append("interrupted: ");
    }
    for (;;)
    {
      localStringBuilder.append(String.format("%s: %s", new Object[] { paramThrowable.getClass().getSimpleName(), paramThrowable.getMessage() }));
      return localStringBuilder.toString();
      if (ExceptionUtils.isNetworkException(paramThrowable)) {
        localStringBuilder.append("network_failure: ");
      }
    }
  }
  
  public static <T> void trackResult(ActionAnalytics paramActionAnalytics, Notification<? extends T> paramNotification)
  {
    if (!paramActionAnalytics.isComplete()) {}
    switch (paramNotification.getKind())
    {
    default: 
      return;
    case ???: 
      paramActionAnalytics.trackSuccess();
      return;
    case ???: 
      paramActionAnalytics.trackFailure("no result");
      return;
    }
    paramActionAnalytics.trackFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.utils.AnalyticsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */