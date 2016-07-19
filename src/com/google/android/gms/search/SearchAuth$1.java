package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzvu;

final class SearchAuth$1
  extends Api.zza<zzvu, Api.ApiOptions.NoOptions>
{
  public zzvu zzt(Context paramContext, Looper paramLooper, zzg paramzzg, Api.ApiOptions.NoOptions paramNoOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return new zzvu(paramContext, paramConnectionCallbacks, paramOnConnectionFailedListener, paramzzg);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.SearchAuth.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */