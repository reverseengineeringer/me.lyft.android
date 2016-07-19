package me.lyft.android.application.ride;

import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRide;

public class RideSession
  implements IRideSession
{
  private IPassengerRideProvider passengerRideProvider;
  private Location pickupLocation;
  
  public RideSession(IPassengerRideProvider paramIPassengerRideProvider)
  {
    passengerRideProvider = paramIPassengerRideProvider;
  }
  
  public Location getPickupLocation()
  {
    return (Location)Objects.firstNonNull(pickupLocation, passengerRideProvider.getPassengerRide().getPickup());
  }
  
  public boolean hasPickupChanged()
  {
    return !passengerRideProvider.getPassengerRide().getPickup().equals(getPickupLocation());
  }
  
  public void resetPickup()
  {
    pickupLocation = null;
  }
  
  public void setPickupLocation(Location paramLocation)
  {
    pickupLocation = paramLocation;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */