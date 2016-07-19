package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

public abstract class zzk<T extends IInterface>
  extends zzd<T>
  implements Api.zze, zzl.zza
{
  private final Account aP;
  private final Set<Scope> dY;
  private final zzg tD;
  
  protected zzk(Context paramContext, Looper paramLooper, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this(paramContext, paramLooper, zzm.zzce(paramContext), GoogleApiAvailability.getInstance(), paramInt, paramzzg, (GoogleApiClient.ConnectionCallbacks)zzab.zzaa(paramConnectionCallbacks), (GoogleApiClient.OnConnectionFailedListener)zzab.zzaa(paramOnConnectionFailedListener));
  }
  
  protected zzk(Context paramContext, Looper paramLooper, zzm paramzzm, GoogleApiAvailability paramGoogleApiAvailability, int paramInt, zzg paramzzg, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramzzm, paramGoogleApiAvailability, paramInt, zza(paramConnectionCallbacks), zza(paramOnConnectionFailedListener), paramzzg.zzasj());
    tD = paramzzg;
    aP = paramzzg.getAccount();
    dY = zzb(paramzzg.zzasg());
  }
  
  private static zzd.zzb zza(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    if (paramConnectionCallbacks == null) {
      return null;
    }
    new zzd.zzb()
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        zzk.this.onConnected(paramAnonymousBundle);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        zzk.this.onConnectionSuspended(paramAnonymousInt);
      }
    };
  }
  
  private static zzd.zzc zza(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    if (paramOnConnectionFailedListener == null) {
      return null;
    }
    new zzd.zzc()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        zzk.this.onConnectionFailed(paramAnonymousConnectionResult);
      }
    };
  }
  
  private Set<Scope> zzb(Set<Scope> paramSet)
  {
    Set localSet = zzc(paramSet);
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext()) {
      if (!paramSet.contains((Scope)localIterator.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    return localSet;
  }
  
  public final Account getAccount()
  {
    return aP;
  }
  
  protected final Set<Scope> zzary()
  {
    return dY;
  }
  
  protected Set<Scope> zzc(Set<Scope> paramSet)
  {
    return paramSet;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */