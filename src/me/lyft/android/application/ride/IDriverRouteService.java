package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.driver.ride.DriverStop;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.ride.CancellationOption;
import rx.Observable;

public abstract interface IDriverRouteService
{
  public abstract Observable<Unit> acceptRoute();
  
  public abstract Observable<Unit> arrive(DriverStop paramDriverStop, String paramString);
  
  public abstract Observable<Unit> cancelRoute(CancellationOption paramCancellationOption);
  
  public abstract Observable<Unit> clearRoute();
  
  public abstract Observable<Unit> dropOff(DriverRidePassenger paramDriverRidePassenger);
  
  public abstract Observable<Unit> enterLastRide();
  
  public abstract Observable<Unit> exitLastRide();
  
  public abstract Observable<Unit> lapseRoute(boolean paramBoolean);
  
  public abstract Observable<Unit> pickup(DriverRidePassenger paramDriverRidePassenger);
  
  public abstract Observable<Unit> pickup(DriverRidePassenger paramDriverRidePassenger, int paramInt);
  
  public abstract Observable<Unit> rate(DriverRidePassenger paramDriverRidePassenger, int paramInt, String paramString);
  
  public abstract Observable<Unit> setDropoff(Location paramLocation);
  
  public abstract Observable<Unit> skipNoShow(DriverRidePassenger paramDriverRidePassenger);
  
  public abstract Observable<Unit> skipWrongPartySize(DriverRidePassenger paramDriverRidePassenger, int paramInt);
  
  public abstract Observable<Unit> startRoute();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IDriverRouteService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */