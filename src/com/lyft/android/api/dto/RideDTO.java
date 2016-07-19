package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideDTO
{
  @SerializedName("actor")
  public final String actor;
  @SerializedName("bannerStyle")
  public final String bannerStyle;
  @SerializedName("bannerText")
  public final String bannerText;
  @SerializedName("cancelPenalty")
  public final Integer cancelPenalty;
  @SerializedName("cancelSubtitleTextNoChargeOverride")
  public final String cancelSubtitleTextNoChargeOverride;
  @SerializedName("cancelationStatuses")
  public final List<String> cancelationStatuses;
  @SerializedName("clientTimeout")
  public final Long clientTimeout;
  @SerializedName("contributors")
  public final List<ContributorDTO> contributors;
  @SerializedName("driverCanPenalize")
  public final Boolean driverCanPenalize;
  @SerializedName("driverStatus")
  public final String driverStatus;
  @SerializedName("driverWaitSeconds")
  public final Integer driverWaitSeconds;
  @SerializedName("dynamicPricing")
  public final Integer dynamicPricing;
  @SerializedName("eta")
  public final Long eta;
  @SerializedName("etd")
  public final Long etd;
  @SerializedName("features")
  public final List<String> features;
  @SerializedName("hideCurrentLocationMarker")
  public final Boolean hideCurrentLocationMarker;
  @SerializedName("icon")
  public final String icon;
  @SerializedName("id")
  public final String id;
  @SerializedName("isBusinessRide")
  public final Boolean isBusinessRide;
  @SerializedName("isEditPickupTooltipVisible")
  public final Boolean isEditPickupTooltipVisible;
  @SerializedName("isPickupEditable")
  public final Boolean isPickupEditable;
  @SerializedName("isTrainingRide")
  public final Boolean isTrainingRide;
  @SerializedName("lineItems")
  public final List<LineItemDTO> lineItems;
  @SerializedName("matchByTimestampMs")
  public final Long matchByTimestampMs;
  @SerializedName("maximumTotalMoney")
  public final MoneyDTO maximumTotalMoney;
  @SerializedName("navAppId")
  public final String navAppId;
  @SerializedName("payStartSeconds")
  public final Integer payStartSeconds;
  @SerializedName("pricingUrl")
  public final String pricingUrl;
  @SerializedName("profitMinusTip")
  public final MoneyDTO profitMinusTip;
  @SerializedName("queuedRoutes")
  public final List<RouteDTO> queuedRoutes;
  @SerializedName("recommendedTotalMoney")
  public final MoneyDTO recommendedTotalMoney;
  @SerializedName("region")
  public final String region;
  @SerializedName("rideTypePublicId")
  public final String rideTypePublicId;
  @SerializedName("route")
  public final RouteDTO route;
  @SerializedName("shouldSignOutOnLapse")
  public final Boolean shouldSignOutOnLapse;
  @SerializedName("showDriverHints")
  public final Boolean showDriverHints;
  @SerializedName("showEndRideConfirmation")
  public final Boolean showEndRideConfirmation;
  @SerializedName("status")
  public final String status;
  @SerializedName("statusTime")
  public final String statusTime;
  @SerializedName("statusTimestamp")
  public final Long statusTimestamp;
  @SerializedName("timezone")
  public final String timezone;
  @SerializedName("tipOptions")
  public final List<TipOptionDTO> tipOptions;
  @SerializedName("userMode")
  public final String userMode;
  @SerializedName("validCoupons")
  public final List<CouponDTO> validCoupons;
  @SerializedName("waitEstimateInSec")
  public final Integer waitEstimateInSec;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideDTO {\n");
    localStringBuilder.append("  id: ").append(id).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  statusTime: ").append(statusTime).append("\n");
    localStringBuilder.append("  statusTimestamp: ").append(statusTimestamp).append("\n");
    localStringBuilder.append("  rideTypePublicId: ").append(rideTypePublicId).append("\n");
    localStringBuilder.append("  recommendedTotalMoney: ").append(recommendedTotalMoney).append("\n");
    localStringBuilder.append("  maximumTotalMoney: ").append(maximumTotalMoney).append("\n");
    localStringBuilder.append("  cancelPenalty: ").append(cancelPenalty).append("\n");
    localStringBuilder.append("  profitMinusTip: ").append(profitMinusTip).append("\n");
    localStringBuilder.append("  tipOptions: ").append(tipOptions).append("\n");
    localStringBuilder.append("  validCoupons: ").append(validCoupons).append("\n");
    localStringBuilder.append("  lineItems: ").append(lineItems).append("\n");
    localStringBuilder.append("  eta: ").append(eta).append("\n");
    localStringBuilder.append("  etd: ").append(etd).append("\n");
    localStringBuilder.append("  timezone: ").append(timezone).append("\n");
    localStringBuilder.append("  dynamicPricing: ").append(dynamicPricing).append("\n");
    localStringBuilder.append("  isTrainingRide: ").append(isTrainingRide).append("\n");
    localStringBuilder.append("  route: ").append(route).append("\n");
    localStringBuilder.append("  queuedRoutes: ").append(queuedRoutes).append("\n");
    localStringBuilder.append("  contributors: ").append(contributors).append("\n");
    localStringBuilder.append("  showEndRideConfirmation: ").append(showEndRideConfirmation).append("\n");
    localStringBuilder.append("  region: ").append(region).append("\n");
    localStringBuilder.append("  showDriverHints: ").append(showDriverHints).append("\n");
    localStringBuilder.append("  driverCanPenalize: ").append(driverCanPenalize).append("\n");
    localStringBuilder.append("  bannerText: ").append(bannerText).append("\n");
    localStringBuilder.append("  bannerStyle: ").append(bannerStyle).append("\n");
    localStringBuilder.append("  cancelSubtitleTextNoChargeOverride: ").append(cancelSubtitleTextNoChargeOverride).append("\n");
    localStringBuilder.append("  driverStatus: ").append(driverStatus).append("\n");
    localStringBuilder.append("  clientTimeout: ").append(clientTimeout).append("\n");
    localStringBuilder.append("  actor: ").append(actor).append("\n");
    localStringBuilder.append("  waitEstimateInSec: ").append(waitEstimateInSec).append("\n");
    localStringBuilder.append("  payStartSeconds: ").append(payStartSeconds).append("\n");
    localStringBuilder.append("  driverWaitSeconds: ").append(driverWaitSeconds).append("\n");
    localStringBuilder.append("  cancelationStatuses: ").append(cancelationStatuses).append("\n");
    localStringBuilder.append("  icon: ").append(icon).append("\n");
    localStringBuilder.append("  hideCurrentLocationMarker: ").append(hideCurrentLocationMarker).append("\n");
    localStringBuilder.append("  isBusinessRide: ").append(isBusinessRide).append("\n");
    localStringBuilder.append("  navAppId: ").append(navAppId).append("\n");
    localStringBuilder.append("  userMode: ").append(userMode).append("\n");
    localStringBuilder.append("  features: ").append(features).append("\n");
    localStringBuilder.append("  isPickupEditable: ").append(isPickupEditable).append("\n");
    localStringBuilder.append("  isEditPickupTooltipVisible: ").append(isEditPickupTooltipVisible).append("\n");
    localStringBuilder.append("  shouldSignOutOnLapse: ").append(shouldSignOutOnLapse).append("\n");
    localStringBuilder.append("  matchByTimestampMs: ").append(matchByTimestampMs).append("\n");
    localStringBuilder.append("  pricingUrl: ").append(pricingUrl).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */