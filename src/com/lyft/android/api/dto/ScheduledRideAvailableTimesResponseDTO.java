package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ScheduledRideAvailableTimesResponseDTO
{
  @SerializedName("available_times")
  public final List<AvailableTimesListItemDTO> available_times;
  @SerializedName("timezone")
  public final String timezone;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ScheduledRideAvailableTimesResponseDTO {\n");
    localStringBuilder.append("  timezone: ").append(timezone).append("\n");
    localStringBuilder.append("  available_times: ").append(available_times).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideAvailableTimesResponseDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */