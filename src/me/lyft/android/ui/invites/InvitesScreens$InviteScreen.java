package me.lyft.android.ui.invites;

import com.lyft.scoop.Controller;

@Controller(InviteController.class)
public class InvitesScreens$InviteScreen
  extends InvitesScreens
{
  InvitesScreens.InviteSource source;
  
  public InvitesScreens$InviteScreen(InvitesScreens.InviteSource paramInviteSource)
  {
    source = paramInviteSource;
  }
  
  public InvitesScreens.InviteSource getSource()
  {
    return source;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InvitesScreens.InviteScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */