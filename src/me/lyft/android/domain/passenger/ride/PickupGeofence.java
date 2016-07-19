package me.lyft.android.domain.passenger.ride;

import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.NullLocation;
import me.lyft.android.domain.location.SphericalUtils;

public class PickupGeofence
{
  private static final NullPickupGeofence EMPTY = new NullPickupGeofence();
  private LatLng center;
  private int radius;
  private String rideId;
  
  public PickupGeofence(String paramString, int paramInt, LatLng paramLatLng)
  {
    rideId = paramString;
    radius = paramInt;
    center = paramLatLng;
  }
  
  public static PickupGeofence empty()
  {
    return EMPTY;
  }
  
  public boolean contains(LatLng paramLatLng)
  {
    return SphericalUtils.computeDistanceBetween(center, paramLatLng) < radius;
  }
  
  public LatLng getCenter()
  {
    return center;
  }
  
  public int getRadius()
  {
    return radius;
  }
  
  public float getZoomLevel()
  {
    return (float)(16.0D - Math.log(getRadius() / 500.0D) / Math.log(2.0D) - 0.7D);
  }
  
  public boolean isForRideWithId(String paramString)
  {
    return rideId.equals(paramString);
  }
  
  public static class NullPickupGeofence
    extends PickupGeofence
  {
    public NullPickupGeofence()
    {
      super(0, NullLocation.getInstance());
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.passenger.ride.PickupGeofence
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */