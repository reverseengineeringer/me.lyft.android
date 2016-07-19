package com.facebook.appevents;

final class AppEventQueue$2
  implements Runnable
{
  public void run()
  {
    AppEventStore.persistEvents(AppEventQueue.access$100());
    AppEventQueue.access$102(new AppEventCollection());
  }
}

/* Location:
 * Qualified Name:     com.facebook.appevents.AppEventQueue.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */