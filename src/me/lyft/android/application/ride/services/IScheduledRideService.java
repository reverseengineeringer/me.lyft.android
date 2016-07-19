package me.lyft.android.application.ride.services;

import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.ride.ScheduledRide;
import rx.Observable;

public abstract interface IScheduledRideService
{
  public abstract Observable<Unit> cancelScheduledRide(ScheduledRide paramScheduledRide);
  
  public abstract void fetchScheduledRides();
  
  public abstract List<ScheduledRide> getScheduledRides();
  
  public abstract Observable<List<ScheduledRide>> observeScheduledRides();
  
  public abstract void resetCache();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.IScheduledRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */