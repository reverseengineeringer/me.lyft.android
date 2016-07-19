package me.lyft.android.infrastructure.notifications;

import com.jakewharton.rxrelay.BehaviorRelay;
import com.lyft.android.api.dto.NotificationsDTO;
import me.lyft.android.common.Unit;
import me.lyft.android.rx.AsyncCall;

class InAppNotificationService$2
  extends AsyncCall<NotificationsDTO>
{
  InAppNotificationService$2(InAppNotificationService paramInAppNotificationService) {}
  
  public void onSuccess(NotificationsDTO paramNotificationsDTO)
  {
    super.onSuccess(paramNotificationsDTO);
    InAppNotificationService.access$000(this$0, paramNotificationsDTO);
    InAppNotificationService.access$100(this$0).call(Unit.create());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.notifications.InAppNotificationService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */