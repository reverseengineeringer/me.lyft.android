package me.lyft.android.locationproviders.fused;

import android.location.Location;
import com.google.android.gms.location.LocationListener;
import me.lyft.android.locationproviders.core.LocationCallback;

class FusedLocationUpdateConnection$1
  implements LocationListener
{
  FusedLocationUpdateConnection$1(FusedLocationUpdateConnection paramFusedLocationUpdateConnection, LocationCallback paramLocationCallback) {}
  
  public void onLocationChanged(Location paramLocation)
  {
    val$locationCallback.onLocationChanged(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.FusedLocationUpdateConnection.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */