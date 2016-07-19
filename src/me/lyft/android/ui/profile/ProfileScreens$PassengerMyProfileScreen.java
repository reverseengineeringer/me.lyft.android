package me.lyft.android.ui.profile;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(PassengerMyProfileController.class)
@DaggerModule(ProfileModule.class)
public class ProfileScreens$PassengerMyProfileScreen
  extends ProfileScreens
{
  private boolean fromRide;
  
  public boolean isFromRide()
  {
    return fromRide;
  }
  
  public PassengerMyProfileScreen setFromRide(boolean paramBoolean)
  {
    fromRide = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileScreens.PassengerMyProfileScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */