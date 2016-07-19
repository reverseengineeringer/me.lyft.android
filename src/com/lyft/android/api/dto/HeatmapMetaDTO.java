package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class HeatmapMetaDTO
{
  @SerializedName("happyHourRange")
  public final String happyHourRange;
  @SerializedName("primeTimeRange")
  public final String primeTimeRange;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class HeatmapMetaDTO {\n");
    localStringBuilder.append("  primeTimeRange: ").append(primeTimeRange).append("\n");
    localStringBuilder.append("  happyHourRange: ").append(happyHourRange).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.HeatmapMetaDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */