package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class GhostrideRequestDTO
{
  @SerializedName("lat")
  public final Double lat;
  @SerializedName("lng")
  public final Double lng;
  
  public GhostrideRequestDTO(Double paramDouble1, Double paramDouble2)
  {
    lat = paramDouble1;
    lng = paramDouble2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class GhostrideRequestDTO {\n");
    localStringBuilder.append("  lat: ").append(lat).append("\n");
    localStringBuilder.append("  lng: ").append(lng).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.GhostrideRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */