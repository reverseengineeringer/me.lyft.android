package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzah<T extends IInterface>
  extends zzk<T>
{
  private final Api.zzg<T> zb;
  
  public zzah(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzg paramzzg, Api.zzg<T> paramzzg1)
  {
    super(paramContext, paramLooper, paramInt, paramzzg, paramConnectionCallbacks, paramOnConnectionFailedListener);
    zb = paramzzg1;
  }
  
  public Api.zzg<T> zzatj()
  {
    return zb;
  }
  
  protected T zzbb(IBinder paramIBinder)
  {
    return zb.zzbb(paramIBinder);
  }
  
  protected void zzc(int paramInt, T paramT)
  {
    zb.zza(paramInt, paramT);
  }
  
  protected String zzra()
  {
    return zb.zzra();
  }
  
  protected String zzrb()
  {
    return zb.zzrb();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.internal.zzah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */