package com.lyft.android.api.dto;

public class ScheduledRideRequestDTOBuilder
{
  private String charge_token;
  private String cost_token;
  private PlaceDTO destination;
  private Boolean is_business_ride;
  private PlaceDTO origin;
  private String payment_account_id;
  private String ride_type;
  private TimeRangeDTO scheduled_pickup_range;
  
  public ScheduledRideRequestDTO build()
  {
    return new ScheduledRideRequestDTO(scheduled_pickup_range, ride_type, origin, destination, cost_token, payment_account_id, is_business_ride, charge_token);
  }
  
  public ScheduledRideRequestDTOBuilder withChargeToken(String paramString)
  {
    charge_token = paramString;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withCostToken(String paramString)
  {
    cost_token = paramString;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withDestination(PlaceDTO paramPlaceDTO)
  {
    destination = paramPlaceDTO;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withIsBusinessRide(Boolean paramBoolean)
  {
    is_business_ride = paramBoolean;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withOrigin(PlaceDTO paramPlaceDTO)
  {
    origin = paramPlaceDTO;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withPaymentAccountId(String paramString)
  {
    payment_account_id = paramString;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withRideType(String paramString)
  {
    ride_type = paramString;
    return this;
  }
  
  public ScheduledRideRequestDTOBuilder withScheduledPickupRange(TimeRangeDTO paramTimeRangeDTO)
  {
    scheduled_pickup_range = paramTimeRangeDTO;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideRequestDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */