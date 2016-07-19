package com.lyft.android.api.dto;

public class ClientPermissionsRequestBuilder
{
  private String locationPermission;
  
  public ClientPermissionsRequestDTO build()
  {
    return new ClientPermissionsRequestDTO(null, null, null, null, locationPermission);
  }
  
  public ClientPermissionsRequestBuilder withAlwaysOnLocationPermission()
  {
    locationPermission = "authorizedAlways";
    return this;
  }
}

/* Location:
 * Qualified Name:     com.lyft.android.api.dto.ClientPermissionsRequestBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */