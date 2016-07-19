package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class ScheduledRideRequestDTO
{
  @SerializedName("charge_token")
  public final String charge_token;
  @SerializedName("cost_token")
  public final String cost_token;
  @SerializedName("destination")
  public final PlaceDTO destination;
  @SerializedName("is_business_ride")
  public final Boolean is_business_ride;
  @SerializedName("origin")
  public final PlaceDTO origin;
  @SerializedName("payment_account_id")
  public final String payment_account_id;
  @SerializedName("ride_type")
  public final String ride_type;
  @SerializedName("scheduled_pickup_range")
  public final TimeRangeDTO scheduled_pickup_range;
  
  public ScheduledRideRequestDTO(TimeRangeDTO paramTimeRangeDTO, String paramString1, PlaceDTO paramPlaceDTO1, PlaceDTO paramPlaceDTO2, String paramString2, String paramString3, Boolean paramBoolean, String paramString4)
  {
    scheduled_pickup_range = paramTimeRangeDTO;
    ride_type = paramString1;
    origin = paramPlaceDTO1;
    destination = paramPlaceDTO2;
    cost_token = paramString2;
    payment_account_id = paramString3;
    is_business_ride = paramBoolean;
    charge_token = paramString4;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ScheduledRideRequestDTO {\n");
    localStringBuilder.append("  scheduled_pickup_range: ").append(scheduled_pickup_range).append("\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  origin: ").append(origin).append("\n");
    localStringBuilder.append("  destination: ").append(destination).append("\n");
    localStringBuilder.append("  cost_token: ").append(cost_token).append("\n");
    localStringBuilder.append("  payment_account_id: ").append(payment_account_id).append("\n");
    localStringBuilder.append("  is_business_ride: ").append(is_business_ride).append("\n");
    localStringBuilder.append("  charge_token: ").append(charge_token).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */