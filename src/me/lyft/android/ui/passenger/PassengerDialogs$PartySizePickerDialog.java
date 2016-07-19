package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.common.IHasName;

@Controller(PartySizePickerDialogController.class)
public class PassengerDialogs$PartySizePickerDialog
  extends PassengerDialogs
  implements IHasName
{
  public String getName()
  {
    return "select_number_of_passengers_dialog";
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.PartySizePickerDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */