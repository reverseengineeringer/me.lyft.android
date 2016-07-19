package me.lyft.android.application.venue;

import java.util.List;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.venue.Venue;
import rx.Observable;

public abstract interface IVenuePickupService
{
  public abstract Venue getVenue(LatLng paramLatLng);
  
  public abstract boolean hasVenue(LatLng paramLatLng);
  
  public abstract boolean isNearby(Venue paramVenue);
  
  public abstract Observable<List<Venue>> observeNearbyVenues();
  
  public abstract Observable<Venue> observeVenueDiscoveries();
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.IVenuePickupService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */