package me.lyft.android.domain.enterprise;

import me.lyft.android.common.INullable;
import me.lyft.android.domain.invite.InviteText;

public class UserOrganization
  implements INullable
{
  private InviteText inviteText;
  private Organization organization;
  
  public UserOrganization(Organization paramOrganization, InviteText paramInviteText)
  {
    organization = paramOrganization;
    inviteText = paramInviteText;
  }
  
  public static UserOrganization empty()
  {
    return NullUserOrganization.INSTANCE;
  }
  
  public InviteText getInviteText()
  {
    return inviteText;
  }
  
  public Organization getOrganization()
  {
    return organization;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public static class NullUserOrganization
    extends UserOrganization
  {
    private static final UserOrganization INSTANCE = new NullUserOrganization();
    
    public NullUserOrganization()
    {
      super(InviteText.empty());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.UserOrganization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */