package me.lyft.android.application.passenger;

import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import rx.functions.Func1;

class PassengerRideProvider$3
  implements Func1<PassengerRide, RideStatus>
{
  PassengerRideProvider$3(PassengerRideProvider paramPassengerRideProvider) {}
  
  public RideStatus call(PassengerRide paramPassengerRide)
  {
    return paramPassengerRide.getStatus();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */