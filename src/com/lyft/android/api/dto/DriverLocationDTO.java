package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class DriverLocationDTO
{
  @SerializedName("bearing")
  public final Double bearing;
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  @SerializedName("recorded_at_ms")
  public final Long recorded_at_ms;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class DriverLocationDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("  bearing: ").append(bearing).append("\n");
    localStringBuilder.append("  recorded_at_ms: ").append(recorded_at_ms).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.DriverLocationDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */