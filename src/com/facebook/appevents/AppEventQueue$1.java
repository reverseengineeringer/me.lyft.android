package com.facebook.appevents;

final class AppEventQueue$1
  implements Runnable
{
  public void run()
  {
    AppEventQueue.access$002(null);
    if (AppEventsLogger.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
      AppEventQueue.flushAndWait(FlushReason.TIMER);
    }
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */