package me.lyft.android.application.passenger;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.routing.PassengerRoutePath;

public class PassengerZoomProvider
  implements IPassengerZoomProvider
{
  private final IPassengerRideProvider passengerRideProvider;
  private final IPassengerRoutingService passengerRoutingService;
  
  public PassengerZoomProvider(IPassengerRoutingService paramIPassengerRoutingService, IPassengerRideProvider paramIPassengerRideProvider)
  {
    passengerRoutingService = paramIPassengerRoutingService;
    passengerRideProvider = paramIPassengerRideProvider;
  }
  
  private PassengerRoutePath getRoutePath()
  {
    PassengerRoutePath localPassengerRoutePath = passengerRoutingService.getLastFetchedPassengerRoute();
    if (localPassengerRoutePath.getRouteId().equals(passengerRideProvider.getPassengerRide().getId())) {
      return localPassengerRoutePath;
    }
    return PassengerRoutePath.empty();
  }
  
  public List<LatLng> getFullRoute()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    ArrayList localArrayList = new ArrayList(localPassengerRide.getIncompletedStops().toLatLngList());
    if (localPassengerRide.getDriver().hasLocation()) {
      localArrayList.add(localPassengerRide.getDriver().getLocation());
    }
    localArrayList.addAll(getRoutePath().toLatLngList());
    return localArrayList;
  }
  
  public List<LatLng> getRouteUntilMyNextStop()
  {
    PassengerRide localPassengerRide = passengerRideProvider.getPassengerRide();
    ArrayList localArrayList = new ArrayList(localPassengerRide.getIncompletedStops().untilMyNextStop().toLatLngList());
    if (localPassengerRide.getDriver().hasLocation()) {
      localArrayList.add(localPassengerRide.getDriver().getLocation());
    }
    if (localPassengerRide.getCurrentStop().isDropOff())
    {
      localArrayList.addAll(getRoutePath().toLatLngList());
      return localArrayList;
    }
    localArrayList.addAll(getRoutePath().untilPickup().toLatLngList());
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerZoomProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */