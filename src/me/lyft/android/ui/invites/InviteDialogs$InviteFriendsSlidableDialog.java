package me.lyft.android.ui.invites;

import com.lyft.scoop.Layout;
import me.lyft.android.domain.invite.Invite;

@Layout(2130903256)
public class InviteDialogs$InviteFriendsSlidableDialog
  extends InviteDialogs
{
  private final Invite invite;
  private final InviteType inviteType;
  
  public InviteDialogs$InviteFriendsSlidableDialog(Invite paramInvite, InviteType paramInviteType)
  {
    invite = paramInvite;
    inviteType = paramInviteType;
  }
  
  public Invite getInvite()
  {
    return invite;
  }
  
  public InviteType getInviteType()
  {
    return inviteType;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.invites.InviteDialogs.InviteFriendsSlidableDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */