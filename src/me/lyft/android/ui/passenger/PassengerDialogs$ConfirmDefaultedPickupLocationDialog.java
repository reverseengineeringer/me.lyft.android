package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;

@Controller(ConfirmDefaultedPickupLocationDialogController.class)
public class PassengerDialogs$ConfirmDefaultedPickupLocationDialog
  extends PassengerDialogs
{
  private final String address;
  
  public PassengerDialogs$ConfirmDefaultedPickupLocationDialog(String paramString)
  {
    address = paramString;
  }
  
  public String getAddress()
  {
    return address;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.ConfirmDefaultedPickupLocationDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */