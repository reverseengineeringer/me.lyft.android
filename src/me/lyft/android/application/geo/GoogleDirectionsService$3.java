package me.lyft.android.application.geo;

import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import rx.Notification;
import rx.functions.Action1;

class GoogleDirectionsService$3
  implements Action1<Notification<? super GoogleDirectionsResponseDTO>>
{
  GoogleDirectionsService$3(GoogleDirectionsService paramGoogleDirectionsService) {}
  
  public void call(Notification<? super GoogleDirectionsResponseDTO> paramNotification)
  {
    if (paramNotification.isOnNext()) {
      GoogleDirectionsService.access$100(this$0).trackDirectionsSuccess();
    }
    while (!paramNotification.isOnError()) {
      return;
    }
    GoogleDirectionsService.access$100(this$0).trackDirectionsFailure(paramNotification.getThrowable());
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleDirectionsService.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */