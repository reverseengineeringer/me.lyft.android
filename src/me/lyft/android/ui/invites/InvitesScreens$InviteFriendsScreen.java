package me.lyft.android.ui.invites;

import com.lyft.scoop.Controller;

@Controller(InviteControllerV2.class)
public class InvitesScreens$InviteFriendsScreen
  extends InvitesScreens
{
  InvitesScreens.InviteSource source;
  
  public InvitesScreens$InviteFriendsScreen(InvitesScreens.InviteSource paramInviteSource)
  {
    source = paramInviteSource;
  }
  
  public InvitesScreens.InviteSource getSource()
  {
    return source;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InvitesScreens.InviteFriendsScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */