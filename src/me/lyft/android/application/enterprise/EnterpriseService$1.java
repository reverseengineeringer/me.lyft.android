package me.lyft.android.application.enterprise;

import com.lyft.android.api.dto.UserOrganizationDTO;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.domain.enterprise.UserOrganizationMapper;
import rx.functions.Func1;

class EnterpriseService$1
  implements Func1<UserOrganizationDTO, UserOrganization>
{
  EnterpriseService$1(EnterpriseService paramEnterpriseService) {}
  
  public UserOrganization call(UserOrganizationDTO paramUserOrganizationDTO)
  {
    return UserOrganizationMapper.fromDTO(paramUserOrganizationDTO);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.EnterpriseService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */