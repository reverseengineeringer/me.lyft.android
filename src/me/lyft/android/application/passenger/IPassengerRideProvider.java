package me.lyft.android.application.passenger;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import me.lyft.android.domain.ride.RideStatus;
import rx.Observable;

public abstract interface IPassengerRideProvider
{
  public abstract boolean canEditPickup();
  
  public abstract boolean didDisplayGiftBoxTooltip();
  
  public abstract boolean didDisplaySplitFareTooltip();
  
  public abstract PassengerRide getPassengerRide();
  
  public abstract PickupGeofence getPickupGeofence();
  
  public abstract boolean hasPickupGeofence();
  
  public abstract Observable<Driver> observeDriverChange();
  
  public abstract Observable<Location> observeDriverLocationChange();
  
  public abstract Observable<List<PassengerRidePassenger>> observePassengersChange();
  
  public abstract Observable<Boolean> observePickupEditability();
  
  public abstract Observable<RideStatus> observeRideStatusChanged();
  
  public abstract Observable<Unit> observeRideUpdateEvent();
  
  public abstract Observable<List<PassengerStop>> observeStopsChange();
  
  public abstract void setGiftBoxTooltip(boolean paramBoolean);
  
  public abstract void setSplitFareTooltipDisplayed(boolean paramBoolean);
  
  @Deprecated
  public abstract void updatePassengerRide(PassengerRide paramPassengerRide);
  
  public abstract void updatePickupGeofence(PickupGeofence paramPickupGeofence);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.IPassengerRideProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */