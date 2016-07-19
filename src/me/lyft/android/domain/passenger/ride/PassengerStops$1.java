package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.location.LatLng;
import rx.functions.Func1;

class PassengerStops$1
  implements Func1<PassengerStop, LatLng>
{
  PassengerStops$1(PassengerStops paramPassengerStops) {}
  
  public LatLng call(PassengerStop paramPassengerStop)
  {
    return paramPassengerStop.getLocation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerStops.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */