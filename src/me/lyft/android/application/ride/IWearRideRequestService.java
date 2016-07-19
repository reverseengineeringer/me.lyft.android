package me.lyft.android.application.ride;

import me.lyft.android.common.Unit;
import rx.Observable;

public abstract interface IWearRideRequestService
{
  public abstract Observable<Unit> requestRide(double paramDouble1, double paramDouble2);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IWearRideRequestService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */