package com.lyft.android.api.dto;

public class LocationDTOBuilder
{
  private Double accuracy;
  private Double bearing;
  private Long eta;
  private Boolean isInternalEta;
  private Double lat;
  private Double lng;
  private String recordedAt;
  private Long recorded_at;
  private String rideId;
  private String rideStatus;
  private String source;
  private Double speed;
  
  public LocationDTO build()
  {
    return new LocationDTO(lat, lng, speed, bearing, accuracy, recordedAt, rideId, rideStatus, eta, isInternalEta, recorded_at, source);
  }
  
  public LocationDTOBuilder withAccuracy(Double paramDouble)
  {
    accuracy = paramDouble;
    return this;
  }
  
  public LocationDTOBuilder withBearing(Double paramDouble)
  {
    bearing = paramDouble;
    return this;
  }
  
  public LocationDTOBuilder withEta(Long paramLong)
  {
    eta = paramLong;
    return this;
  }
  
  public LocationDTOBuilder withIsInternalEta(Boolean paramBoolean)
  {
    isInternalEta = paramBoolean;
    return this;
  }
  
  public LocationDTOBuilder withLat(Double paramDouble)
  {
    lat = paramDouble;
    return this;
  }
  
  public LocationDTOBuilder withLng(Double paramDouble)
  {
    lng = paramDouble;
    return this;
  }
  
  public LocationDTOBuilder withRecordedAt(Long paramLong)
  {
    recorded_at = paramLong;
    return this;
  }
  
  public LocationDTOBuilder withRecordedAt(String paramString)
  {
    recordedAt = paramString;
    return this;
  }
  
  public LocationDTOBuilder withRideId(String paramString)
  {
    rideId = paramString;
    return this;
  }
  
  public LocationDTOBuilder withRideStatus(String paramString)
  {
    rideStatus = paramString;
    return this;
  }
  
  public LocationDTOBuilder withSource(String paramString)
  {
    source = paramString;
    return this;
  }
  
  public LocationDTOBuilder withSpeed(Double paramDouble)
  {
    speed = paramDouble;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.LocationDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */