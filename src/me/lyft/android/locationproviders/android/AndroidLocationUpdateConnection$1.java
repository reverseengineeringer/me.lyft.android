package me.lyft.android.locationproviders.android;

import android.location.Location;
import me.lyft.android.locationproviders.core.LocationCallback;
import me.lyft.android.locationproviders.core.LocationClientConfiguration;

class AndroidLocationUpdateConnection$1
  extends SimpleLocationListener
{
  AndroidLocationUpdateConnection$1(AndroidLocationUpdateConnection paramAndroidLocationUpdateConnection, LocationClientConfiguration paramLocationClientConfiguration, LocationCallback paramLocationCallback) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    if (LocationUtil.isBetterLocation(paramLocation, AndroidLocationUpdateConnection.access$000(this$0), 30L, val$locationClientConfiguration.smallestDisplacement)) {
      val$locationCallback.onLocationChanged(paramLocation);
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.android.AndroidLocationUpdateConnection.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */