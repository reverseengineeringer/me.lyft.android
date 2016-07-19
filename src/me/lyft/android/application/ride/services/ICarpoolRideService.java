package me.lyft.android.application.ride.services;

import java.io.IOException;
import java.util.List;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.ride.CancellationOption;
import rx.Observable;

public abstract interface ICarpoolRideService
{
  public abstract Observable<Unit> acceptRide(String paramString);
  
  public abstract void clearRides();
  
  public abstract Observable<Unit> declineRides(List<String> paramList, CancellationOption paramCancellationOption);
  
  public abstract Observable<List<DriverRide>> fetchCarpoolRides(String paramString);
  
  public abstract void updateCarpoolRidesSync(String paramString)
    throws IOException;
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.services.ICarpoolRideService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */