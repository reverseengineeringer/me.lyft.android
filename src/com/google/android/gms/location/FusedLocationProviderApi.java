package com.google.android.gms.location;

import android.location.Location;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface FusedLocationProviderApi
{
  public abstract Location getLastLocation(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> removeLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationListener paramLocationListener);
  
  public abstract PendingResult<Status> requestLocationUpdates(GoogleApiClient paramGoogleApiClient, LocationRequest paramLocationRequest, LocationListener paramLocationListener);
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.FusedLocationProviderApi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */