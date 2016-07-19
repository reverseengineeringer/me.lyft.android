package me.lyft.android.application.enterprise;

import com.lyft.android.api.dto.UserOrganizationDTO;
import rx.Observable;
import rx.functions.Func1;

class EnterpriseService$5
  implements Func1<Throwable, Observable<? extends UserOrganizationDTO>>
{
  EnterpriseService$5(EnterpriseService paramEnterpriseService) {}
  
  public Observable<? extends UserOrganizationDTO> call(Throwable paramThrowable)
  {
    return EnterpriseService.access$000(this$0, paramThrowable);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.EnterpriseService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */