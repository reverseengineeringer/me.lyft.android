package me.lyft.android.application.enterprise;

import com.lyft.android.api.dto.InviteRequestDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.enterprise.UserOrganization;
import rx.Observable;

public abstract interface IEnterpriseService
{
  public abstract Observable<UserOrganization> createUserOrganization(String paramString);
  
  public abstract String getEmail();
  
  public abstract Observable<UserOrganization> getUserOrganization();
  
  public abstract boolean isNewUserDescriptionShown();
  
  public abstract Observable<Unit> sendEnterpriseInvites(InviteRequestDTO paramInviteRequestDTO);
  
  public abstract void setEmail(String paramString);
  
  public abstract void setNewUserDescriptionShown();
  
  public abstract Observable<UserOrganization> updateUserOrganization(String paramString);
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.IEnterpriseService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */