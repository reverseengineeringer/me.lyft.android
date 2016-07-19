package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.domain.location.LatLng;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApiException;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

public class DirectionsFallbackDecorator
  implements IDirectionsService
{
  private IDirectionsService directionsService;
  private ILyftApi lyftApi;
  
  public DirectionsFallbackDecorator(IDirectionsService paramIDirectionsService, ILyftApi paramILyftApi)
  {
    directionsService = paramIDirectionsService;
    lyftApi = paramILyftApi;
  }
  
  private Func1<Throwable, Observable<List<Leg>>> callFallback(final String paramString)
  {
    new Func1()
    {
      public Observable<List<Leg>> call(Throwable paramAnonymousThrowable)
      {
        lyftApi.fallbackDirections(paramString).map(new Func1()
        {
          public List<Leg> call(GoogleDirectionsResponseDTO paramAnonymous2GoogleDirectionsResponseDTO)
          {
            if (!paramAnonymous2GoogleDirectionsResponseDTO.getRoutes().isEmpty()) {
              return GoogleRouteMapper.fromDto((GoogleRouteDTO)paramAnonymous2GoogleDirectionsResponseDTO.getRoutes().get(0));
            }
            throw new GoogleGeoApiException("Unable to get response from google api fallback");
          }
        });
      }
    };
  }
  
  public Observable<List<Leg>> directions(String paramString, List<LatLng> paramList)
  {
    return directionsService.directions(paramString, paramList).onErrorResumeNext(callFallback(paramString));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.DirectionsFallbackDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */