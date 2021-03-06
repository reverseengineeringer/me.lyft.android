package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApiException;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import me.lyft.android.infrastructure.lyft.ILyftApi;
import rx.Observable;
import rx.functions.Func1;

class DirectionsFallbackDecorator$1
  implements Func1<Throwable, Observable<List<Leg>>>
{
  DirectionsFallbackDecorator$1(DirectionsFallbackDecorator paramDirectionsFallbackDecorator, String paramString) {}
  
  public Observable<List<Leg>> call(Throwable paramThrowable)
  {
    DirectionsFallbackDecorator.access$000(this$0).fallbackDirections(val$rideId).map(new Func1()
    {
      public List<Leg> call(GoogleDirectionsResponseDTO paramAnonymousGoogleDirectionsResponseDTO)
      {
        if (!paramAnonymousGoogleDirectionsResponseDTO.getRoutes().isEmpty()) {
          return GoogleRouteMapper.fromDto((GoogleRouteDTO)paramAnonymousGoogleDirectionsResponseDTO.getRoutes().get(0));
        }
        throw new GoogleGeoApiException("Unable to get response from google api fallback");
      }
    });
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.DirectionsFallbackDecorator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */