package me.lyft.android.application.passenger;

import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.routing.PassengerRoutePath;
import rx.Observable;

public abstract interface IPassengerRoutingService
{
  public abstract PassengerRoutePath getLastFetchedPassengerRoute();
  
  public abstract Observable<PassengerRoutePath> getRoute(PassengerStops paramPassengerStops, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.IPassengerRoutingService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */