package me.lyft.android.analytics;

import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.passenger.IPassengerRideProvider;
import me.lyft.android.application.ride.IDriverRideProvider;
import me.lyft.android.domain.User;
import me.lyft.android.domain.driver.ride.DriverRide;
import me.lyft.android.domain.passenger.ride.PassengerRide;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;

public class AnalyticsRideInfoProvider
  implements IAnalyticsRideInfoProvider
{
  private final IDriverRideProvider driverRideProvider;
  private final IPassengerRideProvider passengerRideProvider;
  private final IUserProvider userProvider;
  
  public AnalyticsRideInfoProvider(IUserProvider paramIUserProvider, IPassengerRideProvider paramIPassengerRideProvider, IDriverRideProvider paramIDriverRideProvider)
  {
    userProvider = paramIUserProvider;
    passengerRideProvider = paramIPassengerRideProvider;
    driverRideProvider = paramIDriverRideProvider;
  }
  
  public String getRideId()
  {
    if (userProvider.getUser().isDispatchable()) {
      return driverRideProvider.getDriverRide().getCurrentRideId();
    }
    return passengerRideProvider.getPassengerRide().getId();
  }
  
  public String getRideStatus()
  {
    if (userProvider.getUser().isDispatchable()) {
      return driverRideProvider.getDriverRide().getStatus().toString();
    }
    return passengerRideProvider.getPassengerRide().getStatus().toString();
  }
  
  public String getRideType()
  {
    if (userProvider.getUser().isDispatchable()) {
      return driverRideProvider.getDriverRide().getType().getType();
    }
    return passengerRideProvider.getPassengerRide().getRideType().getType();
  }
  
  public boolean hasRide()
  {
    if (userProvider.getUser().isDispatchable()) {
      if (driverRideProvider.getDriverRide().isNull()) {}
    }
    while (!passengerRideProvider.getPassengerRide().isNull())
    {
      return true;
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.analytics.AnalyticsRideInfoProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */