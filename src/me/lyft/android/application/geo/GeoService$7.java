package me.lyft.android.application.geo;

import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.Notification;
import rx.functions.Action1;

class GeoService$7
  implements Action1<Notification<? super GoogleGeocodeResponseDTO>>
{
  GeoService$7(GeoService paramGeoService) {}
  
  public void call(Notification<? super GoogleGeocodeResponseDTO> paramNotification)
  {
    if (paramNotification.isOnNext()) {
      GeoService.access$200(this$0).trackAddressLookupSuccess();
    }
    while (!paramNotification.isOnError()) {
      return;
    }
    GeoService.access$200(this$0).trackAddressLookupFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */