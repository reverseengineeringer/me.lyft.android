package me.lyft.android.application.passenger;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRideExpense;
import me.lyft.android.domain.passenger.ride.PassengerRidePayment;
import me.lyft.android.domain.passenger.ride.PassengerRideRating;
import me.lyft.android.domain.ride.CancellationOption;
import rx.Observable;

public abstract interface IPassengerRideService
{
  public abstract Observable<Unit> cancelRide(CancellationOption paramCancellationOption, int paramInt);
  
  public abstract Observable<Unit> changePickup(Location paramLocation);
  
  public abstract void fetchPickupGeofence();
  
  public abstract Observable<Unit> rateAndPayDriver(PassengerRideRating paramPassengerRideRating, PassengerRideExpense paramPassengerRideExpense, PassengerRidePayment paramPassengerRidePayment);
  
  public abstract Observable<Unit> setDropoff(Location paramLocation);
  
  public abstract Observable<String> shareRoute();
  
  public abstract void updatePassengerRide(PassengerRide paramPassengerRide);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.IPassengerRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */