package me.lyft.android.ui;

import com.lyft.scoop.Controller;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.common.Objects;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.ui.driver.ridescreens.DriverRideController;
import me.lyft.android.ui.driver.ridescreens.DriverRideModule;

@Controller(DriverRideController.class)
@DaggerModule(DriverRideModule.class)
@SingleInstance
public class MainScreens$DriverRideScreen
  extends Screen
{
  private boolean goOffline;
  private boolean goOnline;
  private String webDialogUrl;
  
  public DriverRideScreen enableGoOffline()
  {
    goOffline = true;
    return this;
  }
  
  public DriverRideScreen enableGoOnline()
  {
    goOnline = true;
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (DriverRideScreen)paramObject;
    } while ((goOnline == goOnline) && (goOffline == goOffline) && (Objects.equals(webDialogUrl, webDialogUrl)));
    return false;
  }
  
  public String getWebDialogParams()
  {
    return webDialogUrl;
  }
  
  public boolean isGoOffline()
  {
    return goOffline;
  }
  
  public boolean isGoOnline()
  {
    return goOnline;
  }
  
  public void resetSwitchToDriverMode()
  {
    goOnline = false;
  }
  
  public void resetSwitchToPassengerMode()
  {
    goOffline = false;
  }
  
  public void resetWebDialogUrl()
  {
    webDialogUrl = null;
  }
  
  public DriverRideScreen setWebDialogUrl(String paramString)
  {
    webDialogUrl = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens.DriverRideScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */