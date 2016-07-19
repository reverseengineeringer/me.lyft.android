package me.lyft.android.ui.driver;

import com.lyft.scoop.Controller;
import java.util.List;
import me.lyft.android.ui.driver.carpool.DriverDeclineRideDialogController;

@Controller(DriverDeclineRideDialogController.class)
public class DriverDialogs$DeclineRideDialog
  extends DriverDialogs
{
  private List<String> passengerPhotoUrls;
  private List<String> rideIds;
  
  public DriverDialogs$DeclineRideDialog(List<String> paramList1, List<String> paramList2)
  {
    passengerPhotoUrls = paramList1;
    rideIds = paramList2;
  }
  
  public List<String> getPassengerPhotoUrls()
  {
    return passengerPhotoUrls;
  }
  
  public List<String> getRideIds()
  {
    return rideIds;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.DeclineRideDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */