package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

class PassengerStops$2
  implements Func1<PassengerStop, Boolean>
{
  PassengerStops$2(PassengerStops paramPassengerStops) {}
  
  public Boolean call(PassengerStop paramPassengerStop)
  {
    if ((!paramPassengerStop.isCompleted()) && (!paramPassengerStop.getLocation().isNull())) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerStops.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */