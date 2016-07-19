package me.lyft.android.ui.landing;

import com.lyft.scoop.Controller;

@Controller(LoginVerifyPhoneController.class)
public class LandingScreens$LoginVerifyPhoneScreen
  extends LandingScreens
{
  final String phoneNumber;
  
  public LandingScreens$LoginVerifyPhoneScreen(String paramString)
  {
    phoneNumber = paramString;
  }
  
  public String getPhoneNumber()
  {
    return phoneNumber;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LandingScreens.LoginVerifyPhoneScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */