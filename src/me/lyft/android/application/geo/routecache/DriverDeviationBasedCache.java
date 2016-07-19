package me.lyft.android.application.geo.routecache;

import java.util.List;
import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.analytics.core.SpanningAnalytics;
import me.lyft.android.analytics.core.events.ActionEvent.Action;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.SphericalUtils;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;

public class DriverDeviationBasedCache
  implements IDirectionsCache
{
  private static final String DIFFERENT_ROUTE = "different_route";
  private static final String EMPTY = "empty";
  private static final String MAX_DISTANCE = "max_distance_exceeded";
  private static final String NOT_FOUND = "not_found";
  private CachedDirections cachedDirections = CachedDirections.empty();
  private int deviationThreshold;
  private int maximumAllowedDistance;
  private IPassengerRideProvider passengerRideProvider;
  
  public DriverDeviationBasedCache(IPassengerRideProvider paramIPassengerRideProvider, int paramInt1, int paramInt2)
  {
    passengerRideProvider = paramIPassengerRideProvider;
    deviationThreshold = paramInt1;
    maximumAllowedDistance = paramInt2;
  }
  
  private CachedDirections find(List<? extends LatLng> paramList, Location paramLocation, ActionAnalytics paramActionAnalytics)
  {
    if (!cachedDirections.areForSameRoute(paramList))
    {
      paramActionAnalytics.trackFailure("different_route");
      return CachedDirections.empty();
    }
    List localList1 = cachedDirections.getLegs();
    Leg localLeg = (Leg)localList1.get(0);
    List localList2 = localLeg.getLocations();
    int i = 0;
    while (i < localList2.size())
    {
      double d = SphericalUtils.computeDistanceBetween((LatLng)localList2.get(i), paramLocation);
      if (d > maximumAllowedDistance)
      {
        paramActionAnalytics.trackFailure("max_distance_exceeded");
        return CachedDirections.empty();
      }
      if (d <= deviationThreshold)
      {
        localList1.set(0, localLeg.subLeg(i, localList2.size()));
        paramActionAnalytics.trackSuccess();
        return new CachedDirections(0L, paramList, localList1);
      }
      i += 1;
    }
    paramActionAnalytics.trackFailure("not_found");
    return CachedDirections.empty();
  }
  
  public void cache(List<? extends LatLng> paramList, List<Leg> paramList1)
  {
    cachedDirections = new CachedDirections(0L, paramList, paramList1);
  }
  
  public List<Leg> getRoute(List<? extends LatLng> paramList)
  {
    ActionAnalytics localActionAnalytics = (ActionAnalytics)new ActionAnalytics(ActionEvent.Action.ACCESS_ROUTE_CACHE).setValue(deviationThreshold).trackInitiation();
    Location localLocation = passengerRideProvider.getPassengerRide().getDriver().getLocation();
    if (!cachedDirections.isEmpty()) {
      cachedDirections = find(paramList, localLocation, localActionAnalytics);
    }
    for (;;)
    {
      return cachedDirections.getLegs();
      localActionAnalytics.trackFailure("empty");
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.routecache.DriverDeviationBasedCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */