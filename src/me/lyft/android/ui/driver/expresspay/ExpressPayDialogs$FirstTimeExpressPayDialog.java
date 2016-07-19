package me.lyft.android.ui.driver.expresspay;

import com.lyft.scoop.Layout;
import me.lyft.android.ui.driver.DriverScreens.DriverSettingsEarningsScreen;
import me.lyft.android.ui.driver.DriverScreens.DriverStatsScreen;

@Layout(2130903227)
public class ExpressPayDialogs$FirstTimeExpressPayDialog
  extends ExpressPayDialogs.ExpressPayDialog
{
  public ExpressPayDialogs$FirstTimeExpressPayDialog(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    setMessage(paramString2);
    setTitleIcon(Integer.valueOf(2130838077));
    setTitle(paramString1);
    setButtonText(paramString3);
    if (paramBoolean) {}
    for (paramString1 = new DriverScreens.DriverSettingsEarningsScreen();; paramString1 = new DriverScreens.DriverStatsScreen())
    {
      setTargetScreen(paramString1);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.expresspay.ExpressPayDialogs.FirstTimeExpressPayDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */