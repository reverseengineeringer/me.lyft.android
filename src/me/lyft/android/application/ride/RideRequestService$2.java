package me.lyft.android.application.ride;

import me.lyft.android.analytics.core.ActionAnalytics;
import me.lyft.android.common.Unit;
import rx.Notification;
import rx.functions.Action1;

class RideRequestService$2
  implements Action1<Notification<? super Unit>>
{
  RideRequestService$2(RideRequestService paramRideRequestService, ActionAnalytics paramActionAnalytics) {}
  
  public void call(Notification<? super Unit> paramNotification)
  {
    RideRequestService.access$000(this$0).setRideRequestInProgress(false);
    if (paramNotification.isOnNext()) {
      val$requestRideAction.trackSuccess();
    }
    while (!paramNotification.isOnError()) {
      return;
    }
    val$requestRideAction.trackFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.RideRequestService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */