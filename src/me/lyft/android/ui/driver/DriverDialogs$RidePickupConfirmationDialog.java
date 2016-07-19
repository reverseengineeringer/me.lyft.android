package me.lyft.android.ui.driver;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;

@Layout(2130903433)
public class DriverDialogs$RidePickupConfirmationDialog
  extends DriverDialogs
{
  private DriverRidePassenger passenger;
  
  public DriverDialogs$RidePickupConfirmationDialog(DriverRidePassenger paramDriverRidePassenger)
  {
    passenger = paramDriverRidePassenger;
  }
  
  public DriverRidePassenger getPassenger()
  {
    return passenger;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.RidePickupConfirmationDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */