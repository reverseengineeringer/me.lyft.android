package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NearbyDriverDTO
{
  @SerializedName("id")
  public final String id;
  @SerializedName("locations")
  public final List<DriverLocationDTO> locations;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NearbyDriverDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  locations: ").append(locations).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NearbyDriverDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */