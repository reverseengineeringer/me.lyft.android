package me.lyft.android.analytics;

import me.lyft.android.analytics.core.events.IEvent;

final class Analytics$1
  implements Runnable
{
  Analytics$1(IEvent paramIEvent) {}
  
  public void run()
  {
    Analytics.access$000(val$event);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.Analytics.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */