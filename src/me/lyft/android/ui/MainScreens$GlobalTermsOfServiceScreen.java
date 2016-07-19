package me.lyft.android.ui;

import com.lyft.scoop.Controller;
import me.lyft.android.domain.User;

@Controller(GlobalTermsOfServiceController.class)
public class MainScreens$GlobalTermsOfServiceScreen
  extends MainScreens
{
  public final String onboardingUrl;
  public final String termsOfServiceUrl;
  
  public MainScreens$GlobalTermsOfServiceScreen(User paramUser)
  {
    onboardingUrl = paramUser.getOnboardingUrl();
    termsOfServiceUrl = paramUser.getTermsUrl();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens.GlobalTermsOfServiceScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */