package me.lyft.android.application.geo;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import me.lyft.android.common.Iterables;
import me.lyft.android.common.Objects;
import me.lyft.android.domain.geo.City;
import me.lyft.android.domain.geo.CityMapper;
import me.lyft.android.domain.location.Location;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApiException;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleGeocodeResultDTO;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class GeoService
  implements IGeoService
{
  private static final Func1<Long, Long> mapToMinutes = new Func1()
  {
    public Long call(Long paramAnonymousLong)
    {
      if (paramAnonymousLong.longValue() > 0L)
      {
        long l2 = TimeUnit.SECONDS.toMinutes(paramAnonymousLong.longValue());
        long l1 = l2;
        if (l2 < 1L) {
          l1 = 1L;
        }
        return Long.valueOf(l1);
      }
      return Long.valueOf(0L);
    }
  };
  private CachedEta cachedEta = null;
  private final IEtaAnalyticService etaAnalyticService;
  private final IEtaRepository etaRepository;
  private final IGoogleGeoApi googleApiService;
  private final GoogleGeoAnalytics googleGeoAnalytics;
  private final ReverseGeocodeService reverseGeocodeService;
  
  public GeoService(ReverseGeocodeService paramReverseGeocodeService, IGoogleGeoApi paramIGoogleGeoApi, IEtaRepository paramIEtaRepository, IEtaAnalyticService paramIEtaAnalyticService, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    reverseGeocodeService = paramReverseGeocodeService;
    googleApiService = paramIGoogleGeoApi;
    etaRepository = paramIEtaRepository;
    etaAnalyticService = paramIEtaAnalyticService;
    googleGeoAnalytics = paramGoogleGeoAnalytics;
  }
  
  public Observable<City> addressLookupFromZip(String paramString1, String paramString2)
  {
    googleGeoAnalytics.addressLookupInitiation();
    googleApiService.addressLookupFromZip(paramString1, paramString2).doOnEach(new Action1()
    {
      public void call(Notification<? super GoogleGeocodeResponseDTO> paramAnonymousNotification)
      {
        if (paramAnonymousNotification.isOnNext()) {
          googleGeoAnalytics.trackAddressLookupSuccess();
        }
        while (!paramAnonymousNotification.isOnError()) {
          return;
        }
        googleGeoAnalytics.trackAddressLookupFailure(paramAnonymousNotification.getThrowable());
      }
    }).flatMap(new Func1()
    {
      public Observable<City> call(GoogleGeocodeResponseDTO paramAnonymousGoogleGeocodeResponseDTO)
      {
        paramAnonymousGoogleGeocodeResponseDTO = paramAnonymousGoogleGeocodeResponseDTO.getResults();
        if ((paramAnonymousGoogleGeocodeResponseDTO != null) && (!paramAnonymousGoogleGeocodeResponseDTO.isEmpty())) {
          return Observable.just(CityMapper.fromGoogleAddressComponentsDTO(get0addressComponents));
        }
        return Observable.error(new GoogleGeoApiException("No address components returned"));
      }
    });
  }
  
  public void expireCache()
  {
    cachedEta = new CachedEta(Long.valueOf(0L), Long.valueOf(0L), "");
  }
  
  public Observable<Long> getDriverEta(final String paramString, Location paramLocation, List<Location> paramList)
  {
    Long localLong = etaRepository.getEta();
    if (localLong != null) {
      paramString = Observable.just(localLong).doOnNext(new Action1()
      {
        public void call(Long paramAnonymousLong)
        {
          etaAnalyticService.record(Boolean.valueOf(true), paramAnonymousLong);
        }
      });
    }
    for (;;)
    {
      return paramString.map(mapToMinutes);
      if ((cachedEta != null) && (System.currentTimeMillis() - cachedEta.getTimestamp().longValue() < CachedEta.CACHE_TTL.longValue()) && (Objects.equals(paramString, cachedEta.getRideId())))
      {
        paramString = Observable.just(cachedEta.getEta());
      }
      else
      {
        cachedEta = null;
        paramList = Iterables.map(paramList, new Func1()
        {
          public String call(Location paramAnonymousLocation)
          {
            return paramAnonymousLocation.toQueryString();
          }
        });
        googleGeoAnalytics.etaInitiation();
        paramString = googleApiService.getTotalEta(paramLocation.toQueryString(), paramList).doOnEach(new Action1()
        {
          public void call(Notification<? super Long> paramAnonymousNotification)
          {
            if (paramAnonymousNotification.isOnNext()) {
              googleGeoAnalytics.trackEtaSuccess();
            }
            while (!paramAnonymousNotification.isOnError()) {
              return;
            }
            googleGeoAnalytics.trackEtaFailure(paramAnonymousNotification.getThrowable());
          }
        }).doOnNext(new Action1()
        {
          public void call(Long paramAnonymousLong)
          {
            GeoService.access$102(GeoService.this, new CachedEta(Long.valueOf(System.currentTimeMillis()), paramAnonymousLong, paramString));
            etaAnalyticService.record(Boolean.valueOf(false), paramAnonymousLong);
          }
        });
      }
    }
  }
  
  public Observable<Long> getDriverEta(String paramString, Location paramLocation, Location... paramVarArgs)
  {
    return getDriverEta(paramString, paramLocation, Arrays.asList(paramVarArgs));
  }
  
  public Observable<Long> getPassengerEtd(String paramString, Location paramLocation, List<Location> paramList)
  {
    paramString = etaRepository.getEtd();
    if (paramString != null) {
      return Observable.just(paramString).map(mapToMinutes);
    }
    return Observable.error(new UnavailableEtdException("Unable to get etd. No fallback option implemented"));
  }
  
  public Observable<Location> reverseGeocode(Location paramLocation)
  {
    return reverseGeocodeService.reverseGeocode(paramLocation);
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GeoService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */