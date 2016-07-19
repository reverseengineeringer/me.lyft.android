package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class AvailableTimesListItemDTO
{
  @SerializedName("first_interval")
  public final ScheduledIntervalDTO first_interval;
  @SerializedName("number_of_intervals")
  public final Integer number_of_intervals;
  @SerializedName("step_time_ms")
  public final Long step_time_ms;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class AvailableTimesListItemDTO {\n");
    localStringBuilder.append("  first_interval: ").append(first_interval).append("\n");
    localStringBuilder.append("  step_time_ms: ").append(step_time_ms).append("\n");
    localStringBuilder.append("  number_of_intervals: ").append(number_of_intervals).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.AvailableTimesListItemDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */