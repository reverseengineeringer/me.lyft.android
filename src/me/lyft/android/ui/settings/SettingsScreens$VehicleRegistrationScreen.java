package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;

@Controller(VehicleRegistrationController.class)
@SingleInstance
public class SettingsScreens$VehicleRegistrationScreen
  extends SettingsScreens.CarScreen
{
  public SettingsScreens$VehicleRegistrationScreen(Vehicle paramVehicle)
  {
    super(paramVehicle);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.VehicleRegistrationScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */