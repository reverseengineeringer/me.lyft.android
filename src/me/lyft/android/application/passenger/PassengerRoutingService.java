package me.lyft.android.application.passenger;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.application.geo.IDirectionsService;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.routing.PassengerLeg;
import me.lyft.android.domain.passenger.routing.PassengerRoutePath;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class PassengerRoutingService
  implements IPassengerRoutingService
{
  private final IDirectionsService directionsService;
  private PassengerRoutePath lastFetchedPassengerRoute = PassengerRoutePath.empty();
  private final IPassengerRideProvider passengerRideProvider;
  
  public PassengerRoutingService(IPassengerRideProvider paramIPassengerRideProvider, IDirectionsService paramIDirectionsService)
  {
    passengerRideProvider = paramIPassengerRideProvider;
    directionsService = paramIDirectionsService;
  }
  
  private List<PassengerLeg> createPassengerLegs(List<Leg> paramList, List<PassengerStop> paramList1, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    if (i < paramList.size())
    {
      if (paramBoolean) {
        localArrayList.add(new PassengerLeg(((Leg)paramList.get(i)).getLocations(), (PassengerStop)paramList1.get(i)));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new PassengerLeg(((Leg)paramList.get(i)).getLocations(), (PassengerStop)paramList1.get(i + 1)));
      }
    }
    return localArrayList;
  }
  
  private List<LatLng> createWaypoints(PassengerStops paramPassengerStops, boolean paramBoolean, Driver paramDriver)
  {
    if (paramBoolean) {
      return withDriverLocation(paramPassengerStops.toLatLngList(), paramDriver);
    }
    return paramPassengerStops.toLatLngList();
  }
  
  private List<LatLng> withDriverLocation(List<LatLng> paramList, Driver paramDriver)
  {
    ArrayList localArrayList = new ArrayList(paramList.size() + 1);
    if (paramDriver.hasLocation()) {
      localArrayList.add(paramDriver.getLocation());
    }
    localArrayList.addAll(paramList);
    return localArrayList;
  }
  
  public PassengerRoutePath getLastFetchedPassengerRoute()
  {
    return lastFetchedPassengerRoute;
  }
  
  public Observable<PassengerRoutePath> getRoute(final PassengerStops paramPassengerStops, final boolean paramBoolean)
  {
    Object localObject = passengerRideProvider.getPassengerRide();
    final String str = ((PassengerRide)localObject).getId();
    localObject = createWaypoints(paramPassengerStops, paramBoolean, ((PassengerRide)localObject).getDriver());
    directionsService.directions(str, (List)localObject).map(new Func1()
    {
      public PassengerRoutePath call(List<Leg> paramAnonymousList)
      {
        return new PassengerRoutePath(PassengerRoutingService.this.createPassengerLegs(paramAnonymousList, paramPassengerStops.toList(), paramBoolean), str);
      }
    }).doOnNext(new Action1()
    {
      public void call(PassengerRoutePath paramAnonymousPassengerRoutePath)
      {
        PassengerRoutingService.access$002(PassengerRoutingService.this, paramAnonymousPassengerRoutePath);
      }
    }).doOnError(new Action1()
    {
      public void call(Throwable paramAnonymousThrowable)
      {
        PassengerRoutingService.access$002(PassengerRoutingService.this, PassengerRoutePath.empty());
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRoutingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */