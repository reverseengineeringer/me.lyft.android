package me.lyft.android.domain.enterprise;

import me.lyft.android.domain.invite.InviteText;

public class UserOrganization$NullUserOrganization
  extends UserOrganization
{
  private static final UserOrganization INSTANCE = new NullUserOrganization();
  
  public UserOrganization$NullUserOrganization()
  {
    super(Organization.empty(), InviteText.empty());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.enterprise.UserOrganization.NullUserOrganization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */