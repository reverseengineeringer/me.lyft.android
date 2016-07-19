package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideTypesResponseDTO
{
  @SerializedName("ride_types")
  public final List<RideTypeDTO> ride_types;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideTypesResponseDTO {\n");
    localStringBuilder.append("  ride_types: ").append(ride_types).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideTypesResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */