package me.lyft.android.analytics.core.events;

import java.util.HashSet;
import me.lyft.android.analytics.core.definitions.Subevent;

final class UxEvent$1
  extends HashSet<Subevent>
{
  UxEvent$1(int paramInt)
  {
    super(paramInt);
    add(Subevent.BASE);
    add(Subevent.CLIENT);
    add(Subevent.DEVICE);
    add(Subevent.USER);
    add(Subevent.RIDE);
    add(Subevent.LOCATION);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.events.UxEvent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */