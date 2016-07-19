package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class PrefillLocationsDTO
{
  @SerializedName("dropoff")
  public final DeprecatedPlaceDTO dropoff;
  @SerializedName("pickup")
  public final DeprecatedPlaceDTO pickup;
  @SerializedName("rideType")
  public final String rideType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class PrefillLocationsDTO {\n");
    localStringBuilder.append("  pickup: ").append(pickup).append("\n");
    localStringBuilder.append("  dropoff: ").append(dropoff).append("\n");
    localStringBuilder.append("  rideType: ").append(rideType).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.PrefillLocationsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */