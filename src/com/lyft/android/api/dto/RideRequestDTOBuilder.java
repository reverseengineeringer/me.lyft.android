package com.lyft.android.api.dto;

public class RideRequestDTOBuilder
{
  private Long carpool_dropoff_time_ms;
  private String charge_token;
  private String cost_token;
  private PlaceDTO destination;
  private Boolean is_business_ride;
  private PlaceDTO origin;
  private Integer party_size;
  private String payment_account_id;
  private String primetime_confirmation_token;
  private String ride_type;
  private Long scheduled_pickup_time_ms;
  private String scheduled_ride_id;
  
  public RideRequestDTO build()
  {
    return new RideRequestDTO(ride_type, origin, destination, cost_token, primetime_confirmation_token, payment_account_id, is_business_ride, charge_token, scheduled_ride_id, scheduled_pickup_time_ms, carpool_dropoff_time_ms, party_size);
  }
  
  public RideRequestDTOBuilder withCarpoolDropoffTimeMs(Long paramLong)
  {
    carpool_dropoff_time_ms = paramLong;
    return this;
  }
  
  public RideRequestDTOBuilder withChargeToken(String paramString)
  {
    charge_token = paramString;
    return this;
  }
  
  public RideRequestDTOBuilder withCostToken(String paramString)
  {
    cost_token = paramString;
    return this;
  }
  
  public RideRequestDTOBuilder withDestination(PlaceDTO paramPlaceDTO)
  {
    destination = paramPlaceDTO;
    return this;
  }
  
  public RideRequestDTOBuilder withIsBusinessRide(Boolean paramBoolean)
  {
    is_business_ride = paramBoolean;
    return this;
  }
  
  public RideRequestDTOBuilder withOrigin(PlaceDTO paramPlaceDTO)
  {
    origin = paramPlaceDTO;
    return this;
  }
  
  public RideRequestDTOBuilder withPartySize(Integer paramInteger)
  {
    party_size = paramInteger;
    return this;
  }
  
  public RideRequestDTOBuilder withPaymentAccountId(String paramString)
  {
    payment_account_id = paramString;
    return this;
  }
  
  public RideRequestDTOBuilder withRideType(String paramString)
  {
    ride_type = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.RideRequestDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */