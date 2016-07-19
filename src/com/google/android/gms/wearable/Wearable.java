package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbp;
import com.google.android.gms.wearable.internal.zzbr;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable
{
  public static final Api<WearableOptions> API = new Api("Wearable.API", bO, bN);
  public static final CapabilityApi CapabilityApi;
  public static final ChannelApi ChannelApi;
  public static final DataApi DataApi = new zzx();
  public static final MessageApi MessageApi;
  public static final NodeApi NodeApi;
  public static final zzc aJi;
  public static final zza aJj;
  public static final zzf aJk;
  public static final zzi aJl;
  public static final zzj aJm;
  public static final Api.zzf<zzbp> bN;
  private static final Api.zza<zzbp, WearableOptions> bO;
  
  static
  {
    CapabilityApi = new com.google.android.gms.wearable.internal.zzj();
    MessageApi = new zzaz();
    NodeApi = new zzbb();
    ChannelApi = new zzl();
    aJi = new com.google.android.gms.wearable.internal.zzg();
    aJj = new zze();
    aJk = new zzw();
    aJl = new zzbm();
    aJm = new zzbr();
    bN = new Api.zzf();
    bO = new Api.zza()
    {
      public zzbp zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzg paramAnonymouszzg, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymousWearableOptions != null) {}
        for (;;)
        {
          return new zzbp(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzg);
          new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
      }
    };
  }
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private WearableOptions(Builder paramBuilder) {}
    
    public static class Builder {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.Wearable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */