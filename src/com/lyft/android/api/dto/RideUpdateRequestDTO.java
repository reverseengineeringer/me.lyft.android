package com.lyft.android.api.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RideUpdateRequestDTO
{
  @SerializedName("actionTimestampMs")
  public final Long actionTimestampMs;
  @SerializedName("arrivedReason")
  public final String arrivedReason;
  @SerializedName("canceledReason")
  public final String canceledReason;
  @SerializedName("concurEnabled")
  public final Boolean concurEnabled;
  @SerializedName("currentClientTimestampMs")
  public final Long currentClientTimestampMs;
  @SerializedName("driverFeedback")
  public final String driverFeedback;
  @SerializedName("driverImprovementAreas")
  public final String driverImprovementAreas;
  @SerializedName("driverRating")
  public final Integer driverRating;
  @SerializedName("endLocation")
  public final DeprecatedPlaceDTO endLocation;
  @SerializedName("expenseCode")
  public final String expenseCode;
  @SerializedName("expenseNote")
  public final String expenseNote;
  @SerializedName("fixedFare")
  public final Object fixedFare;
  @SerializedName("fixedFareToken")
  public final String fixedFareToken;
  @SerializedName("isBusinessRide")
  public final Boolean isBusinessRide;
  @SerializedName("location")
  public final LocationDTO location;
  @SerializedName("partySize")
  public final Integer partySize;
  @SerializedName("passengerFeedback")
  public final String passengerFeedback;
  @SerializedName("passengerRating")
  public final Integer passengerRating;
  @SerializedName("payment")
  public final List<RidePaymentDTO> payment;
  @SerializedName("startLocation")
  public final DeprecatedPlaceDTO startLocation;
  @SerializedName("status")
  public final String status;
  
  public RideUpdateRequestDTO(DeprecatedPlaceDTO paramDeprecatedPlaceDTO1, Integer paramInteger1, String paramString1, String paramString2, Boolean paramBoolean1, String paramString3, String paramString4, List<RidePaymentDTO> paramList, Object paramObject, String paramString5, Boolean paramBoolean2, DeprecatedPlaceDTO paramDeprecatedPlaceDTO2, String paramString6, String paramString7, String paramString8, LocationDTO paramLocationDTO, Integer paramInteger2, String paramString9, Long paramLong1, Long paramLong2, Integer paramInteger3)
  {
    endLocation = paramDeprecatedPlaceDTO1;
    driverRating = paramInteger1;
    driverFeedback = paramString1;
    driverImprovementAreas = paramString2;
    concurEnabled = paramBoolean1;
    expenseNote = paramString3;
    expenseCode = paramString4;
    payment = paramList;
    fixedFare = paramObject;
    fixedFareToken = paramString5;
    isBusinessRide = paramBoolean2;
    startLocation = paramDeprecatedPlaceDTO2;
    status = paramString6;
    arrivedReason = paramString7;
    canceledReason = paramString8;
    location = paramLocationDTO;
    passengerRating = paramInteger2;
    passengerFeedback = paramString9;
    currentClientTimestampMs = paramLong1;
    actionTimestampMs = paramLong2;
    partySize = paramInteger3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class RideUpdateRequestDTO {\n");
    localStringBuilder.append("  endLocation: ").append(endLocation).append("\n");
    localStringBuilder.append("  driverRating: ").append(driverRating).append("\n");
    localStringBuilder.append("  driverFeedback: ").append(driverFeedback).append("\n");
    localStringBuilder.append("  driverImprovementAreas: ").append(driverImprovementAreas).append("\n");
    localStringBuilder.append("  concurEnabled: ").append(concurEnabled).append("\n");
    localStringBuilder.append("  expenseNote: ").append(expenseNote).append("\n");
    localStringBuilder.append("  expenseCode: ").append(expenseCode).append("\n");
    localStringBuilder.append("  payment: ").append(payment).append("\n");
    localStringBuilder.append("  fixedFare: ").append(fixedFare).append("\n");
    localStringBuilder.append("  fixedFareToken: ").append(fixedFareToken).append("\n");
    localStringBuilder.append("  isBusinessRide: ").append(isBusinessRide).append("\n");
    localStringBuilder.append("  startLocation: ").append(startLocation).append("\n");
    localStringBuilder.append("  status: ").append(status).append("\n");
    localStringBuilder.append("  arrivedReason: ").append(arrivedReason).append("\n");
    localStringBuilder.append("  canceledReason: ").append(canceledReason).append("\n");
    localStringBuilder.append("  location: ").append(location).append("\n");
    localStringBuilder.append("  passengerRating: ").append(passengerRating).append("\n");
    localStringBuilder.append("  passengerFeedback: ").append(passengerFeedback).append("\n");
    localStringBuilder.append("  currentClientTimestampMs: ").append(currentClientTimestampMs).append("\n");
    localStringBuilder.append("  actionTimestampMs: ").append(actionTimestampMs).append("\n");
    localStringBuilder.append("  partySize: ").append(partySize).append("\n");
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideUpdateRequestDTO
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */