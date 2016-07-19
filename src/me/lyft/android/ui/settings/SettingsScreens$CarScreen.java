package me.lyft.android.ui.settings;

import com.lyft.scoop.Controller;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.Vehicle;
import me.lyft.android.ui.driver.vehicles.CarController;

@Controller(CarController.class)
public class SettingsScreens$CarScreen
  extends SettingsScreens
{
  private Vehicle vehicle;
  private String vehicleId;
  
  public SettingsScreens$CarScreen(String paramString)
  {
    vehicleId = paramString;
  }
  
  public SettingsScreens$CarScreen(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
  
  public Vehicle getVehicle()
  {
    return (Vehicle)Objects.firstNonNull(vehicle, Vehicle.empty());
  }
  
  public String getVehicleId()
  {
    return (String)Objects.firstNonNull(vehicleId, "");
  }
  
  public void setVehicle(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.settings.SettingsScreens.CarScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */