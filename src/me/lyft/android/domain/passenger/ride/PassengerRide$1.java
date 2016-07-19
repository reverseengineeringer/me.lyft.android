package me.lyft.android.domain.passenger.ride;

import rx.functions.Func1;

class PassengerRide$1
  implements Func1<PassengerRidePassenger, Boolean>
{
  PassengerRide$1(PassengerRide paramPassengerRide) {}
  
  public Boolean call(PassengerRidePassenger paramPassengerRidePassenger)
  {
    return Boolean.valueOf(paramPassengerRidePassenger.isSelf());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRide.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */