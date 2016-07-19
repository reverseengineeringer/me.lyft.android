package me.lyft.android.analytics.trackers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import me.lyft.android.analytics.IEventTracker;
import me.lyft.android.analytics.core.events.IEvent;
import me.lyft.android.logging.L;

public class LogEventTracker
  implements IEventTracker
{
  private void appendEvent(StringBuilder paramStringBuilder, IEvent paramIEvent)
  {
    Map localMap = paramIEvent.getParameters();
    paramStringBuilder.append(String.format("event_name: %s%n", new Object[] { paramIEvent.getName() }));
    paramIEvent = localMap.keySet().iterator();
    while (paramIEvent.hasNext())
    {
      String str = (String)paramIEvent.next();
      paramStringBuilder.append(String.format("\t%s: %s%n", new Object[] { str, localMap.get(str) }));
    }
  }
  
  public void flush()
  {
    L.i("flush", new Object[0]);
  }
  
  public void track(IEvent paramIEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEvent(localStringBuilder, paramIEvent);
    L.i(localStringBuilder.toString(), new Object[0]);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.trackers.LogEventTracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */