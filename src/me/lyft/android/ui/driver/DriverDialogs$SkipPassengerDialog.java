package me.lyft.android.ui.driver;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;

@Layout(2130903456)
public class DriverDialogs$SkipPassengerDialog
  extends DriverDialogs
{
  private Integer partySize;
  private DriverRidePassenger passenger;
  
  public DriverDialogs$SkipPassengerDialog(DriverRidePassenger paramDriverRidePassenger, Integer paramInteger)
  {
    passenger = paramDriverRidePassenger;
    partySize = paramInteger;
  }
  
  public Integer getPartySize()
  {
    return partySize;
  }
  
  public DriverRidePassenger getPassenger()
  {
    return passenger;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.SkipPassengerDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */