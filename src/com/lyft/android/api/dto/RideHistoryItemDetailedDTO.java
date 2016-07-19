package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideHistoryItemDetailedDTO
{
  @SerializedName("cancelPenaltyReason")
  public final String cancelPenaltyReason;
  @SerializedName("distance")
  public final Integer distance;
  @SerializedName("driverName")
  public final String driverName;
  @SerializedName("driverPhoneNumber")
  public final String driverPhoneNumber;
  @SerializedName("driverPhotoUrl")
  public final String driverPhotoUrl;
  @SerializedName("dropoffAddress")
  public final String dropoffAddress;
  @SerializedName("dropoffTimestamp")
  public final Long dropoffTimestamp;
  @SerializedName("features")
  public final List<String> features;
  @SerializedName("isBusinessRide")
  public final Boolean isBusinessRide;
  @SerializedName("mapImageUrl")
  public final String mapImageUrl;
  @SerializedName("paymentBreakdown")
  public final List<PaymentBreakdownItemDTO> paymentBreakdown;
  @SerializedName("pickupAddress")
  public final String pickupAddress;
  @SerializedName("pickupTimestamp")
  public final Long pickupTimestamp;
  @SerializedName("pricingUrl")
  public final String pricingUrl;
  @SerializedName("region")
  public final String region;
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
    localStringBuilder.append("class RideHistoryItemDetailedDTO {\n");
    localStringBuilder.append("  rideId: ").append(rideId).append("\n");
    localStringBuilder.append("  driverName: ").append(driverName).append("\n");
    localStringBuilder.append("  driverPhotoUrl: ").append(driverPhotoUrl).append("\n");
    localStringBuilder.append("  driverPhoneNumber: ").append(driverPhoneNumber).append("\n");
    localStringBuilder.append("  totalMoney: ").append(totalMoney).append("\n");
    localStringBuilder.append("  distance: ").append(distance).append("\n");
    localStringBuilder.append("  pickupTimestamp: ").append(pickupTimestamp).append("\n");
    localStringBuilder.append("  dropoffTimestamp: ").append(dropoffTimestamp).append("\n");
    localStringBuilder.append("  timeZone: ").append(timeZone).append("\n");
    localStringBuilder.append("  rideType: ").append(rideType).append("\n");
    localStringBuilder.append("  rideTypeLabel: ").append(rideTypeLabel).append("\n");
    localStringBuilder.append("  isBusinessRide: ").append(isBusinessRide).append("\n");
    localStringBuilder.append("  mapImageUrl: ").append(mapImageUrl).append("\n");
    localStringBuilder.append("  region: ").append(region).append("\n");
    localStringBuilder.append("  pickupAddress: ").append(pickupAddress).append("\n");
    localStringBuilder.append("  dropoffAddress: ").append(dropoffAddress).append("\n");
    localStringBuilder.append("  paymentBreakdown: ").append(paymentBreakdown).append("\n");
    localStringBuilder.append("  rideState: ").append(rideState).append("\n");
    localStringBuilder.append("  cancelPenaltyReason: ").append(cancelPenaltyReason).append("\n");
    localStringBuilder.append("  features: ").append(features).append("\n");
    localStringBuilder.append("  pricingUrl: ").append(pricingUrl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideHistoryItemDetailedDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */