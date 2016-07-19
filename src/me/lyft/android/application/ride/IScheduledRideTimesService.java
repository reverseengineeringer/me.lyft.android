package me.lyft.android.application.ride;

import java.util.List;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.passenger.ridetypes.RequestRideType;
import me.lyft.android.domain.ride.ScheduledInterval;
import rx.Observable;

public abstract interface IScheduledRideTimesService
{
  public abstract Observable<List<ScheduledInterval>> fetchForLocations(RequestRideType paramRequestRideType, Location paramLocation1, Location paramLocation2);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IScheduledRideTimesService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */