package me.lyft.android.application.ride;

import com.lyft.android.api.dto.RideDTO;
import me.lyft.android.domain.driver.ride.DriverRide;
import rx.Observable;

public abstract interface IDriverRideProvider
{
  public abstract void clearRoute();
  
  public abstract DriverRide getDriverRide();
  
  public abstract Observable<DriverRide> observeRide();
  
  public abstract void setOfflineRide(DriverRide paramDriverRide);
  
  public abstract boolean shouldIgnoreRide(RideDTO paramRideDTO);
  
  public abstract void updateRide(DriverRide paramDriverRide);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.IDriverRideProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */