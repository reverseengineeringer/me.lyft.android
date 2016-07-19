package me.lyft.android.application.geo;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.common.Iterables;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.infrastructure.googlegeo.IGoogleGeoApi;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class GoogleDirectionsService
  implements IDirectionsService
{
  private final IGoogleGeoApi googleApiService;
  private final GoogleGeoAnalytics googleGeoAnalytics;
  
  public GoogleDirectionsService(IGoogleGeoApi paramIGoogleGeoApi, GoogleGeoAnalytics paramGoogleGeoAnalytics)
  {
    googleApiService = paramIGoogleGeoApi;
    googleGeoAnalytics = paramGoogleGeoAnalytics;
  }
  
  private List<Leg> translateToLegs(GoogleRouteDTO paramGoogleRouteDTO)
  {
    return GoogleRouteMapper.fromDto(paramGoogleRouteDTO);
  }
  
  public Observable<List<Leg>> directions(String paramString, List<LatLng> paramList)
  {
    if (paramList.isEmpty()) {
      return Observable.empty();
    }
    paramString = (LatLng)Iterables.firstOrDefault(paramList);
    LatLng localLatLng = (LatLng)Iterables.last(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i < paramList.size() - 1)
    {
      localArrayList.add(paramList.get(i));
      i += 1;
    }
    paramList = Iterables.map(localArrayList, new Func1()
    {
      public String call(LatLng paramAnonymousLatLng)
      {
        return paramAnonymousLatLng.toQueryString();
      }
    });
    googleGeoAnalytics.directionsInitiation();
    googleApiService.directions(paramString.toQueryString(), localLatLng.toQueryString(), paramList).doOnEach(new Action1()
    {
      public void call(Notification<? super GoogleDirectionsResponseDTO> paramAnonymousNotification)
      {
        if (paramAnonymousNotification.isOnNext()) {
          googleGeoAnalytics.trackDirectionsSuccess();
        }
        while (!paramAnonymousNotification.isOnError()) {
          return;
        }
        googleGeoAnalytics.trackDirectionsFailure(paramAnonymousNotification.getThrowable());
      }
    }).map(new Func1()
    {
      public List<Leg> call(GoogleDirectionsResponseDTO paramAnonymousGoogleDirectionsResponseDTO)
      {
        return GoogleDirectionsService.this.translateToLegs((GoogleRouteDTO)paramAnonymousGoogleDirectionsResponseDTO.getRoutes().get(0));
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleDirectionsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */