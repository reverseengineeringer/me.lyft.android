package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.domain.location.Location;

@Controller(LockedAddressDialogController.class)
public class PassengerDialogs$LockAddressDialog
  extends PassengerDialogs
{
  private final boolean isPickup;
  private final Location location;
  private final boolean passengerCancel;
  
  public PassengerDialogs$LockAddressDialog(Location paramLocation, boolean paramBoolean1, boolean paramBoolean2)
  {
    location = paramLocation;
    isPickup = paramBoolean1;
    passengerCancel = paramBoolean2;
  }
  
  public boolean canPassengerCancel()
  {
    return passengerCancel;
  }
  
  public Location getLocation()
  {
    return location;
  }
  
  public boolean isPickup()
  {
    return isPickup;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.LockAddressDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */