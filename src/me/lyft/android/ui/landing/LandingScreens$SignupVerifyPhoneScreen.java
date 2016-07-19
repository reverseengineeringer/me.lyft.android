package me.lyft.android.ui.landing;

import com.lyft.scoop.Controller;

@Controller(SignupVerifyPhoneController.class)
public class LandingScreens$SignupVerifyPhoneScreen
  extends LandingScreens
{
  final String phoneNumber;
  
  public LandingScreens$SignupVerifyPhoneScreen(String paramString)
  {
    phoneNumber = paramString;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LandingScreens.SignupVerifyPhoneScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */