package me.lyft.android.application.passenger;

import com.jakewharton.rxrelay.BehaviorRelay;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import me.lyft.android.common.Objects;
import me.lyft.android.common.Strings;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ride.Driver;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.passenger.ride.PassengerRidePassenger;
import me.lyft.android.domain.passenger.ride.PassengerStop;
import me.lyft.android.domain.passenger.ride.PassengerStops;
import me.lyft.android.domain.passenger.ride.PickupGeofence;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.rx.ReactiveProperty;
import me.lyft.android.rx.ReactiveProperty.EqualityComparator;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public class PassengerRideProvider
  implements IPassengerRideProvider
{
  private boolean didDisplayGiftBoxTooltip = false;
  private boolean didDisplaySplitFareTooltip = false;
  private ReactiveProperty<Driver> driverSubject = ReactiveProperty.create(Driver.empty()).setEqualityComparator(new ReactiveProperty.EqualityComparator()
  {
    public boolean equals(Driver paramAnonymousDriver1, Driver paramAnonymousDriver2)
    {
      return Strings.equalsIgnoreCase(paramAnonymousDriver1.getId(), paramAnonymousDriver2.getId());
    }
  });
  private ReactiveProperty<PassengerRide> passengerRideSubject = ReactiveProperty.create(PassengerRide.empty());
  private ReactiveProperty<List<PassengerRidePassenger>> passengersSubject = ReactiveProperty.create(Collections.emptyList()).setEqualityComparator(new ReactiveProperty.EqualityComparator()
  {
    public boolean equals(List<PassengerRidePassenger> paramAnonymousList1, List<PassengerRidePassenger> paramAnonymousList2)
    {
      return Objects.equals(PassengerRideProvider.this.getPassengerIds(paramAnonymousList1), PassengerRideProvider.this.getPassengerIds(paramAnonymousList2));
    }
  });
  private BehaviorRelay<PickupGeofence> pickupGeofenceRelay = BehaviorRelay.create(PickupGeofence.empty());
  private ReactiveProperty<List<PassengerStop>> stopsSubject = ReactiveProperty.create(Collections.emptyList());
  
  private Set<String> getPassengerIds(List<PassengerRidePassenger> paramList)
  {
    HashSet localHashSet = new HashSet();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localHashSet.add(((PassengerRidePassenger)paramList.next()).getId());
    }
    return localHashSet;
  }
  
  public boolean canEditPickup()
  {
    return (getPassengerRide().isPickupEditEnabled()) && (hasPickupGeofence());
  }
  
  public boolean didDisplayGiftBoxTooltip()
  {
    return didDisplayGiftBoxTooltip;
  }
  
  public boolean didDisplaySplitFareTooltip()
  {
    return didDisplaySplitFareTooltip;
  }
  
  public PassengerRide getPassengerRide()
  {
    return (PassengerRide)passengerRideSubject.get();
  }
  
  public PickupGeofence getPickupGeofence()
  {
    return (PickupGeofence)pickupGeofenceRelay.getValue();
  }
  
  public boolean hasPickupGeofence()
  {
    return ((PickupGeofence)pickupGeofenceRelay.getValue()).isForRideWithId(getPassengerRide().getId());
  }
  
  public Observable<Driver> observeDriverChange()
  {
    passengerRideSubject.map(new Func1()
    {
      public Driver call(PassengerRide paramAnonymousPassengerRide)
      {
        return paramAnonymousPassengerRide.getDriver();
      }
    });
  }
  
  public Observable<Location> observeDriverLocationChange()
  {
    passengerRideSubject.map(new Func1()
    {
      public Location call(PassengerRide paramAnonymousPassengerRide)
      {
        return paramAnonymousPassengerRide.getDriver().getLocation();
      }
    }).distinctUntilChanged();
  }
  
  public Observable<List<PassengerRidePassenger>> observePassengersChange()
  {
    return passengersSubject.asObservable();
  }
  
  public Observable<Boolean> observePickupEditability()
  {
    Observable.combineLatest(passengerRideSubject, pickupGeofenceRelay, new Func2()
    {
      public Boolean call(PassengerRide paramAnonymousPassengerRide, PickupGeofence paramAnonymousPickupGeofence)
      {
        if ((paramAnonymousPassengerRide.isPickupEditEnabled()) && (paramAnonymousPickupGeofence.isForRideWithId(paramAnonymousPassengerRide.getId()))) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    });
  }
  
  public Observable<RideStatus> observeRideStatusChanged()
  {
    passengerRideSubject.map(new Func1()
    {
      public RideStatus call(PassengerRide paramAnonymousPassengerRide)
      {
        return paramAnonymousPassengerRide.getStatus();
      }
    }).distinctUntilChanged();
  }
  
  public Observable<Unit> observeRideUpdateEvent()
  {
    return passengerRideSubject.map(Unit.func1());
  }
  
  public Observable<List<PassengerStop>> observeStopsChange()
  {
    return stopsSubject.asObservable();
  }
  
  public void setGiftBoxTooltip(boolean paramBoolean)
  {
    didDisplayGiftBoxTooltip = paramBoolean;
  }
  
  public void setSplitFareTooltipDisplayed(boolean paramBoolean)
  {
    didDisplaySplitFareTooltip = paramBoolean;
  }
  
  public void updatePassengerRide(PassengerRide paramPassengerRide)
  {
    passengerRideSubject.onNext(paramPassengerRide);
    stopsSubject.onNext(paramPassengerRide.getIncompletedStops().toList());
    passengersSubject.onNext(paramPassengerRide.getPassengers());
    driverSubject.onNext(paramPassengerRide.getDriver());
    if (paramPassengerRide.getStatus().isDroppedOff()) {
      didDisplaySplitFareTooltip = false;
    }
  }
  
  public void updatePickupGeofence(PickupGeofence paramPickupGeofence)
  {
    pickupGeofenceRelay.call(paramPickupGeofence);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.passenger.PassengerRideProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */