package me.lyft.android.infrastructure.location;

import android.location.Location;
import me.lyft.android.application.features.Features;
import me.lyft.android.application.features.IFeaturesProvider;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.maps.GoogleLocationMapper;
import rx.Subscriber;

class RxLocationService$5
  implements LocationCallback
{
  RxLocationService$5(RxLocationService paramRxLocationService, Subscriber paramSubscriber) {}
  
  public void onError(String paramString, int paramInt) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (RxLocationService.access$600(this$0).isEnabled(Features.USE_ANDROID_LOCATION_MANAGER)) {
      val$subscriber.onNext(GoogleLocationMapper.toDomainLocation(paramLocation));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */