package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ScheduledRideResponseDTO
{
  @SerializedName("scheduled_rides")
  public final List<ScheduledRideDTO> scheduled_rides;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ScheduledRideResponseDTO {\n");
    localStringBuilder.append("  scheduled_rides: ").append(scheduled_rides).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */