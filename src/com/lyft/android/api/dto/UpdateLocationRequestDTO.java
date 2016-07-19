package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UpdateLocationRequestDTO
{
  @SerializedName("locations")
  public final List<LocationDTO> locations;
  
  public UpdateLocationRequestDTO(List<LocationDTO> paramList)
  {
    locations = paramList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class UpdateLocationRequestDTO {\n");
    localStringBuilder.append("  locations: ").append(locations).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.UpdateLocationRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */