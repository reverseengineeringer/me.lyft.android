package me.lyft.android.flows;

import javax.inject.Inject;
import me.lyft.android.application.IUserProvider;
import me.lyft.android.common.AppFlow;
import me.lyft.android.domain.User;
import me.lyft.android.ui.profile.ProfileScreens.DriverMyProfileScreen;
import me.lyft.android.ui.profile.ProfileScreens.PassengerMyProfileScreen;
import me.lyft.android.ui.profile.ProfileScreens.PassengerRideProfileScreen;

public class ProfileFlow
{
  @Inject
  AppFlow appFlow;
  @Inject
  IUserProvider userProvider;
  
  public void openMyPassengerRideProfile()
  {
    appFlow.goTo(new ProfileScreens.PassengerMyProfileScreen().setFromRide(true));
  }
  
  public void openMyProfile()
  {
    if (userProvider.getUser().isApprovedDriver())
    {
      appFlow.goTo(new ProfileScreens.DriverMyProfileScreen());
      return;
    }
    appFlow.goTo(new ProfileScreens.PassengerMyProfileScreen());
  }
  
  public void openPassengerRideProfile(String paramString)
  {
    appFlow.goTo(new ProfileScreens.PassengerRideProfileScreen(paramString));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.flows.ProfileFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */