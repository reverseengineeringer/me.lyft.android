package me.lyft.android.common;

import com.lyft.scoop.RouteChange;
import com.lyft.scoop.Screen;
import rx.Observable;

public class DriverFlow
{
  private final AppFlow driverRouter;
  
  public DriverFlow(AppFlow paramAppFlow)
  {
    driverRouter = paramAppFlow;
  }
  
  public void clearAndShow(Screen paramScreen)
  {
    driverRouter.replaceAllWith(new Screen[] { paramScreen });
  }
  
  public boolean dismiss()
  {
    return driverRouter.goBack();
  }
  
  public boolean hasActiveScreen()
  {
    return driverRouter.hasActiveScreen();
  }
  
  public Observable<RouteChange> observeDriverScreenChange()
  {
    return driverRouter.observeRouteChange();
  }
  
  public void show(Screen paramScreen)
  {
    driverRouter.resetTo(paramScreen);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.common.DriverFlow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */