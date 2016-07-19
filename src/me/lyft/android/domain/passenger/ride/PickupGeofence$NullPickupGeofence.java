package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.location.NullLocation;

public class PickupGeofence$NullPickupGeofence
  extends PickupGeofence
{
  public PickupGeofence$NullPickupGeofence()
  {
    super("", 0, NullLocation.getInstance());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PickupGeofence.NullPickupGeofence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */