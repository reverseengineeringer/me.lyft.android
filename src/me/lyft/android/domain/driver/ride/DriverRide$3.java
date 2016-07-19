package me.lyft.android.domain.driver.ride;

import rx.functions.Func1;

class DriverRide$3
  implements Func1<DriverStop, Boolean>
{
  DriverRide$3(DriverRide paramDriverRide) {}
  
  public Boolean call(DriverStop paramDriverStop)
  {
    return Boolean.valueOf(paramDriverStop.isPickup());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRide.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */