package me.lyft.android.application.geo;

import rx.Notification;
import rx.functions.Action1;

class GeoService$5
  implements Action1<Notification<? super Long>>
{
  GeoService$5(GeoService paramGeoService) {}
  
  public void call(Notification<? super Long> paramNotification)
  {
    if (paramNotification.isOnNext()) {
      GeoService.access$200(this$0).trackEtaSuccess();
    }
    while (!paramNotification.isOnError()) {
      return;
    }
    GeoService.access$200(this$0).trackEtaFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */