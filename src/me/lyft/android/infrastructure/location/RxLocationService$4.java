package me.lyft.android.infrastructure.location;

import android.location.Location;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.maps.GoogleLocationMapper;
import rx.Subscriber;

class RxLocationService$4
  implements LocationCallback
{
  RxLocationService$4(RxLocationService paramRxLocationService, Subscriber paramSubscriber) {}
  
  public void onError(String paramString, int paramInt) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (paramLocation == null) {
      val$subscriber.onNext(NullLocation.getInstance());
    }
    for (;;)
    {
      val$subscriber.onCompleted();
      return;
      val$subscriber.onNext(GoogleLocationMapper.toDomainLocation(paramLocation));
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.location.RxLocationService.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */