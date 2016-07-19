package me.lyft.android.maps;

import com.lyft.googlemaps.core.callback.Callback1;
import com.lyft.googlemaps.googlemap.latlng.LocationSourceHook;
import me.lyft.android.infrastructure.location.ILocationService;
import me.lyft.android.rx.SimpleSubscriber;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class LocationServiceSourceHook
  implements LocationSourceHook
{
  private final ILocationService locationService;
  private Subscription locationUpdateSubscription = Subscriptions.empty();
  
  public LocationServiceSourceHook(ILocationService paramILocationService)
  {
    locationService = paramILocationService;
  }
  
  public void activate(final Callback1<android.location.Location> paramCallback1)
  {
    locationUpdateSubscription.unsubscribe();
    locationService.observePassiveLocationUpdates().subscribe(new SimpleSubscriber()
    {
      public void onNext(me.lyft.android.domain.location.Location paramAnonymousLocation)
      {
        paramCallback1.call(GoogleLocationMapper.toAndroidLocation(paramAnonymousLocation));
      }
    });
  }
  
  public void deactivate()
  {
    locationUpdateSubscription.unsubscribe();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.LocationServiceSourceHook
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */