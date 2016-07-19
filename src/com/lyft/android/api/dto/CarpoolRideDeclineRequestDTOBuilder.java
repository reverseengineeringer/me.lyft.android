package com.lyft.android.api.dto;

import java.util.List;

public class CarpoolRideDeclineRequestDTOBuilder
{
  private List<String> ids;
  private Double lat;
  private Double lng;
  private String reason;
  
  public CarpoolRideDeclineRequestDTO build()
  {
    return new CarpoolRideDeclineRequestDTO(ids, reason, lat, lng);
  }
  
  public CarpoolRideDeclineRequestDTOBuilder withIds(List<String> paramList)
  {
    ids = paramList;
    return this;
  }
  
  public CarpoolRideDeclineRequestDTOBuilder withLat(Double paramDouble)
  {
    lat = paramDouble;
    return this;
  }
  
  public CarpoolRideDeclineRequestDTOBuilder withLng(Double paramDouble)
  {
    lng = paramDouble;
    return this;
  }
  
  public CarpoolRideDeclineRequestDTOBuilder withReason(String paramString)
  {
    reason = paramString;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.CarpoolRideDeclineRequestDTOBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */