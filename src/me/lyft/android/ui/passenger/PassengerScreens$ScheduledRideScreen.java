package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.ui.passenger.v2.scheduled.ScheduledRideModule;
import me.lyft.android.ui.passenger.v2.scheduled.ScheduledRideViewController;

@Controller(ScheduledRideViewController.class)
@DaggerModule(ScheduledRideModule.class)
public class PassengerScreens$ScheduledRideScreen
  extends PassengerScreens
{
  private final ScheduledRide scheduledRide;
  
  public PassengerScreens$ScheduledRideScreen(ScheduledRide paramScheduledRide)
  {
    scheduledRide = paramScheduledRide;
  }
  
  public ScheduledRide getScheduledRide()
  {
    return scheduledRide;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerScreens.ScheduledRideScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */