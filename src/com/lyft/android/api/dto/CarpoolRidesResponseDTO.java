package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarpoolRidesResponseDTO
{
  @SerializedName("rides")
  public final List<RideDTO> rides;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class CarpoolRidesResponseDTO {\n");
    localStringBuilder.append("  rides: ").append(rides).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CarpoolRidesResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */