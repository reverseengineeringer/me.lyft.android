package me.lyft.android.application.passenger;

import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import rx.functions.Func2;

class PassengerRideProvider$5
  implements Func2<PassengerRide, PickupGeofence, Boolean>
{
  PassengerRideProvider$5(PassengerRideProvider paramPassengerRideProvider) {}
  
  public Boolean call(PassengerRide paramPassengerRide, PickupGeofence paramPickupGeofence)
  {
    if ((paramPassengerRide.isPickupEditEnabled()) && (paramPickupGeofence.isForRideWithId(paramPassengerRide.getId()))) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */