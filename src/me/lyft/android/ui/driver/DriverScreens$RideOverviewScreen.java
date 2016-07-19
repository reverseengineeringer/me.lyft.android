package me.lyft.android.ui.driver;

import com.lyft.scoop.Layout;

@Layout(2130903429)
public class DriverScreens$RideOverviewScreen
  extends DriverScreens
{
  private final Boolean isNetworkError;
  
  public DriverScreens$RideOverviewScreen(boolean paramBoolean)
  {
    isNetworkError = Boolean.valueOf(paramBoolean);
  }
  
  public Boolean isNetworkError()
  {
    return isNetworkError;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.ui.driver.DriverScreens.RideOverviewScreen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */