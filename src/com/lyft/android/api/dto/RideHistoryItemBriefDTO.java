package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;

public class RideHistoryItemBriefDTO
{
  @SerializedName("distance")
  public final Integer distance;
  @SerializedName("driverFirstName")
  public final String driverFirstName;
  @SerializedName("driverPhotoUrl")
  public final String driverPhotoUrl;
  @SerializedName("dropoffTimestamp")
  public final Long dropoffTimestamp;
  @SerializedName("isBusinessRide")
  public final Boolean isBusinessRide;
  @SerializedName("pickupTimestamp")
  public final Long pickupTimestamp;
  @SerializedName("rideId")
  public final String rideId;
  @SerializedName("rideState")
  public final String rideState;
  @SerializedName("rideType")
  public final String rideType;
  @SerializedName("rideTypeLabel")
  public final String rideTypeLabel;
  @SerializedName("timeZone")
  public final String timeZone;
  @SerializedName("totalMoney")
  public final MoneyDTO totalMoney;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideHistoryItemBriefDTO {\n");
    localStringBuilder.append("  rideId: ").append(rideId).append("\n");
    localStringBuilder.append("  driverFirstName: ").append(driverFirstName).append("\n");
    localStringBuilder.append("  driverPhotoUrl: ").append(driverPhotoUrl).append("\n");
    localStringBuilder.append("  totalMoney: ").append(totalMoney).append("\n");
    localStringBuilder.append("  distance: ").append(distance).append("\n");
    localStringBuilder.append("  pickupTimestamp: ").append(pickupTimestamp).append("\n");
    localStringBuilder.append("  dropoffTimestamp: ").append(dropoffTimestamp).append("\n");
    localStringBuilder.append("  timeZone: ").append(timeZone).append("\n");
    localStringBuilder.append("  rideType: ").append(rideType).append("\n");
    localStringBuilder.append("  rideTypeLabel: ").append(rideTypeLabel).append("\n");
    localStringBuilder.append("  isBusinessRide: ").append(isBusinessRide).append("\n");
    localStringBuilder.append("  rideState: ").append(rideState).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideHistoryItemBriefDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */