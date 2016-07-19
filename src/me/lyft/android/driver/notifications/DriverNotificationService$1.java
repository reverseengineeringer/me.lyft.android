package me.lyft.android.driver.notifications;

import me.lyft.android.domain.location.Location;
import me.lyft.android.navigation.Navigator;

class DriverNotificationService$1
  implements Runnable
{
  DriverNotificationService$1(DriverNotificationService paramDriverNotificationService, Location paramLocation) {}
  
  public void run()
  {
    DriverNotificationService.access$000(this$0).navigate(val$location);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.driver.notifications.DriverNotificationService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */