package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class StopDTO
{
  @SerializedName("completed")
  public final Boolean completed;
  @SerializedName("inGeoFence")
  public final Boolean inGeoFence;
  @SerializedName("location")
  public final DeprecatedPlaceDTO location;
  @SerializedName("passengerId")
  public final String passengerId;
  @SerializedName("rideId")
  public final String rideId;
  @SerializedName("scheduledTimeRange")
  public final TimeRangeDeprecatedDTO scheduledTimeRange;
  @SerializedName("stopType")
  public final String stopType;
  
  public StopDTO(Boolean paramBoolean1, DeprecatedPlaceDTO paramDeprecatedPlaceDTO, String paramString1, String paramString2, String paramString3, Boolean paramBoolean2, TimeRangeDeprecatedDTO paramTimeRangeDeprecatedDTO)
  {
    completed = paramBoolean1;
    location = paramDeprecatedPlaceDTO;
    passengerId = paramString1;
    rideId = paramString2;
    stopType = paramString3;
    inGeoFence = paramBoolean2;
    scheduledTimeRange = paramTimeRangeDeprecatedDTO;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class StopDTO {\n");
    localStringBuilder.append("  completed: ").append(completed).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  passengerId: ").append(passengerId).append("\n");
    localStringBuilder.append("  rideId: ").append(rideId).append("\n");
    localStringBuilder.append("  stopType: ").append(stopType).append("\n");
    localStringBuilder.append("  inGeoFence: ").append(inGeoFence).append("\n");
    localStringBuilder.append("  scheduledTimeRange: ").append(scheduledTimeRange).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.StopDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */