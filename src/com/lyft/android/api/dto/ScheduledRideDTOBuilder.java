package com.lyft.android.api.dto;

public class ScheduledRideDTOBuilder
{
  private PlaceDTO destination;
  private String id;
  private PlaceDTO origin;
  private String ride_type;
  private Long scheduled_pickup_time_ms;
  private String timezone;
  
  public ScheduledRideDTO build()
  {
    return new ScheduledRideDTO(origin, destination, ride_type, id, scheduled_pickup_time_ms, timezone);
  }
  
  public ScheduledRideDTOBuilder withId(String paramString)
  {
    id = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ScheduledRideDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */