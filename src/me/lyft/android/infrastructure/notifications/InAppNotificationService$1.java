package me.lyft.android.infrastructure.notifications;

import me.lyft.android.common.Unit;
import rx.functions.Action1;

class InAppNotificationService$1
  implements Action1<Unit>
{
  InAppNotificationService$1(InAppNotificationService paramInAppNotificationService, String paramString) {}
  
  public void call(Unit paramUnit)
  {
    this$0.showNotificationIfAvailable(val$eventName);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.notifications.InAppNotificationService.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */