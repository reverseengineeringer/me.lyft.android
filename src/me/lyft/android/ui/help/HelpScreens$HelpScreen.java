package me.lyft.android.ui.help;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;

@Controller(HelpController.class)
@DaggerModule(HelpModule.class)
public class HelpScreens$HelpScreen
  extends HelpScreens
{
  private final boolean disableMenu;
  
  public HelpScreens$HelpScreen()
  {
    disableMenu = false;
  }
  
  public HelpScreens$HelpScreen(boolean paramBoolean)
  {
    disableMenu = paramBoolean;
  }
  
  public boolean disableMenu()
  {
    return disableMenu;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.help.HelpScreens.HelpScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */