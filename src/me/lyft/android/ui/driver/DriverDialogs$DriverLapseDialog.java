package me.lyft.android.ui.driver;

import com.lyft.scoop.Controller;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.ui.driver.ridescreens.DriverLapseDialogController;

@Controller(DriverLapseDialogController.class)
@DaggerModule(DriverModule.class)
public class DriverDialogs$DriverLapseDialog
  extends DriverDialogs
{}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverDialogs.DriverLapseDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */