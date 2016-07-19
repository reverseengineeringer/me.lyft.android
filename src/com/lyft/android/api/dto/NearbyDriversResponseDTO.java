package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class NearbyDriversResponseDTO
{
  @SerializedName("nearby_drivers")
  public final List<NearbyDriversDTO> nearby_drivers;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class NearbyDriversResponseDTO {\n");
    localStringBuilder.append("  nearby_drivers: ").append(nearby_drivers).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.NearbyDriversResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */