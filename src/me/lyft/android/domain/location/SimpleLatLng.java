package me.lyft.android.domain.location;

public class SimpleLatLng
  implements LatLng
{
  private static final float MIN_DISTANCE_CHANGE = 10.0F;
  private final double lat;
  private final double lng;
  
  public SimpleLatLng(double paramDouble1, double paramDouble2)
  {
    lat = paramDouble1;
    lng = paramDouble2;
  }
  
  public double distanceTo(LatLng paramLatLng)
  {
    return SphericalUtils.computeDistanceBetween(this, paramLatLng);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SimpleLatLng)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (SimpleLatLng)paramObject;
      if (Double.compare(lat, lat) != 0) {
        break;
      }
      bool1 = bool2;
    } while (Double.compare(lng, lng) == 0);
    return false;
  }
  
  public double getLat()
  {
    return lat;
  }
  
  public double getLng()
  {
    return lng;
  }
  
  public boolean hasSameCoordinates(LatLng paramLatLng)
  {
    double d = distanceTo(paramLatLng);
    return (paramLatLng != null) && (d < 10.0D);
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public String toQueryString()
  {
    return getLat() + "," + getLng();
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.location.SimpleLatLng
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */