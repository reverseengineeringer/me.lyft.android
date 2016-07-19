package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzg;

public abstract class Api$zza<T extends Api.zze, O>
  extends Api.zzd<T, O>
{
  public abstract T zza(Context paramContext, Looper paramLooper, zzg paramzzg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */