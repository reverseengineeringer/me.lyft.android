package me.lyft.android.domain.venue;

import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.Location;
import me.lyft.android.domain.location.SphericalUtils;

public class VenuePickupLocation
  implements LatLng
{
  private static final float MIN_DISTANCE_CHANGE = 10.0F;
  private final String copy;
  private final String id;
  private final double lat;
  private final double lng;
  private final String name;
  
  public VenuePickupLocation(double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3)
  {
    lat = paramDouble1;
    lng = paramDouble2;
    name = paramString1;
    id = paramString2;
    copy = paramString3;
  }
  
  public double distanceTo(LatLng paramLatLng)
  {
    return SphericalUtils.computeDistanceBetween(this, paramLatLng);
  }
  
  public String getCopy()
  {
    return copy;
  }
  
  public String getId()
  {
    return id;
  }
  
  public double getLat()
  {
    return lat;
  }
  
  public double getLng()
  {
    return lng;
  }
  
  public String getName()
  {
    return name;
  }
  
  public boolean hasSameCoordinates(LatLng paramLatLng)
  {
    return distanceTo(paramLatLng) < 10.0D;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public Location toLocation()
  {
    Location localLocation = new Location(this, "venue");
    localLocation.setPlaceId(id);
    localLocation.setPlaceName(copy);
    return localLocation;
  }
  
  public String toQueryString()
  {
    return getLat() + "," + getLng();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.VenuePickupLocation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */