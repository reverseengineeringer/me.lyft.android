package me.lyft.android.domain.venue;

import java.util.Collections;
import me.lyft.android.domain.location.LatLng;

class NearbyVenues$NullVenuesCacheItem
  extends NearbyVenues
{
  private static final NearbyVenues INSTANCE = new NullVenuesCacheItem();
  
  private NearbyVenues$NullVenuesCacheItem()
  {
    super(0.0D, 0.0D, 0.0D, Collections.emptyList());
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

/* Location:
 * Qualified Name:     me.lyft.android.domain.venue.NearbyVenues.NullVenuesCacheItem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */