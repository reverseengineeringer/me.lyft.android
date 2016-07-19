package me.lyft.android.ui.passenger;

import com.lyft.scoop.Controller;

@Controller(PostRideSocialDialogController.class)
public class PassengerDialogs$PostRideSocialShareDialog
  extends PassengerDialogs
{
  private final boolean isInvitesSentDialog;
  
  public PassengerDialogs$PostRideSocialShareDialog(boolean paramBoolean)
  {
    isInvitesSentDialog = paramBoolean;
  }
  
  public boolean isInvitesSentDialog()
  {
    return isInvitesSentDialog;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.passenger.PassengerDialogs.PostRideSocialShareDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */