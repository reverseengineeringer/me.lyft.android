package me.lyft.android.infrastructure.googleplay;

import com.google.android.gms.common.api.GoogleApiClient;

public abstract interface IGoogleApiProvider
{
  public abstract boolean checkGooglePlayServicesAvailable();
  
  public abstract GoogleApiClient getApi();
}

/* Location:
 * Qualified Name:     me.lyft.android.infrastructure.googleplay.IGoogleApiProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */