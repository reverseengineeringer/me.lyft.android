package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import me.lyft.android.domain.ride.ScheduledRide;
import rx.Observable;

public abstract interface IRideRequestService
{
  public abstract Observable<Unit> requestRide(boolean paramBoolean);
  
  public abstract Observable<ScheduledRide> scheduleRide();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IRideRequestService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */