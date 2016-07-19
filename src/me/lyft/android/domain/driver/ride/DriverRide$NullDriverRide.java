package me.lyft.android.domain.driver.ride;

import java.util.Collections;
import java.util.List;
import me.lyft.android.domain.driver.carpool.CarpoolInfo;
import me.lyft.android.domain.ride.RideStatus;
import me.lyft.android.domain.ride.RideType;

public class DriverRide$NullDriverRide
  extends DriverRide
{
  private static DriverRide INSTANCE = new NullDriverRide();
  
  private DriverRide$NullDriverRide()
  {
    super(Collections.emptyList(), RideStatus.empty(), RideType.empty(), null, "", false, 0L, 0, null, false, false, null, null, CarpoolInfo.empty(), 0, 0, false, Collections.emptyList());
  }
  
  public List<DriverStop> getIncompleteStops()
  {
    return Collections.emptyList();
  }
  
  public boolean isNull()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.driver.ride.DriverRide.NullDriverRide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */