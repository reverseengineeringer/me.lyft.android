package me.lyft.android.application.geo;

import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.Notification;
import rx.functions.Action1;

class ReverseGeocodeService$3
  implements Action1<Notification<? super GoogleGeocodeResponseDTO>>
{
  ReverseGeocodeService$3(ReverseGeocodeService paramReverseGeocodeService) {}
  
  public void call(Notification<? super GoogleGeocodeResponseDTO> paramNotification)
  {
    if (paramNotification.isOnNext()) {
      ReverseGeocodeService.access$100(this$0).trackReverseGeocodeSuccess();
    }
    while (!paramNotification.isOnError()) {
      return;
    }
    ReverseGeocodeService.access$100(this$0).trackReverseGeocodeFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.ReverseGeocodeService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */