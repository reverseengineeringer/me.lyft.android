package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.infrastructure.googlegeo.GoogleGeoApiException;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import rx.functions.Func1;

class DirectionsFallbackDecorator$1$1
  implements Func1<GoogleDirectionsResponseDTO, List<Leg>>
{
  DirectionsFallbackDecorator$1$1(DirectionsFallbackDecorator.1 param1) {}
  
  public List<Leg> call(GoogleDirectionsResponseDTO paramGoogleDirectionsResponseDTO)
  {
    if (!paramGoogleDirectionsResponseDTO.getRoutes().isEmpty()) {
      return GoogleRouteMapper.fromDto((GoogleRouteDTO)paramGoogleDirectionsResponseDTO.getRoutes().get(0));
    }
    throw new GoogleGeoApiException("Unable to get response from google api fallback");
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.DirectionsFallbackDecorator.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */