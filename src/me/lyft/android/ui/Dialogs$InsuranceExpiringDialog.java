package me.lyft.android.ui;

import com.lyft.scoop.Layout;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.driver.Vehicle;

@Layout(2130903252)
public class Dialogs$InsuranceExpiringDialog
  extends Dialogs
{
  private boolean attemptEnterDriverMode;
  private Vehicle vehicle;
  
  public Dialogs$InsuranceExpiringDialog(Vehicle paramVehicle)
  {
    vehicle = paramVehicle;
  }
  
  public boolean getAttemptEnterDriverMode()
  {
    return attemptEnterDriverMode;
  }
  
  public Vehicle getVehicle()
  {
    return (Vehicle)Objects.firstNonNull(vehicle, Vehicle.empty());
  }
  
  public InsuranceExpiringDialog setAttemptEnterDriverMode(boolean paramBoolean)
  {
    attemptEnterDriverMode = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.Dialogs.InsuranceExpiringDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */