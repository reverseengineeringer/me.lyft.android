package me.lyft.android.domain.passenger.ride;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.domain.time.Time;
import rx.functions.Func1;

public class PassengerRide
  implements INullable
{
  private final int cancelPenalty;
  private final String cancelSubtitleText;
  private final Driver driver;
  private final Time driverWaitTime;
  private final boolean hideLocationMarker;
  private final String id;
  private final boolean isEditPickupTooltipVisible;
  private final boolean isPickupEditable;
  private final boolean isQueued;
  private final boolean isRealTimeMatching;
  private final Time matchByTime;
  private final List<PassengerRidePassenger> passengers;
  private final List<RideFeature> rideFeatures;
  private final RideStatus status;
  private final PassengerStops stops;
  private final long timestamp;
  private final RideType type;
  private final int waitEstimateInSec;
  
  public PassengerRide(String paramString1, Driver paramDriver, RideType paramRideType, RideStatus paramRideStatus, PassengerStops paramPassengerStops, List<PassengerRidePassenger> paramList, int paramInt1, boolean paramBoolean1, int paramInt2, String paramString2, List<RideFeature> paramList1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, Time paramTime1, Time paramTime2, long paramLong)
  {
    id = paramString1;
    driver = paramDriver;
    type = paramRideType;
    status = paramRideStatus;
    stops = paramPassengerStops;
    passengers = paramList;
    cancelPenalty = paramInt1;
    hideLocationMarker = paramBoolean1;
    waitEstimateInSec = paramInt2;
    cancelSubtitleText = paramString2;
    rideFeatures = paramList1;
    isPickupEditable = paramBoolean2;
    isRealTimeMatching = paramBoolean3;
    isEditPickupTooltipVisible = paramBoolean4;
    isQueued = paramBoolean5;
    matchByTime = paramTime1;
    driverWaitTime = paramTime2;
    timestamp = paramLong;
  }
  
  public static PassengerRide empty()
  {
    return NullPassengerRide.getInstance();
  }
  
  public int getCancelPenalty()
  {
    return cancelPenalty;
  }
  
  public String getCancelSubtitleText()
  {
    return cancelSubtitleText;
  }
  
  public PassengerStop getCurrentStop()
  {
    return stops.incompleted().first();
  }
  
  public Driver getDriver()
  {
    return (Driver)Objects.firstNonNull(driver, Driver.empty());
  }
  
  public Time getDriverWaitTime()
  {
    return driverWaitTime;
  }
  
  public Location getDropoff()
  {
    Iterator localIterator = stops.toList().iterator();
    while (localIterator.hasNext())
    {
      PassengerStop localPassengerStop = (PassengerStop)localIterator.next();
      if ((localPassengerStop.isDropOff()) && (localPassengerStop.getPassenger().isSelf())) {
        return localPassengerStop.getLocation();
      }
    }
    return NullLocation.getInstance();
  }
  
  public String getId()
  {
    return (String)Objects.firstNonNull(id, "");
  }
  
  public PassengerStop getIncompletedDropoffStop()
  {
    Iterator localIterator = stops.incompleted().toList().iterator();
    while (localIterator.hasNext())
    {
      PassengerStop localPassengerStop = (PassengerStop)localIterator.next();
      if ((localPassengerStop.isDropOff()) && (localPassengerStop.getPassenger().isSelf())) {
        return localPassengerStop;
      }
    }
    return PassengerStop.empty();
  }
  
  public PassengerStop getIncompletedPickupStop()
  {
    Iterator localIterator = stops.incompleted().toList().iterator();
    while (localIterator.hasNext())
    {
      PassengerStop localPassengerStop = (PassengerStop)localIterator.next();
      if ((localPassengerStop.isPickup()) && (localPassengerStop.getPassenger().isSelf())) {
        return localPassengerStop;
      }
    }
    return PassengerStop.empty();
  }
  
  public PassengerStops getIncompletedStops()
  {
    return stops.incompleted();
  }
  
  public Time getMatchByTime()
  {
    return matchByTime;
  }
  
  public List<PassengerRidePassenger> getPassengers()
  {
    return passengers;
  }
  
  public Location getPickup()
  {
    Iterator localIterator = stops.toList().iterator();
    while (localIterator.hasNext())
    {
      PassengerStop localPassengerStop = (PassengerStop)localIterator.next();
      if ((localPassengerStop.isPickup()) && (localPassengerStop.getPassenger().isSelf())) {
        return localPassengerStop.getLocation();
      }
    }
    return NullLocation.getInstance();
  }
  
  public RideType getRideType()
  {
    return type;
  }
  
  public PassengerRidePassenger getSelf()
  {
    (PassengerRidePassenger)Iterables.firstOrDefault(passengers, new Func1()
    {
      public Boolean call(PassengerRidePassenger paramAnonymousPassengerRidePassenger)
      {
        return Boolean.valueOf(paramAnonymousPassengerRidePassenger.isSelf());
      }
    }, PassengerRidePassenger.empty());
  }
  
  public RideStatus getStatus()
  {
    return status;
  }
  
  public long getTimestamp()
  {
    return timestamp;
  }
  
  public int getWaitEstimateInSec()
  {
    return waitEstimateInSec;
  }
  
  public boolean hasFeatures()
  {
    return !rideFeatures.isEmpty();
  }
  
  public boolean isCarpool()
  {
    return getRideType().isCarpool();
  }
  
  public boolean isCourier()
  {
    return getRideType().isCourier();
  }
  
  public boolean isEditPickupTooltipVisible()
  {
    return isEditPickupTooltipVisible;
  }
  
  public boolean isFeatureEnabled(RideFeature paramRideFeature)
  {
    return rideFeatures.contains(paramRideFeature);
  }
  
  public boolean isInProgress()
  {
    return getStatus().isInProgress();
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean isPickupEditEnabled()
  {
    return isPickupEditable;
  }
  
  public boolean isQueued()
  {
    return isQueued;
  }
  
  public boolean isRealTimeMatching()
  {
    return isRealTimeMatching;
  }
  
  public boolean shouldHideLocationMarker()
  {
    return hideLocationMarker;
  }
  
  private static class NullPassengerRide
    extends PassengerRide
  {
    private static final PassengerRide INSTANCE = new NullPassengerRide();
    
    private NullPassengerRide()
    {
      super(Driver.empty(), RideType.empty(), RideStatus.empty(), new PassengerStops(Collections.emptyList()), Collections.emptyList(), 0, false, 0, "", Collections.emptyList(), false, false, false, false, Time.empty(), Time.empty(), 0L);
    }
    
    public static PassengerRide getInstance()
    {
      return INSTANCE;
    }
    
    public boolean isNull()
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */