package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import java.io.File;
import java.util.List;

class AnswersRetryFilesSender
  implements FilesSender
{
  private final SessionAnalyticsFilesSender filesSender;
  private final RetryManager retryManager;
  
  AnswersRetryFilesSender(SessionAnalyticsFilesSender paramSessionAnalyticsFilesSender, RetryManager paramRetryManager)
  {
    filesSender = paramSessionAnalyticsFilesSender;
    retryManager = paramRetryManager;
  }
  
  public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender paramSessionAnalyticsFilesSender)
  {
    return new AnswersRetryFilesSender(paramSessionAnalyticsFilesSender, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000L, 8), 0.1D), new DefaultRetryPolicy(5))));
  }
  
  public boolean send(List<File> paramList)
  {
    boolean bool = false;
    long l = System.nanoTime();
    if (retryManager.canRetry(l))
    {
      if (filesSender.send(paramList))
      {
        retryManager.reset();
        bool = true;
      }
    }
    else {
      return bool;
    }
    retryManager.recordRetry(l);
    return false;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersRetryFilesSender
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */