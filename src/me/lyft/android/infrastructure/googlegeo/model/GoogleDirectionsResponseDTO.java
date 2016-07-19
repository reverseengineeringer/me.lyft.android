package me.lyft.android.infrastructure.googlegeo.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class GoogleDirectionsResponseDTO
  extends GoogleGeoResponseDTO
{
  @SerializedName("routes")
  private List<GoogleRouteDTO> routes = new ArrayList();
  @SerializedName("status")
  private String status;
  
  public GoogleDirectionsResponseDTO(String paramString, List<GoogleRouteDTO> paramList)
  {
    status = paramString;
    routes = paramList;
  }
  
  public List<GoogleRouteDTO> getRoutes()
  {
    return routes;
  }
  
  public String getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googlegeo.model.GoogleDirectionsResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */