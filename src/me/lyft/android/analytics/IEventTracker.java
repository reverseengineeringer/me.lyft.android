package me.lyft.android.analytics;

import me.lyft.android.analytics.core.events.IEvent;

public abstract interface IEventTracker
{
  public abstract void flush();
  
  public abstract void track(IEvent paramIEvent);
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.IEventTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */