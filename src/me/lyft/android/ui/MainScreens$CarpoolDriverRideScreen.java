package me.lyft.android.ui;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.ui.driver.carpool.DriverCarpoolRidesModule;
import me.lyft.android.ui.driver.carpool.screens.CarpoolDriverRideController;

@Controller(CarpoolDriverRideController.class)
@DaggerModule(DriverCarpoolRidesModule.class)
@SingleInstance
public class MainScreens$CarpoolDriverRideScreen
  extends Screen
{}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens.CarpoolDriverRideScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */