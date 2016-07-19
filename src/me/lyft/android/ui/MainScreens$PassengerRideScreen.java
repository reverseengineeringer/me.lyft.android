package me.lyft.android.ui;

import com.lyft.scoop.Layout;
import com.lyft.scoop.Screen;
import com.lyft.scoop.dagger.DaggerModule;
import me.lyft.android.common.Objects;
import me.lyft.android.common.SingleInstance;
import me.lyft.android.ui.ride.PassengerRideModule;

@Layout(2130903360)
@DaggerModule(PassengerRideModule.class)
@SingleInstance
public class MainScreens$PassengerRideScreen
  extends Screen
{
  private String webDialogUrl;
  
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
      paramObject = (PassengerRideScreen)paramObject;
    } while (Objects.equals(webDialogUrl, webDialogUrl));
    return false;
  }
  
  public String getWebDialogParams()
  {
    return webDialogUrl;
  }
  
  public void resetWebDialogUrl()
  {
    webDialogUrl = null;
  }
  
  public PassengerRideScreen setWebDialogUrl(String paramString)
  {
    webDialogUrl = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.MainScreens.PassengerRideScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */