package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;

public class zzk$zza
  extends Api.zza<zzk, PlacesOptions>
{
  public zzk zzb(Context paramContext, Looper paramLooper, zzg paramzzg, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramPlacesOptions == null) {
      paramPlacesOptions = new PlacesOptions.Builder().build();
    }
    for (;;)
    {
      String str = paramContext.getPackageName();
      if (afb != null) {
        str = afb;
      }
      return new zzk(paramContext, paramLooper, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener, str, paramPlacesOptions, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.places.internal.zzk.zza
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */