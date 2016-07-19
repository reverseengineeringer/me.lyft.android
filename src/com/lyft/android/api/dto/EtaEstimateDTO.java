package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class EtaEstimateDTO
{
  @SerializedName("display_name")
  public final String display_name;
  @SerializedName("eta_seconds")
  public final Integer eta_seconds;
  @SerializedName("ride_type")
  public final String ride_type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class EtaEstimateDTO {\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  display_name: ").append(display_name).append("\n");
    localStringBuilder.append("  eta_seconds: ").append(eta_seconds).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.EtaEstimateDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */