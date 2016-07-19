package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;

public class zzpu
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  public final Api<?> pD;
  private final int sV;
  private zzqf sW;
  
  public zzpu(Api<?> paramApi, int paramInt)
  {
    pD = paramApi;
    sV = paramInt;
  }
  
  private void zzaox()
  {
    zzab.zzb(sW, "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
  }
  
  public void onConnected(Bundle paramBundle)
  {
    zzaox();
    sW.onConnected(paramBundle);
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    zzaox();
    sW.zza(paramConnectionResult, pD, sV);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    zzaox();
    sW.onConnectionSuspended(paramInt);
  }
  
  public void zza(zzqf paramzzqf)
  {
    sW = paramzzqf;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzpu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */