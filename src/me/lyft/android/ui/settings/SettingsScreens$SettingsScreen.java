package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.Objects;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.domain.driver.Vehicle;

@Controller(SettingsController.class)
@SingleInstance
public class SettingsScreens$SettingsScreen
  extends SettingsScreens
{
  private Vehicle vehicle;
  
  public Vehicle getVehicle()
  {
    return (Vehicle)Objects.firstNonNull(vehicle, Vehicle.empty());
  }
  
  public void setVehicle(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.SettingsScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */