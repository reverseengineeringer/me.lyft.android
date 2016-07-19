package me.lyft.android.ui.driver;

import com.lyft.scoop.Layout;
import java.util.List;
import me.lyft.android.domain.driver.ride.DriverRidePassenger;

@Layout(2130903422)
public class DriverDialogs$QueuedRideDialog
  extends DriverDialogs
{
  private final List<DriverRidePassenger> passengers;
  
  public DriverDialogs$QueuedRideDialog(List<DriverRidePassenger> paramList)
  {
    passengers = paramList;
  }
  
  public List<DriverRidePassenger> getPassengers()
  {
    return passengers;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.QueuedRideDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */