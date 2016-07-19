package me.lyft.android.locationproviders.fused;

import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

abstract interface GoogleApiListener
  extends GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{}

/* Location:
 * Qualified Name:     me.lyft.android.locationproviders.fused.GoogleApiListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */