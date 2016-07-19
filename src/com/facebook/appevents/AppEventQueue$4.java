package com.facebook.appevents;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class AppEventQueue$4
  implements Runnable
{
  AppEventQueue$4(AccessTokenAppIdPair paramAccessTokenAppIdPair, AppEvent paramAppEvent) {}
  
  public void run()
  {
    AppEventQueue.access$100().addEvent(val$accessTokenAppId, val$appEvent);
    if ((AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) && (AppEventQueue.access$100().getEventCount() > 100)) {
      AppEventQueue.flushAndWait(FlushReason.EVENT_THRESHOLD);
    }
    while (AppEventQueue.access$000() != null) {
      return;
    }
    AppEventQueue.access$002(AppEventQueue.access$300().schedule(AppEventQueue.access$200(), 15L, TimeUnit.SECONDS));
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */