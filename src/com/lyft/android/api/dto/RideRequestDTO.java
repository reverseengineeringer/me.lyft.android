package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RideRequestDTO
{
  @SerializedName("carpool_dropoff_time_ms")
  public final Long carpool_dropoff_time_ms;
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
  @SerializedName("party_size")
  public final Integer party_size;
  @SerializedName("payment_account_id")
  public final String payment_account_id;
  @SerializedName("primetime_confirmation_token")
  public final String primetime_confirmation_token;
  @SerializedName("ride_type")
  public final String ride_type;
  @SerializedName("scheduled_pickup_time_ms")
  public final Long scheduled_pickup_time_ms;
  @SerializedName("scheduled_ride_id")
  public final String scheduled_ride_id;
  
  public RideRequestDTO(String paramString1, PlaceDTO paramPlaceDTO1, PlaceDTO paramPlaceDTO2, String paramString2, String paramString3, String paramString4, Boolean paramBoolean, String paramString5, String paramString6, Long paramLong1, Long paramLong2, Integer paramInteger)
  {
    ride_type = paramString1;
    origin = paramPlaceDTO1;
    destination = paramPlaceDTO2;
    cost_token = paramString2;
    primetime_confirmation_token = paramString3;
    payment_account_id = paramString4;
    is_business_ride = paramBoolean;
    charge_token = paramString5;
    scheduled_ride_id = paramString6;
    scheduled_pickup_time_ms = paramLong1;
    carpool_dropoff_time_ms = paramLong2;
    party_size = paramInteger;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideRequestDTO {\n");
    localStringBuilder.append("  ride_type: ").append(ride_type).append("\n");
    localStringBuilder.append("  origin: ").append(origin).append("\n");
    localStringBuilder.append("  destination: ").append(destination).append("\n");
    localStringBuilder.append("  cost_token: ").append(cost_token).append("\n");
    localStringBuilder.append("  primetime_confirmation_token: ").append(primetime_confirmation_token).append("\n");
    localStringBuilder.append("  payment_account_id: ").append(payment_account_id).append("\n");
    localStringBuilder.append("  is_business_ride: ").append(is_business_ride).append("\n");
    localStringBuilder.append("  charge_token: ").append(charge_token).append("\n");
    localStringBuilder.append("  scheduled_ride_id: ").append(scheduled_ride_id).append("\n");
    localStringBuilder.append("  scheduled_pickup_time_ms: ").append(scheduled_pickup_time_ms).append("\n");
    localStringBuilder.append("  carpool_dropoff_time_ms: ").append(carpool_dropoff_time_ms).append("\n");
    localStringBuilder.append("  party_size: ").append(party_size).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */