package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UpdateUserLocationRequestDTO
{
  @SerializedName("appInfoRevision")
  public final String appInfoRevision;
  @SerializedName("clientRideId")
  public final String clientRideId;
  @SerializedName("locations")
  public final List<LocationDTO> locations;
  @SerializedName("marker")
  public final DeprecatedPlaceDTO marker;
  @SerializedName("markerDestination")
  public final DeprecatedPlaceDTO markerDestination;
  @SerializedName("rideType")
  public final String rideType;
  
  public UpdateUserLocationRequestDTO(List<LocationDTO> paramList, DeprecatedPlaceDTO paramDeprecatedPlaceDTO1, DeprecatedPlaceDTO paramDeprecatedPlaceDTO2, String paramString1, String paramString2, String paramString3)
  {
    locations = paramList;
    marker = paramDeprecatedPlaceDTO1;
    markerDestination = paramDeprecatedPlaceDTO2;
    rideType = paramString1;
    appInfoRevision = paramString2;
    clientRideId = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UpdateUserLocationRequestDTO {\n");
    localStringBuilder.append("  locations: ").append(locations).append("\n");
    localStringBuilder.append("  marker: ").append(marker).append("\n");
    localStringBuilder.append("  markerDestination: ").append(markerDestination).append("\n");
    localStringBuilder.append("  rideType: ").append(rideType).append("\n");
    localStringBuilder.append("  appInfoRevision: ").append(appInfoRevision).append("\n");
    localStringBuilder.append("  clientRideId: ").append(clientRideId).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UpdateUserLocationRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */