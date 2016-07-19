package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;

@Controller(VehicleInspectionController.class)
@SingleInstance
public class SettingsScreens$VehicleInspectionScreen
  extends SettingsScreens.CarScreen
{
  public SettingsScreens$VehicleInspectionScreen(Vehicle paramVehicle)
  {
    super(paramVehicle);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.VehicleInspectionScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */