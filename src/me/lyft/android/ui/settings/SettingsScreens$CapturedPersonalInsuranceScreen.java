package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;

@Controller(CapturedPersonalInsuranceController.class)
@SingleInstance
public class SettingsScreens$CapturedPersonalInsuranceScreen
  extends SettingsScreens.CarScreen
{
  public SettingsScreens$CapturedPersonalInsuranceScreen(Vehicle paramVehicle)
  {
    super(paramVehicle);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.CapturedPersonalInsuranceScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */