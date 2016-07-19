package me.lyft.android.ui.driver;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;
import me.lyft.android.domain.time.Time;

@Layout(2130903077)
public class DriverDialogs$CallConfirmationDialog
  extends DriverDialogs
{
  private final DriverRidePassenger passenger;
  private final Time scheduledTime;
  
  public DriverDialogs$CallConfirmationDialog(DriverRidePassenger paramDriverRidePassenger)
  {
    this(paramDriverRidePassenger, Time.empty());
  }
  
  public DriverDialogs$CallConfirmationDialog(DriverRidePassenger paramDriverRidePassenger, Time paramTime)
  {
    passenger = paramDriverRidePassenger;
    scheduledTime = paramTime;
  }
  
  public DriverRidePassenger getPassenger()
  {
    return passenger;
  }
  
  public Time getScheduledTime()
  {
    return scheduledTime;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.CallConfirmationDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */