package me.lyft.android.ui.help;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(HelpTermsController.class)
@DaggerModule(HelpModule.class)
public class HelpScreens$HelpTermsScreen
  extends HelpScreens
{
  private final boolean showPrivacyTerms;
  
  public HelpScreens$HelpTermsScreen(boolean paramBoolean)
  {
    showPrivacyTerms = paramBoolean;
  }
  
  public boolean showPrivacyTerms()
  {
    return showPrivacyTerms;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.help.HelpScreens.HelpTermsScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */