package me.lyft.android.application.enterprise;

import com.lyft.android.api.dto.InviteRequestDTO;
import com.lyft.android.api.dto.OrganizationRequestDTO;
import com.lyft.android.api.dto.UserOrganizationDTO;
import me.lyft.android.ILyftPreferences;
import me.lyft.android.common.EmailUtils;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.enterprise.UserOrganization;
import me.lyft.android.domain.enterprise.UserOrganizationMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import me.lyft.android.infrastructure.lyft.LyftApiException;
import rx.Observable;
import rx.functions.Func1;

public class EnterpriseService
  implements IEnterpriseService
{
  static final String BUSINESS_PROFILE_CHANGE_SOURCE = "business_profile_change";
  static final String BUSINESS_PROFILE_SIGNUP_SOURCE = "business_profile_signup";
  private final ILyftApi lyftApi;
  private final ILyftPreferences preferences;
  
  public EnterpriseService(ILyftApi paramILyftApi, ILyftPreferences paramILyftPreferences)
  {
    lyftApi = paramILyftApi;
    preferences = paramILyftPreferences;
  }
  
  private <T> Observable<T> handleError(Throwable paramThrowable)
  {
    Throwable localThrowable = paramThrowable;
    Object localObject = localThrowable;
    if ((paramThrowable instanceof LyftApiException))
    {
      paramThrowable = (LyftApiException)paramThrowable;
      localObject = localThrowable;
      if (paramThrowable.getStatusCode() == 422)
      {
        localObject = localThrowable;
        if (EnterpriseException.containsWorkValidationError(paramThrowable)) {
          localObject = new EnterpriseException(paramThrowable);
        }
      }
    }
    return Observable.error((Throwable)localObject);
  }
  
  public Observable<UserOrganization> createUserOrganization(String paramString)
  {
    lyftApi.createUserOrganization(new OrganizationRequestDTO(paramString, "business_profile_signup")).map(new Func1()
    {
      public UserOrganization call(UserOrganizationDTO paramAnonymousUserOrganizationDTO)
      {
        return UserOrganizationMapper.fromDTO(paramAnonymousUserOrganizationDTO);
      }
    });
  }
  
  public String getEmail()
  {
    return preferences.getBusinessOnboardEmail();
  }
  
  public Observable<UserOrganization> getUserOrganization()
  {
    lyftApi.getUserOrganization().onErrorResumeNext(new Func1()
    {
      public Observable<? extends UserOrganizationDTO> call(Throwable paramAnonymousThrowable)
      {
        return EnterpriseService.this.handleError(paramAnonymousThrowable);
      }
    }).map(new Func1()
    {
      public UserOrganization call(UserOrganizationDTO paramAnonymousUserOrganizationDTO)
      {
        return UserOrganizationMapper.fromDTO(paramAnonymousUserOrganizationDTO);
      }
    });
  }
  
  public boolean isNewUserDescriptionShown()
  {
    return preferences.isBusinessOnboardNewUserDescriptionShown();
  }
  
  public Observable<Unit> sendEnterpriseInvites(InviteRequestDTO paramInviteRequestDTO)
  {
    lyftApi.sendEnterpriseInvites(paramInviteRequestDTO).onErrorResumeNext(new Func1()
    {
      public Observable<? extends Unit> call(Throwable paramAnonymousThrowable)
      {
        return EnterpriseService.this.handleError(paramAnonymousThrowable);
      }
    });
  }
  
  public void setEmail(String paramString)
  {
    preferences.setBusinessOnboardEmail(paramString);
  }
  
  public void setNewUserDescriptionShown()
  {
    preferences.setIsBusinessOnboardNewUserDescriptionShown(true);
  }
  
  public Observable<UserOrganization> updateUserOrganization(String paramString)
  {
    if (!EmailUtils.validateEmail(paramString)) {
      return handleError(new Throwable("Client detected Invalid email format"));
    }
    lyftApi.createUserOrganization(new OrganizationRequestDTO(paramString, "business_profile_change")).onErrorResumeNext(new Func1()
    {
      public Observable<? extends UserOrganizationDTO> call(Throwable paramAnonymousThrowable)
      {
        return EnterpriseService.this.handleError(paramAnonymousThrowable);
      }
    }).map(new Func1()
    {
      public UserOrganization call(UserOrganizationDTO paramAnonymousUserOrganizationDTO)
      {
        return UserOrganizationMapper.fromDTO(paramAnonymousUserOrganizationDTO);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.enterprise.EnterpriseService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */