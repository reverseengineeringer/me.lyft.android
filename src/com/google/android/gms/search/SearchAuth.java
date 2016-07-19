package com.google.android.gms.search;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzvu;
import com.google.android.gms.internal.zzvv;

public class SearchAuth
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("SearchAuth.API", atZ, bN);
  public static final SearchAuthApi SearchAuthApi = new zzvv();
  private static final Api.zza<zzvu, Api.ApiOptions.NoOptions> atZ = new Api.zza()
  {
    public zzvu zzt(Context paramAnonymousContext, Looper paramAnonymousLooper, zzg paramAnonymouszzg, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzvu(paramAnonymousContext, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzg);
    }
  };
  public static final Api.zzf<zzvu> bN = new Api.zzf();
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.SearchAuth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */