package me.lyft.android.application.ride;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.location.Location;

public class GooglePlaceTypeAnalytics
{
  public void trackDropOffGooglePlaceType(Location paramLocation)
  {
    if (Strings.isNullOrEmpty(paramLocation.getGooglePlaceType())) {}
  }
  
  public void trackPickUpGooglePlaceType(Location paramLocation)
  {
    if (Strings.isNullOrEmpty(paramLocation.getGooglePlaceType())) {}
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.ride.GooglePlaceTypeAnalytics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */