package me.lyft.android.ui.profile;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(UpdatePassengerPhotoFromEditProfileController.class)
@DaggerModule(ProfileModule.class)
public class ProfileScreens$UpdatePassengerPhotoFromEditProfileScreen
  extends ProfileScreens.EditProfileScreen
{
  public ProfileScreens$UpdatePassengerPhotoFromEditProfileScreen(EditProfileSession paramEditProfileSession)
  {
    super(paramEditProfileSession);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileScreens.UpdatePassengerPhotoFromEditProfileScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */