package me.lyft.android.jobs;

import com.crashlytics.android.Crashlytics;
import com.lyft.android.api.dto.UniversalDTO;
import com.lyft.android.api.dto.UserDTO;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.application.payment.ICouponService;
import me.lyft.android.application.profile.IProfileService;
import me.lyft.android.application.ride.IUserUiService;
import me.lyft.android.domain.User;
import me.lyft.android.domain.UserMapper;
import me.lyft.android.domain.driver.UiState;
import me.lyft.android.domain.payment.CreditMapper;
import me.lyft.android.domain.profile.Profile;
import me.lyft.android.domain.profile.ProfileMapper;

public class UserUpdateJob
  implements Job
{
  @Inject
  ICouponService couponService;
  @Inject
  IProfileService profileService;
  private final UniversalDTO universalDTO;
  @Inject
  IUserProvider userProvider;
  @Inject
  IUserUiService userUiService;
  
  public UserUpdateJob(UniversalDTO paramUniversalDTO)
  {
    universalDTO = paramUniversalDTO;
  }
  
  private void setAuthorized(User paramUser)
  {
    if (paramUser.isUnauthorized())
    {
      Crashlytics.setString("user_authorized", "unauthorized");
      return;
    }
    Crashlytics.setString("user_authorized", "authorized");
  }
  
  private void setDispatchable(User paramUser)
  {
    if (paramUser.isDispatchable())
    {
      Crashlytics.setString("user_dispatchable", "online");
      return;
    }
    Crashlytics.setString("user_dispatchable", "offline");
  }
  
  private void setUiState()
  {
    if (userUiService.getUiState().isDriverUi())
    {
      Crashlytics.setString("user_ui", "driver");
      return;
    }
    Crashlytics.setString("user_ui", "passenger");
  }
  
  private void updateCrashlyticsData(User paramUser)
  {
    setUiState();
    setDispatchable(paramUser);
    setAuthorized(paramUser);
  }
  
  public void execute()
    throws Throwable
  {
    if (universalDTO == null) {
      return;
    }
    Object localObject = universalDTO.user;
    User localUser;
    List localList;
    if (localObject != null)
    {
      localUser = UserMapper.fromUserDTO((UserDTO)localObject);
      localList = CreditMapper.fromCreditDTO(credits);
      localObject = ProfileMapper.fromUserDTO((UserDTO)localObject);
      profileService.updateMyProfile((Profile)localObject);
    }
    for (;;)
    {
      userProvider.updateUser(localUser);
      couponService.updateCredits(localList);
      userUiService.validateUiState();
      updateCrashlyticsData(localUser);
      return;
      localUser = User.empty();
      localList = Collections.emptyList();
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UserUpdateJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */