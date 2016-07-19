package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;
import me.lyft.android.ui.passenger.v2.request.dialogs.CarpoolDriverAboutDialogController;

@Controller(CarpoolDriverAboutDialogController.class)
public class PassengerDialogs$AboutCarpoolDriversDialog
  extends PassengerDialogs
{
  private String termsUrl;
  
  public PassengerDialogs$AboutCarpoolDriversDialog(String paramString)
  {
    termsUrl = paramString;
  }
  
  public String getTermsUrl()
  {
    return termsUrl;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.AboutCarpoolDriversDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */