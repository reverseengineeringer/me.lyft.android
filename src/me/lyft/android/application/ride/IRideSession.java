package me.lyft.android.application.ride;

import me.lyft.android.domain.location.Location;

public abstract interface IRideSession
{
  public abstract Location getPickupLocation();
  
  public abstract boolean hasPickupChanged();
  
  public abstract void resetPickup();
  
  public abstract void setPickupLocation(Location paramLocation);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IRideSession
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */