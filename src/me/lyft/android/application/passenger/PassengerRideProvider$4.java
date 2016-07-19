package me.lyft.android.application.passenger;

import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import rx.functions.Func1;

class PassengerRideProvider$4
  implements Func1<PassengerRide, Location>
{
  PassengerRideProvider$4(PassengerRideProvider paramPassengerRideProvider) {}
  
  public Location call(PassengerRide paramPassengerRide)
  {
    return paramPassengerRide.getDriver().getLocation();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */