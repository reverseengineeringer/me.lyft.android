package me.lyft.android.driver.notifications;

import java.util.List;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.location.Location;

public abstract interface IDriverNotificationService
{
  public abstract void courierRouteChanged(Location paramLocation);
  
  public abstract void destinationChanged(Location paramLocation);
  
  public abstract void newPassengerAdded();
  
  public abstract void newQueuedRoute(List<DriverRidePassenger> paramList);
  
  public abstract void pickupChanged(Location paramLocation);
  
  public abstract void rideCanceled();
  
  public abstract void rideRemoved();
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.notifications.IDriverNotificationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */