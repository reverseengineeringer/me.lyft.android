package com.kochava.android.tracker;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.kochava.android.util.Logging;

final class LocationDirector$2
  implements LocationListener
{
  public void onLocationChanged(Location paramLocation)
  {
    Logging.Log("onLocationChanged");
    Logging.Log("lat " + paramLocation.getLatitude());
    Logging.Log("long " + paramLocation.getLongitude());
    Logging.Log("accuracy " + paramLocation.getAccuracy());
    if (paramLocation.getAccuracy() <= LocationDirector.desiredAccuracy)
    {
      LocationDirector.access$200(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
      LocationDirector.access$000();
    }
    while ((paramLocation.getAccuracy() >= LocationDirector.access$300()) && (LocationDirector.access$300() != 0.0F)) {
      return;
    }
    LocationDirector.access$200(paramLocation.getLatitude(), paramLocation.getLongitude(), paramLocation.getAccuracy());
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}

/* Location:
 * Qualified Name:     com.kochava.android.tracker.LocationDirector.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */