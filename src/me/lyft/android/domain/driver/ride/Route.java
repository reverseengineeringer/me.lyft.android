package me.lyft.android.domain.driver.ride;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import rx.functions.Func1;

public class Route
{
  private final List<DriverRidePassenger> passengers;
  private final List<DriverStop> stops;
  
  public Route(List<DriverStop> paramList, List<DriverRidePassenger> paramList1)
  {
    stops = paramList;
    passengers = paramList1;
  }
  
  private static boolean isSameStop(DriverStop paramDriverStop1, DriverStop paramDriverStop2)
  {
    return (Objects.equals(paramDriverStop1.getRideId(), paramDriverStop2.getRideId())) && (Objects.equals(paramDriverStop1.getPassenger().getId(), paramDriverStop2.getPassenger().getId())) && (Objects.equals(Boolean.valueOf(paramDriverStop1.isDropOff()), Boolean.valueOf(paramDriverStop2.isDropOff()))) && (Objects.equals(Boolean.valueOf(paramDriverStop1.isPickup()), Boolean.valueOf(paramDriverStop2.isPickup())));
  }
  
  private List<DriverRidePassenger> updatePassengerList(DriverRidePassenger paramDriverRidePassenger)
  {
    ArrayList localArrayList = new ArrayList(passengers);
    int i = 0;
    while (i < passengers.size())
    {
      if (Objects.equals(((DriverRidePassenger)passengers.get(i)).getId(), paramDriverRidePassenger.getId())) {
        localArrayList.set(i, paramDriverRidePassenger);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public Route advanceTo(DriverStop paramDriverStop)
  {
    ArrayList localArrayList = new ArrayList(stops);
    int i = 0;
    while (i < stops.size())
    {
      if (isSameStop((DriverStop)stops.get(i), paramDriverStop)) {
        localArrayList.set(i, paramDriverStop);
      }
      i += 1;
    }
    return new Route(localArrayList, updatePassengerList(paramDriverStop.getPassenger()));
  }
  
  public DriverStop getFirstStop()
  {
    return (DriverStop)stops.get(0);
  }
  
  public List<DriverStop> getIncompleteStops()
  {
    Iterables.where(stops, new Func1()
    {
      public Boolean call(DriverStop paramAnonymousDriverStop)
      {
        if (!paramAnonymousDriverStop.isCompleted()) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  public DriverStop getLastStop()
  {
    return (DriverStop)stops.get(stops.size() - 1);
  }
  
  public List<DriverRidePassenger> getPassengers()
  {
    return passengers;
  }
  
  public List<DriverStop> getStops()
  {
    return stops;
  }
  
  public Route withUpdatedPassenger(DriverRidePassenger paramDriverRidePassenger)
  {
    ArrayList localArrayList = new ArrayList(stops);
    int i = 0;
    while (i < stops.size())
    {
      DriverStop localDriverStop = (DriverStop)stops.get(i);
      if (Objects.equals(localDriverStop.getPassenger().getId(), paramDriverRidePassenger.getId())) {
        localArrayList.set(i, localDriverStop.withPassenger(paramDriverRidePassenger));
      }
      i += 1;
    }
    return new Route(localArrayList, updatePassengerList(paramDriverRidePassenger));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.Route
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */