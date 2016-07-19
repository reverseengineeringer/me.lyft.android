package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class TimeRangeDeprecatedDTO
{
  @SerializedName("endTimestamp")
  public final Long endTimestamp;
  @SerializedName("startTimestamp")
  public final Long startTimestamp;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class TimeRangeDeprecatedDTO {\n");
    localStringBuilder.append("  startTimestamp: ").append(startTimestamp).append("\n");
    localStringBuilder.append("  endTimestamp: ").append(endTimestamp).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.TimeRangeDeprecatedDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */