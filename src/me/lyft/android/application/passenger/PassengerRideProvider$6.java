package me.lyft.android.application.passenger;

import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import rx.functions.Func1;

class PassengerRideProvider$6
  implements Func1<PassengerRide, Driver>
{
  PassengerRideProvider$6(PassengerRideProvider paramPassengerRideProvider) {}
  
  public Driver call(PassengerRide paramPassengerRide)
  {
    return paramPassengerRide.getDriver();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */