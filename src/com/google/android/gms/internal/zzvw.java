package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;

public final class zzvw
{
  public static final Api<zzvy> API = new Api("SignIn.API", bO, bN);
  public static final Api<zza> EX = new Api("SignIn.INTERNAL_API", auk, auj);
  public static final Api.zzf<com.google.android.gms.signin.internal.zzg> auj;
  static final Api.zza<com.google.android.gms.signin.internal.zzg, zza> auk;
  public static final Api.zzf<com.google.android.gms.signin.internal.zzg> bN = new Api.zzf();
  public static final Api.zza<com.google.android.gms.signin.internal.zzg, zzvy> bO;
  public static final Scope dP;
  public static final Scope dQ;
  
  static
  {
    auj = new Api.zzf();
    bO = new Api.zza()
    {
      public com.google.android.gms.signin.internal.zzg zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzg paramAnonymouszzg, zzvy paramAnonymouszzvy, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymouszzvy == null) {
          paramAnonymouszzvy = zzvy.aul;
        }
        for (;;)
        {
          return new com.google.android.gms.signin.internal.zzg(paramAnonymousContext, paramAnonymousLooper, true, paramAnonymouszzg, paramAnonymouszzvy, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
        }
      }
    };
    auk = new Api.zza()
    {
      public com.google.android.gms.signin.internal.zzg zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzg paramAnonymouszzg, zzvw.zza paramAnonymouszza, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        return new com.google.android.gms.signin.internal.zzg(paramAnonymousContext, paramAnonymousLooper, false, paramAnonymouszzg, paramAnonymouszza.zzbzj(), paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
      }
    };
    dP = new Scope("profile");
    dQ = new Scope("email");
  }
  
  public static class zza
    implements Api.ApiOptions.HasOptions
  {
    public Bundle zzbzj()
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzvw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */