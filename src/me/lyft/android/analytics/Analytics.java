package me.lyft.android.analytics;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import me.lyft.android.analytics.core.events.IEvent;
import me.lyft.android.analytics.core.events.IEvent.Priority;
import me.lyft.android.common.Preconditions;
import me.lyft.android.logging.L;

public final class Analytics
{
  private static Executor dispatchExecutor = Executors.newSingleThreadExecutor();
  private static final List<IEventTracker> eventTrackers = new CopyOnWriteArrayList();
  
  public static void add(IEventTracker paramIEventTracker)
  {
    Preconditions.checkNotNull(paramIEventTracker, "EventTracker cannot be null");
    eventTrackers.add(paramIEventTracker);
  }
  
  public static void flush()
  {
    Iterator localIterator = eventTrackers.iterator();
    while (localIterator.hasNext()) {
      ((IEventTracker)localIterator.next()).flush();
    }
  }
  
  public static void removeAllTrackers()
  {
    eventTrackers.clear();
  }
  
  public static void setDispatchExecutor(Executor paramExecutor)
  {
    Preconditions.checkNotNull(paramExecutor, "Executor cannot be null");
    dispatchExecutor = paramExecutor;
  }
  
  public static void track(IEvent paramIEvent)
  {
    Preconditions.checkNotNull(paramIEvent, "Event cannot be null");
    dispatchExecutor.execute(new Runnable()
    {
      public void run()
      {
        Analytics.trackInternal(val$event);
      }
    });
  }
  
  private static void trackInternal(IEvent paramIEvent)
  {
    if (eventTrackers.isEmpty()) {
      L.w("Initialize analytics before tracking this event: %s", new Object[] { paramIEvent.getName() });
    }
    int i;
    do
    {
      return;
      for (;;)
      {
        try
        {
          if (paramIEvent.getPriority() == IEvent.Priority.CRITICAL)
          {
            i = 1;
            Iterator localIterator = eventTrackers.iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            ((IEventTracker)localIterator.next()).track(paramIEvent);
            continue;
          }
          i = 0;
        }
        catch (Throwable localThrowable)
        {
          L.e(localThrowable, "Failed to track event %s", new Object[] { paramIEvent.getName() });
          return;
        }
      }
    } while (i == 0);
    flush();
  }
  
  public static void trackSync(IEvent paramIEvent)
  {
    Preconditions.checkNotNull(paramIEvent, "Event cannot be null");
    trackInternal(paramIEvent);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.Analytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */