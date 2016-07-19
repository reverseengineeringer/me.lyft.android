package me.lyft.android.ui.driver;

import com.lyft.scoop.Controller;
import me.lyft.android.domain.ats.DriverApplication;

@Controller(DriverApplicationDialogController.class)
public class DriverDialogs$DriverApplicationDialog
  extends DriverDialogs
{
  private final DriverApplication driverApplication;
  
  public DriverDialogs$DriverApplicationDialog(DriverApplication paramDriverApplication)
  {
    driverApplication = paramDriverApplication;
  }
  
  public DriverApplication getDriverApplication()
  {
    return driverApplication;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.DriverApplicationDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */