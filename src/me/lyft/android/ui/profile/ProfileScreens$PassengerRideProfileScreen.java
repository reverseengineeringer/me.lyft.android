package me.lyft.android.ui.profile;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(PassengerRideProfileController.class)
@DaggerModule(ProfileModule.class)
public class ProfileScreens$PassengerRideProfileScreen
  extends ProfileScreens
{
  public final String passengerId;
  
  public ProfileScreens$PassengerRideProfileScreen(String paramString)
  {
    passengerId = paramString;
  }
  
  public String getPassengerId()
  {
    return passengerId;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileScreens.PassengerRideProfileScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */