package me.lyft.android.ui.landing;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.ui.MainScreens;
import me.lyft.android.ui.development.EnvironmentSwitcherViewController;

public class LandingScreens
  extends MainScreens
{
  @Controller(CountryPickerController.class)
  public static class CountryPickerScreen
    extends LandingScreens
  {}
  
  @Controller(EnvironmentSwitcherViewController.class)
  public static class EnvironmentSwitcherScreen
    extends LandingScreens
  {}
  
  @Controller(IntroductionViewController.class)
  public static class IntroductionScreen
    extends Screen
  {}
  
  @Controller(LoginCreditCardChallengeController.class)
  public static class LoginCreditCardChallengeScreen
    extends LandingScreens
  {}
  
  @Controller(LoginDriverLicenseChallengeController.class)
  public static class LoginDriverLicenseChallengeScreen
    extends LandingScreens
  {}
  
  @Controller(LoginEnterInfoController.class)
  public static class LoginEnterInfoScreen
    extends LandingScreens
  {}
  
  @Controller(LoginPhoneController.class)
  public static class LoginPhoneScreen
    extends LandingScreens
  {}
  
  @Controller(LoginViewController.class)
  public static class LoginScreen
    extends LandingScreens
  {}
  
  @Controller(LoginVerifyPhoneController.class)
  public static class LoginVerifyPhoneScreen
    extends LandingScreens
  {
    final String phoneNumber;
    
    public LoginVerifyPhoneScreen(String paramString)
    {
      phoneNumber = paramString;
    }
    
    public String getPhoneNumber()
    {
      return phoneNumber;
    }
  }
  
  @Controller(SignupEnterInfoController.class)
  public static class SignupEnterInfoScreen
    extends LandingScreens
  {
    final boolean forceNewUser;
    
    public SignupEnterInfoScreen(boolean paramBoolean)
    {
      forceNewUser = paramBoolean;
    }
  }
  
  @Controller(SignupPhoneController.class)
  public static class SignupPhoneScreen
    extends LandingScreens
  {}
  
  @Controller(SignupViewController.class)
  public static class SignupScreen
    extends LandingScreens
  {}
  
  @Controller(SignupVerifyPhoneController.class)
  public static class SignupVerifyPhoneScreen
    extends LandingScreens
  {
    final String phoneNumber;
    
    public SignupVerifyPhoneScreen(String paramString)
    {
      phoneNumber = paramString;
    }
    
    public String getPhoneNumber()
    {
      return phoneNumber;
    }
  }
  
  @Controller(StarterViewController.class)
  @SingleInstance
  public static class StarterScreen
    extends LandingScreens
  {}
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.landing.LandingScreens
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */