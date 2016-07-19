package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.wearable.internal.zzbp;

final class Wearable$1
  extends Api.zza<zzbp, Wearable.WearableOptions>
{
  public zzbp zza(Context paramContext, Looper paramLooper, zzg paramzzg, Wearable.WearableOptions paramWearableOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramWearableOptions != null) {}
    for (;;)
    {
      return new zzbp(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg);
      new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.Wearable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */