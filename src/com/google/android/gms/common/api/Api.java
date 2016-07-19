package com.google.android.gms.common.api;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class Api<O extends ApiOptions>
{
  private final String mName;
  private final zza<?, O> rr;
  private final zzh<?, O> rs;
  private final zzf<?> rt;
  private final zzi<?> ru;
  
  public <C extends zze> Api(String paramString, zza<C, O> paramzza, zzf<C> paramzzf)
  {
    zzab.zzb(paramzza, "Cannot construct an Api with a null ClientBuilder");
    zzab.zzb(paramzzf, "Cannot construct an Api with a null ClientKey");
    mName = paramString;
    rr = paramzza;
    rs = null;
    rt = paramzzf;
    ru = null;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public zzd<?, O> zzanm()
  {
    if (zzanq()) {
      return null;
    }
    return rr;
  }
  
  public zza<?, O> zzann()
  {
    if (rr != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzab.zza(bool, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
      return rr;
    }
  }
  
  public zzh<?, O> zzano()
  {
    zzab.zza(false, "This API was constructed with a ClientBuilder. Use getClientBuilder");
    return null;
  }
  
  public zzc<?> zzanp()
  {
    if (rt != null) {
      return rt;
    }
    throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
  }
  
  public boolean zzanq()
  {
    return false;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract class zza<T extends Api.zze, O>
    extends Api.zzd<T, O>
  {
    public abstract T zza(Context paramContext, Looper paramLooper, zzg paramzzg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
  }
  
  public static abstract interface zzb {}
  
  public static class zzc<C extends Api.zzb> {}
  
  public static abstract class zzd<T extends Api.zzb, O>
  {
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public List<Scope> zzq(O paramO)
    {
      return Collections.emptyList();
    }
  }
  
  public static abstract interface zze
    extends Api.zzb
  {
    public abstract void disconnect();
    
    public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
    
    public abstract boolean isConnected();
    
    public abstract boolean isConnecting();
    
    public abstract void zza(zzd.zzf paramzzf);
    
    public abstract void zza(zzq paramzzq, Set<Scope> paramSet);
    
    public abstract boolean zzafk();
    
    public abstract boolean zzafz();
    
    public abstract Intent zzaga();
    
    public abstract boolean zzanr();
    
    public abstract IBinder zzans();
  }
  
  public static final class zzf<C extends Api.zze>
    extends Api.zzc<C>
  {}
  
  public static abstract interface zzg<T extends IInterface>
    extends Api.zzb
  {
    public abstract void zza(int paramInt, T paramT);
    
    public abstract T zzbb(IBinder paramIBinder);
    
    public abstract String zzra();
    
    public abstract String zzrb();
  }
  
  public static abstract class zzh<T extends Api.zzg, O>
    extends Api.zzd<T, O>
  {
    public abstract int zzant();
    
    public abstract T zzs(O paramO);
  }
  
  public static final class zzi<C extends Api.zzg>
    extends Api.zzc<C>
  {}
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.api.Api
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */