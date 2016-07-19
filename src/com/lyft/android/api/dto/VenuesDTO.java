package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class VenuesDTO
{
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("radius_miles")
  public final Double radius_miles;
  @SerializedName("venues")
  public final List<VenueDTO> venues;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class VenuesDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  radius_miles: ").append(radius_miles).append("\n");
    localStringBuilder.append("  venues: ").append(venues).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.VenuesDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */