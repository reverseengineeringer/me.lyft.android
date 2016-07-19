package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideRequestDetailsDTO
{
  @SerializedName("destination")
  public final PlaceDTO destination;
  @SerializedName("dropoff_time_range")
  public final TimeRangeDTO dropoff_time_range;
  @SerializedName("features")
  public final List<String> features;
  @SerializedName("generated_at_ms")
  public final Long generated_at_ms;
  @SerializedName("origin")
  public final PlaceDTO origin;
  @SerializedName("pickup_time_range")
  public final TimeRangeDTO pickup_time_range;
  @SerializedName("requested_at_ms")
  public final Long requested_at_ms;
  @SerializedName("ride_id")
  public final String ride_id;
  @SerializedName("ride_type")
  public final String ride_type;
  @SerializedName("status")
  public final String status;
  @SerializedName("timezone")
  public final String timezone;
  @SerializedName("wait_estimate_seconds")
  public final Integer wait_estimate_seconds;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideRequestDetailsDTO {\n");
    localStringBuilder.append("  ride_id: ").append(ride_id).append("\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  features: ").append(features).append("\n");
    localStringBuilder.append("  wait_estimate_seconds: ").append(wait_estimate_seconds).append("\n");
    localStringBuilder.append("  requested_at_ms: ").append(requested_at_ms).append("\n");
    localStringBuilder.append("  generated_at_ms: ").append(generated_at_ms).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  origin: ").append(origin).append("\n");
    localStringBuilder.append("  destination: ").append(destination).append("\n");
    localStringBuilder.append("  pickup_time_range: ").append(pickup_time_range).append("\n");
    localStringBuilder.append("  dropoff_time_range: ").append(dropoff_time_range).append("\n");
    localStringBuilder.append("  timezone: ").append(timezone).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideRequestDetailsDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */