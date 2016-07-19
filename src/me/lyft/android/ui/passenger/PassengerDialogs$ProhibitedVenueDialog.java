package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.ui.passenger.v2.request.venue.ProhibitedVenueDialogController;

@Controller(ProhibitedVenueDialogController.class)
public class PassengerDialogs$ProhibitedVenueDialog
  extends PassengerDialogs
{
  private final String detail;
  private final boolean hasPickupSuggestion;
  private final String message;
  
  public PassengerDialogs$ProhibitedVenueDialog(String paramString1, String paramString2, boolean paramBoolean)
  {
    message = paramString1;
    detail = paramString2;
    hasPickupSuggestion = paramBoolean;
  }
  
  public String getDetail()
  {
    return detail;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public boolean hasPickupSuggestion()
  {
    return hasPickupSuggestion;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.ProhibitedVenueDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */