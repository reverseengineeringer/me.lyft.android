package me.lyft.android.analytics.core.events;

import java.util.HashSet;
import me.lyft.android.analytics.core.definitions.Subevent;

final class ActionEvent$1
  extends HashSet<Subevent>
{
  ActionEvent$1(int paramInt)
  {
    super(paramInt);
    add(Subevent.BASE);
    add(Subevent.CLIENT);
    add(Subevent.USER);
    add(Subevent.RIDE);
    add(Subevent.LOCATION);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.core.events.ActionEvent.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */