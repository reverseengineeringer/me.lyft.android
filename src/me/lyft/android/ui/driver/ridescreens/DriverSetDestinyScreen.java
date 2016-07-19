package me.lyft.android.ui.driver.ridescreens;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.domain.location.Location;

@Controller(DriverSetDestinyController.class)
@DaggerModule(DriverSetDestinyModule.class)
public class DriverSetDestinyScreen
  extends Screen
{
  private final Location driverDestination;
  private boolean fromDispatchableScreen;
  
  public DriverSetDestinyScreen(Location paramLocation, boolean paramBoolean)
  {
    driverDestination = paramLocation;
    fromDispatchableScreen = paramBoolean;
  }
  
  public Location getDriverDestination()
  {
    return driverDestination;
  }
  
  public boolean isFromDispatchableScreen()
  {
    return fromDispatchableScreen;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.ridescreens.DriverSetDestinyScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */