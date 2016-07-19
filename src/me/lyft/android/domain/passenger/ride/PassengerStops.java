package me.lyft.android.domain.passenger.ride;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.Location;
import rx.functions.Func1;

public class PassengerStops
{
  private List<PassengerStop> stops;
  
  public PassengerStops(List<PassengerStop> paramList)
  {
    stops = paramList;
  }
  
  public PassengerStop first()
  {
    return (PassengerStop)Iterables.firstOrDefault(stops, PassengerStop.empty());
  }
  
  public PassengerStops incompleted()
  {
    new PassengerStops(Iterables.where(stops, new Func1()
    {
      public Boolean call(PassengerStop paramAnonymousPassengerStop)
      {
        if ((!paramAnonymousPassengerStop.isCompleted()) && (!paramAnonymousPassengerStop.getLocation().isNull())) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }));
  }
  
  public List<LatLng> toLatLngList()
  {
    Iterables.map(stops, new Func1()
    {
      public LatLng call(PassengerStop paramAnonymousPassengerStop)
      {
        return paramAnonymousPassengerStop.getLocation();
      }
    });
  }
  
  public List<PassengerStop> toList()
  {
    return stops;
  }
  
  public PassengerStops untilMyNextStop()
  {
    ArrayList localArrayList = new ArrayList(stops.size());
    Iterator localIterator = stops.iterator();
    PassengerStop localPassengerStop;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localPassengerStop = (PassengerStop)localIterator.next();
      localArrayList.add(localPassengerStop);
    } while (!localPassengerStop.getPassenger().isSelf());
    return new PassengerStops(localArrayList);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerStops
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */