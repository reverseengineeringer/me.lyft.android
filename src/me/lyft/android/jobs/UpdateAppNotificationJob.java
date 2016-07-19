package me.lyft.android.jobs;

import javax.inject.Inject;
import me.lyft.android.infrastructure.notifications.InAppNotificationService;

public class UpdateAppNotificationJob
  implements Job
{
  @Inject
  InAppNotificationService inAppNotificationService;
  
  public void execute()
    throws Throwable
  {
    inAppNotificationService.fetchNotifications();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.jobs.UpdateAppNotificationJob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */