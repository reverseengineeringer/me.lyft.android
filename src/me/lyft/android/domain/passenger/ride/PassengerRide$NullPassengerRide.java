package me.lyft.android.domain.passenger.ride;

import java.util.Collections;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;
import me.lyft.android.domain.time.Time;

class PassengerRide$NullPassengerRide
  extends PassengerRide
{
  private static final PassengerRide INSTANCE = new NullPassengerRide();
  
  private PassengerRide$NullPassengerRide()
  {
    super("", Driver.empty(), RideType.empty(), RideStatus.empty(), new PassengerStops(Collections.emptyList()), Collections.emptyList(), 0, false, 0, "", Collections.emptyList(), false, false, false, false, Time.empty(), Time.empty(), 0L);
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PassengerRide.NullPassengerRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */