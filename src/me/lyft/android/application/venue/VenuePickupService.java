package me.lyft.android.application.venue;

import com.lyft.android.api.dto.VenuesDTO;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import me.lyft.android.application.ride.IRideRequestSession;
import me.lyft.android.common.Unit;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.domain.venue.NearbyVenues;
import me.lyft.android.domain.venue.Venue;
import me.lyft.android.domain.venue.VenueMapper;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class VenuePickupService
  implements IVenuePickupService
{
  private final Set<Venue> discoveredVenues = new HashSet();
  private final ILyftApi lyftApi;
  private NearbyVenues pickupVenueCache = NearbyVenues.empty();
  private final Observable<List<Venue>> receivedNearbyVenuesStream;
  private final Observable<Venue> venueDiscoveryStream;
  
  public VenuePickupService(ILyftApi paramILyftApi, final IRideRequestSession paramIRideRequestSession)
  {
    lyftApi = paramILyftApi;
    receivedNearbyVenuesStream = paramIRideRequestSession.observePickupLocationChange().switchMap(new Func1()
    {
      public Observable<List<Venue>> call(LatLng paramAnonymousLatLng)
      {
        return VenuePickupService.this.getNearbyVenues(paramAnonymousLatLng);
      }
    }).share();
    venueDiscoveryStream = Observable.merge(paramIRideRequestSession.observePickupLocationChange().map(Unit.func1()), receivedNearbyVenuesStream.map(Unit.func1())).map(new Func1()
    {
      public Venue call(Unit paramAnonymousUnit)
      {
        return getVenue(paramIRideRequestSession.getPickupLocation());
      }
    }).filter(new Func1()
    {
      public Boolean call(Venue paramAnonymousVenue)
      {
        if ((!paramAnonymousVenue.isNull()) && (!discoveredVenues.contains(paramAnonymousVenue))) {}
        for (boolean bool = true;; bool = false) {
          return Boolean.valueOf(bool);
        }
      }
    }).doOnNext(new Action1()
    {
      public void call(Venue paramAnonymousVenue)
      {
        discoveredVenues.add(paramAnonymousVenue);
      }
    }).share();
  }
  
  private Observable<List<Venue>> getNearbyVenues(LatLng paramLatLng)
  {
    if (pickupVenueCache.needsRefresh(paramLatLng)) {
      lyftApi.getVenues(paramLatLng).map(new Func1()
      {
        public List<Venue> call(VenuesDTO paramAnonymousVenuesDTO)
        {
          paramAnonymousVenuesDTO = VenueMapper.fromVenuesDTO(paramAnonymousVenuesDTO);
          VenuePickupService.access$202(VenuePickupService.this, paramAnonymousVenuesDTO);
          return paramAnonymousVenuesDTO.getVenues();
        }
      }).onErrorResumeNext(new Func1()
      {
        public Observable<? extends List<Venue>> call(Throwable paramAnonymousThrowable)
        {
          return Observable.just(Collections.emptyList());
        }
      });
    }
    return Observable.just(pickupVenueCache.getVenues());
  }
  
  public Venue getVenue(LatLng paramLatLng)
  {
    return pickupVenueCache.getVenue(paramLatLng);
  }
  
  public boolean hasVenue(LatLng paramLatLng)
  {
    paramLatLng = getVenue(paramLatLng);
    return (!paramLatLng.isNull()) && (!paramLatLng.isProhibited());
  }
  
  public boolean isNearby(Venue paramVenue)
  {
    return pickupVenueCache.getVenues().contains(paramVenue);
  }
  
  public Observable<List<Venue>> observeNearbyVenues()
  {
    return receivedNearbyVenuesStream;
  }
  
  public Observable<Venue> observeVenueDiscoveries()
  {
    return venueDiscoveryStream;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.venue.VenuePickupService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */