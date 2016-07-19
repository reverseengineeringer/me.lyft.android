package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class TimeRangeDTO
{
  @SerializedName("range_ms")
  public final Long range_ms;
  @SerializedName("timestamp_ms")
  public final Long timestamp_ms;
  
  public TimeRangeDTO(Long paramLong1, Long paramLong2)
  {
    timestamp_ms = paramLong1;
    range_ms = paramLong2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class TimeRangeDTO {\n");
    localStringBuilder.append("  timestamp_ms: ").append(timestamp_ms).append("\n");
    localStringBuilder.append("  range_ms: ").append(range_ms).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.TimeRangeDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */