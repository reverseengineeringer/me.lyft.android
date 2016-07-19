package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ScheduledRideDTO
{
  @SerializedName("destination")
  public final PlaceDTO destination;
  @SerializedName("id")
  public final String id;
  @SerializedName("origin")
  public final PlaceDTO origin;
  @SerializedName("ride_type")
  public final String ride_type;
  @SerializedName("scheduled_pickup_time_ms")
  public final Long scheduled_pickup_time_ms;
  @SerializedName("timezone")
  public final String timezone;
  
  public ScheduledRideDTO(PlaceDTO paramPlaceDTO1, PlaceDTO paramPlaceDTO2, String paramString1, String paramString2, Long paramLong, String paramString3)
  {
    origin = paramPlaceDTO1;
    destination = paramPlaceDTO2;
    ride_type = paramString1;
    id = paramString2;
    scheduled_pickup_time_ms = paramLong;
    timezone = paramString3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ScheduledRideDTO {\n");
    localStringBuilder.append("  origin: ").append(origin).append("\n");
    localStringBuilder.append("  destination: ").append(destination).append("\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  scheduled_pickup_time_ms: ").append(scheduled_pickup_time_ms).append("\n");
    localStringBuilder.append("  timezone: ").append(timezone).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */