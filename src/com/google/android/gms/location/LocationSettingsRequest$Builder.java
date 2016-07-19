package com.google.android.gms.location;

import java.util.ArrayList;

public final class LocationSettingsRequest$Builder
{
  private boolean adk = false;
  private boolean adl = false;
  private final ArrayList<LocationRequest> adm = new ArrayList();
  
  public Builder addLocationRequest(LocationRequest paramLocationRequest)
  {
    adm.add(paramLocationRequest);
    return this;
  }
  
  public LocationSettingsRequest build()
  {
    return new LocationSettingsRequest(adm, adk, adl, null);
  }
  
  public Builder setAlwaysShow(boolean paramBoolean)
  {
    adk = paramBoolean;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.LocationSettingsRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */