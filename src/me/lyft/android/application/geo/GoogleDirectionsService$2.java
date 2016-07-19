package me.lyft.android.application.geo;

import java.util.List;
import me.lyft.android.domain.geo.Leg;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;
import rx.functions.Func1;

class GoogleDirectionsService$2
  implements Func1<GoogleDirectionsResponseDTO, List<Leg>>
{
  GoogleDirectionsService$2(GoogleDirectionsService paramGoogleDirectionsService) {}
  
  public List<Leg> call(GoogleDirectionsResponseDTO paramGoogleDirectionsResponseDTO)
  {
    return GoogleDirectionsService.access$000(this$0, (GoogleRouteDTO)paramGoogleDirectionsResponseDTO.getRoutes().get(0));
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.GoogleDirectionsService.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */