package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.ui.dialogs.RateCardDialogController;

@Controller(RateCardDialogController.class)
public class PassengerDialogs$RideTypeInfoDialog
  extends PassengerDialogs
{
  String rideTypeId;
  
  public PassengerDialogs$RideTypeInfoDialog(String paramString)
  {
    rideTypeId = paramString;
  }
  
  public String getRideTypeId()
  {
    return rideTypeId;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.RideTypeInfoDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */