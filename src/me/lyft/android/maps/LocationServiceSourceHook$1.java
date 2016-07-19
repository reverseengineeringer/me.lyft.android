package me.lyft.android.maps;

import com.lyft.googlemaps.core.callback.Callback1;
import me.lyft.android.domain.location.Location;
import me.lyft.android.rx.SimpleSubscriber;

class LocationServiceSourceHook$1
  extends SimpleSubscriber<Location>
{
  LocationServiceSourceHook$1(LocationServiceSourceHook paramLocationServiceSourceHook, Callback1 paramCallback1) {}
  
  public void onNext(Location paramLocation)
  {
    val$activationCallback.call(GoogleLocationMapper.toAndroidLocation(paramLocation));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.maps.LocationServiceSourceHook.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */