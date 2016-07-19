package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

final class zzvw$1
  extends Api.zza<com.google.android.gms.signin.internal.zzg, zzvy>
{
  public com.google.android.gms.signin.internal.zzg zza(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzg paramzzg, zzvy paramzzvy, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramzzvy == null) {
      paramzzvy = zzvy.aul;
    }
    for (;;)
    {
      return new com.google.android.gms.signin.internal.zzg(paramContext, paramLooper, true, paramzzg, paramzzvy, paramConnectionCallbacks, paramOnConnectionFailedListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvw.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */