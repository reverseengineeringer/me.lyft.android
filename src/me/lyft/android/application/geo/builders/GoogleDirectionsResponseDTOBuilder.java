package me.lyft.android.application.geo.builders;

import java.util.ArrayList;
import java.util.List;
import me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO;
import me.lyft.android.infrastructure.googlegeo.model.GoogleRouteDTO;

public class GoogleDirectionsResponseDTOBuilder
{
  private List<GoogleRouteDTO> routes = new ArrayList();
  private String status = "OK";
  
  public GoogleDirectionsResponseDTO build()
  {
    return new GoogleDirectionsResponseDTO(status, routes);
  }
  
  public GoogleDirectionsResponseDTOBuilder withRoute(GoogleRouteDTOBuilder paramGoogleRouteDTOBuilder)
  {
    routes.add(paramGoogleRouteDTOBuilder.build());
    return this;
  }
  
  public GoogleDirectionsResponseDTOBuilder withStatus(String paramString)
  {
    status = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.application.geo.builders.GoogleDirectionsResponseDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */