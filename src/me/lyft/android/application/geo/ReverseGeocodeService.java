package me.lyft.android.application.geo;

import me.lyft.android.common.Strings;
import me.lyft.android.domain.geo.AddressMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.cache.ICache;
import me.lyft.android.infrastructure.cache.LruMemoryCache;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class ReverseGeocodeService
{
  private static final int CACHE_CAPACITY = 15;
  private final ICache<Location> cache = new LruMemoryCache(15);
  private final GoogleGeoAnalytics googleGeoAnalytics;
  private final IGoogleGeoApi googleGeoApiService;
  
  public ReverseGeocodeService(IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    googleGeoApiService = paramIGoogleGeoApi;
    googleGeoAnalytics = paramGoogleGeoAnalytics;
  }
  
  public Observable<Location> reverseGeocode(final Location paramLocation)
  {
    final String str = paramLocation.toQueryString();
    if ((!Strings.isNullOrEmpty(paramLocation.getDisplayName())) || (paramLocation.isNull()))
    {
      cache.put(str, paramLocation);
      return Observable.just(paramLocation);
    }
    if (cache.contains(str)) {
      return Observable.just(cache.get(str));
    }
    googleGeoAnalytics.reverseGeocodeInitiation();
    googleGeoApiService.reverseGeocode(str).doOnEach(new Action1()
    {
      public void call(Notification<? super GoogleGeocodeResponseDTO> paramAnonymousNotification)
      {
        if (paramAnonymousNotification.isOnNext()) {
          googleGeoAnalytics.trackReverseGeocodeSuccess();
        }
        while (!paramAnonymousNotification.isOnError()) {
          return;
        }
        googleGeoAnalytics.trackReverseGeocodeFailure(paramAnonymousNotification.getThrowable());
      }
    }).map(new Func1()
    {
      public Location call(GoogleGeocodeResponseDTO paramAnonymousGoogleGeocodeResponseDTO)
      {
        paramAnonymousGoogleGeocodeResponseDTO = AddressMapper.fromGoogleGeocodeResult(paramAnonymousGoogleGeocodeResponseDTO);
        paramAnonymousGoogleGeocodeResponseDTO = paramLocation.cloneWithAddress(paramAnonymousGoogleGeocodeResponseDTO);
        if (!Strings.isNullOrEmpty(paramAnonymousGoogleGeocodeResponseDTO.getDisplayName())) {
          cache.put(str, paramAnonymousGoogleGeocodeResponseDTO);
        }
        return paramAnonymousGoogleGeocodeResponseDTO;
      }
    }).flatMap(new Func1()
    {
      public Observable<Location> call(Location paramAnonymousLocation)
      {
        if (Strings.isNullOrEmpty(paramAnonymousLocation.getDisplayName())) {
          return Observable.error(new RuntimeException("No displayable address available."));
        }
        return Observable.just(paramAnonymousLocation);
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.ReverseGeocodeService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */