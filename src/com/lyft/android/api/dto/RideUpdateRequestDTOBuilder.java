package com.lyft.android.api.dto;

import java.util.List;

public class RideUpdateRequestDTOBuilder
{
  private Long actionTimestampMs;
  private String arrivedReason;
  private String canceledReason;
  private Boolean concurEnabled;
  private Long currentClientTimestampMs;
  private String driverFeedback;
  private String driverImprovementAreas;
  private Integer driverRating;
  private DeprecatedPlaceDTO endLocation;
  private String expenseCode;
  private String expenseNote;
  private Object fixedFare;
  private String fixedFareToken;
  private Boolean isBusinessRide;
  private LocationDTO location;
  private Integer partySize;
  private String passengerFeedback;
  private Integer passengerRating;
  private List<RidePaymentDTO> payment;
  private DeprecatedPlaceDTO startLocation;
  private String status;
  
  public RideUpdateRequestDTO build()
  {
    return new RideUpdateRequestDTO(endLocation, driverRating, driverFeedback, driverImprovementAreas, concurEnabled, expenseNote, expenseCode, payment, fixedFare, fixedFareToken, isBusinessRide, startLocation, status, arrivedReason, canceledReason, location, passengerRating, passengerFeedback, currentClientTimestampMs, actionTimestampMs, partySize);
  }
  
  public RideUpdateRequestDTOBuilder withActionTimestampMs(Long paramLong)
  {
    actionTimestampMs = paramLong;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withArrivedReason(String paramString)
  {
    arrivedReason = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withCanceledReason(String paramString)
  {
    canceledReason = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withConcurEnabled(Boolean paramBoolean)
  {
    concurEnabled = paramBoolean;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withCurrentClientTimestampMs(Long paramLong)
  {
    currentClientTimestampMs = paramLong;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withDriverFeedback(String paramString)
  {
    driverFeedback = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withDriverImprovementAreas(String paramString)
  {
    driverImprovementAreas = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withDriverRating(Integer paramInteger)
  {
    driverRating = paramInteger;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withEndLocation(DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    endLocation = paramDeprecatedPlaceDTO;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withExpenseCode(String paramString)
  {
    expenseCode = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withExpenseNote(String paramString)
  {
    expenseNote = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withIsBusinessRide(Boolean paramBoolean)
  {
    isBusinessRide = paramBoolean;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withLocation(LocationDTO paramLocationDTO)
  {
    location = paramLocationDTO;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withPartySize(Integer paramInteger)
  {
    partySize = paramInteger;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withPassengerFeedback(String paramString)
  {
    passengerFeedback = paramString;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withPassengerRating(Integer paramInteger)
  {
    passengerRating = paramInteger;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withPayment(List<RidePaymentDTO> paramList)
  {
    payment = paramList;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withStartLocation(DeprecatedPlaceDTO paramDeprecatedPlaceDTO)
  {
    startLocation = paramDeprecatedPlaceDTO;
    return this;
  }
  
  public RideUpdateRequestDTOBuilder withStatus(String paramString)
  {
    status = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideUpdateRequestDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */