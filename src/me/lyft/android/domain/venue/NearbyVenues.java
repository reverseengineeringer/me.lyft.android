package me.lyft.android.domain.venue;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import me.lyft.android.common.INullable;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.location.SimpleLatLng;
import me.lyft.android.domain.location.SphericalUtils;

public class NearbyVenues
  implements INullable
{
  private final LatLng latLng;
  private final double radiusKilometers;
  private final List<Venue> venues;
  
  NearbyVenues(double paramDouble1, double paramDouble2, double paramDouble3, List<Venue> paramList)
  {
    latLng = new SimpleLatLng(paramDouble1, paramDouble2);
    radiusKilometers = paramDouble3;
    venues = paramList;
  }
  
  public static NearbyVenues empty()
  {
    return NullVenuesCacheItem.INSTANCE;
  }
  
  public Venue getVenue(LatLng paramLatLng)
  {
    if (!paramLatLng.isNull())
    {
      Iterator localIterator = venues.iterator();
      while (localIterator.hasNext())
      {
        Venue localVenue = (Venue)localIterator.next();
        if (localVenue.containsLocation(paramLatLng)) {
          return localVenue;
        }
      }
    }
    return Venue.empty();
  }
  
  public List<Venue> getVenues()
  {
    return venues;
  }
  
  public boolean isNull()
  {
    return false;
  }
  
  public boolean needsRefresh(LatLng paramLatLng)
  {
    return SphericalUtils.computeDistanceBetween(latLng, paramLatLng) / 1000.0D > radiusKilometers;
  }
  
  private static class NullVenuesCacheItem
    extends NearbyVenues
  {
    private static final NearbyVenues INSTANCE = new NullVenuesCacheItem();
    
    private NullVenuesCacheItem()
    {
      super(0.0D, 0.0D, Collections.emptyList());
    }
    
    public boolean isNull()
    {
      return true;
    }
    
    public boolean needsRefresh(LatLng paramLatLng)
    {
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.NearbyVenues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */