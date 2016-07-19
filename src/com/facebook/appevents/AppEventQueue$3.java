package com.facebook.appevents;

final class AppEventQueue$3
  implements Runnable
{
  AppEventQueue$3(FlushReason paramFlushReason) {}
  
  public void run()
  {
    AppEventQueue.flushAndWait(val$reason);
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */