package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PickupGeofenceDTO
{
  @SerializedName("center")
  public final CircleCenterDTO center;
  @SerializedName("radius")
  public final Integer radius;
  @SerializedName("type")
  public final String type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PickupGeofenceDTO {\n");
    localStringBuilder.append("  type: ").append(type).append("\n");
    localStringBuilder.append("  radius: ").append(radius).append("\n");
    localStringBuilder.append("  center: ").append(center).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PickupGeofenceDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */