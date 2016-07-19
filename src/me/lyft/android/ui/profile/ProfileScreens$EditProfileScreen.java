package me.lyft.android.ui.profile;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.common.Preconditions;

@Controller(EditProfileController.class)
@DaggerModule(ProfileModule.class)
public class ProfileScreens$EditProfileScreen
  extends ProfileScreens
{
  private EditProfileSession editProfileSession;
  
  public ProfileScreens$EditProfileScreen()
  {
    editProfileSession = new EditProfileSession();
  }
  
  protected ProfileScreens$EditProfileScreen(EditProfileSession paramEditProfileSession)
  {
    Preconditions.checkNotNull(paramEditProfileSession);
    editProfileSession = paramEditProfileSession;
  }
  
  public EditProfileSession getEditProfileSession()
  {
    return editProfileSession;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.profile.ProfileScreens.EditProfileScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */