package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ScheduledIntervalDTO
{
  @SerializedName("dropoff_range")
  public final TimeRangeDTO dropoff_range;
  @SerializedName("pickup_range")
  public final TimeRangeDTO pickup_range;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ScheduledIntervalDTO {\n");
    localStringBuilder.append("  dropoff_range: ").append(dropoff_range).append("\n");
    localStringBuilder.append("  pickup_range: ").append(pickup_range).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledIntervalDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */