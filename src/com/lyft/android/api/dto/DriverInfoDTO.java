package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class DriverInfoDTO
{
  @SerializedName("firstName")
  public final String firstName;
  @SerializedName("id")
  public final String id;
  @SerializedName("location")
  public final LocationDTO location;
  @SerializedName("recentLocations")
  public final List<LocationDTO> recentLocations;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverInfoDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  firstName: ").append(firstName).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  recentLocations: ").append(recentLocations).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverInfoDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */