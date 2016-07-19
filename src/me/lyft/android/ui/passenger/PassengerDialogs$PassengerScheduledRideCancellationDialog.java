package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.domain.ride.ScheduledRide;
import me.lyft.android.ui.passenger.v2.scheduled.PassengerScheduledRideCancellationDialogController;

@Controller(PassengerScheduledRideCancellationDialogController.class)
public class PassengerDialogs$PassengerScheduledRideCancellationDialog
  extends PassengerDialogs
{
  private final ScheduledRide scheduledRide;
  
  public PassengerDialogs$PassengerScheduledRideCancellationDialog(ScheduledRide paramScheduledRide)
  {
    scheduledRide = paramScheduledRide;
  }
  
  public ScheduledRide getScheduledRide()
  {
    return scheduledRide;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.PassengerScheduledRideCancellationDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */